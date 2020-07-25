package example;

public class GuessNumberValidator implements Validator{
    @Override
    public boolean isValid(String guessNumber) {
        if (guessNumber.length() != 4) {
            return false;
        }
        for (int i = 0; i < guessNumber.length(); i++) {
            for (int j = i + 1; j < guessNumber.length(); j++) {
                if (guessNumber.charAt(i) == guessNumber.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
