package game;

import game.Monsters.Monster;

public interface Strikeable {

	//all strikeable will be able to be suffer damage and must therefore be able to update health
	public void sufferHit(int damage);

	public void updateCurrentHealth(int damage);
}
