package minderaExercices.MonsterGame.MonsterGameBasic.Monsters;

import minderaExercices.MonsterGame.MonsterGameBasic.Random;

public class Vampire extends Monster {

	private final Random random;

	public Vampire(Random random) {
		super(TypeMonsters.VAMPIRE);
		this.random = random;
	}

	@Override
	public void specialAbility() {
		bite();
	}

	//to utilize in game I must return if vampire will bite or not so the action will occur in game
	public void bite() {
		int changeOfBite = random.randomBiteChange();

		//25% change of biting, also checking if health is near 85 ensure that health doesn't go above is max health
		if (changeOfBite <= 25 && currentHealth <= 85) {
			int healthBack = 15;
			currentHealth += healthBack;
		}
	}

}
