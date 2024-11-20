package minderaExercices.MonsterGame.MonsterGameBasic;

import minderaExercices.MonsterGame.MonsterGameBasic.Monsters.Monster;
import minderaExercices.MonsterGame.MonsterGameBasic.Monsters.TypeMonsters;

public class Random {

	//change name for generateMonsterType
	public static int randomMonsterTypeId() {
		return  (int) (Math.random() * 3 + 1);
	}

	public static int randomBiteChange() {
		return (int) (Math.random() * 100 + 1);
	}

	public static int randomIndex(Player player) {
		return (int) (Math.random() * player.getAliveIndexCounter());
	}

	public static int randomDecision(){
		return (int)(Math.random() * 10 + 1);
	}

}
