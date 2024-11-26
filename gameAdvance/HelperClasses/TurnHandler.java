package gameAdvance.HelperClasses;

import gameAdvance.Enums.DamageDecision;
import gameAdvance.Monsters.Monster;
import gameAdvance.Scanner.GameScannerManager;
import gameAdvance.Player;

public class TurnHandler {


	public void handlePlayerTurn(Player attacker, Player defense, Monster attackerMonsterChoice) {


		//todo if is attacking just get the monster choice else get monster choice, and damage decision so i need to
		// pass the isAttacking trough args
		String damageDecision = GameScannerManager.handleDamageDecision();

		if (damageDecision.equals("Yes")) {
			dealDamage(attackerMonsterChoice, null, defense, true);
		} else {
			Monster defenseMonsterChoice = GameScannerManager.handleMonsterChoice(defense);
			dealDamage(attackerMonsterChoice, defenseMonsterChoice, defense, false);
		}
	}

	public void handleBotTurnBotVsBot(Player attacker, Player defense,Monster attackerMonsterChoice,
	                                  int roundTrackingCounter){


		Monster defenseMonsterChoice = Generator.generateRoundPick(defense);
		boolean damageDecision = Generator.generateDecisionToTakeDamage();


		GameConsole.printRoundInfo(roundTrackingCounter, attacker.getName(), defense.getName(),
				attackerMonsterChoice.getName(), defenseMonsterChoice.getName(),
				attackerMonsterChoice.getCurrentHealth(), defenseMonsterChoice.getCurrentHealth());

		if(damageDecision){
			dealDamage(attackerMonsterChoice,null,defense,true);
		}else{
			dealDamage(attackerMonsterChoice,defenseMonsterChoice,defense, false);
		}

	}

	public void handleBotTurnVsPlayer(Player player1, Player player2){

		if(player1.isAttacking()){
			Monster botMonster = Generator.generateRoundPick(player2);
			Monster player1Monster = GameScannerManager.handleMonsterChoice(player1);

			GameConsole.printPlayerVsBotRoundInfo(player1.getName(), player1Monster.getName(), player2.getName(),
					botMonster.getName(), player1Monster.getCurrentHealth(), botMonster.getCurrentHealth());

			boolean damageDecisionBot = Generator.generateDecisionToTakeDamage();

			if(damageDecisionBot){
				//decision and health of hit print inside dealvdamage
				dealDamage(player1Monster, null, player2, true);
			}else{
				dealDamage(player1Monster, botMonster,player2, false);
			}

		}else{

			Monster botMonster = Generator.generateRoundPick(player2);
			GameConsole.printBotMonsterSelection(player2.getName(), botMonster.getName(),
					botMonster.getCurrentHealth());

			Monster player1Monster = GameScannerManager.handleMonsterChoice(player1);
			GameConsole.printPlayerMonsterSelection(player1.getName(),player1Monster.getName(), player1Monster.getCurrentHealth());

			boolean player1Decision = DamageDecision.finalDamageDecision(GameScannerManager.handleDamageDecision());

			if(player1Decision){
				dealDamage(botMonster, null, player1, true);
			}else{
				dealDamage(botMonster, player1Monster, player1, false);
			}

		}

	}

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
}
