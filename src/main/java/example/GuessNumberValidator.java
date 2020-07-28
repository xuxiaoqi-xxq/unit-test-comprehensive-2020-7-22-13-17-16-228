package example;

public class GuessNumberValidator implements Validator {
    @Override
    public boolean isValid(String guessNumber) {
        if (guessNumber.length() != 4) {
            return false;
        }
        // check guess number is only contains numbers
        //todo
        if (guessNumber.matches(".*[^0-9]+.*")) {
            return false;
        }
        // check guess number is repetitive
        //todo
        if (guessNumber.matches(".*(.).*\\1.*")) {
          return false;
        }
        return true;
    }
}
