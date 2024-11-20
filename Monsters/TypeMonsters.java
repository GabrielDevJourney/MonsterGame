package minderaExercices.MonsterGame.MonsterGameBasic.Monsters;

public enum TypeMonsters {
	VAMPIRE(1),
	MUMMY(2),
	WEREWOLF(3);

	private int id;

	private TypeMonsters(int id){
		this.id = id;
	}

	public static Monster typeOfMonstersToCreate(int id){
		switch (id){
			case 1:{
				return new Vampire();
			}
			case 2 : {
				return new Mummy();
			}
			case 3 : {
				return new Werewolf();
			}
		}
	}
}
