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

        return this.sum(this.toIntValues(this.split(stringValue)));
    }


    private String[] split(String stringValue) {
        return stringValue.replace(" ", "").split(",");
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

    private boolean isBlank(String stringValue) {
        return stringValue == null || "".equals(stringValue.replace(" ", ""));
    }

    private int[] toIntValues(String[] strings) {
        if (!this.isValid(strings)) {
            throw new IllegalArgumentException();
        }

        int[] intValues = new int[strings.length];
        for (int stringsIndex = 0; stringsIndex < strings.length; stringsIndex++) {
            intValues[stringsIndex] = Integer.parseInt(strings[stringsIndex]);
        }

        return intValues;
    }

    private int sum(int[] intValues) {
        int result = 0;
        for (int intValue : intValues) {
            result += intValue;
        }

        return result;
    }
}
