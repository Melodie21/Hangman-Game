public class Main {

    public static void main(String[] args) {
	Prompter prompter = new Prompter(new Hangman("melodie"));
	prompter.promptForGuess();
    }
}
