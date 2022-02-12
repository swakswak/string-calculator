package toy.swak.string.calculator;

import java.util.Arrays;

/**
 * @author hyoseok.choi (hyoseok.choi@sdt.inc)
 **/
class StringCalculator {
    // TODO: 리팩토링 필요
    public int convertAndSum(String string) {
        if (string == null || "".equals(string.replace(" ", ""))) {
            return 0;
        } else {
            String[] split = string.replace(" ", "").split("[,:]");
            if (Arrays.asList(split).contains("")) {
                throw new NumberFormatException();
            }
            int result = 0;
            for (String beforeConvert : split) {
                result += Integer.parseInt(beforeConvert);
            }
            return result;
        }
    }
}
