package gameAdvance.HelperClasses;

import gameAdvance.Enums.TypeMonsters;
import gameAdvance.Player;

public class Random {

	public static int randomBiteChange() {
		return (int) (Math.random() * 100 + 1);
	}

	public static int randomIndex(Player player) {
		return (int) (Math.random() * player.getAliveIndexCounter());
	}

	public static int randomDecision(){
		return (int)(Math.random() * 10 + 1);
	}

	public static int randomTypeMonstersIndex(){
		return (int)(Math.random() * TypeMonsters.values().length);
	}

}
