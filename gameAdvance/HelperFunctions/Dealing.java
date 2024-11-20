package gameAdvance.HelperFunctions;

import gameAdvance.MonsterFactory;
import gameAdvance.Monsters.Monster;
import gameAdvance.Player;

public class Dealing {

	//this will now follow oop principles because this type of factory patterns shouldnt be static
	 private final MonsterFactory factory;

	public Dealing(MonsterFactory factory) {
		this.factory = factory;
	}

	public void dealDamage(Monster attackerMonster, Monster defenseMonster, Player defense,boolean randomDecision) {
		attackerMonster.specialAbility();
		if(randomDecision){

			//if true player damage else monster damage
			defense.decreaseHealth(attackerMonster.getDamage());
		}else{
		defenseMonster.sufferHit(attackerMonster.getDamage(), defense);
		}

		//!terminal
		GameConsole.printDamageInfo(attackerMonster.getDamage(),
				defenseMonster.getName(), defenseMonster.getCurrentHealth());
	}

	public void dealCards(Player player, int randomIndex) {
		Monster[] currentPlayerHand = player.getPlayerCards();
		for (int i = 0; i < currentPlayerHand.length; i++) {
			if (currentPlayerHand[i] == null) {
				currentPlayerHand[i] = factory.createRandomMonster(randomIndex);
			}
		}
	}

}
