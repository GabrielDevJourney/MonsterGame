package gameAdvance.HelperClasses;

import gameAdvance.Monsters.Monster;
import gameAdvance.Player;

public class Generator {


	public static Monster generateRoundPick(Player player) {
		int randomIndex = Random.randomIndex(player);

		if (player.getCardsAlive() == null) {
			player.updateAliveCards();
		}

		Monster[] currentPlayerCards = player.getCardsAlive();
		return currentPlayerCards[randomIndex];

	}

	public static boolean generateDecisionToTakeDamage(){
		//40% change for player to take damage
		return Random.randomDecision() <= 4;
	}

}
