import java.util.Scanner;

public class Hangman {

	final static int MAX_TRIES = 7; 
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to the game Hangingman.\n"
				+ "You can guess wrong 7 times before it is Game Over\n");
		
		int mode =  getValidMode(input);
		
		WordHandler game;
		// Prepare the game after chosen mode
		if(mode == 1) {
			game = new WordHandler();
			
		} else {
			System.out.print("Enter a word: ");
			String secretWord = emptyCheck(input);
			
			game = new WordHandler(secretWord);
			
		}

		// Run the game until the secretWord is found or 7 failed attempts
		while (game.getFaildAttempts() < MAX_TRIES && !game.foundSecretWord()) {
			switch (getChoice(input)) {
			case 1:
				// Game status
				System.out.println("You have used " + game.getFaildAttempts() + " tries of " 
						+ MAX_TRIES + ".\n");
				break;
			case 2:
				// Guess char
				game.guessLetter();
				break;	
			case 3:
				// Guess word
				game.guessWord();
				break;			
			}
		}
		
		if(game.getFaildAttempts() == MAX_TRIES) {
			System.out.println("The word was: " + game.getSecretWord());
		}
		
		
		input.close();
	}


	static int getValidMode(Scanner input) {

		System.out.println("Available game modes:\n"
				+ "1 - Random word\n"
				+ "2 - Enter a word");
		System.out.print("Mode: ");
		
		int move = getInt(input);
		
		while (move != 1 && move != 2) {
			System.out.print("Invalid playing mode! Try again [1,2]: ");
			move = getInt(input);
		}
		
		input.nextLine();  // Consume newline left-over
		System.out.println();
		
		return move;
	}

	public static int getChoice(Scanner input) {
		System.out.println("----------------------\n"
				+ "| Available options: |\n"
				+ "| 1 - Game status    |\n"
				+ "| 2 - Guess letter   |\n"
				+ "| 3 - Guess word     |\n"
				+ "----------------------");
		System.out.print("Option: ");
		int choice = 0;
		choice = getInt(input);
		input.nextLine();
		return choice;
	}
	
	public static int getInt(Scanner input) {
		while (!input.hasNextInt()){
			input.next();
			System.out.print("Must be a number, try again: ");
		}
		int move = input.nextInt();
		return move;
	}
	

	static String emptyCheck(Scanner input) {
		
		String word = input.nextLine();
		
		while(word.length() < 3) {
			System.out.println("Invalid word! The word must have atleast 3 letters: ");
			word = input.nextLine();
		}
		clearScreen();
		return word;
	}
	 public static void clearScreen() {
		 // "Hide" secretWord input
		 System.out.println(new String(new char[70]).replace("\0", "\r\n"));
		}
}