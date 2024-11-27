package gameAdvance.HelperClasses;

import gameAdvance.Enums.TypeMonsters;
import gameAdvance.Player;

public class Random {

	//todo create more generic random based on ranges, also use this for randomobstacle in game for the change of
	// either like 70/30 or something
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
