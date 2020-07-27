package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayGuessNumberGame {

    private GuessNumberValidator guessNumberValidator;

    private GuessNumberGame guessNumberGame;

    private GuessNumberAnswerGenerator generateAnswer;

    public PlayGuessNumberGame() {

        guessNumberValidator = new GuessNumberValidator();
        generateAnswer = new GuessNumberAnswerGenerator();
        guessNumberGame = new GuessNumberGame(generateAnswer.generate());
    }

    public void play() {
        try {
            int playTimes = 0;
            BufferedReader guessNumberReader = new BufferedReader(new InputStreamReader(System.in));
            String guessResult = "";
            String guessNumber = "";
            while (playTimes++ < 6 && (guessNumber = guessNumberReader.readLine()) != null) {
                if (guessNumberValidator.isValid(guessNumber)) {
                    guessResult = guessNumberGame.guess(guessNumber);
                } else {
                    guessResult = "wrong input, input again";
                }
                System.out.print(guessResult + "\n");
                if (guessResult.equals("4A0B")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
