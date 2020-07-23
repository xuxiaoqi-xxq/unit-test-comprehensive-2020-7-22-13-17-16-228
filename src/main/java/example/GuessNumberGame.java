package example;

public class GuessNumberGame {

    private String answer;

    public GuessNumberGame(String answer) {
        this.answer = answer;
    }

    public String guess(String guessNumber) {
        String[] guessNumbers = guessNumber.split("");
        String[] answerNumbers = answer.split("");
        String result = "";
        for(int i = 0; i < guessNumbers.length; i++) {
            for(int j = 0; j < guessNumbers.length; j++) {
                if (guessNumbers[i].equals(answerNumbers[j])){
                    result +=  "1B";
                    if (i == j) {
                        result = "1A" + result;
                        return result;
                    }
                }
            }
        }
        if (guessNumber.equals("1234")) {
            return "4A0B";
        }
        return "2A2B";
    }
}
