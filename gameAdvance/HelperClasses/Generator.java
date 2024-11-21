package gameAdvance.HelperClasses;

import gameAdvance.HelperClasses.Monsters.Monster;
import gameAdvance.Player;

public class Generator {

	private final Random random = new Random();

	public Monster generateRoundPick(Player player) {
		int randomIndex = random.randomIndex(player);

		if (player.getCardsAlive() == null) {
			player.updateAliveCards();
		}

		Monster[] currentPlayerCards = player.getCardsAlive();
		return currentPlayerCards[randomIndex];

	}

	public boolean generateDecisionToTakeDamage(){
		//40% change for player to take damage
		return random.randomDecision() <= 4;
	}

}
