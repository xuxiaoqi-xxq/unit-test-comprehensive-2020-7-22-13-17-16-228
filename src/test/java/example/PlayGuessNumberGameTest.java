package example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayGuessNumberGameTest {

    private static ByteArrayInputStream guessInputFromConsole;

    private static PrintStream guessOutputFromConsole;

    private static ByteArrayOutputStream guessOutputContent;

    private static PlayGuessNumberGame playGuessNumberGame;

    private static Validator validator;

    private static GenerateAnswer generateAnswer;

    private static GuessNumberGame guessNumberGame;

    @BeforeAll
    static void prepare() {
        guessOutputContent = new ByteArrayOutputStream();
        guessOutputFromConsole = new PrintStream(guessOutputContent);
        System.setOut(guessOutputFromConsole);

        playGuessNumberGame = new PlayGuessNumberGame();

        validator = Mockito.mock(Validator.class);

        generateAnswer = Mockito.mock(GenerateAnswer.class);
        when(generateAnswer.generate()).thenReturn("1234");

        guessNumberGame = Mockito.mock(GuessNumberGame.class);
    }

    @Test
    void should_win_when_answer_is_1234_given_three_valid_numbers() {
        //given
        String[] guessNumbers = new String[]{"1647", "1324", "1234"};
        String[] guessResults = new String[]{"1A1B", "2A2B", "4A0B"};

        for (int i = 0; i < guessNumbers.length; i++) {
            guessInputFromConsole = new ByteArrayInputStream(guessNumbers[i].getBytes());
            System.setIn(guessInputFromConsole);
            when(validator.isValid(guessNumbers[i])).thenReturn(true);
            when(guessNumberGame.guess(guessNumbers[i])).thenReturn(guessResults[i]);

            //when
            playGuessNumberGame.play();

            //then
            assertEquals(guessResults[i], guessOutputContent.toString());
        }
    }
}
