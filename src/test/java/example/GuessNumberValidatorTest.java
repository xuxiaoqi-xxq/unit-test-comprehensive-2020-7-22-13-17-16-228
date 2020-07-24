package example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GuessNumberValidatorTest {

    @Test
    void should_return_true_when_validate_input_guess_number_given_1234() {
        //given
        GenerateGuessNumber generateGuessNumber = Mockito.mock(GenerateGuessNumber.class);
        when(generateGuessNumber.generateNumber()).thenReturn("1234");

        GuessNumberValidator guessNumberValidator = new GuessNumberValidator();

        //when
        boolean isGuessNumberValid = guessNumberValidator.isValid(generateGuessNumber.generateNumber());

        //then
        assertEquals(true, isGuessNumberValid);
    }

    @Test
    void should_return_false_when_validate_input_guess_number_given_11() {
        //given
        GenerateGuessNumber generateGuessNumber = Mockito.mock(GenerateGuessNumber.class);
        when(generateGuessNumber.generateNumber()).thenReturn("11");

        GuessNumberValidator guessNumberValidator = new GuessNumberValidator();

        //when
        boolean isGuessNumberValid = guessNumberValidator.isValid(generateGuessNumber.generateNumber());

        //then
        assertEquals(false, isGuessNumberValid);
    }
}
