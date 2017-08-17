#include<stdio.h>
#include<string.h>
#include<stdlib.h>

char *zero2Twenty[21] = {
	"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
	"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
	"nineteen", "twenty"
};

char *twenty2Ninety[10] = {
	"", "", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninty"
};

typedef struct scale {
	int value;
	char *name;
} scale;

scale crore = {10000000, "crore"};
scale lakh = {100000, "lakh"};
scale thousand = {1000, "thousand"};
scale hundred = {100, "hundred"};
scale unit = {1, ""};

void * allocateMemory(int size) {
	void *ptr = malloc(size);

	if(ptr == NULL) {
		printf("%s\n", "Unable to allocate memory ... exiting.");
		exit(1);
	}
	return ptr;
}

char * getWordsFor2DigitNumber(int numScale) {
	char *wordsFor2DigitNumber;

	if(numScale <= 20) {
		wordsFor2DigitNumber = (char *) allocateMemory(strlen(zero2Twenty[numScale]) + 1);
		wordsFor2DigitNumber = zero2Twenty[numScale];
	} else {
		int firstDigit = numScale / 10;
		int secondDigit = numScale % 10;

		char *wordForFirstDigit = twenty2Ninety[firstDigit];

		if(secondDigit > 0) {
			char *wordForSecondDigit = zero2Twenty[secondDigit];
			wordsFor2DigitNumber = (char *) allocateMemory(strlen(wordForFirstDigit) + strlen(wordForSecondDigit) + 1);
			
    		strcpy(wordsFor2DigitNumber, wordForFirstDigit);
    		strcat(wordsFor2DigitNumber, " ");
			strcat(wordsFor2DigitNumber, wordForSecondDigit);
		} else {
			wordsFor2DigitNumber = wordForFirstDigit;
		}
	}
	return wordsFor2DigitNumber;
}

char * getWordsForScale(int number, int scaleValue, char *scaleName) {
	char *wordsForScale;

	int twoDigitScaleNumber = number / scaleValue;

	if(twoDigitScaleNumber > 0) {
		char *twoDigitScaleWord = getWordsFor2DigitNumber(twoDigitScaleNumber);
		wordsForScale = allocateMemory(strlen(twoDigitScaleWord) + strlen(scaleName) + 1);

    	strcpy(wordsForScale, twoDigitScaleWord);
    	strcat(wordsForScale, " ");
    	strcat(wordsForScale, scaleName);
    	strcat(wordsForScale, " ");
	} else {
		wordsForScale = "";
	}
	return wordsForScale;
}

int getLength(int number) {
	int length = 0;
	while(number > 0) {
		length++;
		number /= 10;
	}
	return length;
}

char * getNumberInWords(int number) {
	if(number < 0 ) {
		return "Invalid number: Negative number";
	} else if(getLength(number) > 9) {
		return "Invalid number: Too many digits";
	} else if(number == 0) {
		return "Zero";
	}

	char *croreString = getWordsForScale(number, crore.value, crore.name);
	number %= crore.value;

	char *lakhString = getWordsForScale(number, lakh.value, lakh.name);
	number %= lakh.value;

	char *thousandString = getWordsForScale(number, thousand.value, thousand.name);
	number %= thousand.value;

	char *hundredString = getWordsForScale(number, hundred.value, hundred.name);
	number %= hundred.value;

	char *unitString = getWordsForScale(number, unit.value, unit.name);

	char *result = (char *) allocateMemory(strlen(croreString) + strlen(lakhString) + strlen(thousandString) + strlen(hundredString) + strlen(unitString) + 1);

	strcpy(result, croreString);
	strcat(result, lakhString);
	strcat(result, thousandString);
	strcat(result, hundredString);
	strcat(result, unitString);
	
	return result;
}

int main() {
	int number;
	char *numberInWords;
	printf("Enter the number: ");
	scanf("%d", &number);
	do {
		numberInWords = getNumberInWords(number);
		printf("Number in words: %s\n", numberInWords);
		printf("Enter the number (-1 to exit): ");
		scanf("%d", &number);
	} while(number != -1);
	return 0;
}

/* Problem: Input int will be in the range 0 to 999999999 (both inclusive). Output will be a String in crores, lakhs, thousands, hundreds system. Examples: Input: 5, Output: five, Input: 111111111, Output: eleven crore eleven lakh eleven thousand one hundred eleven */
