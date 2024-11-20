package minderaExercices.MonsterGame.MonsterGameBasic;

import minderaExercices.MonsterGame.MonsterGameBasic.HelperFunctions.Generator;
import minderaExercices.MonsterGame.MonsterGameBasic.Monsters.*;

public class MonsterFactory {

	//!this type must generated random
	private Monster monsterCreator(TypeMonsters type) {
		switch (type) {
			case VAMPIRE -> {
				return new Vampire();
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
