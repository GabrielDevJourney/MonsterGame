package game.HelperFunctions;

//todo print player vida cada round

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
}
