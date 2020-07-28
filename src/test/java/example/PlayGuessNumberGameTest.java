package example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

public class PlayGuessNumberGameTest {

    private static ByteArrayInputStream guessInputFromConsole;

    private static PrintStream guessOutputFromConsole;

    private static ByteArrayOutputStream guessOutputContent;

    private static PlayGuessNumberGame playGuessNumberGame;

    private static Validator validator;

    private static AnswerGenerator answerGenerator;

    private static GuessNumberGame guessNumberGame;

    @BeforeAll
    static void prepare() throws Exception {
        guessOutputContent = new ByteArrayOutputStream();
        guessOutputFromConsole = new PrintStream(guessOutputContent);
        System.setOut(guessOutputFromConsole);

        playGuessNumberGame = new PlayGuessNumberGame();

        validator = Mockito.mock(Validator.class);

        answerGenerator = Mockito.mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn("1234");

        guessNumberGame = Mockito.mock(GuessNumberGame.class);
        //todo
        Field guessNumberGameField = playGuessNumberGame.getClass().getDeclaredField("guessNumberGame");
        guessNumberGameField.setAccessible(true);
        guessNumberGameField.set(playGuessNumberGame, guessNumberGame);
    }

    @Test
    void should_win_when_answer_is_1234_given_three_valid_numbers() {
        //given
        String guessNumber = "1647\n1324\n1234\n";
        String guessResult = "1A1B\n2A2B\n4A0B\n";

        when(validator.isValid(any())).thenReturn(true);
        when(guessNumberGame.guess(any())).thenReturn("1A1B", "2A2B", "4A0B");

        guessInputFromConsole = new ByteArrayInputStream(guessNumber.getBytes());
        System.setIn(guessInputFromConsole);

        //when
        playGuessNumberGame.play();

        //then
        assertEquals(guessResult, guessOutputContent.toString());
        guessOutputContent.reset();
    }

    @Test
    void should_win_when_answer_is_1234_given_11_and_two_valid_numbers() {
        //given
        String guessNumber = "11\n1324\n1234\n";
        String guessResult = "wrong input, input again\n2A2B\n4A0B\n";

        when(validator.isValid(any())).thenReturn(false, true, true);
        when(guessNumberGame.guess(any())).thenReturn("2A2B", "4A0B");

        guessInputFromConsole = new ByteArrayInputStream(guessNumber.getBytes());
        System.setIn(guessInputFromConsole);

        //when
        playGuessNumberGame.play();

        //then
        assertEquals(guessResult, guessOutputContent.toString());
        guessOutputContent.reset();
    }

    @Test
    void should_end_game_after_6_times_when_answer_is_1234_given_7_valid_numbers() {
        //given
        String guessNumber = "1093\n1093\n1093\n1093\n1093\n1324\n1234\n";
        String guessResult = "1A1B\n1A1B\n1A1B\n1A1B\n1A1B\n2A2B\n";

        when(validator.isValid(any())).thenReturn(true);
        when(guessNumberGame.guess(any())).thenReturn("1A1B", "1A1B", "1A1B", "1A1B", "1A1B", "2A2B", "4A0B");

        guessInputFromConsole = new ByteArrayInputStream(guessNumber.getBytes());
        System.setIn(guessInputFromConsole);

        //when
        playGuessNumberGame.play();

        //then
        assertEquals(guessResult, guessOutputContent.toString());
        guessOutputContent.reset();
    }

    @Test
    void should_lose_after_6_times_when_answer_is_1234_given_6_valid_numbers() {
        //given
        String guessNumber = "1093\n1093\n1093\n1093\n1093\n1324\n";
        String guessResult = "1A1B\n1A1B\n1A1B\n1A1B\n1A1B\n2A2B\n";

        when(validator.isValid(any())).thenReturn(true);
        when(guessNumberGame.guess(any())).thenReturn("1A1B", "1A1B", "1A1B", "1A1B", "1A1B", "2A2B");

        guessInputFromConsole = new ByteArrayInputStream(guessNumber.getBytes());
        System.setIn(guessInputFromConsole);

        //when
        playGuessNumberGame.play();

        //then
        assertEquals(guessResult, guessOutputContent.toString());
        guessOutputContent.reset();
    }
}
