package gameAdvance.HelperClasses;

import gameAdvance.Enums.DamageDecision;
import gameAdvance.Monsters.Monster;
import gameAdvance.Scanner.GameScannerManager;
import gameAdvance.Player;

public class TurnHandler {


	public void handlePlayerVsPlayerTurn(Player attacker, Player defense) {

		Monster attackerMonster = getUserMonsterChoice(attacker);
		System.out.println(attacker.getName() + " choose " + attackerMonster.getName());

		boolean defenseDecision = DamageDecision.finalDamageDecision(GameScannerManager.handleDamageDecision(defense.getName()));

		if(defenseDecision){
			defense.decreaseHealth(attackerMonster.getDamage());
			System.out.println(defense.getName() + " was hit and now has HP: " + defense.getHealth());
		}else{
			Monster defenseMonster = getUserMonsterChoice(defense);
			defenseMonster.updateCurrentHealth(attackerMonster.getDamage());
			System.out.println(defenseMonster.getName() + " was hit remaing HP: " + defenseMonster.getCurrentHealth());
		}


	}

	public void handleBotTurnBotVsBot(Player attacker, Player defense, Monster attackerMonsterChoice,
	                                  int roundTrackingCounter) {


		Monster defenseMonsterChoice = Generator.generateRoundPick(defense);
		boolean damageDecision = Generator.generateDecisionToTakeDamage();


		GameConsole.printRoundInfo(roundTrackingCounter, attacker.getName(), defense.getName(),
				attackerMonsterChoice.getName(), defenseMonsterChoice.getName(),
				attackerMonsterChoice.getCurrentHealth(), defenseMonsterChoice.getCurrentHealth());

		if (damageDecision) {
			dealDamage(attackerMonsterChoice, null, defense, true);
		} else {
			dealDamage(attackerMonsterChoice, defenseMonsterChoice, defense, false);
		}

	}

	public void handleBotVsPlayerTurn(Player attacker, Player defense) {

		if (attacker.isAttacking()) {
			Monster botMonster = Generator.generateRoundPick(defense);

			//*GET USER MONSTER CHOICE
			Monster attackerMonster = getUserMonsterChoice(attacker);

			GameConsole.printPlayerVsBotRoundInfo(attacker.getName(), attackerMonster.getName(), defense.getName(),
					botMonster.getName(), attackerMonster.getCurrentHealth(), botMonster.getCurrentHealth());

			boolean damageDecisionBot = Generator.generateDecisionToTakeDamage();

			//decision of getting hit or let monster be hit
			if (damageDecisionBot) {
				dealDamage(attackerMonster, null, defense, true);
			} else {
				dealDamage(attackerMonster, botMonster, defense, false);
			}


		} else {

			Monster botMonster = Generator.generateRoundPick(defense);
			GameConsole.printBotMonsterSelection(defense.getName(), botMonster.getName(),
					botMonster.getCurrentHealth());


			//*GET USER MOSNTER CHOICE
			Monster attackerMonster = getUserMonsterChoice(attacker);


			GameConsole.printPlayerMonsterSelection(attacker.getName(), attackerMonster.getName(),
					attackerMonster.getCurrentHealth());

			boolean attackerDecision =
					DamageDecision.finalDamageDecision(GameScannerManager.handleDamageDecision(attacker.getName()));

			if (attackerDecision) {
				dealDamage(botMonster, null, attacker, true);
			} else {
				dealDamage(botMonster, attackerMonster, attacker, false);
			}

		}

	}

	//todo handleTurnWithObstacle need to have the obstacle and both players and monsters
		//todo call the attack created in supernatural since it can handle both types of obstacles
		//todo update both player cards state because one of them can have a mosnter die in round

	//*DEAL DAMAGE LOGIC
	private void dealDamage(Monster attackerMonster, Monster defenseMonster, Player defense, boolean randomDecision) {

		if (randomDecision) {
			int healthBeforeHit = defense.getHealth();

			//if true player take damage else take monster damage
			defense.decreaseHealth(attackerMonster.getDamage());

			GameConsole.displayPlayerHealthWhenHit(defense.getName(), healthBeforeHit);

		} else {

			System.out.println(defense.getName() + " choose to let monster take the hit");

			attackerMonster.specialAbility();
			defenseMonster.sufferHit(attackerMonster.getDamage(), defense);

			//!terminal
			GameConsole.printDamageInfo(attackerMonster.getDamage(),
					defenseMonster.getName(), defenseMonster.getCurrentHealth());

		}

	}


	
	//*METHODS FOR FIND AND RETURN ACTUAL USER MONSTER CHOICE

	private Monster findMonsterById(Player player, int userChoice) {
		Monster[] currentAliveCards = player.getCardsAlive();
		for (Monster currentMonster : currentAliveCards) {
			if (userChoice == currentMonster.getId()) {
				return currentMonster;
			}
		}
		throw new IllegalArgumentException("That monster isn't available");
	}

	private Monster getUserMonsterChoice(Player player) {
		int userChoice = GameScannerManager.handleMonsterChoice(player);
		return findMonsterById(player,userChoice);
	}
}
