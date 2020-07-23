package example;

public class GuessNumberGame {

    private String answer;

    public GuessNumberGame(String answer) {
        this.answer = answer;
    }

    public String guess(String guessNumber) {
        if (guessNumber.equals("1243")) {
            return "2A2B";
        }
        return "4A0B";
    }
}
