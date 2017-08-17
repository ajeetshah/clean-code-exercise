/*
Problem:
Input int will be in the range 0 to 999999999 (both inclusive).
Output will be a String in crores, lakhs, thousands, hundreds system.
Examples:
Input: 5
Output: five
Input: 111111111
Output: eleven crore eleven lakh eleven thousand one hundred eleven
*/

#include<stdio.h>
#include<string.h>
#include<stdlib.h>

struct numberStringStruct {
	char *string;
};
struct numberStringStruct zero2TwentyMap[21];
struct numberStringStruct twenty2Ninety[9];

void defineNumberStringMap() {
	zero2TwentyMap[0].string = "Zero";
	zero2TwentyMap[1].string = "One";
	zero2TwentyMap[2].string = "Two";
	zero2TwentyMap[3].string = "Three";
	zero2TwentyMap[4].string = "Four";
	zero2TwentyMap[5].string = "Five";
	zero2TwentyMap[6].string = "Six";
	zero2TwentyMap[7].string = "Seven";
	zero2TwentyMap[8].string = "Eight";
	zero2TwentyMap[9].string = "Nine";
	zero2TwentyMap[10].string = "Ten";
	zero2TwentyMap[11].string = "Eleven";
	zero2TwentyMap[12].string = "Twelve";
	zero2TwentyMap[13].string = "Thirteen";
	zero2TwentyMap[14].string = "Fourteen";
	zero2TwentyMap[15].string = "Fifteen";
	zero2TwentyMap[16].string = "Sixteen";
	zero2TwentyMap[17].string = "Seventeen";
	zero2TwentyMap[18].string = "Eighteen";
	zero2TwentyMap[19].string = "Nineteen";
	zero2TwentyMap[20].string = "Twenty";

	twenty2Ninety[0].string = "n/a";
	twenty2Ninety[1].string = "n/a";
	twenty2Ninety[2].string = "Twenty";
	twenty2Ninety[3].string = "Thirty";
	twenty2Ninety[4].string = "Fourty";
	twenty2Ninety[5].string = "Fifty";
	twenty2Ninety[6].string = "Sixty";
	twenty2Ninety[7].string = "Seventy";
	twenty2Ninety[8].string = "Eighty";
	twenty2Ninety[9].string = "Ninty";
}

enum scale {
	crore = 10000000,
	lakh = 100000,
	thousand = 1000,
	hundred = 100,
	unit = 1
};

char * getString(int numScale) {
	char *string;
	char *result;

	if(numScale <= 20) {
		result = malloc(strlen(zero2TwentyMap[numScale].string)+1);
		result = zero2TwentyMap[numScale].string;
	} else {
		int startDigit = numScale / 10;
		int endDigit = numScale % 10;
		string = twenty2Ninety[startDigit].string;
		if(endDigit > 0) {
			result = malloc(strlen(string)+strlen(zero2TwentyMap[endDigit].string)+1);
    		strcpy(result, string);
    		strcat(result, " ");
			strcat(result, zero2TwentyMap[endDigit].string);
		} else {
			result = string;
		}
	}
	return result;
}

char * getScaleString(int number, int scale, const char *scaleString) {
	char *string;
	char *result;

	int numScale = number / scale;
	if(numScale>0) {
		string = getString(numScale);
		result = malloc(strlen(string)+strlen(scaleString)+1);
    	strcpy(result, string);
    	strcat(result, " ");
    	strcat(result, scaleString);
    	strcat(result, " ");
	} else {
		result = "";
	}
	return result;
}

int getLength(int number) {
	int length = 0;
	while(number > 0) {
		length++;
		number /= 10;
	}
	return length;
}

char * getNumberString(int number) {
	if(number <= -1 ) {
		return "Invalid number: Please enter a non negative number";
	} else if(getLength(number) >= 10) {
		return "Invalid number: Please neter a number of length less than 10";
	} else if(number == 0) {
		return "Zero";
	}
	char *numberString;
	char *croreString;
	char *lakhString;
	char *thousandString;
	char *hundredString;
	char *unitString;

	croreString = getScaleString(number, crore, "Crore");
	number = number % crore;

	lakhString = getScaleString(number, lakh, "Lakh");
	number %= lakh;

	thousandString = getScaleString(number, thousand, "Thousand");
	number %= thousand;

	hundredString = getScaleString(number, hundred, "Hundred");
	number %= hundred;

	unitString = getScaleString(number, unit, "");

	numberString = malloc(strlen(croreString)+strlen(lakhString)+strlen(thousandString)+strlen(hundredString)+strlen(unitString)+1);
	strcpy(numberString, croreString);
	strcat(numberString, lakhString);
	strcat(numberString, thousandString);
	strcat(numberString, hundredString);
	strcat(numberString, unitString);
	return numberString;
}

int main() {
	int number;
	char *numberString;
	defineNumberStringMap();
	printf("Enter the number: ");
	scanf("%d", &number);
	do {
		numberString = getNumberString(number);
		printf("Number in string: %s\n", numberString);
		printf("Enter the number (-1 to exit): ");
		scanf("%d", &number);
	} while(number != -1);
	return 0;
}
