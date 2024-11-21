package gameAdvance;

import gameAdvance.HelperClasses.*;
import gameAdvance.HelperClasses.Monsters.Monster;
import gameAdvance.HelperClasses.Monsters.MonsterFactory;
import gameAdvance.HelperClasses.Scanner.GameScannerManager;

public class Game {
	//trying to use last class subject since players will always be 2 why not set it
	private final Player[] players = new Player[2];
	private int roundTrackingCounter = 0;
	private final Generator generator = new Generator();
	private final Random random = new Random();
	private final MonsterFactory factory = new MonsterFactory(random);
	private final Dealing dealing = new Dealing(factory);
	private final GameScannerManager gameScanner = new GameScannerManager(this);

	public Game() {
		this.players[0] = new Player("Player 1");
		this.players[1] = new Player("Player 2");
		initializePlayersHands();
	}

	//*METHODS

	private void initializePlayersHands() {
		for (Player player : players) {
			dealing.dealCards(player, random);
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
		//&& cuz need oly one to stop game
		while (!player1.hasNoCards() && !player2.hasNoCards() && !player1.isHasLost() && !player2.isHasLost()) {

			playRound(player1, player2);
			roundTrackingCounter++;
		}

		endGame(player1, player2);

	}

	private void playRound(Player player1, Player player2) {

		//todo for scanner to be implmented this must go way into a bot vs bot method since they will auto play
		Monster monsterPlayer1 = generator.generateRoundPick(player1);
		Monster monsterPlayer2 = generator.generateRoundPick(player2);


		if (roundTrackingCounter % 2 == 0) {
			//generate here to always pick different monster

			//!terminal info
			GameConsole.printRoundInfo(roundTrackingCounter, player1.getName(), player2.getName(),
					monsterPlayer1.getName(), monsterPlayer2.getName(),
					monsterPlayer1.getCurrentHealth(), monsterPlayer2.getCurrentHealth());

			handleTurn(player2, monsterPlayer1, monsterPlayer2);

		} else {

			//!terminal info
			GameConsole.printRoundInfo(roundTrackingCounter, player2.getName(), player1.getName(),
					monsterPlayer2.getName(), monsterPlayer1.getName(),
					monsterPlayer2.getCurrentHealth(), monsterPlayer1.getCurrentHealth());


			handleTurn(player1, monsterPlayer2, monsterPlayer1);

		}

	}


	//no need for attacker player itself be passed since I am passing his selected monster and that is where i will
	// grab damage to deal from
	private void handleTurn(Player defense, Monster attackerMonster, Monster defenseMonster) {
		dealing.dealDamage(attackerMonster, defenseMonster, defense,generator.generateDecisionToTakeDamage());
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

	public Monster getPlayerMonsterChoice(Player player, int userChoice){
		Monster[] currentAliveCards = player.getCardsAlive();
		for(Monster currentMonster : currentAliveCards){
			if(userChoice == currentMonster.getId() ){
				return currentMonster;
			}
		}
		throw new IllegalArgumentException("That monster isn't available");
	}

}
