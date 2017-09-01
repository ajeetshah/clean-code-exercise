package main;

import java.util.HashMap;
import java.util.Map;

import test.InvalidValueException;

public class Converter {

	private static boolean britishConversion = true;

	public static void setBritishConversion(boolean britishConversion) {
		Converter.britishConversion = britishConversion;
	}

	private static final int ZERO = 0;
	private static final long _99_99_99_999L = 99_99_99_999l;
	private static final int TEN = 10;
	private static final String SPACE = " ";
	private static final int HUNDRED = 100;
	private static final int THOUSAND = 1000;
	private static final int MILLION= 1000_000;
	private static final int BILLION= 1000_000_000;
	private static final int LAKH = 1000_00;
	private static final int CRORE = 1000_00_00;

	private static Map<String, String> intoToTextDictionary = new HashMap<>();

	static {
		buildIntToTextDictionary();
	}

	public static String convert(long input) throws InvalidValueException {

		if (input < ZERO || input > _99_99_99_999L) {
			throw new InvalidValueException();
		}

		if (input == ZERO) {
			return getFromDictionary(ZERO);
		}

		StringBuilder str = new StringBuilder();
		if (britishConversion) {
			getBritishConversion(input, str);
		} else {
			getAmericanConversion(input,str);
		}

		return leftTrim(str);
	}

	private static void getAmericanConversion(long input, StringBuilder str) {
		str.append(getPrefixForUnit(input, BILLION));
		long inputForMillion = input % BILLION;
		
		str.append(getPrefixForUnit(inputForMillion, MILLION));
		long inputForThousand = input % MILLION;
		
		str.append(getPrefixForUnit(inputForThousand, THOUSAND));
		long inputForHundred = input % THOUSAND;

		str.append(getPrefixForUnit(inputForHundred, HUNDRED));
		long inputForDecimalAndUnit = input % HUNDRED;

		str.append(getFormattedStringForLessThanHundred(inputForDecimalAndUnit));
		
	}

	private static void getBritishConversion(long input, StringBuilder str) {
		str.append(getPrefixForUnit(input, CRORE));
		long inputForLakh = input % CRORE;

		str.append(getPrefixForUnit(inputForLakh, LAKH));
		long inputForThousad = inputForLakh % LAKH;

		str.append(getPrefixForUnit(inputForThousad, THOUSAND));
		long inputForHundred = input % THOUSAND;

		str.append(getPrefixForUnit(inputForHundred, HUNDRED));
		long inputForDecimalAndUnit = input % HUNDRED;

		str.append(getFormattedStringForLessThanHundred(inputForDecimalAndUnit));
	}

	private static String leftTrim(StringBuilder str) {
		String result = str.toString();
		if (str.toString().startsWith(SPACE)) {
			result = str.substring(1);
		}
		return result;
	}

	/*
	 * Unit can be CRORE,LAKH, THOUSAND, HUNDRED
	 */
	private static String getPrefixForUnit(long input, long unitForSuffix) {
		StringBuilder str = new StringBuilder();
		long prefix = (input / unitForSuffix);

		if (prefix < 1000) {
			if (prefix > 99) {
				str.append(getPrefixForUnit(prefix, HUNDRED));
				
				if(!britishConversion) {
					long inputForDecimalAndUnit = prefix % HUNDRED;
					str.append(getFormattedStringForLessThanHundred(inputForDecimalAndUnit));
				}
				str.append(SPACE);
				str.append(getFromDictionary(unitForSuffix));
			} else if (prefix > 0 && prefix < 100) {
				str.append(getFormattedStringForLessThanHundred(prefix));
				str.append(SPACE);
				str.append(getFromDictionary(unitForSuffix));
			}
		}
		return str.toString();
	}

	private static String getFormattedStringForLessThanHundred(long input) {

		StringBuilder str = new StringBuilder();

		if (isLessThanTwenty(input)) {
			str.append(getTextFromDictionaryWithSpace(input));
		}

		else if (isMoreThan20LessThan100(input)) {
			long decimal = input / TEN;
			str.append(SPACE);
			str.append(getFromDictionary(decimal * TEN));

			if (input % TEN > 0) {
				long unit = input % TEN;
				str.append(getTextFromDictionaryWithSpace(unit));
			}
		}
		return str.toString();
	}

	private static String getTextFromDictionaryWithSpace(long input) {
		return SPACE + getFromDictionary(input);
	}

	private static boolean isMoreThan20LessThan100(long prefix) {
		return prefix < 100 && prefix > 20;
	}

	private static boolean isLessThanTwenty(long prefix) {
		return prefix <= 20 && prefix > 0;
	}

	private static String getFromDictionary(long input) {
		return intoToTextDictionary.get(Long.toString(input));
	}

	private static void buildIntToTextDictionary() {
		intoToTextDictionary.put("0", "zero");
		intoToTextDictionary.put("1", "one");
		intoToTextDictionary.put("2", "two");
		intoToTextDictionary.put("3", "three");
		intoToTextDictionary.put("4", "four");
		intoToTextDictionary.put("5", "five");
		intoToTextDictionary.put("6", "six");
		intoToTextDictionary.put("7", "seven");
		intoToTextDictionary.put("8", "eight");
		intoToTextDictionary.put("9", "nine");
		intoToTextDictionary.put("10", "ten");
		intoToTextDictionary.put("11", "eleven");
		intoToTextDictionary.put("12", "twelve");
		intoToTextDictionary.put("13", "thirteen");
		intoToTextDictionary.put("14", "fourteen");
		intoToTextDictionary.put("15", "fifteen");
		intoToTextDictionary.put("16", "sixteen");
		intoToTextDictionary.put("17", "seventeen");
		intoToTextDictionary.put("18", "eighteen");
		intoToTextDictionary.put("19", "nineteen");
		intoToTextDictionary.put("20", "twenty");
		intoToTextDictionary.put("30", "thirty");
		intoToTextDictionary.put("40", "forty");
		intoToTextDictionary.put("50", "fifty");
		intoToTextDictionary.put("60", "sixty");
		intoToTextDictionary.put("70", "seventy");
		intoToTextDictionary.put("80", "eighty");
		intoToTextDictionary.put("90", "ninety");
		intoToTextDictionary.put("10000000", "crore");
		intoToTextDictionary.put("100000", "lakh");
		intoToTextDictionary.put("1000000", "million");
		intoToTextDictionary.put("1000000000", "billion");
		intoToTextDictionary.put("1000", "thousand");
		intoToTextDictionary.put("100", "hundred");
	}

}
