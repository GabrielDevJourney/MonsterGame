package gameAdvance.HelperClasses;

import gameAdvance.HelperClasses.Monsters.MonsterFactory;
import gameAdvance.HelperClasses.Monsters.Monster;
import gameAdvance.Player;

public class Dealing {

	public static void dealDamage(Monster attackerMonster, Monster defenseMonster, Player defense, boolean randomDecision) {

		if (randomDecision) {
			int healthBeforeHit = defense.getHealth();

			//if true player take damage else take monster damage
			defense.decreaseHealth(attackerMonster.getDamage());

			GameConsole.displayPlayerHealthWhenHit(defense, healthBeforeHit);

		} else {

			System.out.println(defense.getName() + " choose to let monster take the hit");

			attackerMonster.specialAbility();
			defenseMonster.sufferHit(attackerMonster.getDamage(), defense);

			//!terminal
			GameConsole.printDamageInfo(attackerMonster.getDamage(),
					defenseMonster.getName(), defenseMonster.getCurrentHealth());

		}

	}

	public static void dealCards(Player player) {
		Monster[] currentPlayerHand = player.getPlayerCards();
		for (int i = 0; i < currentPlayerHand.length; i++) {
			//choose a rancom enum type each time
			int randomIndex = Random.randomTypeMonstersIndex();
			if (currentPlayerHand[i] == null) {
				currentPlayerHand[i] = MonsterFactory.createRandomMonster(randomIndex);
			}
		}
	}

}
