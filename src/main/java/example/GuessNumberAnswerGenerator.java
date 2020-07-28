package example;

import java.util.HashSet;
import java.util.Set;

public class GuessNumberAnswerGenerator implements AnswerGenerator {
    @Override
    public String generate() {
        Set<Integer> answers = new HashSet<>();
        //todo
        StringBuilder stringBuilder = new StringBuilder();
        //todo extract 4
        while (answers.size() < 4) {
            Integer answer = (int) (Math.random() * 10);
            if (!answers.contains(answer)) {
                stringBuilder.append(answer);
            }
            answers.add(answer);
        }
        return stringBuilder.toString();
    }
}
