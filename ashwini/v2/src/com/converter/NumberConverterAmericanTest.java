package com.converter;

import org.junit.Test;
import junit.framework.Assert;

public class NumberConverterAmericanTest {

    @SuppressWarnings("deprecation")
    @Test
    public void test() {
        test_1_DigitNumber();
        test_2_DigitNumber();
        test_3_DigitNumber();
        test_4_DigitNumber();
        test_5_DigitNumber();
        test_6_DigitNumber();
        test_7_DigitNumber();
        test_8_DigitNumber();
        test_9_DigitNumber();
        test_10_DigitNumber();
        test_11_DigitNumber();
        test_12_DigitNumber();
        testinvalidNumber();
    }

    private void test_1_DigitNumber() {
        Assert.assertEquals("zero", NumberConverterAmerican.convert(0));
        Assert.assertEquals("nine", NumberConverterAmerican.convert(9));
    }

    private void test_2_DigitNumber() {
        Assert.assertEquals("ten", NumberConverterAmerican.convert(10));
        Assert.assertEquals("ninety nine", NumberConverterAmerican.convert(99));
    }

    private void test_3_DigitNumber() {
        Assert.assertEquals("one hundred", NumberConverterAmerican.convert(100));
        Assert.assertEquals("nine hundred ninety nine", NumberConverterAmerican.convert(999));
    }

    private void test_4_DigitNumber() {
        Assert.assertEquals("one thousand", NumberConverterAmerican.convert(1000));
        Assert.assertEquals("nine thousand nine hundred ninety nine", NumberConverterAmerican.convert(9999));
    }

    private void test_5_DigitNumber() {
        Assert.assertEquals("ten thousand", NumberConverterAmerican.convert(10000));
        Assert.assertEquals("ninety nine thousand nine hundred ninety nine", NumberConverterAmerican.convert(99999));
    }

    private void test_6_DigitNumber() {
        Assert.assertEquals("one hundred thousand", NumberConverterAmerican.convert(100000));
        Assert.assertEquals("nine hundred ninety nine thousand nine hundred ninety nine", NumberConverterAmerican.convert(999999));
    }

    private void test_7_DigitNumber() {
        Assert.assertEquals("one million", NumberConverterAmerican.convert(1000000));
        Assert.assertEquals("nine million nine hundred ninety nine thousand nine hundred ninety nine", NumberConverterAmerican.convert(9999999));
    }

    private void test_8_DigitNumber() {
        Assert.assertEquals("ten million", NumberConverterAmerican.convert(10000000));
        Assert.assertEquals("ninety nine million nine hundred ninety nine thousand nine hundred ninety nine", NumberConverterAmerican.convert(99999999));
    }

    private void test_9_DigitNumber() {
        Assert.assertEquals("one hundred million", NumberConverterAmerican.convert(100000000L));
        Assert.assertEquals("nine hundred ninety nine million nine hundred ninety nine thousand nine hundred ninety nine", NumberConverterAmerican.convert(999999999L));
    }

    private void test_10_DigitNumber() {
        Assert.assertEquals("one billion", NumberConverterAmerican.convert(1000000000L));
        Assert.assertEquals("nine billion nine hundred ninety nine million nine hundred ninety nine thousand nine hundred ninety nine", NumberConverterAmerican.convert(9999999999L));
    }

    private void test_11_DigitNumber() {
        Assert.assertEquals("ten billion", NumberConverterAmerican.convert(10000000000L));
        Assert.assertEquals("ninety nine billion nine hundred ninety nine million nine hundred ninety nine thousand nine hundred ninety nine", NumberConverterAmerican.convert(99999999999L));
    }

    private void test_12_DigitNumber() {
        Assert.assertEquals("one hundred billion", NumberConverterAmerican.convert(100000000000L));
        Assert.assertEquals("nine hundred ninety nine billion nine hundred ninety nine million nine hundred ninety nine thousand nine hundred ninety nine", NumberConverterAmerican.convert(999999999999L));
    }

    private void testinvalidNumber() {
        Assert.assertEquals("no result", NumberConverterAmerican.convert(-1));
        Assert.assertEquals("no result", NumberConverterAmerican.convert(1000000000000L));
    }
}
