#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#include"number-in-words.c"

void assertEquals(char str1[], char str2[]) {
	if(strcmp(str1, str2) != 0) {
		printf("Failed. Expected '%s', Actual '%s' ... exiting\n", str1, str2);
		exit(1);
	} else {
		printf("Passed: %s\n", str1);
	}
}

void test1DigitNumbers() {
	assertEquals ("zero", getNumberInWords (0));
	assertEquals ("one", getNumberInWords (1));
	assertEquals ("two", getNumberInWords (2));
	assertEquals ("three", getNumberInWords (3));
	assertEquals ("four", getNumberInWords (4));
	assertEquals ("five", getNumberInWords (5));
	assertEquals ("six", getNumberInWords (6));
	assertEquals ("seven", getNumberInWords (7));
	assertEquals ("eight", getNumberInWords (8));
	assertEquals ("nine", getNumberInWords (9));
}

void test2DigitNumbers() {
	assertEquals ("ten", getNumberInWords (10));
	assertEquals ("eleven", getNumberInWords (11));
	assertEquals ("twelve", getNumberInWords (12));
	assertEquals ("thirteen", getNumberInWords (13));
	assertEquals ("fourteen", getNumberInWords (14));
	assertEquals ("fifteen", getNumberInWords (15));
	assertEquals ("sixteen", getNumberInWords (16));
	assertEquals ("seventeen", getNumberInWords (17));
	assertEquals ("eighteen", getNumberInWords (18));
	assertEquals ("nineteen", getNumberInWords (19));
	assertEquals ("twenty", getNumberInWords (20));
	assertEquals ("thirty one", getNumberInWords (31));
	assertEquals ("forty two", getNumberInWords (42));
	assertEquals ("fifty three", getNumberInWords (53));
	assertEquals ("sixty four", getNumberInWords (64));
	assertEquals ("seventy five", getNumberInWords (75));
	assertEquals ("eighty six", getNumberInWords (86));
	assertEquals ("ninety seven", getNumberInWords (97));
	assertEquals ("ninety eight", getNumberInWords (98));
	assertEquals ("ninety nine", getNumberInWords (99));
}

void test3DigitNumbers() {
	assertEquals ("one hundred", getNumberInWords (100));
	assertEquals ("one hundred one", getNumberInWords (101));
	assertEquals ("two hundred eleven", getNumberInWords (211));
	assertEquals ("three hundred twenty two", getNumberInWords (322));
	assertEquals ("four hundred thirty three", getNumberInWords (433));
	assertEquals ("five hundred forty four", getNumberInWords (544));
	assertEquals ("six hundred fifty five", getNumberInWords (655));
	assertEquals ("seven hundred sixty six", getNumberInWords (766));
	assertEquals ("eight hundred seventy seven", getNumberInWords (877));
	assertEquals ("nine hundred eighty eight", getNumberInWords (988));
	assertEquals ("nine hundred ninety nine", getNumberInWords (999));
}

void test4DigitNumbers() {
	assertEquals ("one thousand", getNumberInWords (1000));
	assertEquals ("one thousand one", getNumberInWords (1001));
	assertEquals ("one thousand two hundred thirty four", getNumberInWords (1234));
	assertEquals ("two thousand three hundred forty five", getNumberInWords (2345));
	assertEquals ("three thousand four hundred fifty six", getNumberInWords (3456));
	assertEquals ("four thousand five hundred sixty seven", getNumberInWords (4567));
	assertEquals ("five thousand six hundred seventy eight", getNumberInWords (5678));
	assertEquals ("six thousand seven hundred eighty nine", getNumberInWords (6789));
	assertEquals ("seven thousand eight hundred ninety", getNumberInWords (7890));
	assertEquals ("eight thousand nine hundred one", getNumberInWords (8901));
	assertEquals ("nine thousand twelve", getNumberInWords (9012));
	assertEquals ("nine thousand nine hundred ninety nine", getNumberInWords (9999));
}

void test5DigitNumbers() {
	assertEquals ("ten thousand", getNumberInWords (10000));
	assertEquals ("ten thousand one", getNumberInWords (10001));
	assertEquals ("twelve thousand three hundred forty five", getNumberInWords (12345));
	assertEquals ("twenty three thousand four hundred fifty six", getNumberInWords (23456));
	assertEquals ("thirty four thousand five hundred sixty seven", getNumberInWords (34567));
	assertEquals ("forty five thousand six hundred seventy eight", getNumberInWords (45678));
	assertEquals ("fifty six thousand seven hundred eighty nine", getNumberInWords (56789));
	assertEquals ("sixty seven thousand eight hundred ninety", getNumberInWords (67890));
	assertEquals ("seventy eight thousand nine hundred one", getNumberInWords (78901));
	assertEquals ("eighty nine thousand twelve", getNumberInWords (89012));
	assertEquals ("ninety thousand one hundred twenty three", getNumberInWords (90123));
	assertEquals ("ninety nine thousand nine hundred ninety nine", getNumberInWords (99999));
}

