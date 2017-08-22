package com.converter;

import org.junit.Test;

import junit.framework.Assert;

public class NumberConverterTest {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		Assert.assertEquals("zero", NumberConverter.convert(0));
		Assert.assertEquals("one", NumberConverter.convert(1));
		Assert.assertEquals("two", NumberConverter.convert(2));
		Assert.assertEquals("nine", NumberConverter.convert(9));
		
		Assert.assertEquals("ten", NumberConverter.convert(10));
		Assert.assertEquals("fifteen", NumberConverter.convert(15));
		Assert.assertEquals("twenty one", NumberConverter.convert(21));
		Assert.assertEquals("ninety nine", NumberConverter.convert(99));
		
		Assert.assertEquals("one hundred", NumberConverter.convert(100));
		Assert.assertEquals("four hundred", NumberConverter.convert(400));
		Assert.assertEquals("five hundred fifty five", NumberConverter.convert(555));
		Assert.assertEquals("nine hundred ninety nine", NumberConverter.convert(999));
		
		Assert.assertEquals("one thousand", NumberConverter.convert(1000));
		Assert.assertEquals("four thousand forty four", NumberConverter.convert(4044));
		
		Assert.assertEquals("ten thousand", NumberConverter.convert(10000));
		
		Assert.assertEquals("fifty thousand twenty three", NumberConverter.convert(50023));
		
		Assert.assertEquals("one lakh", NumberConverter.convert(100000));
		
		Assert.assertEquals("twenty three lakh", NumberConverter.convert(2300000));
		
		Assert.assertEquals("one crore", NumberConverter.convert(10000000));
		
		Assert.assertEquals("seventy five crore", NumberConverter.convert(750000000));
		
		Assert.assertEquals("no result", NumberConverter.convert(-23));
		
	}

}
