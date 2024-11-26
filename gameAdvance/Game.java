package gameAdvance;

import gameAdvance.HelperClasses.*;
import gameAdvance.HelperClasses.Enums.GameMode;
import gameAdvance.HelperClasses.Monsters.Monster;
import gameAdvance.HelperClasses.Monsters.MonsterFactory;
import gameAdvance.HelperClasses.Scanner.GameScannerManager;

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
		GameMode mode = GameScannerManager.handleGameModeOptions();
		GameConsole.printGameStart(mode);
		playGame(mode);
	}

	private void playGame(GameMode mode) {
		Player player1 = players[0];
		Player player2 = players[1];

		//keep playing while neither has lost all cards so have a variable for both
		//&& cuz need oly one to stop game
		while (!player1.hasNoCards() && !player2.hasNoCards() && !player1.isHasLost() && !player2.isHasLost()) {

			playRound(player1, player2,mode);
			roundTrackingCounter++;
		}

		endGame(player1, player2);

	}

	private void playRound(Player player1, Player player2, GameMode mode) {

		GameConsole.printRoundStart(roundTrackingCounter);

		switch (mode){
			case BOT_VS_BOT -> {
				handleGameBotVsBot(player1,player2);
			}
			case PLAYER_VS_BOT -> {
				handleGamePlayerVsBot(player1, player2);
			}
		}

		GameConsole.printRoundEnd();

			//!terminal info
			/*GameConsole.printRoundInfo(roundTrackingCounter, player2.getName(), player1.getName(),
					monsterPlayer2.getName(), monsterPlayer1.getName(),
					monsterPlayer2.getCurrentHealth(), monsterPlayer1.getCurrentHealth());*/
	}


	//no need for attacker player itself be passed since I am passing his selected monster and that is where i will
	// grab damage to deal from
	private void handleGameBotVsBot(Player player1,Player player2) {
		if (roundTrackingCounter % 2 == 0) {
			Monster attackerMonster = Generator.generateRoundPick(player1);
			TurnHandler.handleBotTurnBotVsBot(player1,player2,attackerMonster,roundTrackingCounter);
			if(player2.hasNoCards()){
				player2.setHasLost(true);
			}
		}else{
			Monster attackerMonster = Generator.generateRoundPick(player2);
			TurnHandler.handleBotTurnBotVsBot(player2,player1,attackerMonster,roundTrackingCounter);
			if(player1.hasNoCards()){
				player1.setHasLost(true);
			}
		}
	}

	private void handleGamePlayerVsBot(Player player1, Player player2){
		if(roundTrackingCounter % 2 == 0){

			player1.setAttacking(true);
			player2.setAttacking(false);

			TurnHandler.handleBotTurnVsPlayer(player1,player2);

		}else{
			player1.setAttacking(false);
			player2.setAttacking(true);

			TurnHandler.handleBotTurnVsPlayer(player1,player2);
		}
	}

/*	private void handlePlayerVsPlayer(Player player1, Player player2){
		if % 2 == 0){
			turnHandler.handlePlayerTurn(player1,player2,gameScanner,dealing);
		}else{
			turnHandler.handlePlayerTurn(player2,player1,gameScanner,dealing);
		}
	}*/

	private void endGame(Player player1, Player player2) {
		if (player1.isHasLost()) {
			GameConsole.announceWinner(player2.getName(), player1.getName());
		} else {
			GameConsole.announceWinner(player1.getName(), player2.getName());
		}
	}

	public static Monster getPlayerMonsterChoice(Player player, int userChoice) {
		Monster[] currentAliveCards = player.getCardsAlive();
		for (Monster currentMonster : currentAliveCards) {
			if (userChoice == currentMonster.getId()) {
				return currentMonster;
			}
		}
		throw new IllegalArgumentException("That monster isn't available");
	}

}
