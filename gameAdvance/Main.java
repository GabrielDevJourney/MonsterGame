package gameAdvance;

public class Main {
	public static void main(String[] args) {
		Game gameTest = new Game();
		gameTest.start();
	}
}
//todo search to see what i should have static and what not like dealdamage is only call
//todo in turnHandler so it should belong to it, and see what type of dependencies should be there
//todo see when i should use static and not

//todo see how to separate getPlayerMonsterChoice from game and gameScanner
//todo this means i need to pass info from method to method