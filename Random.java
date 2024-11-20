package minderaExercices.MonsterGame.MonsterGameBasic;

public class Random {

	//change name for generateMonsterType
	public static int randomMonsterType() {
		return (int) (Math.random() * 10 + 1);
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
