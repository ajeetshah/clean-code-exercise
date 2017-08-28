package com.converter;

import static com.converter.StringConstants.INDIAN;
import static com.converter.StringConstants.AMERICAN;
import static com.converter.StringConstants.NO_RESULT;

class NumberConverter {

    static String convert(long number, String numberSystem) {
        switch (numberSystem) {
            case INDIAN:
                return NumberConverterIndian.convert((int) number);
            case AMERICAN:
                return NumberConverterAmerican.convert(number);
            default:
                return NO_RESULT;
        }
    }
}
