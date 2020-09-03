import java.util.*;

public class WordHandler {
	
	private Scanner input;
	private Image image;
	private Word word;
	private List<String> guessdLetters;
	private boolean secretWordFound;
	
	public WordHandler() {
		input = new Scanner(System.in);
		image = new Image();
		word = new Word();
		guessdLetters = new ArrayList<>();
		secretWordFound = false;
	}
	
	public WordHandler(String theWord) {
		input = new Scanner(System.in);
		image = new Image();
		word = new Word(theWord);
		guessdLetters = new ArrayList<>();
		secretWordFound = false;
	}
	
	public int getFaildAttempts() {
		return image.getFaildAttempts();
	}
	
	public String getSecretWord() {
		return word.getSecretWord();
	}
	
	public boolean foundSecretWord() {
		return secretWordFound;
	}
	
	public void guessLetter() {

		System.out.print("\n"+ word.getFoundLetters() + "\nEnter a letter: ");
		String letter = checkLetterInput();

		// Avoid using duplicates
		while(guessdLetters.contains(letter)) {
			System.out.print("\"" + letter.toUpperCase() 
			+ "\" Has already been used! Try again: ");
			letter = checkLetterInput();
		}
		
		guessdLetters.add(letter);		//Keep track of used letters	
		checkCharsInWord(letter);
	}

	public String checkLetterInput() {
		
		String letter = input.next();
		input.nextLine(); // Consume newline left-over
		
		while(Character.isLetter(letter.charAt(0)) == false || letter.length() == 0) { 
			System.out.print("Enter a letter: ");
			letter = input.next();
			input.nextLine();
		} 
		
		return letter;
	}
	
	private void checkCharsInWord(String letter) {
		// Build new string to compare with in checkResult
		String str = "";	
		
		String secretWord = word.getSecretWord();
		String foundLetters = word.getFoundLetters();
		
		for (int i = 0; i < secretWord.length(); i++) {
			if (isEqual(letter, secretWord, i)) {
				str += letter.charAt(0); // Found a match, add letter
			} else if (foundLetters.charAt(i) != '*') {
				str += secretWord.charAt(i); // Add existing found letters
			} else {
				str += "*"; // Nothing new add *
			}
		}
		
		checkResult(str);
	}

	private boolean isEqual(String letter, String secretWord, int i) {
		return Character.toLowerCase(secretWord.charAt(i)) == 
				Character.toLowerCase(letter.charAt(0));
	}
	
	
	private void checkResult(String str) {
		String secretWord = word.getSecretWord();
		
		if (word.getFoundLetters().equalsIgnoreCase(str)) {   
			// nothing new found = wrong guess 
			image.incrimentCounter();
			image.getHangmanImage();
		} else {
			System.out.println(str);
			word.SetFoundLetters(str); // updated foundLetters 
		}
		
		if (word.getFoundLetters().equalsIgnoreCase(secretWord)) { 
			System.out.println("\nThe word is: "+ secretWord 
					+ " \nCongratulations! "
					+ "\n  *----------*\n"
					+ "  | You win! |\n"
					+ "  *----------*");
			secretWordFound = true;
		}
	}
	
	public void guessWord() {
		String secretWord = word.getSecretWord();
		
		System.out.println("\n"+ word.getFoundLetters());
		
		String guessdWord = checkWordInput();
		
		if (guessdWord.equalsIgnoreCase(secretWord)) { 
			System.out.println("\nThe word is: " + secretWord 
					+ " \nCongratulations! "
					+ "\n  *----------*\n"
					+ "  | You win! |\n"
					+ "  *----------*");
			secretWordFound = true;
		} else {
			image.incrimentCounter();
			image.getHangmanImage();
		}
	}
	
	public String checkWordInput() {
		String str = "";		
		while(str.equals("")) { 
			System.out.print("Enter a word: ");
			str = input.nextLine();
		} 
		
		return str;
	}
}
