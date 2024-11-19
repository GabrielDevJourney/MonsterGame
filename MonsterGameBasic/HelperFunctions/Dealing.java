package minderaExercices.MonsterGame.MonsterGameBasic.HelperFunctions;

import minderaExercices.MonsterGame.MonsterGameBasic.Monsters.Monster;
import minderaExercices.MonsterGame.MonsterGameBasic.Player;

public class Dealing {

	public static void dealDamage(Monster attackerMonster, Monster defenseMonster, Player defense) {
		attackerMonster.specialAbility();
		defenseMonster.sufferHit(attackerMonster.getDamage(), defense);

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
