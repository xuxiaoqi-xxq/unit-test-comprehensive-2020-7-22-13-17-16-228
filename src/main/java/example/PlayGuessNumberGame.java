package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayGuessNumberGame {

    private final GuessNumberValidator guessNumberValidator;

    private final GuessNumberGame guessNumberGame;

    public PlayGuessNumberGame() {

        guessNumberValidator = new GuessNumberValidator();
        GuessNumberAnswerGenerator generateAnswer = new GuessNumberAnswerGenerator();
        guessNumberGame = new GuessNumberGame(generateAnswer.generate());
    }

    public void play() {
        try {
            int playTimes = 0;
            BufferedReader guessNumberReader = new BufferedReader(new InputStreamReader(System.in));
            String guessResult;
            String guessNumber;
            //todo
            while (playTimes++ < 6 && (guessNumber = guessNumberReader.readLine()) != null) {
                if (guessNumberValidator.isValid(guessNumber)) {
                    guessResult = guessNumberGame.guess(guessNumber);
                } else {
                    //todo
                    guessResult = "wrong input, input again";
                }
                //todo
                System.out.print(guessResult + "\n");
                //todo
                if (guessResult.equals("4A0B")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
