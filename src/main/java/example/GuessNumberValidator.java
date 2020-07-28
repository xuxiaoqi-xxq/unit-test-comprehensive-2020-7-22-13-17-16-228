package example;

public class GuessNumberValidator implements Validator {

    public static final String ONLY_NUMBER_REGEX = ".*[^0-9]+.*";
    public static final String NO_REPEAT_NUMBER_REGEX = ".*(.).*\\1.*";

    @Override
    public boolean isValid(String guessNumber) {
        if (guessNumber.length() != 4) {
            return false;
        }
        // check guess number is only contains numbers
        if (guessNumber.matches(ONLY_NUMBER_REGEX)) {
            return false;
        }
        // check guess number is repetitive
        if (guessNumber.matches(NO_REPEAT_NUMBER_REGEX)) {
          return false;
        }
        return true;
    }
}
