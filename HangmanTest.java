import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


public class HangmanTest {
    Hangman hangman ;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        hangman = new Hangman("charizard");

    }

    @Test
    public void choosingACharacterInTheAnswerReturnsTrue() throws Exception {
        assertTrue(hangman.applyGuess('c'));
    }

    @Test
    public void ifAStringIsEnteredOnlyTheFirstCharacterMatters() throws Exception{
        assertTrue(hangman.applyGuess("cljn"));
    }

    @Test
    public void givingAnEmptyGuessIsNotAllowed() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Please make sure to enter a guess");

        hangman.applyGuess("");
    }

    @Test
    public void makingAGuessThatIsAlreadyBeenMadeIsNotAllowed() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("You already made this guess ");

        hangman.applyGuess("c");
        hangman.applyGuess("c");
    }
    @Test
    public void enteringAllCharactersInTheAnswerAtLeastOnceResultsInWinningTheGame() throws Exception{
        hangman.applyGuess("c");
        hangman.applyGuess("h");
        hangman.applyGuess("a");
        hangman.applyGuess("r");
        hangman.applyGuess("i");
        hangman.applyGuess("z");
        hangman.applyGuess("d");

        assertTrue(hangman.isWon());

    }

}