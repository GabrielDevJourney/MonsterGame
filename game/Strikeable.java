package game;

import game.Monsters.Monster;

public interface Strikeable {
	//todo flow attackMonster.attack(monsterdefense,defense) then within monsterdeffense call sufferhit that will be
	//todo passing damage of the attacker and its own player to check array

	//todo might need to separate logic of suffer hti from the player array update otherwise witch cant suffer hit
	// with the same method called
	public void sufferHit(int damage);

	public void updateCurrentHealth(int damage);
}
