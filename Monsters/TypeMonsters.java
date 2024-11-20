package minderaExercices.MonsterGame.MonsterGameBasic.Monsters;

public enum TypeMonsters {
	VAMPIRE(1,100,18, "Vampire"),
	MUMMY(2,120,15, "Mummy"),
	WEREWOLF(3,140,20, "Werewolf");

	private final int id;
	private final int health;
	private final int damage;
	private final String name;

	private TypeMonsters(int id, int health, int damage, String name){
		this.id = id;
		this.health = health;
		this.damage = damage;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getCurrentHealth() {
		return health;
	}

	public int getDamage() {
		return damage;
	}

	public static Monster typeOfMonstersToCreate(int id){
		for(TypeMonsters type : TypeMonsters.values()){
			if(id == type.getId()){
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
		//instead of null i can do this type of built in error that will be fast to
		//let me know to see if everything is working nice and smooth
		throw new IllegalArgumentException("Invalid monster id " + id);
	}
}
