package gameAdvance.HelperClasses;

import gameAdvance.Game;
import gameAdvance.HelperClasses.Enums.DamageDecision;
import gameAdvance.HelperClasses.Enums.GameMode;
import gameAdvance.HelperClasses.Monsters.Monster;
import gameAdvance.HelperClasses.Scanner.GameScannerManager;
import gameAdvance.Player;

public class TurnHandler {

	//need to handle different mode flows since i will need to "pause" pvp to get player 2 decision
	//todo this needs to now what mode is being played to either generate a choice or get a choice from playerDefense
	// so,if player vs player call damageDecison and show monster to player 2 and what he will be using to take hit
	// if his damage decison is no
	public static void handlePlayerTurn(Player attacker, Player defense, Monster attackerMonsterChoice) {


		//todo if is attacking just get the monster choice else get monster choice, and damage decision so i need to
		// pass the isAttacking trough args
		String damageDecision = GameScannerManager.handleDamageDecision();

		if (damageDecision.equals("Yes")) {
			Dealing.dealDamage(attackerMonsterChoice, null, defense, true);
		} else {
			Monster defenseMonsterChoice = GameScannerManager.handleMonsterChoice(defense);
			Dealing.dealDamage(attackerMonsterChoice, defenseMonsterChoice, defense, false);
		}
	}

	public static void handleBotTurnBotVsBot(Player attacker, Player defense,Monster attackerMonsterChoice,
	                                  int roundTrackingCounter){


		Monster defenseMonsterChoice = Generator.generateRoundPick(defense);
		boolean damageDecision = Generator.generateDecisionToTakeDamage();


		GameConsole.printRoundInfo(roundTrackingCounter, attacker.getName(), defense.getName(),
				attackerMonsterChoice.getName(), defenseMonsterChoice.getName(),
				attackerMonsterChoice.getCurrentHealth(), defenseMonsterChoice.getCurrentHealth());

		if(damageDecision){
			Dealing.dealDamage(attackerMonsterChoice,null,defense,true);
		}else{
			Dealing.dealDamage(attackerMonsterChoice,defenseMonsterChoice,defense, false);
		}

	}

	public static void handleBotTurnVsPlayer(Player player1, Player player2){

		if(player1.isAttacking()){
			Monster botMonster = Generator.generateRoundPick(player2);
			Monster player1Monster = GameScannerManager.handleMonsterChoice(player1);

			GameConsole.printPlayerVsBotRoundInfo(player1, player1Monster, player2, botMonster);

			boolean damageDecisionBot = Generator.generateDecisionToTakeDamage();

			if(damageDecisionBot){
				//decision and health of hit print inside dealvdamage
				Dealing.dealDamage(player1Monster, null, player2, true);
			}else{
				Dealing.dealDamage(player1Monster, botMonster,player2, false);
			}

		}else{

			Monster botMonster = Generator.generateRoundPick(player2);
			GameConsole.printBotMonsterSelection(player2.getName(),botMonster);

			Monster player1Monster = GameScannerManager.handleMonsterChoice(player1);
			GameConsole.printPlayerMonsterSelection(player1.getName(),player1Monster);

			boolean player1Decision = DamageDecision.finalDamageDecision(GameScannerManager.handleDamageDecision());
			GameConsole.printPlayerDecisionInfo(player1.getName(), player1Decision, player1Monster);

			if(player1Decision){
				Dealing.dealDamage(botMonster, null, player1, true);
			}else{
				Dealing.dealDamage(botMonster, player1Monster, player1, false);
			}

		}

	}
}
