package game;

import game.HelperFunctions.Dealing;
import game.HelperFunctions.GameConsole;
import game.HelperFunctions.Generator;
import game.Monsters.Monster;
import game.Obstacule.Fairy;
import game.Obstacule.Whitch;

public class Game {
	//trying to use last class subject since players will always be 2 why not set it
	private final Player[] players = new Player[2];
	public static final Supernatural[] obstacles = new Supernatural[2];
	private int roundTrackingCounter = 0;

	public Game() {
		this.players[0] = new Player("Player 1");
		this.players[1] = new Player("Player 2");
		obstacles[0] = new Fairy();
		obstacles[1] = new Whitch();
		initializePlayersHands();
	}


	//*METHODS

	private void initializePlayersHands() {
		for (Player player : players) {
			Dealing.dealCards(player);
			//initialize cardsAlive with all new cards
			player.updateAliveCards();
		}
	}

	public void start() {
		playGame();
	}

	private void playGame() {
		Player player1 = players[0];
		Player player2 = players[1];

		//keep playing while neither has lost all cards so have a variable for both
		while (!player1.hasNoCards() && !player1.isHasLost() && !player2.hasNoCards() && !player2.isHasLost()) {

			playRound(player1, player2);
		}

		endGame(player1, player2);

	}

	private void playRound(Player player1, Player player2) {

		Monster monsterPlayer1 = Generator.generateRandomRoundPick(player1);
		Monster monsterPlayer2 = Generator.generateRandomRoundPick(player2);

		if (monsterPlayer1 == null || monsterPlayer2 == null) {

			player1.updateAliveCards();
			player2.updateAliveCards();

			if (player1.hasNoCards()) {
				player1.setHasLost(true);
			}
			if (player2.hasNoCards()) {
				player2.setHasLost(true);
			}

			return;

		}


		roundTrackingCounter++;
		Supernatural gameObstacule = Generator.generateRandomObstacule();

		if (gameObstacule != null) {
			handleTurnWithObstacule(gameObstacule, player1, player2, monsterPlayer1, monsterPlayer2);
		} else {
			if (roundTrackingCounter % 2 == 0) {

				//!terminal info
				GameConsole.printRoundInfo(roundTrackingCounter, player1.getName(), player2.getName(),
						monsterPlayer1.getName(), monsterPlayer2.getName(),
						monsterPlayer1.getHealth(), monsterPlayer2.getHealth());


				handleTurn(player1, player2, monsterPlayer1, monsterPlayer2);

			} else {

				//!terminal info
				GameConsole.printRoundInfo(roundTrackingCounter, player2.getName(), player1.getName(),
						monsterPlayer2.getName(), monsterPlayer1.getName(),
						monsterPlayer2.getHealth(), monsterPlayer1.getHealth());


				handleTurn(player2, player1, monsterPlayer2, monsterPlayer1);

			}
		}
	}


	private void handleTurn(Player attacker, Player defense, Monster attackerMonster, Monster defenseMonster) {

	Dealing.dealDamage(attackerMonster, defenseMonster, defense);

	//need to handle possibility of mummy being the attacker and dying from penalty damage
	defense.updatePlayerCardsState(defenseMonster);
	attacker.updatePlayerCardsState(attackerMonster);

}

	private void handleTurnWithObstacule(Supernatural obstacule, Player attacker, Player defense,
                                     Monster attackerMonster,
                                     Monster defenseMonster) {

	obstacule.attack(roundTrackingCounter, attacker, defense, attackerMonster, defenseMonster);

	attacker.updatePlayerCardsState(attackerMonster);
	defense.updatePlayerCardsState(defenseMonster);
}

	private void endGame(Player player1, Player player2) {
	if (player1.hasNoCards() || player1.isHasLost()) {
		GameConsole.announceWinner(player2.getName(), player1.getName());
	} else if (player2.hasNoCards() || player2.isHasLost()) {
		GameConsole.announceWinner(player1.getName(), player2.getName());
	}
}

}
