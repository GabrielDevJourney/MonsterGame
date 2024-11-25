package game.HelperFunctions;

import game.Monsters.Monster;
import game.Player;

public class Dealing {

	public static void dealDamage(Monster attackerMonster, Monster defenseMonster, Player defense) {

		attackerMonster.attack(defenseMonster);

		//!terminal
		GameConsole.printDamageInfo(attackerMonster.getDamage(),
				defenseMonster.getName(), defenseMonster.getHealth());
	}

	public static void dealCards(Player player) {
		Monster[] currentPlayerHand = player.getPlayerCards();
		for (int i = 0; i < currentPlayerHand.length; i++) {
			if (currentPlayerHand[i] == null) {
				currentPlayerHand[i] = Generator.generateRandomDealCard();
			}
		}
	}

}
