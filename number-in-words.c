#include<stdio.h>
#include<string.h>
#include<stdlib.h>

char *zero2Twenty[21] = {
	"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
	"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
	"Nineteen", "Twenty"
};

char *twenty2Ninety[10] = {
	"", "", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninty"
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

char * getString(int numScale) {
	char *string;
	char *result;

	if(numScale <= 20) {
		result = (char *) allocateMemory(strlen(zero2Twenty[numScale]) + 1);
		result = zero2Twenty[numScale];
	} else {
		int first = numScale / 10;
		int second = numScale % 10;
		string = twenty2Ninety[first];
		if(second > 0) {
			result = (char *) allocateMemory(strlen(string) + strlen(zero2Twenty[second]) + 1);
    		strcpy(result, string);
    		strcat(result, " ");
			strcat(result, zero2Twenty[second]);
		} else {
			result = string;
		}
	}
	return result;
}

char * getScaleString(int number, int scale, char *scaleString) {
	char *string;
	char *result;

	int numScale = number / scale;
	if(numScale>0) {
		string = getString(numScale);
		result = allocateMemory(strlen(string) + strlen(scaleString) + 1);
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

char * getNumberInWords(int number) {
	if(number < 0 ) {
		return "Invalid number: Negative number";
	} else if(getLength(number) > 9) {
		return "Invalid number: Too many digits";
	} else if(number == 0) {
		return "Zero";
	}

	char *croreString = getScaleString(number, crore.value, crore.name);
	number %= crore.value;

	char *lakhString = getScaleString(number, lakh.value, lakh.name);
	number %= lakh.value;

	char *thousandString = getScaleString(number, thousand.value, thousand.name);
	number %= thousand.value;

	char *hundredString = getScaleString(number, hundred.value, hundred.name);
	number %= hundred.value;

	char *unitString = getScaleString(number, unit.value, unit.name);

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
