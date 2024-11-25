package game.Monsters;

import game.Strikeable;
import game.Supernatural;

public abstract class Monster extends Supernatural implements Strikeable {
	protected int health;
	protected boolean isDead;

	//if I need all monsters to have an id this also means that those id must be different with simply incrementing
	// so all will share id this means the current monster id will be last one set ++ this should be incremented in
	// monster, but I can do something like in each monster type this.id = id++

	//*GETTERS AND SETTERS


	public int getHealth() {
		return health;
	}

	public boolean isDead() {
		return isDead;
	}

	//check for zero health this means mosnter is dead
	public void updateCurrentHealth(int damageOfHit) {
		if (health - damageOfHit <= 0) {
			health = 0;
			isDead = true;
		} else {
			health -= damageOfHit;
		}
	}


	//*METHODS

	public abstract void specialAbility();

	//using This is referring to the monster that already called method on itself


	@Override
	public void sufferHit(int damage) {
		//change this to here so attack handles everything by calling proper methods
		this.updateCurrentHealth(damage);
	}

	public void attack(Monster defenseMonster) {
		this.specialAbility();
		defenseMonster.sufferHit(this.getDamage());

	}
}
