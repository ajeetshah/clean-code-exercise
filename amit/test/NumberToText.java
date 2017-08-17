package test;

import java.util.HashMap;
import java.util.Scanner;


public class NumberToText {
	public enum Number {
		ZERO(0, "zero"), ONE(1, "One"), TWO(2, "Two"), THREE(3, "Three"), FOUR(4,
				"Four"), FIVE(5, "Five"), SIX(6, "Six"), SEVEN(7,
						"Seven"), EIGHT(8, "Eight"), NINE(9,
								"Nine"), TEN(10, "Ten"), ELEVEN(11,
										"Eleven"), TWELVE(12, "Tweleve"),THIRTEEN(13, "Thirteen"), FOURTEEN(14, "Fourteen"), FIFTEEN(15,
												"Fifteen"), SIXTEEN(16, "Sixteen"), SEVENTEEN(17,
														"Seventeen"), EIGHTEEN(18, "Eighteen"), NINETEEN(19,
																"Nineteen"), TWENTY(20, "Twenty"), THIRTY(30, "Thirty"), FORTY(40, "Forty")
		, FIFTY(50, "Fifty"), SIXTY(60, "Sixty"), SEVENTY(70, "Seventy"), EIGHTY(80, "Eighty"), NINTY(90, "Ninty");
		private Number(int code, String value) {
			this.code = code;
			this.value = value;
		}

		private int code;
		private String value;

		public int getCode() {
			return code;
		}

		public String getValue() {
			return value;
		}

		public static String getValueByCode(int code) {
			for (Number number : Number.values()) {
				if (code == number.getCode()) {
					return number.getValue();
				}
			}
			return "";
		}
	}
	public String integerNumberToTextConversion(int number){
		if(checkNumberValidation(number)){
			return "number out of range";
		}
		else if(number==0){
			return "zero";
		}
		else{
			return numberToTextConversion(number).toLowerCase();
		}
	}
	public String numberToTextConversion(int number){
		
		int numberOfDigits=countDigit(number);
		switch(numberOfDigits){
		case 1:
			return displayOneDigitNumberIntoText(number);
		case 2:
			return displayTwoDigitNumberIntoText(number);
		case 3:
			return displayThreeDigitNumberIntoText(number);
		case 4:
			return displayFourDigitNumberIntoText(number);
		case 5:
			return displayFiveDigitNumberIntoText(number);
		case 6:
			return displaySixDigitNumberIntoText(number);
		case 7:
			return displaySevenDigitNumberIntoText(number);
		case 8:
			return displayEightDigitNumberIntoText(number);
		case 9:
			return displayNineDigitNumberIntoText(number);
		}
		return "";
	}
	private boolean checkNumberValidation(int number) {
		return number<0||number>999999999;
	}
	public int countDigit(int number){
		String numberAsString=number+"";
		int size=numberAsString.trim().length();
		return size;
	}
	public String displayOneDigitNumberIntoText(int number){
		return Number.getValueByCode(number);
	}
	
	public String displayTwoDigitNumberIntoText(int number){
		
		if(number>20&&number%10!=0){ //21
			return Number.getValueByCode(number-number%10)+numberToTextConversion(number-(number/10)*10);
		}else{
			return Number.getValueByCode(number);
		}
		
	}
	
	public String displayThreeDigitNumberIntoText(int number){
		return displayOneDigitNumberIntoText((number/100))+" "+"hunderd"+" "+numberToTextConversion(number-(number/100)*100);
	}
	
	public String displayFourDigitNumberIntoText(int number){ 
		return displayOneDigitNumberIntoText((number/1000))+" "+"thousand"+" "+numberToTextConversion(number-(number/1000)*1000);
	}
	
	public String displayFiveDigitNumberIntoText(int number){
		return displayTwoDigitNumberIntoText((number/1000))+" "+"thousand"+" "+numberToTextConversion(number-(number/1000)*1000);
	}
	
	public String displaySixDigitNumberIntoText(int number){ 
		return displayOneDigitNumberIntoText((number/100000))+" "+"lac"+" "+numberToTextConversion(number-(number/100000)*100000);
	}
	public String displaySevenDigitNumberIntoText(int number){ 
		return displayTwoDigitNumberIntoText((number/100000))+" "+"lac"+" "+numberToTextConversion(number-(number/100000)*100000);
	}
	
	public String displayEightDigitNumberIntoText(int number){
		return displayOneDigitNumberIntoText((number/10000000))+" "+"crore"+" "+numberToTextConversion(number-(number/10000000)*10000000);
	}
	
	public String displayNineDigitNumberIntoText(int number){
		return displayTwoDigitNumberIntoText((number/10000000))+" "+"crore"+" "+numberToTextConversion(number-(number/10000000)*10000000);
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("enter an integer");
		int myint = keyboard.nextInt();
		NumberToText numberToText=new NumberToText();
		System.out.println(numberToText.integerNumberToTextConversion(myint));
	}

}
