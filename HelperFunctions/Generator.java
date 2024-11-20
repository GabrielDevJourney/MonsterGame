package minderaExercices.MonsterGame.MonsterGameBasic.HelperFunctions;

import minderaExercices.MonsterGame.MonsterGameBasic.Monsters.Monster;
import minderaExercices.MonsterGame.MonsterGameBasic.Monsters.Mummy;
import minderaExercices.MonsterGame.MonsterGameBasic.Monsters.Vampire;
import minderaExercices.MonsterGame.MonsterGameBasic.Monsters.Werewolf;
import minderaExercices.MonsterGame.MonsterGameBasic.Player;
import minderaExercices.MonsterGame.MonsterGameBasic.Random;

public class Generator {
	public static Monster generateRandomDealCard() {
		int randomNumberToDealCard = Random.randomMonsterType();

		if (randomNumberToDealCard <= 2) {
			return new Werewolf();
			//will go to next since num is above 3 no need for &&
		} else if (randomNumberToDealCard <= 6) return new Mummy();
		return new Vampire();
	}

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
