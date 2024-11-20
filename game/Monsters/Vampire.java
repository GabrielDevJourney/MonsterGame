package game.Monsters;

import game.Random;

public class Vampire extends Monster {

	public Vampire() {
		super();
		health = 100;
		damage = 18;
		name = "Vampire";
	}

	@Override
	public void specialAbility() {
		bite();
	}

	//to utilize in game I must return if vampire will bite or not so the action will occur in game
	public void bite() {
		int changeOfBite = Random.generateBiteChange();

		//25% change of biting, also checking if health is near 85 ensure that health doesn't go above is max health
		if (changeOfBite <= 25 && health <= 85) {
			int healthBack = 15;
			health += healthBack;
		}
	}

}
