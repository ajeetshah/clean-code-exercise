package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Converter;

public class ConverterTest {

	@Test
	public void testOneDigitValues() throws InvalidValueException {
		assertEquals ("zero", Converter.convert (0));
		assertEquals ("one", Converter.convert (1));
		assertEquals ("two", Converter.convert (2));
		assertEquals ("three", Converter.convert (3));
		assertEquals ("four", Converter.convert (4));
		assertEquals ("five", Converter.convert (5));
		assertEquals ("six", Converter.convert (6));
		assertEquals ("seven", Converter.convert (7));
		assertEquals ("eight", Converter.convert (8));
		assertEquals ("nine", Converter.convert (9));
	}
	
	@Test
	public void testTwoDigitValues() throws InvalidValueException {
		assertEquals ("ten", Converter.convert (10));
		assertEquals ("eleven", Converter.convert (11));
		assertEquals ("twelve", Converter.convert (12));
		assertEquals ("thirteen", Converter.convert (13));
		assertEquals ("fourteen", Converter.convert (14));
		assertEquals ("fifteen", Converter.convert (15));
		assertEquals ("sixteen", Converter.convert (16));
		assertEquals ("seventeen", Converter.convert (17));
		assertEquals ("eighteen", Converter.convert (18));
		assertEquals ("nineteen", Converter.convert (19));
		assertEquals ("twenty", Converter.convert (20));
		assertEquals ("thirty one", Converter.convert (31));
		assertEquals ("forty two", Converter.convert (42));
		assertEquals ("fifty three", Converter.convert (53));
		assertEquals ("sixty four", Converter.convert (64));
		assertEquals ("seventy five", Converter.convert (75));
		assertEquals ("eighty six", Converter.convert (86));
		assertEquals ("ninety seven", Converter.convert (97));
		assertEquals ("ninety eight", Converter.convert (98));
		assertEquals ("ninety nine", Converter.convert (99));
	}
	
	@Test
	public void testThreeDigitValues() throws InvalidValueException {
		assertEquals ("one hundred", Converter.convert (100));
		assertEquals ("one hundred one", Converter.convert (101));
		assertEquals ("two hundred eleven", Converter.convert (211));
		assertEquals ("three hundred twenty two", Converter.convert (322));
		assertEquals ("four hundred thirty three", Converter.convert (433));
		assertEquals ("five hundred forty four", Converter.convert (544));
		assertEquals ("six hundred fifty five", Converter.convert (655));
		assertEquals ("seven hundred sixty six", Converter.convert (766));
		assertEquals ("eight hundred seventy seven", Converter.convert (877));
		assertEquals ("nine hundred eighty eight", Converter.convert (988));
		assertEquals ("nine hundred ninety nine", Converter.convert (999));
	}
	
	@Test
	public void testFourDigitValues() throws InvalidValueException {
		assertEquals ("one thousand", Converter.convert (1000));
		assertEquals ("one thousand one", Converter.convert (1001));
		assertEquals ("one thousand two hundred thirty four", Converter.convert (1234));
		assertEquals ("two thousand three hundred forty five", Converter.convert (2345));
		assertEquals ("three thousand four hundred fifty six", Converter.convert (3456));
		assertEquals ("four thousand five hundred sixty seven", Converter.convert (4567));
		assertEquals ("five thousand six hundred seventy eight", Converter.convert (5678));
		assertEquals ("six thousand seven hundred eighty nine", Converter.convert (6789));
		assertEquals ("seven thousand eight hundred ninety", Converter.convert (7890));
		assertEquals ("eight thousand nine hundred one", Converter.convert (8901));
		assertEquals ("nine thousand twelve", Converter.convert (9012));
		assertEquals ("nine thousand nine hundred ninety nine", Converter.convert (9999));
	}
	
	@Test
	public void testFiveDigitValues() throws InvalidValueException {
		assertEquals ("ten thousand", Converter.convert (10000));
		assertEquals ("ten thousand one", Converter.convert (10001));
		assertEquals ("twelve thousand three hundred forty five", Converter.convert (12345));
		assertEquals ("twenty three thousand four hundred fifty six", Converter.convert (23456));
		assertEquals ("thirty four thousand five hundred sixty seven", Converter.convert (34567));
		assertEquals ("forty five thousand six hundred seventy eight", Converter.convert (45678));
		assertEquals ("fifty six thousand seven hundred eighty nine", Converter.convert (56789));
		assertEquals ("sixty seven thousand eight hundred ninety", Converter.convert (67890));
		assertEquals ("seventy eight thousand nine hundred one", Converter.convert (78901));
		assertEquals ("eighty nine thousand twelve", Converter.convert (89012));
		assertEquals ("ninety thousand one hundred twenty three", Converter.convert (90123));
		assertEquals ("ninety nine thousand nine hundred ninety nine", Converter.convert (99999));
	}
	
