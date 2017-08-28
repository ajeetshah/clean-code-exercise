package com.converter;

import org.junit.Test;
import junit.framework.Assert;
import static com.converter.StringConstants.INDIAN;
import static com.converter.StringConstants.AMERICAN;

public class NumberConverterTest {

    @SuppressWarnings("deprecation")
    @Test
    public void test() {
        testIndianSystem();
        testAmericanSystem();
    }

    private void testIndianSystem() {
        Assert.assertEquals("zero", NumberConverter.convert(0, INDIAN));
        Assert.assertEquals("one", NumberConverter.convert(1, INDIAN));
        Assert.assertEquals("two", NumberConverter.convert(2, INDIAN));
        Assert.assertEquals("nine", NumberConverter.convert(9, INDIAN));
        Assert.assertEquals("ten", NumberConverter.convert(10, INDIAN));
        Assert.assertEquals("fifteen", NumberConverter.convert(15, INDIAN));
        Assert.assertEquals("twenty one", NumberConverter.convert(21, INDIAN));
        Assert.assertEquals("ninety nine", NumberConverter.convert(99, INDIAN));
        Assert.assertEquals("one hundred", NumberConverter.convert(100, INDIAN));
        Assert.assertEquals("four hundred", NumberConverter.convert(400, INDIAN));
        Assert.assertEquals("five hundred fifty five", NumberConverter.convert(555, INDIAN));
        Assert.assertEquals("nine hundred ninety nine", NumberConverter.convert(999, INDIAN));
        Assert.assertEquals("one thousand", NumberConverter.convert(1000, INDIAN));
        Assert.assertEquals("four thousand forty four", NumberConverter.convert(4044, INDIAN));
        Assert.assertEquals("ten thousand", NumberConverter.convert(10000, INDIAN));
        Assert.assertEquals("fifty thousand twenty three", NumberConverter.convert(50023, INDIAN));
        Assert.assertEquals("one lakh", NumberConverter.convert(100000, INDIAN));
        Assert.assertEquals("twenty three lakh", NumberConverter.convert(2300000, INDIAN));
        Assert.assertEquals("one crore", NumberConverter.convert(10000000, INDIAN));
        Assert.assertEquals("seventy five crore", NumberConverter.convert(750000000, INDIAN));
        Assert.assertEquals("no result", NumberConverter.convert(-23, INDIAN));
    }

    private void testAmericanSystem() {
        Assert.assertEquals("no result", NumberConverter.convert(-1, AMERICAN));
        Assert.assertEquals("no result", NumberConverter.convert(1000000000000L, AMERICAN));
        Assert.assertEquals("one hundred billion", NumberConverter.convert(100000000000L, AMERICAN));
        Assert.assertEquals("nine hundred ninety nine billion nine hundred ninety nine million nine hundred ninety nine thousand nine hundred ninety nine", NumberConverter.convert(999999999999L, AMERICAN));
    }
}
