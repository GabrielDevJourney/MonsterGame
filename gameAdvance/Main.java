package gameAdvance;

public class Main {
	public static void main(String[] args) {
		Game gameTest = new Game();
		gameTest.start();
	}
}

//todo will be better to create a method to just call inside what have mode will be seleteced beause all will need to
// check if there is a obstacle and if yes random seletect one and implement that same behaviour so roundcounter will
// be there the generatorRandomObstacle also
	//todo if there is handle obstacle round else normal behavior of round happens
	//todo generatorRandomRoundObstacle
	//todo might not make sense have enum because there are kly 2 options so if x % call on or the other dont return
// null instead use exceptions see the BASIC VERSION
	//! check if thre is any need to imoelemnt round even and odd inside the method itself or does how it is works
	//! might work because the only change if there is obtacle then coll the handler of that