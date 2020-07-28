package example;

import java.util.HashSet;
import java.util.Set;

public class GuessNumberAnswerGenerator implements AnswerGenerator {

    public static final int MAX_LENGTH = 4;

    @Override
    public String generate() {
        StringBuilder answer = new StringBuilder();
        while (answer.length() < MAX_LENGTH) {
            String generateAnswer = String.valueOf((int) (Math.random() * 10));
            if (answer.indexOf(generateAnswer) == -1) {
                answer.append(generateAnswer);
            }
        }
        return answer.toString();
    }
}
