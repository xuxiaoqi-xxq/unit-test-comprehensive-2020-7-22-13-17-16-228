package example;

import java.util.HashSet;
import java.util.Set;

public class GenerateAnswerImpl implements GenerateAnswer {
    @Override
    public String generate() {
        Set<Integer> answer = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        while (answer.size() < 4) {
            Integer ans = (int) (Math.random() * 10);
            if (!answer.contains(ans)) {
                stringBuilder.append(String.valueOf(ans));
            }
            answer.add(ans);
        }
        return stringBuilder.toString();
    }
}
