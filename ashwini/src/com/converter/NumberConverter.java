package com.converter;

import java.util.Scanner;

public class NumberConverter {

	private static final String NO_RESULT = "no result";
	private static final String SPACE = " ";
	private static final String HUNDRED = "hundred";
	private static final String THOUSAND = "thousand";
	private static final String LAC = "lakh";
	private static final String CRORE = "crore";
	private static Scanner scanner;

	public static void main(String args[]) {
		int number = readNumber();
		System.out.println("Number entered is : " + convert(number));
	}

	private static int readNumber() {
		scanner = new Scanner(System.in);
		System.out.println("Please enter the number you want to convert : ");
		return scanner.nextInt();
	}

	private static boolean validateNumber(int number) {
		if (number < 0 || number > 999999999) {
			System.out.println(NO_RESULT);
			return false;
		}
		return true;
	}

	static String convert(int number) {
		if (validateNumber(number)) {
			int numberOfDigits = String.valueOf(number).length();
			switch (numberOfDigits) {
			case 0:
				return getSingleDigitNumber(number);
			case 1:
				return getSingleDigitNumber(number);
			case 2:
				return getTwoDigitNumber(number);
			case 3:
				return getThreeDigitNumber(number);
			case 4:
				return getFourDigitNumber(number);
			case 5:
				return getFiveDigitNumber(number);
			case 6:
				return getSixDigitNumber(number);
			case 7:
				return getSevenDigitNumber(number);
			case 8:
				return getEightDigitNumber(number);
			case 9:
				return getNineDigitNumber(number);
			}
		}
		return NO_RESULT;
	}

	private static String getSingleDigitNumber(int number) {
		return NumberConstants.numberMap.get(new Integer(number));
	}

	private static String getTwoDigitNumber(int number) {
		if (number > 20 && number % 10 != 0) {
			return NumberConstants.numberMap.get(new Integer(number - number % 10)) + SPACE
					+ NumberConstants.numberMap.get(new Integer(number - (number / 10) * 10));
		} else {
			return NumberConstants.numberMap.get(new Integer(number));
		}
	}

	private static String getThreeDigitNumber(int number) {
		if ((number % 100) == 0) {
			return NumberConstants.numberMap.get(new Integer(number / 100)) + SPACE + HUNDRED;
		} else {
			return getSingleDigitNumber((number / 100)) + SPACE + HUNDRED + SPACE
					+ convert((number - (number / 100) * 100));
		}
	}

	private static String getFourDigitNumber(int number) {
		if ((number % 1000) == 0) {
			return NumberConstants.numberMap.get(new Integer(number / 1000)) + SPACE + THOUSAND;
		} else {
			return getSingleDigitNumber((number / 1000)) + SPACE + THOUSAND + SPACE
					+ convert((number - (number / 1000) * 1000));
		}
	}

	private static String getFiveDigitNumber(int number) {
		if ((number % 1000) == 0) {
			if ((number % 10000) == 0) {
				return NumberConstants.numberMap.get(new Integer(number / 1000)) + SPACE + THOUSAND;
			}
			return getTwoDigitNumber((number / 1000)) + SPACE + THOUSAND;
		} else {
			return getTwoDigitNumber((number / 1000)) + SPACE + THOUSAND + SPACE
					+ convert((number - (number / 1000) * 1000));
		}
	}

	private static String getSixDigitNumber(int number) {
		if ((number % 100000) == 0) {
			return NumberConstants.numberMap.get(new Integer(number / 100000)) + SPACE + LAC;
		} else {
			return getSingleDigitNumber((number / 100000)) + SPACE + LAC + SPACE
					+ convert((number - (number / 100000) * 100000));
		}
	}

	private static String getSevenDigitNumber(int number) {
		if ((number % 100000) == 0) {
			if ((number % 1000000) == 0) {
				return NumberConstants.numberMap.get(new Integer(number / 100000)) + SPACE + LAC;
			}
			return getTwoDigitNumber((number / 100000)) + SPACE + LAC;
		} else {
			return getTwoDigitNumber((number / 100000)) + SPACE + LAC + SPACE
					+ convert((number - (number / 100000) * 100000));
		}
	}

	private static String getEightDigitNumber(int number) {
		if ((number % 10000000) == 0) {
			return NumberConstants.numberMap.get(new Integer(number / 10000000)) + SPACE + CRORE;
		} else {
			return getSingleDigitNumber((number / 1000000)) + SPACE + CRORE + SPACE
					+ convert((number - (number / 1000000) * 1000000));
		}
	}

	private static String getNineDigitNumber(int number) {
		if ((number % 10000000) == 0) {
			if ((number % 100000000) == 0) {
				return NumberConstants.numberMap.get(new Integer(number / 10000000)) + SPACE + CRORE;
			}
			return getTwoDigitNumber((number / 10000000)) + SPACE + CRORE;
		} else {
			return getTwoDigitNumber((number / 10000000)) + SPACE + CRORE + SPACE
					+ convert((number - (number / 10000000) * 10000000));
		}
	}

}