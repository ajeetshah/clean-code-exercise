package com.converter;

import org.junit.Test;
import junit.framework.Assert;

public class NumberConverterIndianTest {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		Assert.assertEquals("zero", NumberConverterIndian.convert(0));
		Assert.assertEquals("one", NumberConverterIndian.convert(1));
		Assert.assertEquals("two", NumberConverterIndian.convert(2));
		Assert.assertEquals("nine", NumberConverterIndian.convert(9));
		Assert.assertEquals("ten", NumberConverterIndian.convert(10));
		Assert.assertEquals("fifteen", NumberConverterIndian.convert(15));
		Assert.assertEquals("twenty one", NumberConverterIndian.convert(21));
		Assert.assertEquals("ninety nine", NumberConverterIndian.convert(99));
		Assert.assertEquals("one hundred", NumberConverterIndian.convert(100));
		Assert.assertEquals("four hundred", NumberConverterIndian.convert(400));
		Assert.assertEquals("five hundred fifty five", NumberConverterIndian.convert(555));
		Assert.assertEquals("nine hundred ninety nine", NumberConverterIndian.convert(999));
		Assert.assertEquals("one thousand", NumberConverterIndian.convert(1000));
		Assert.assertEquals("four thousand forty four", NumberConverterIndian.convert(4044));
		Assert.assertEquals("ten thousand", NumberConverterIndian.convert(10000));
		Assert.assertEquals("fifty thousand twenty three", NumberConverterIndian.convert(50023));
		Assert.assertEquals("one lakh", NumberConverterIndian.convert(100000));
		Assert.assertEquals("twenty three lakh", NumberConverterIndian.convert(2300000));
		Assert.assertEquals("one crore", NumberConverterIndian.convert(10000000));
		Assert.assertEquals("seventy five crore", NumberConverterIndian.convert(750000000));
		Assert.assertEquals("no result", NumberConverterIndian.convert(-23));
		
	}
}
