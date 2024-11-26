package gameAdvance.HelperClasses.Monsters;

import gameAdvance.HelperClasses.Enums.TypeMonsters;
import gameAdvance.HelperClasses.Random;

public class MonsterFactory {


	private static Monster monsterCreator(TypeMonsters type) {
		switch (type) {
			case VAMPIRE -> {
				return new Vampire(Random.randomBiteChange());
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

	public static Monster createRandomMonster(int randomIndex){
		//monsterCreator(randomType)
		TypeMonsters type = TypeMonsters.values()[randomIndex];
		return monsterCreator(type);
	}

}
