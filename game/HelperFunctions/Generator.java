package game.HelperFunctions;

import game.Monsters.Monster;
import game.Monsters.Mummy;
import game.Monsters.Vampire;
import game.Monsters.Werewolf;
import game.Player;
import game.Random;

public class Generator {
	public static Monster generateRandomDealCard() {
		int randomNumberToDealCard = Random.generateMonsterType();

		if (randomNumberToDealCard <= 2) {
			return new Werewolf();
			//will go to next since num is above 3 no need for &&
		} else if (randomNumberToDealCard <= 6) return new Mummy();
		return new Vampire();
	}

	public static Monster generateRandomRoundPick(Player player) {
		int randomIndex = Random.generateIndex(player);

		if (player.getCardsAlive() == null) {
			player.updateAliveCards();
		}

		Monster[] currentPlayerCards = player.getCardsAlive();
		return currentPlayerCards[randomIndex];

	}
}
