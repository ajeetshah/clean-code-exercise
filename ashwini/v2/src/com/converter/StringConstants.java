package com.converter;

import java.util.HashMap;
import java.util.Map;

final class StringConstants {

    static final Map<String, Long> stringMap;
    static final String INDIAN = "INDIAN";
    static final String AMERICAN = "AMERICAN";
    static final String NO_RESULT = "no result";
    static final String SPACE = " ";
    static final String HUNDRED = "hundred";
    static final String THOUSAND = "thousand";
    static final String MILLION = "million";
    static final String BILLION = "billion";
    static final String LAC = "lakh";
    static final String CRORE = "crore";

    static {
        stringMap = new HashMap<String, Long>();
        stringMap.put("hundred", 100L);
        stringMap.put("thousand", 1000L);
        stringMap.put("million", 1000000L);
        stringMap.put("billion", 1000000000L);
    }
}
