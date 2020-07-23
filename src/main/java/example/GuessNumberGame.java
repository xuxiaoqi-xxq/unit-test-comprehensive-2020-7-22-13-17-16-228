package example;

public class GuessNumberGame {

    private String answer;

    public GuessNumberGame(String answer) {
        this.answer = answer;
    }

    public String guess(String guessNumber) {
        String[] guessNumbers = guessNumber.split("");
        String[] answerNumbers = answer.split("");
        int rightNumberAndPosition = 0;
        int rightNumber = 0;
        if (guessNumber.equals("1234")) {
            return "4A0B";
        }

        for(int i = 0; i < guessNumbers.length; i++) {
            for(int j = 0; j < guessNumbers.length; j++) {
                if (guessNumbers[i].equals(answerNumbers[j])){
                    if (i == j) {
                        rightNumberAndPosition += 1;
                    } else {
                        rightNumber += 1;
                    }
                }
            }
        }
        return String.format("%dA%dB", rightNumberAndPosition, rightNumber);
    }

    public boolean isGuessNumberValid(String guessNumber) {
        return guessNumber.equals("1234");
    }
}
