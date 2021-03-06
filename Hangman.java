
public class Hangman {
    private String answer;
    private String hits;
    private String misses;
    public static final int NUMBER_OF_TRIES = 7;

    public Hangman(String answer) {
        this.answer = answer;
        hits = "";
        misses = "";
    }

    public boolean applyGuess(char c) {
        boolean isCorrect = false;
        if (hits.indexOf(c) != -1 || misses.indexOf(c) != -1) {
            throw new IllegalArgumentException("You already made this guess ");
        }
        if (answer.indexOf(c) != -1) {
            isCorrect = true;
            hits += c;
        } else {
            misses += c;
        }
        return isCorrect;

    }

    public boolean applyGuess(String s) {
        if (s.length() == 0) {
            throw new IllegalArgumentException("Please make sure to enter a guess");
        }
        return applyGuess(s.charAt(0));
    }


    public String getCurrentProgress() {

        String progress = "";
        for (char c : answer.toCharArray()) {
            char display = '-';
            if (hits.indexOf(c) != -1) {
                display = c;
            }
            progress += display;
        }
        return progress;
    }

    public boolean isWon(){
        String progress = getCurrentProgress();
        if(progress.indexOf('-') == -1){
            return true ;
        } else {
            return false;
        }
    }

    public String getAnswer() {
        return answer;
    }

    public String getHits() {
        return hits;
    }

    public String getMisses() {
        return misses;
    }



}
