package gameAdvance.HelperClasses;

import gameAdvance.HelperClasses.Enums.TypeMonsters;
import gameAdvance.Player;

public class Random {

	public int randomBiteChange() {
		return (int) (Math.random() * 100 + 1);
	}

	public int randomIndex(Player player) {
		return (int) (Math.random() * player.getAliveIndexCounter());
	}

	public int randomDecision(){
		return (int)(Math.random() * 10 + 1);
	}

	public int randomTypeMonstersIndex(){
		return (int)(Math.random() * TypeMonsters.values().length);
	}

}
