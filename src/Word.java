
public class Word {
	
	private String[] defaultWords = new String[6];
	private String secretWord;
	private String foundLetters;

	
	public Word() {
		defaultWords= new String[]{"Summer", "Java", "Program", "Gaming", "Anime", "Workspace"};
		// Initiate with a random defaultWord
		secretWord = defaultWords[(int) (Math.random() * defaultWords.length)];
		foundLetters = "";
		fillOutWithAsterisk();
	}
	
	public Word(String theWord) {
		secretWord = theWord;
		foundLetters = "";
		fillOutWithAsterisk();		
	}
	
	public void fillOutWithAsterisk() {
		// Fill foundLetters with * symbols to represent every letter for the secretWord
		foundLetters = new String(new char[secretWord.length()]).replace('\0', '*');
	}
	
	public String getSecretWord() {
		return secretWord;
	}
	
	public String getFoundLetters() {
		return foundLetters;
	}
	
	public void SetFoundLetters(String str) {
		foundLetters = str.substring(0,1).toUpperCase() 
				+ str.substring(1).toLowerCase();;
	}
}
