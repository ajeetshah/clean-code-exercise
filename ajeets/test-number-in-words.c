#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#include"number-in-words.c"

void assertEqualString(char str1[], char str2[]) {
	// printf("|%s|%s|\n", str1, str2);
	if(strcmp(str1, str2) != 0) {
		printf("Failed. Expected '%s', Actual '%s' ... exiting\n", str1, str2);
		exit(1);
	} else {
		printf("Passed: %s\n", str1);
	}
}

void test1DigitNumbers() {
	assertEqualString("zero", getNumberInWords(0));
	assertEqualString("nine", getNumberInWords(9));
}

void test2DigitNumbers() {
	assertEqualString("ten", getNumberInWords(10));
	assertEqualString("twenty", getNumberInWords(20));
}

void test3DigitNumbers() {
	assertEqualString("one hundred", getNumberInWords(100));
	assertEqualString("nine hundred nine", getNumberInWords(909));
}

void test4DigitNumbers() {
	assertEqualString("one thousand two hundred thirty four", getNumberInWords(1234));
	assertEqualString("nine thousand nine", getNumberInWords(9009));
}

void test5DigitNumbers() {
	assertEqualString("eighty nine thousand ninety seven", getNumberInWords(89097));
	assertEqualString("eleven thousand nine hundred ninety", getNumberInWords(11990));
}

void test6DigitNumbers() {
	assertEqualString("one lakh twenty three thousand four hundred fifty six", getNumberInWords(123456));
	assertEqualString("eight lakh ninety two thousand three hundred", getNumberInWords(892300));
}

void test7DigitNumbers() {
	assertEqualString("twelve lakh two hundred thirty six", getNumberInWords(1200236));
	assertEqualString("eighty nine lakh twenty three thousand one", getNumberInWords(8923001));
}

void test8DigitNumbers() {
	assertEqualString("eight crore eighty one lakh twelve thousand two hundred fourty four", getNumberInWords(88112244));
	assertEqualString("nine lakh ninety one thousand one hundred", getNumberInWords(991100));
}

void test9DigitNumbers() {
	assertEqualString("eighty eight crore eleven lakh twenty two thousand four hundred fourty", getNumberInWords(881122440));
	assertEqualString("ninety nine lakh eleven thousand nine", getNumberInWords(9911009));
}

int main(int numArgs, char *args[]) {
	test1DigitNumbers();
	test2DigitNumbers();
	test3DigitNumbers();
	test4DigitNumbers();
	test5DigitNumbers();
	test6DigitNumbers();
	test7DigitNumbers();
	test8DigitNumbers();
	test9DigitNumbers();
	return 0;
}
