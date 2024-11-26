package gameAdvance.HelperClasses.Scanner;

import gameAdvance.Game;
import gameAdvance.HelperClasses.Enums.DamageDecision;
import gameAdvance.HelperClasses.Enums.GameMode;
import gameAdvance.HelperClasses.Monsters.Monster;
import gameAdvance.Player;

import java.util.Scanner;

public class GameScannerManager {

	static Scanner gameScanner = new Scanner(System.in);
	Game game;

	public GameScannerManager(Game game) {
		this.game = game;
	}

	public static GameMode handleGameModeOptions() {
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

	public static String handleDamageDecision() {
		int userChoice = 0;

		do {

			System.out.println("Do you want to take damage yourself?");
			DamageDecision.displayDecisionOptions();

			if (gameScanner.hasNextInt()) {
				userChoice = gameScanner.nextInt();
				gameScanner.nextLine();

				//check user choice and available ones
				return DamageDecision.getDamageDecision(userChoice);

			}

		} while (true);
	}

	public static Monster handleMonsterChoice(Player player) {
		//my scanner needs to grab player alive monsters and display them
		//but the display must be based on enums
		//so for each monster alive in monster get enum info

		int userChoice = 0;
		do {

			System.out.println("Choose your monster for this round!");
			player.showAliveMonsters();

			if (gameScanner.hasNextInt()) {
				userChoice = gameScanner.nextInt();
				gameScanner.nextLine();

				//compare choice with available options
				return Game.getPlayerMonsterChoice(player, userChoice);
			}

		} while (true);
	}
}
