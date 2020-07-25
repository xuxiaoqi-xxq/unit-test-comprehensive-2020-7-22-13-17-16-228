package example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GuessNumberGameTest {

    private static GenerateAnswer generateAnswer;

    private static GuessNumberGame guessNumberGame;

    @BeforeAll
    static void prepare() {
        generateAnswer = Mockito.mock(GenerateAnswer.class);
        when(generateAnswer.generate()).thenReturn("1234");
        guessNumberGame = new GuessNumberGame(generateAnswer.generate());
    }

    @Test
    void should_return_4A0B_when_answer_is_1234_given_1234() {
        //given
        String guessNumber = "1234";

        //when
        String guessResult = guessNumberGame.guess(guessNumber);

        //then
        assertEquals("4A0B", guessResult);
    }

    @Test
    void should_return_2A2B_when_answer_is_1234_given_1243() {
        //given
        String guessNumber = "1243";

        //when
        String guessResult = guessNumberGame.guess(guessNumber);

        //then
        assertEquals("2A2B", guessResult);
    }

    @Test
    void should_return_1A1B_when_answer_is_1234_given_1563() {
        //given
        String guessNumber = "1563";

        //when
        String guessResult = guessNumberGame.guess(guessNumber);

        //then
        assertEquals("1A1B", guessResult);
    }

    @Test
    void should_return_0A4B_when_answer_is_1234_given_4321() {
        //given
        String guessNumber = "4321";

        //when
        String guessResult = guessNumberGame.guess(guessNumber);

        //then
        assertEquals("0A4B", guessResult);
    }

    @Test
    void should_return_0A2B_when_answer_is_1234_given_4356() {
        //given
        String guessNumber = "4356";

        //when
        String guessResult = guessNumberGame.guess(guessNumber);

        //then
        assertEquals("0A2B", guessResult);
    }

    @Test
    void should_return_0A0B_when_answer_is_1234_given_5678() {
        //given
        String guessNumber = "5678";

        //when
        String guessResult = guessNumberGame.guess(guessNumber);

        //then
        assertEquals("0A0B", guessResult);
    }
}
