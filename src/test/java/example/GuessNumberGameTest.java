package example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

public class GuessNumberGameTest {

  @Test
  void should_return_4A0B_when_answer_is_1234_given_1234() {
      //given
      GenerateAnswer generateAnswer = Mockito.mock(GenerateAnswer.class);
      when(generateAnswer.generate()).thenReturn("1234");
      GuessNumberGame guessNumberGame = new GuessNumberGame(generateAnswer.generate());

      //when
      String guessResult = guessNumberGame.guess("1234");

      //then
      assertEquals("4A0B", guessResult);
  }

    @Test
    void should_return_2A2B_when_answer_is_1234_given_1243() {
        //given
        GenerateAnswer generateAnswer = Mockito.mock(GenerateAnswer.class);
        given(generateAnswer.generate()).willReturn("1234");
        GuessNumberGame guessNumberGame = new GuessNumberGame(generateAnswer.generate());

        //when
        String guessResult = guessNumberGame.guess("1243");

        //then
        assertEquals("2A2B", guessResult);
    }

    @Test
    void should_return_1A1B_when_answer_is_1234_given_1563() {
        //given
        GenerateAnswer generateAnswer = Mockito.mock(GenerateAnswer.class);
        given(generateAnswer.generate()).willReturn("1234");
        GuessNumberGame guessNumberGame = new GuessNumberGame(generateAnswer.generate());

        //when
        String guessResult = guessNumberGame.guess("1563");

        //then
        assertEquals("1A1B", guessResult);
    }
}
