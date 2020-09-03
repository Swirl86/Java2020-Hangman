
public class Image {

	private int faildAttempts;

	public Image() {
		faildAttempts = 0;
	}

	public void incrimentCounter() {
		faildAttempts += 1;
	}

	public int getFaildAttempts() {
		return faildAttempts;
	}

	public void getHangmanImage() {

		switch (faildAttempts) {
		case 1:
			System.out.println("Wrong guess, try again!");
			System.out.println("--------------------");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___ ___");
			System.out.println("--------------------");
			break;
		case 2:
			System.out.println("Wrong guess, try again!");
			System.out.println("--------------------");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
			System.out.println("--------------------");
			break;
		case 3:
			System.out.println("Wrong guess, try again!");
			System.out.println("--------------------");
			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___	");
			System.out.println("--------------------");
			break;
		case 4:
			System.out.println("Wrong guess, try again!");
			System.out.println("--------------------");
			System.out.println("   ____________");
			System.out.println("   |           |");
			System.out.println("   |         __|__");
			System.out.println("   |        / x x \\");
			System.out.println("   |        \\__^__/");
			System.out.println("   |			");
			System.out.println("   |			");
			System.out.println("   |			");
			System.out.println("   |			");
			System.out.println("   |			");
			System.out.println("___|___			");
			System.out.println("--------------------");
			break;
		case 5:
			System.out.println("Wrong guess, try again!");
			System.out.println("--------------------");
			System.out.println("   ____________");
			System.out.println("   |           |");
			System.out.println("   |         __|__");
			System.out.println("   |        / x x \\");
			System.out.println("   |        \\__^__/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |			");
			System.out.println("   |			");
			System.out.println("   |			");
			System.out.println("___|___			");
			System.out.println("--------------------");
			break;
		case 6:
			System.out.println("Wrong guess, ONE more try!");
			System.out.println("--------------------");
			System.out.println("   ____________");
			System.out.println("   |           |");
			System.out.println("   |         __|__");
			System.out.println("   |        / x x \\");
			System.out.println("   |        \\__^__/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("   |         /   \\");
			System.out.println("   |				");
			System.out.println("___|___            ");
			System.out.println("--------------------");
			break;
		case 7:
			System.out.println("\n--------------------");
			System.out.println("   ____________");
			System.out.println("   |           |");
			System.out.println("   |         __|__");
			System.out.println("   |        / x x \\");
			System.out.println("   |        \\__^__/");
			System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("   |         /   \\");
			System.out.println("   |				");
			System.out.println("___|___   GAME OVER!");
			System.out.println("--------------------");
			break;
		}
	}
}
