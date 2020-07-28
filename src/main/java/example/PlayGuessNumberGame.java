package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayGuessNumberGame {

    public static final int MAX_PLAY_TIMES = 6;
    public static final String WRONG_INPUT_MSG = "wrong input, input again";
    public static final String RIGHT_GUESS_RESULT = "4A0B";
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
            while (playTimes++ < MAX_PLAY_TIMES && (guessNumber = guessNumberReader.readLine()) != null) {
                if (guessNumberValidator.isValid(guessNumber)) {
                    guessResult = guessNumberGame.guess(guessNumber);
                } else {
                    guessResult = WRONG_INPUT_MSG;
                }
                System.out.print(guessResult + "\n");
                //todo
                if (guessResult.equals(RIGHT_GUESS_RESULT)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