	@Test
	public void testSixDigitValues() throws InvalidValueException {
		assertEquals ("one lakh", Converter.convert (100000));
		assertEquals ("one lakh one", Converter.convert (100001));
		assertEquals ("one lakh nine thousand eight hundred seventy six", Converter.convert (109876));
		assertEquals ("two lakh ten thousand nine hundred eighty seven", Converter.convert (210987));
		assertEquals ("three lakh twenty one thousand ninety eight", Converter.convert (321098));
		assertEquals ("four lakh thirty two thousand one hundred nine", Converter.convert (432109));
		assertEquals ("five lakh forty three thousand two hundred ten", Converter.convert (543210));
		assertEquals ("six lakh fifty four thousand three hundred twenty one", Converter.convert (654321));
		assertEquals ("seven lakh sixty five thousand four hundred thirty two", Converter.convert (765432));
		assertEquals ("eight lakh seventy six thousand five hundred forty three", Converter.convert (876543));
		assertEquals ("nine lakh eighty seven thousand six hundred fifty four", Converter.convert (987654));
		assertEquals ("nine lakh ninety nine thousand nine hundred ninety nine", Converter.convert (999999));
	}
	
	@Test
	public void testSixDigitValuesAmerican() throws InvalidValueException {
		Converter.setBritishConversion(false);
		assertEquals ("one hundred thousand", Converter.convert (100000));
		assertEquals ("one hundred thousand one", Converter.convert (100001));
		assertEquals ("one hundred nine thousand eight hundred seventy six", Converter.convert (109876));
		assertEquals ("two hundred ten thousand nine hundred eighty seven", Converter.convert (210987));
		assertEquals ("three hundred twenty one thousand ninety eight", Converter.convert (321098));
		assertEquals ("four hundred thirty two thousand one hundred nine", Converter.convert (432109));
		assertEquals ("five hundred forty three thousand two hundred ten", Converter.convert (543210));
		assertEquals ("six hundred fifty four thousand three hundred twenty one", Converter.convert (654321));
		assertEquals ("seven hundred sixty five thousand four hundred thirty two", Converter.convert (765432));
		assertEquals ("eight hundred seventy six thousand five hundred forty three", Converter.convert (876543));
		assertEquals ("nine hundred eighty seven thousand six hundred fifty four", Converter.convert (987654));
		assertEquals ("nine hundred ninety nine thousand nine hundred ninety nine", Converter.convert (999999));
	}
	
	@Test
	public void testSevenDigitValuesThousand() throws InvalidValueException{
		assertEquals ("ten lakh", Converter.convert (1000000));
		assertEquals ("ten lakh one", Converter.convert (1000001));
		assertEquals ("eleven lakh eleven thousand one hundred eleven", Converter.convert (1111111));
		assertEquals ("twenty two lakh twenty two thousand two hundred twenty two", Converter.convert (22_22_222));
		assertEquals ("thirty three lakh thirty three thousand three hundred thirty three", Converter.convert (3333333));
		assertEquals ("forty four lakh forty four thousand four hundred forty four", Converter.convert (44_44_444));
		assertEquals ("fifty five lakh fifty five thousand five hundred fifty five", Converter.convert (5555555));
		assertEquals ("sixty six lakh sixty six thousand six hundred sixty six", Converter.convert (6666666));
		assertEquals ("seventy seven lakh seventy seven thousand seven hundred seventy seven", Converter.convert (7777777));
		assertEquals ("eighty eight lakh eighty eight thousand eight hundred eighty eight", Converter.convert (8888888));
		assertEquals ("ninety nine lakh ninety nine thousand nine hundred ninety nine", Converter.convert (9999999));
	}
	
