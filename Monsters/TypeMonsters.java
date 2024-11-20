package minderaExercices.MonsterGame.MonsterGameBasic.Monsters;

public enum TypeMonsters {
	VAMPIRE(1),
	MUMMY(2),
	WEREWOLF(3);

	//todo implement health for each here also have a getter for this health
	private int id;

	private TypeMonsters(int id){
		this.id = id;
	}

	public static Monster typeOfMonstersToCreate(int id){
		for(TypeMonsters type : TypeMonsters.values()){
			if(type.id == id){
				switch (type){
					case VAMPIRE -> {
						return new Vampire();
					}
					case MUMMY -> {
						return new Mummy();
					}
					case WEREWOLF -> {
						return new Werewolf();
					}
				}
			}
		}
		return null;
	}
}
