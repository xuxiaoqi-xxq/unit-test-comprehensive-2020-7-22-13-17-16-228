package example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayGuessNumberGameTest {

    private ByteArrayInputStream guessInputFromConsole;

    private PrintStream guessOutputFromConsole;

    private ByteArrayOutputStream guessOutputContent;

    private PlayGuessNumberGame playGuessNumberGame;

    @BeforeEach
    void prepare() {
        guessOutputContent = new ByteArrayOutputStream();
        guessOutputFromConsole = new PrintStream(guessOutputContent);
        System.setOut(guessOutputFromConsole);

        playGuessNumberGame = new PlayGuessNumberGame();
    }

    @Test
    void should_win_when_answer_is_1234_given_three_valid_numbers() {
        //given
        String[] guessNumbers = new String[]{"1647", "1324", "1234"};
        String[] guessResults = new String[]{"1A1B", "2A2B", "4A0B"};

        for (int i = 0; i < guessNumbers.length; i++) {
            guessInputFromConsole = new ByteArrayInputStream(guessNumbers[i].getBytes());
            System.setIn(guessInputFromConsole);

            //when
            playGuessNumberGame.play();

            //then
            assertEquals(guessResults[i], guessOutputContent.toString());
        }
    }
}
