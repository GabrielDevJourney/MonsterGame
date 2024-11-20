package game;

import game.HelperFunctions.Dealing;
import game.HelperFunctions.GameConsole;
import game.HelperFunctions.Generator;
import game.Monsters.Monster;

public class Game {
	//trying to use last class subject since players will always be 2 why not set it
	private final Player[] players = new Player[2];
	private int roundTrackingCounter = 0;

	public Game() {
		this.players[0] = new Player("Player 1");
		this.players[1] = new Player("Player 2");
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
		while (!player1.hasNoCards() && !player2.hasNoCards()) {

			playRound(player1, player2);
			roundTrackingCounter++;
		}

		endGame(player1, player2);

	}

	private void playRound(Player player1, Player player2) {

		Monster monsterPlayer1 = Generator.generateRandomRoundPick(player1);
		Monster monsterPlayer2 = Generator.generateRandomRoundPick(player2);


		if (roundTrackingCounter % 2 == 0) {
			//generate here to always pick different monster

			//!terminal info
			GameConsole.printRoundInfo(roundTrackingCounter, player1.getName(), player2.getName(),
					monsterPlayer1.getName(), monsterPlayer2.getName(),
					monsterPlayer1.getHealth(), monsterPlayer2.getHealth());

			handleTurn(player2, monsterPlayer1, monsterPlayer2);
		} else {

			//!terminal info
			GameConsole.printRoundInfo(roundTrackingCounter, player2.getName(), player1.getName(),
					monsterPlayer2.getName(), monsterPlayer1.getName(),
					monsterPlayer2.getHealth(), monsterPlayer1.getHealth());


			handleTurn(player1, monsterPlayer2, monsterPlayer1);
		}

	}


	//no need for attacker player itself be passed since I am passing his selected monster and that is where i will
	// grab damage to deal from
	private void handleTurn(Player defense, Monster attackerMonster, Monster defenseMonster) {
		Dealing.dealDamage(attackerMonster, defenseMonster, defense);
		if (defense.hasNoCards()) {
			defense.setHasLost(true);

		}
	}

	private void endGame(Player player1, Player player2) {
		if (player1.isHasLost()) {
			GameConsole.announceWinner(player2.getName(), player1.getName());
		} else {
			GameConsole.announceWinner(player1.getName(), player2.getName());
		}
	}

}
