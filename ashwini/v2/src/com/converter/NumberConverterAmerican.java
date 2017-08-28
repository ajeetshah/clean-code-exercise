package com.converter;

import java.util.Scanner;
import static com.converter.StringConstants.NO_RESULT;
import static com.converter.StringConstants.SPACE;
import static com.converter.StringConstants.BILLION;
import static com.converter.StringConstants.MILLION;
import static com.converter.StringConstants.HUNDRED;
import static com.converter.StringConstants.THOUSAND;

class NumberConverterAmerican {

    private static final long MIN_NUMBER = 0L;
    private static final long MAX_NUMBER = 999999999999L;

    public static void main(String[] args) {
        long number = readNumber();
        if (isNumberValid(number)) {
            System.out.println(convert(number));
        } else {
            System.out.println(NO_RESULT);
        }
    }

    private static long readNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLong();
    }

    private static boolean isNumberValid(long number) {
        return !(number < MIN_NUMBER || number > MAX_NUMBER);
    }

    static String convert(long number) {
        if (!isNumberValid(number)) {
            return NO_RESULT;
        }
        if (number == 0) {
            return NumberConverterIndian.convert(0);
        }

        String result = "";
        int numberUnderThisScale;

        numberUnderThisScale = (int) (number / StringConstants.stringMap.get("billion"));
        if( numberUnderThisScale > 0 ) {
            result = NumberConverterIndian.convert(numberUnderThisScale) + SPACE + BILLION;
            number %= StringConstants.stringMap.get("billion");
        }

        numberUnderThisScale = (int) (number / StringConstants.stringMap.get("million"));
        if( numberUnderThisScale > 0 ) {
            result += SPACE + NumberConverterIndian.convert(numberUnderThisScale) + SPACE + MILLION;
            number %= StringConstants.stringMap.get("million");
        }

        numberUnderThisScale = (int) (number / StringConstants.stringMap.get("thousand"));
        if( numberUnderThisScale > 0 ) {
            result += SPACE + NumberConverterIndian.convert(numberUnderThisScale) + SPACE + THOUSAND;
            number %= StringConstants.stringMap.get("thousand");
        }

        numberUnderThisScale = (int) (number / StringConstants.stringMap.get("hundred"));
        if( numberUnderThisScale > 0 ) {
            result += SPACE + NumberConverterIndian.convert(numberUnderThisScale) + SPACE + HUNDRED;
            number %= StringConstants.stringMap.get("hundred");
        }
        
        numberUnderThisScale = (int) number;
        if(numberUnderThisScale > 0) {
            result += SPACE + NumberConverterIndian.convert(numberUnderThisScale);
        }

        return result.trim();
    }
}
