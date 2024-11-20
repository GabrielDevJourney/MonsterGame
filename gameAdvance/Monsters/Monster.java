package gameAdvance.Monsters;

import gameAdvance.Player;

public abstract class Monster {
	protected final String name;
	protected int currentHealth;
	protected TypeMonsters type;
	protected final int damage;
	protected boolean isDead;

	public Monster(TypeMonsters type){
		this.type = type;
		this.currentHealth = type.getCurrentHealth();
		this.damage = type.getDamage();
		this.name = type.getName();
	}

	//if I need all monsters to have an id this also means that those id must be different with simply incrementing
	// so all will share id this means the current monster id will be last one set ++ this should be incremented in
	// monster, but I can do something like in each monster type this.id = id++

	//*GETTERS AND SETTERS

	public String getName() {
		return name;
	}

	public int getCurrentHealth() {
		return currentHealth;
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
			currentHealth = 0;
			isDead = true;
		} else {
			currentHealth = healthAfterHit;
		}
	}

	//*METHODS

	public abstract void specialAbility();

	//using This is referring to the monster that already called method on itself
	public void sufferHit(int damageOfHit, Player currentPlayer) {
		int healthAfterHit = currentHealth - damageOfHit;
		this.setHealth(healthAfterHit);
		if (this.isDead) {
			currentPlayer.decreaseCardsAlive();
			currentPlayer.updateAliveCards();
		}
	}
}
