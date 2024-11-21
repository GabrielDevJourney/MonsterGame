package gameAdvance.HelperClasses.Scanner;

import gameAdvance.Game;
import gameAdvance.HelperClasses.Enums.DamageDecision;
import gameAdvance.HelperClasses.Enums.GameMode;
import gameAdvance.HelperClasses.Monsters.Monster;
import gameAdvance.Player;

import java.util.Scanner;

public class GameScannerManager {

	Scanner gameScanner = new Scanner(System.in);
	Game game;

	public GameScannerManager(Game game) {
		this.game = game;
	}

	public GameMode handleGameModeOptions() {
		int userChoice = 0;

		do {

			GameMode.displayModeOptions();

			if (gameScanner.hasNextInt()) {
				userChoice = gameScanner.nextInt();
				gameScanner.nextLine();

				//check user choice and available ones
				return GameMode.decisionOfMode(userChoice);

			}

		} while (true);

	}

	public boolean handleDamageDecision() {
		int userChoice = 0;

		do {

			DamageDecision.displayDecisionOptions();

			if (gameScanner.hasNextInt()) {
				userChoice = gameScanner.nextInt();
				gameScanner.nextLine();

				//check user choice and available ones
				return DamageDecision.damageDecision(userChoice);

			}

		} while (true);
	}

	public Monster handleMonsterChoice(Player player) {
		//my scanner needs to grab player alive monsters and display them
		//but the display must be based on enums
		//so for each monster alive in monster get enum info

		int userChoice = 0;
		do {

			player.showAliveMonsters();

			if (gameScanner.hasNextInt()) {
				userChoice = gameScanner.nextInt();
				gameScanner.nextLine();

				//compare choice with available options
				return game.getPlayerMonsterChoice(player, userChoice);
			}

		} while (true);
	}
}
