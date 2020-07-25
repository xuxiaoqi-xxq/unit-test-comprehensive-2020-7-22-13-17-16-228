package example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PlayGuessNumberGameTest {

    @Test
    void should_return_guess_result_when_answer_is_1234_given_three_numbers() {
        //given
        PlayGuessNumberGame playGuessNumberGame = new PlayGuessNumberGame();
        String[] guessNumbers = new String[]{"1647", "1324", "1234"};
        StringBuilder guessResult = new StringBuilder();

        //when
        for (int i = 0; i < guessNumbers.length; i++) {
            InputStream byteArrayInputStream = new ByteArrayInputStream(guessNumbers[i].getBytes());
            guessResult.append(playGuessNumberGame.play() + " ");
        }
        guessResult.delete(guessResult.length() - 1, guessResult.length());

        //then
        assertEquals("1A1B 2A2B 4A0B", guessResult.toString());
    }
}
