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

        for (int index = 0; index < guessNumbers.length; index++) {
            if(answer.contains(guessNumbers[index])){
                rightNumber ++;
                if (String.valueOf(answer.charAt(index)).equals(guessNumbers[index])) {
                    rightNumber --;
                    rightNumberAndPosition ++;
                }
            }
        }
        return String.format("%dA%dB", rightNumberAndPosition, rightNumber);
    }
}
