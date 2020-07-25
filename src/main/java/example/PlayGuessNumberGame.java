package example;

import java.io.*;
import java.util.Scanner;

public class PlayGuessNumberGame {

    private GuessNumberValidator guessNumberValidator;

    private GuessNumberGame guessNumberGame;

    private GenerateAnswerImpl generateAnswer;

    public PlayGuessNumberGame() {

        guessNumberValidator = new GuessNumberValidator();
        generateAnswer = new GenerateAnswerImpl();
        guessNumberGame = new GuessNumberGame();
        guessNumberGame.setAnswer(generateAnswer.generate());
    }

    public void play() {
        try {
            BufferedReader guessNumberReader = new BufferedReader(new InputStreamReader(System.in));
            String guessNumber = guessNumberReader.readLine();
            if (guessNumberValidator.isValid(guessNumber)) {
                System.out.print(guessNumberGame.guess(guessNumber));
            } else {
                System.out.print("wrong input, input again");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
