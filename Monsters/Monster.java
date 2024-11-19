package minderaExercices.MonsterGame.MonsterGameBasic.Monsters;

import minderaExercices.MonsterGame.MonsterGameBasic.Player;

public abstract class Monster {
	protected String name;
	protected int health;
	protected int damage;
	protected boolean isDead;

	//if I need all monsters to have an id this also means that those id must be different with simply incrementing
	// so all will share id this means the current monster id will be last one set ++ this should be incremented in
	// monster, but I can do something like in each monster type this.id = id++

	//*GETTERS AND SETTERS


	public int getHealth() {
		return health;
	}

	public String getName() {
		return name;
	}

	public int getDamage() {
		return damage;
	}

	public boolean isDead() {
		return isDead;
	}

	//check for zero health this means mosnter is dead
	public void setHealth(int healthAfterHit) {
		if (healthAfterHit < 0) {
			this.health = 0;
			isDead = true;
		} else {
			this.health = healthAfterHit;
		}
	}

	//*METHODS

	public abstract void specialAbility();

	//using This is referring to the monster that already called method on itself
	public void sufferHit(int damageOfHit, Player currentPlayer) {
		int healthAfterHit = this.getHealth() - damageOfHit;
		this.setHealth(healthAfterHit);
		if (this.isDead) {
			currentPlayer.decreaseCardsAlive();
			currentPlayer.updateAliveCards();
		}
	}
}
