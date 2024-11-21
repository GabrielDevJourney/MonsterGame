package gameAdvance;

public enum DamageDecision {
	YES(1, "Yes"),
	NO(2, "No");

	private int id;
	private String description;

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

	public static DamageDecision damageDecision(int damageDecision) {
		for (DamageDecision decision : DamageDecision.values()) {
			if (decision.getId() == damageDecision) {
				return decision;
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
