package example;

public class GuessNumberGame {

    private final String answer;

    public GuessNumberGame(String answer) {
        this.answer = answer;
    }

    public String guess(String guessNumber) {
        String[] guessNumbers = guessNumber.split("");
        int rightNumberAndPosition = 0;
        int rightNumber = 0;

        for (int i = 0; i < guessNumbers.length; i++) {
            if(answer.contains(guessNumbers[i])){
                rightNumber ++;
                if (String.valueOf(answer.charAt(i)).equals(guessNumbers[i])) {
                    rightNumber --;
                    rightNumberAndPosition ++;
                }
            }
        }
        return String.format("%dA%dB", rightNumberAndPosition, rightNumber);
    }
}
