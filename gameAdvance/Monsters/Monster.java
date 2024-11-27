package gameAdvance.Monsters;

import gameAdvance.Enums.TypeMonsters;
import gameAdvance.Player;
import gameAdvance.Strikeable;
import gameAdvance.Supernatural;

public abstract class Monster extends Supernatural implements Strikeable {
	protected int currentHealth;
	protected TypeMonsters type;
	protected boolean isDead;
	protected final int id;
	protected static int idCounter = 0;

	public Monster(TypeMonsters type){
		this.type = type;
		this.currentHealth = type.getCurrentHealth();
		this.damage = type.getDamage();
		this.name = type.getName();
		this.id = idCounter++;
	}

	//if I need all monsters to have an id this also means that those id must be different with simply incrementing
	// so all will share id this means the current monster id will be last one set ++ this should be incremented in
	// monster, but I can do something like in each monster type this.id = id++

	//*GETTERS AND SETTERS,

	public int getCurrentHealth() {
		return currentHealth;
	}


	public int getId() {
		return id;
	}

	public boolean isDead() {
		return isDead;
	}

	//check for zero health this means mosnter is dead
	public void updateCurrentHealth(int damage) {
		if (damage <= 0) {
			currentHealth = 0;
			isDead = true;
		} else {
			currentHealth -= damage;
		}
	}

	//*METHODS

	public abstract void specialAbility();

	//using This is referring to the monster that already called method on itself
	public void sufferHit(int damage, Player currentPlayer) {
		this.updateCurrentHealth(damage);

		//todo get this out of here and implement in the updateCardState in player
		if (this.isDead) {
			currentPlayer.decreaseCardsAlive();
			currentPlayer.updateAliveCards();
		}


	}

	@Override
	public void attack(Monster defenseMonster) {
		this.specialAbility();
		defenseMonster.sufferHit(this.getDamage());
	}
}
