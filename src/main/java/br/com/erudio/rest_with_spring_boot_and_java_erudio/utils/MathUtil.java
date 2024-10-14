package br.com.erudio.rest_with_spring_boot_and_java_erudio.utils;

import br.com.erudio.rest_with_spring_boot_and_java_erudio.exception.UnsupportedMathOperationException;

public class MathUtil {
    public static boolean isNumeric(String numberStr) throws UnsupportedMathOperationException {
        if (numberStr == null) throw new UnsupportedMathOperationException("Please provide a valid number!");
        numberStr = numberStr.replace(",", ".");
        return numberStr.matches("[+-]?[0-9]*\\.?[0-9]+");
    }

    public static Double convertToDoble(String numberStr) throws UnsupportedMathOperationException {
        if (isNumeric(numberStr)) {
            numberStr = numberStr.replace(",", ".");

            return Double.parseDouble(numberStr);
        }
        throw new UnsupportedMathOperationException("Please provide a valid number!");
    }
}