	@Test
	public void testEightDigitValues() throws InvalidValueException{
		Converter.setBritishConversion(false);
		assertEquals ("ten million", Converter.convert (10000000));
		assertEquals ("ten million one", Converter.convert (10000001));
		assertEquals ("ten million nine hundred eighty seven thousand six hundred fifty four", Converter.convert (10_987_654));
		assertEquals ("twenty one million ninety eight thousand seven hundred sixty five", Converter.convert (21_098_765));
		assertEquals ("thirty two million one hundred nine thousand eight hundred seventy six", Converter.convert (32_109_876));
		assertEquals ("forty three million two hundred ten thousand nine hundred eighty seven", Converter.convert (43_210_987));
		assertEquals ("fifty four million three hundred twenty one thousand ninety eight", Converter.convert (54_321_098));
		assertEquals ("sixty five million four hundred thirty two thousand one hundred nine", Converter.convert (65_432_109));
		assertEquals ("seventy six million five hundred forty three thousand two hundred ten", Converter.convert (76_543_210));
		assertEquals ("eighty seven million six hundred fifty four thousand three hundred twenty one", Converter.convert (87_654_321));
		assertEquals ("ninety eight million seven hundred sixty five thousand four hundred thirty two", Converter.convert (98_765_432));
		assertEquals ("ninety nine million nine hundred ninety nine thousand nine hundred ninety nine", Converter.convert (99_999_999));
	}
	public void testEightDigitValuesAmerican() throws InvalidValueException{
		assertEquals ("one crore", Converter.convert (10000000));
		assertEquals ("one crore one", Converter.convert (10000001));
		assertEquals ("one crore nine lakh eighty seven thousand six hundred fifty four", Converter.convert (10987654));
		assertEquals ("two crore ten lakh ninety eight thousand seven hundred sixty five", Converter.convert (21098765));
		assertEquals ("three crore twenty one lakh nine thousand eight hundred seventy six", Converter.convert (32109876));
		assertEquals ("four crore thirty two lakh ten thousand nine hundred eighty seven", Converter.convert (43210987));
		assertEquals ("five crore forty three lakh twenty one thousand ninety eight", Converter.convert (54321098));
		assertEquals ("six crore fifty four lakh thirty two thousand one hundred nine", Converter.convert (65432109));
		assertEquals ("seven crore sixty five lakh forty three thousand two hundred ten", Converter.convert (76543210));
		assertEquals ("eight crore seventy six lakh fifty four thousand three hundred twenty one", Converter.convert (87654321));
		assertEquals ("nine crore eighty seven lakh sixty five thousand four hundred thirty two", Converter.convert (98765432));
		assertEquals ("nine crore ninety nine lakh ninety nine thousand nine hundred ninety nine", Converter.convert (99999999));
	}
	
	public void testNineDigitValues() throws InvalidValueException {
		assertEquals ("ten crore", Converter.convert (100000000));
		assertEquals ("ten crore one", Converter.convert (100000001));
		assertEquals ("twelve crore thirty one lakh twenty three thousand one hundred twenty three", Converter.convert (123123123));
		assertEquals ("twenty three crore forty two lakh thirty four thousand two hundred thirty four", Converter.convert (234234234));
		assertEquals ("thirty four crore fifty three lakh forty five thousand three hundred forty five", Converter.convert (345345345));
		assertEquals ("forty five crore sixty four lakh fifty six thousand four hundred fifty six", Converter.convert (456456456));
		assertEquals ("fifty six crore seventy five lakh sixty seven thousand five hundred sixty seven", Converter.convert (567567567));
		assertEquals ("sixty seven crore eighty six lakh seventy eight thousand six hundred seventy eight", Converter.convert (678678678));
		assertEquals ("seventy eight crore ninety seven lakh eighty nine thousand seven hundred eighty nine", Converter.convert (789789789));
		assertEquals ("eighty nine crore eight lakh ninety thousand eight hundred ninety", Converter.convert (890890890));
		assertEquals ("ninety crore nineteen lakh one thousand nine hundred one", Converter.convert (901901901));
		assertEquals ("ninety nine crore ninety nine lakh ninety nine thousand nine hundred ninety nine", Converter.convert (999999999));
	}
	
	@Test (expected = InvalidValueException.class)
	public void testValuesOutsideRange() throws InvalidValueException{
		assertEquals ("no result", Converter.convert (-1));
		assertEquals ("no result", Converter.convert (1000000000));
	}
}