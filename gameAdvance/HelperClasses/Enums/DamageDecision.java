package gameAdvance.HelperClasses.Enums;

public enum DamageDecision {
	YES(1, "Yes"),
	NO(2, "No");

	private final int id;
	private final String description;

	DamageDecision(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public static boolean damageDecision(int damageDecision) {
		for (DamageDecision decision : DamageDecision.values()) {
			if (decision.getId() == damageDecision) {

				return damageDecision == 1;
			}
		}

		throw new IllegalArgumentException("This choice doesn't exist");
	}

	public static void displayDecisionOptions() {
		System.out.println("Choose a game decision");
		for (DamageDecision decision : DamageDecision.values()) {
			System.out.println(decision.getId() + " " + decision.getDescription());
		}
	}

}
