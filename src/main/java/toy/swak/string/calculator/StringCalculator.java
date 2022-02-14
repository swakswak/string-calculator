package toy.swak.string.calculator;

import java.util.Arrays;

/**
 * @author hyoseok.choi (hschoi0702@gmail.com)
 **/
class StringCalculator {
    public int convertAndSum(String stringValue) {
        if (this.isBlank(stringValue)) {
            return 0;
        }

        String[] split = this.split(stringValue);
        return this.sum(split);
    }


    private boolean isBlank(String stringValue) {
        return stringValue == null || "".equals(stringValue.replace(" ", ""));
    }

    private String[] split(String stringValue) {
        return stringValue.replace(" ", "").split("[,]");
    }

    private boolean isValid(String[] strings) {
        return Arrays.stream(strings)
                .allMatch(string -> !this.isBlank(string) && this.isPositiveNumber(string));
    }

    private boolean isPositiveNumber(String stringValue) {
        try {
            return Integer.parseInt(stringValue) > 0;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    private int sum(String[] intStrings) {
        if (!this.isValid(intStrings)) {
            throw new IllegalArgumentException();
        }
        int result = 0;
        for (String beforeConvert : intStrings) {
            result += Integer.parseInt(beforeConvert);
        }

        return result;
    }
}
