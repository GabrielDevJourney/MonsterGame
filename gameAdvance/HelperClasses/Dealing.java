package gameAdvance.HelperClasses;

import gameAdvance.HelperClasses.Monsters.MonsterFactory;
import gameAdvance.HelperClasses.Monsters.Monster;
import gameAdvance.Player;
import gameAdvance.HelperClasses.Random;

public class Dealing {

	//this will now follow oop principles because this type of factory patterns shouldnt be static
	private final MonsterFactory factory;

	public Dealing(MonsterFactory factory) {
		this.factory = factory;
	}

	public void dealDamage(Monster attackerMonster, Monster defenseMonster, Player defense, boolean randomDecision) {
		attackerMonster.specialAbility();
		if (randomDecision) {

			//if true player take damage else take monster damage
			defense.decreaseHealth(attackerMonster.getDamage());
			System.out.println(defense.getName() + " choose to take hit himself, now has HP : " + defense.getHealth());//
		} else {
			System.out.println(defense.getName() + " choose to let monster take the hit");//

			defenseMonster.sufferHit(attackerMonster.getDamage(), defense);

			//!terminal
			GameConsole.printDamageInfo(attackerMonster.getDamage(),
					defenseMonster.getName(), defenseMonster.getCurrentHealth());
		}

	}

	public void dealCards(Player player, Random random) {
		Monster[] currentPlayerHand = player.getPlayerCards();
		for (int i = 0; i < currentPlayerHand.length; i++) {
			//choose a rancom enum type each time
			int randomIndex = random.randomTypeMonstersIndex();
			if (currentPlayerHand[i] == null) {
				currentPlayerHand[i] = factory.createRandomMonster(randomIndex);
			}
		}
	}

}
