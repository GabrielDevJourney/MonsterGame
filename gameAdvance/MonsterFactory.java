package gameAdvance;

import gameAdvance.Monsters.*;

public class MonsterFactory {

	private final Random random;

	public MonsterFactory(Random random) {
		this.random = random;
	}

	private Monster monsterCreator(TypeMonsters type) {
		switch (type) {
			case VAMPIRE -> {
				return new Vampire(random.randomBiteChange());
			}
			case MUMMY -> {
				return new Mummy();
			}
			case WEREWOLF -> {
				return new Werewolf();
			}
		}
		throw new IllegalArgumentException("Invalid monster type");
	}

	public Monster createRandomMonster(int randomIndex){
		//monsterCreator(randomType)
		TypeMonsters type = TypeMonsters.values()[randomIndex];
		return monsterCreator(type);
	}

}
