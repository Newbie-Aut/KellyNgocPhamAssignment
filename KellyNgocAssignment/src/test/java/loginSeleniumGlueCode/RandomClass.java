package loginSeleniumGlueCode;

import java.util.Random;

public class RandomClass {

	public int RandomNumber() {

		Random rand = new Random();
		int upperbound = 70;
		int random_int = rand.nextInt(upperbound);
		return random_int;
	}
}
