package gameAdvance;

public enum GameMode {
	BOT_VS_BOT(1,"Bot vs Bot"),
	PLAYER_VS_BOT(2, "Player vs Bot"),
	PLAYER_VS_PLAYER(3, "Player vs Player");

	private final int id;
	private final String description;

	GameMode(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public GameMode decisionBasedOnMode(int modeChoice){
		for(GameMode mode : GameMode.values()){
			if(mode.getId() == modeChoice){
				return mode;
			}
		}

		throw IllegalArgumentException("")
	}
}
