package example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PlayGuessNumberGameTest {

    @Test
    void should_return_guess_result_when_answer_is_1234_given_all_input() {
        //given
        GenerateGuessNumber generateGuessNumber = Mockito.mock(GenerateGuessNumber.class);
        when(generateGuessNumber.generateNumbers()).thenReturn("1563 1324 1234");
        String[] guessNumbers = generateGuessNumber.generateNumbers().split(" ");

        PlayGuessNumberGame playGuessNumberGame = new PlayGuessNumberGame();

        //when
        String guessResult = playGuessNumberGame.play(guessNumbers);

        //then
        assertEquals("1A1B 2A2B 4A0B", guessResult);

    }
}
