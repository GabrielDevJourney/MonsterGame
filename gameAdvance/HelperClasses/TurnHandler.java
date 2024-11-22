package gameAdvance.HelperClasses;

import gameAdvance.HelperClasses.Monsters.Monster;
import gameAdvance.HelperClasses.Scanner.GameScannerManager;
import gameAdvance.Player;

public class TurnHandler {

	//need to handle different mode flows since i will need to "pause" pvp to get player 2 decision
	//todo this needs to now what mode is being played to either generate a choice or get a choice from playerDefense
	// so,if player vs player call damageDecison and show monster to player 2 and what he will be using to take hit
	// if his damage decison is no
	public void handlePlayerTurn(Player attacker, Player defense,
	                             GameScannerManager gameScanner, Dealing dealing) {

		Monster attackerMonsterChoice = gameScanner.handleMonsterChoice(attacker);

		boolean damageDecision = gameScanner.handleDamageDecision();

		if (damageDecision) {
			dealing.dealDamage(attackerMonsterChoice, null, defense, true);
		} else {
			Monster defenseMonsterChoice = gameScanner.handleMonsterChoice(defense);
			dealing.dealDamage(attackerMonsterChoice, defenseMonsterChoice, defense, false);
		}
	}

	public void handleBotTurn(Player attacker, Player defense,Monster defenseMonster,Dealing dealing,
	                          Generator generator, int roundTrackingCounter){
		//generate monster
		//and simply atack defense monster
		Monster attackerMonsterChoice = generator.generateRoundPick(attacker);
		boolean damageDecision = generator.generateDecisionToTakeDamage();

		if(damageDecision){
			dealing.dealDamage(attackerMonsterChoice,null,defense,true);
		}else{
			dealing.dealDamage(attackerMonsterChoice,defenseMonster,defense, false);
		}

		GameConsole.printRoundInfo(roundTrackingCounter, attacker.getName(), defense.getName(),
				attackerMonsterChoice.getName(), defenseMonster.getName(),
				attackerMonsterChoice.getCurrentHealth(), defenseMonster.getCurrentHealth());
	}
}