void test6DigitNumbers() {
	assertEquals ("one lakh", getNumberInWords (100000));
	assertEquals ("one lakh one", getNumberInWords (100001));
	assertEquals ("one lakh nine thousand eight hundred seventy six", getNumberInWords (109876));
	assertEquals ("two lakh ten thousand nine hundred eighty seven", getNumberInWords (210987));
	assertEquals ("three lakh twenty one thousand ninety eight", getNumberInWords (321098));
	assertEquals ("four lakh thirty two thousand one hundred nine", getNumberInWords (432109));
	assertEquals ("five lakh forty three thousand two hundred ten", getNumberInWords (543210));
	assertEquals ("six lakh fifty four thousand three hundred twenty one", getNumberInWords (654321));
	assertEquals ("seven lakh sixty five thousand four hundred thirty two", getNumberInWords (765432));
	assertEquals ("eight lakh seventy six thousand five hundred forty three", getNumberInWords (876543));
	assertEquals ("nine lakh eighty seven thousand six hundred fifty four", getNumberInWords (987654));
	assertEquals ("nine lakh ninety nine thousand nine hundred ninety nine", getNumberInWords (999999));
}

void test7DigitNumbers() {
	assertEquals ("ten lakh", getNumberInWords (1000000));
	assertEquals ("ten lakh one", getNumberInWords (1000001));
	assertEquals ("eleven lakh eleven thousand one hundred eleven", getNumberInWords (1111111));
	assertEquals ("twenty two lakh twenty two thousand two hundred twenty two", getNumberInWords (2222222));
	assertEquals ("thirty three lakh thirty three thousand three hundred thirty three", getNumberInWords (3333333));
	assertEquals ("forty four lakh forty four thousand four hundred forty four", getNumberInWords (4444444));
	assertEquals ("fifty five lakh fifty five thousand five hundred fifty five", getNumberInWords (5555555));
	assertEquals ("sixty six lakh sixty six thousand six hundred sixty six", getNumberInWords (6666666));
	assertEquals ("seventy seven lakh seventy seven thousand seven hundred seventy seven", getNumberInWords (7777777));
	assertEquals ("eighty eight lakh eighty eight thousand eight hundred eighty eight", getNumberInWords (8888888));
	assertEquals ("ninety nine lakh ninety nine thousand nine hundred ninety nine", getNumberInWords (9999999));
}

void test8DigitNumbers() {
	assertEquals ("one crore", getNumberInWords (10000000));
	assertEquals ("one crore one", getNumberInWords (10000001));
	assertEquals ("one crore nine lakh eighty seven thousand six hundred fifty four", getNumberInWords (10987654));
	assertEquals ("two crore ten lakh ninety eight thousand seven hundred sixty five", getNumberInWords (21098765));
	assertEquals ("three crore twenty one lakh nine thousand eight hundred seventy six", getNumberInWords (32109876));
	assertEquals ("four crore thirty two lakh ten thousand nine hundred eighty seven", getNumberInWords (43210987));
	assertEquals ("five crore forty three lakh twenty one thousand ninety eight", getNumberInWords (54321098));
	assertEquals ("six crore fifty four lakh thirty two thousand one hundred nine", getNumberInWords (65432109));
	assertEquals ("seven crore sixty five lakh forty three thousand two hundred ten", getNumberInWords (76543210));
	assertEquals ("eight crore seventy six lakh fifty four thousand three hundred twenty one", getNumberInWords (87654321));
	assertEquals ("nine crore eighty seven lakh sixty five thousand four hundred thirty two", getNumberInWords (98765432));
	assertEquals ("nine crore ninety nine lakh ninety nine thousand nine hundred ninety nine", getNumberInWords (99999999));
}

void test9DigitNumbers() {
	assertEquals ("ten crore", getNumberInWords (100000000));
	assertEquals ("ten crore one", getNumberInWords (100000001));
	assertEquals ("twelve crore thirty one lakh twenty three thousand one hundred twenty three", getNumberInWords (123123123));
	assertEquals ("twenty three crore forty two lakh thirty four thousand two hundred thirty four", getNumberInWords (234234234));
	assertEquals ("thirty four crore fifty three lakh forty five thousand three hundred forty five", getNumberInWords (345345345));
	assertEquals ("forty five crore sixty four lakh fifty six thousand four hundred fifty six", getNumberInWords (456456456));
	assertEquals ("fifty six crore seventy five lakh sixty seven thousand five hundred sixty seven", getNumberInWords (567567567));
	assertEquals ("sixty seven crore eighty six lakh seventy eight thousand six hundred seventy eight", getNumberInWords (678678678));
	assertEquals ("seventy eight crore ninety seven lakh eighty nine thousand seven hundred eighty nine", getNumberInWords (789789789));
	assertEquals ("eighty nine crore eight lakh ninety thousand eight hundred ninety", getNumberInWords (890890890));
	assertEquals ("ninety crore nineteen lakh one thousand nine hundred one", getNumberInWords (901901901));
	assertEquals ("ninety nine crore ninety nine lakh ninety nine thousand nine hundred ninety nine", getNumberInWords (999999999));
}

void testValuesOutsideRange() {
	assertEquals ("no result", getNumberInWords (-1));
	assertEquals ("no result", getNumberInWords (1000000000));
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
	testValuesOutsideRange();
	return 0;
}
