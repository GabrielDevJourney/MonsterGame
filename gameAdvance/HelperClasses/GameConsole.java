package gameAdvance.HelperClasses;

import gameAdvance.HelperClasses.Enums.GameMode;
import gameAdvance.HelperClasses.Monsters.Monster;
import gameAdvance.Player;

public class GameConsole {
	public static void printRoundInfo(int round, String attackerName, String defenseName,
	                                  String attackerMonsterName, String defenseMonsterName,
	                                  int attackerHealth, int defenseHealth) {

		System.out.println("\nRound: " + round);
		System.out.println(attackerName + " is attacking and " + defenseName + " is being attacked!");
		System.out.println(attackerName + " monster: " + attackerMonsterName + " - HP: " + attackerHealth);
		System.out.println(defenseName + " monster: " + defenseMonsterName + " - HP: " + defenseHealth);
	}

	public static void printDamageInfo(int attackerDamage,
	                                   String defenseMonsterName,
	                                   int defenseHealth) {
		System.out.println("Damage dealt to " + defenseMonsterName + " " + attackerDamage + " damage");
		System.out.println(defenseMonsterName + " health after hit - HP: " + defenseHealth);
	}

	public static void announceWinner(String winnerName, String loserName) {
		System.out.println(winnerName + " wins! " + loserName + " has lost!");
	}

	public static void displayPlayerHealthWhenHit(Player defense, int healthBeforeHit){
		System.out.println(defense.getName() + " choose to take hit himself health before " + healthBeforeHit +
				" after hit now has HP : " + defense.getHealth());
	}

	//player vs bot
	//player attacking
		//round display
		//plyaer1 is attacking plyaer 2 defending
		//!player 1 choose
		//display bot monster and damage decision
		//health dislay of based on if bot has take damage or mosnter did
	//bot attacking
		//round
		//bot monster
		//player choose monster then display
		//then plauer choose to take or hit or no based on that display either player monsters helth or plyaer health

	public static void printPlayerVsBotRoundInfo(Player attacker, Monster attackerMonster,
	                                             Player defense, Monster defenseMonster) {
		System.out.println(attacker.getName() + " is attacking with " + attackerMonster.getName() +
				" (HP: " + attackerMonster.getCurrentHealth() + ")");
		System.out.println(defense.getName() + " defends with " + defenseMonster.getName() +
				" (HP: " + defenseMonster.getCurrentHealth() + ")");
	}

	public static void printBotMonsterSelection(String botName, Monster selectedMonster) {
		System.out.println(botName + " selected " + selectedMonster.getName() +
				" (HP: " + selectedMonster.getCurrentHealth() + ")");
	}

	public static void printPlayerMonsterSelection(String playerName, Monster selectedMonster) {
		System.out.println(playerName + " selected " + selectedMonster.getName() +
				" (HP: " + selectedMonster.getCurrentHealth() + ")");
	}

	public static void printPlayerDecisionInfo(String playerName, boolean tookDamage, Monster playerMonster) {
		if (tookDamage) {
			System.out.println(playerName + " chose to take damage directly");
		} else {
			System.out.println(playerName + " chose to defend with " + playerMonster.getName() +
					" (HP: " + playerMonster.getCurrentHealth() + ")");
		}
	}

	public static void printTurnResult(String attackerName, String defenseName,
	                                   String defenderType, int damageDealt, int remainingHealth) {
		System.out.println(attackerName + " dealt " + damageDealt + " damage to " + defenseName + "'s " +
				defenderType + ". Remaining HP: " + remainingHealth);
	}

	public static void printGameStart(GameMode mode) {
		System.out.println("\n=========================");
		System.out.println("Game Starting - Mode: " + mode.getDescription());
		System.out.println("=========================\n");
	}

	public static void printRoundStart(int roundNumber) {
		System.out.println("\n=========================");
		System.out.println("Round " + roundNumber);
		System.out.println("=========================");
	}

	public static void printRoundEnd() {
		System.out.println("\n-------------------------\n");
	}
}
