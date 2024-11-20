package minderaExercices.MonsterGame.MonsterGameBasic.HelperFunctions;

import minderaExercices.MonsterGame.MonsterGameBasic.Monsters.*;
import minderaExercices.MonsterGame.MonsterGameBasic.Player;
import minderaExercices.MonsterGame.MonsterGameBasic.Random;

public class Generator {
	public static Monster generateRandomDealCard() {
		return TypeMonsters.typeOfMonstersToCreate(Random.randomMonsterTypeId());
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
