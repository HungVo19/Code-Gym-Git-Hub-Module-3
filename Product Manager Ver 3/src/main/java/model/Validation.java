package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation{
    private final static String integerRegex = "^[0-9]+$";

    public Validation() {
    }

    public boolean checkInteger(String input) {
        Pattern pattern = Pattern.compile(integerRegex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public Double parseDouble(String myString) {
        final String Digits = "(\\p{Digit}+)";
        final String HexDigits = "(\\p{XDigit}+)";

        final String Exp = "[eE][+-]?" + Digits;
        final String fpRegex = ("[\\x00-\\x20]*" +
                "[+-]?(" +
                "NaN|" +
                "Infinity|" +

                "(((" + Digits + "(\\.)?(" + Digits + "?)(" + Exp + ")?)|" +
                "(\\.(" + Digits + ")(" + Exp + ")?)|" +
                "((" +
                "(0[xX]" + HexDigits + "(\\.)?)|" +

                "(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" +
                ")[pP][+-]?" + Digits + "))" + "[fFdD]?))" + "[\\x00-\\x20]*");
        if (Pattern.matches(fpRegex, myString))
            return Double.valueOf(myString);
        else {
            return null;
        }
    }
}
