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
	                             GameScannerManager gameScanner,
	                             boolean damageDecision, Dealing dealing) {
		//player will need to see monsters options
		//attacker choose monster
		Monster attackerMonsterChoice = gameScanner.handleMonsterChoice(attacker);

		//player2 choose take damage or not
		//no which monster show options and get his option
		//yes just decrease damage
		if (damageDecision) {
			defense.decreaseHealth(attackerMonsterChoice.getDamage());
		} else {
			Monster defenseMonsterChoice = gameScanner.handleMonsterChoice(defense);
		dealing.dealDamage(attackerMonsterChoice,defenseMonsterChoice,defense);
		}

		//handle dealdamage

	}
}
