package game;

public class Random {

	//change name for generateMonsterType
	public static int generateMonsterType() {
		return (int) (Math.random() * 10 + 1);
	}

	public static int generateBiteChange() {
		return (int) (Math.random() * 100 + 1);
	}

	public static int generateIndex(Player player) {
		return (int) (Math.random() * player.getAliveIndexCounter());
	}

}
