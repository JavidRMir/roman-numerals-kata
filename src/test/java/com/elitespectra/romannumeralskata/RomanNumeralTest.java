package com.elitespectra.romannumeralskata;

import org.junit.Test;
import static org.junit.Assert.*;

public class RomanNumeralTest {

    RomanNumeral romanNumeral = new RomanNumeral();

    @Test
    public void checkSingleDigitNumbersConversionToRomanNumerals() {

        assertEquals("I", romanNumeral.numberToRomanNumeral(1));
        assertEquals("II", romanNumeral.numberToRomanNumeral(2));
        assertEquals("III", romanNumeral.numberToRomanNumeral(3));
        assertEquals("IV", romanNumeral.numberToRomanNumeral(4));
        assertEquals("V", romanNumeral.numberToRomanNumeral(5));
        assertEquals("VI", romanNumeral.numberToRomanNumeral(6));
        assertEquals("VII", romanNumeral.numberToRomanNumeral(7));
        assertEquals("VIII", romanNumeral.numberToRomanNumeral(8));
        assertEquals("IX", romanNumeral.numberToRomanNumeral(9));

    }

    @Test
    public void checkTwoDigitNumberConversionToRomanNumerals() {

        assertEquals("X", romanNumeral.numberToRomanNumeral(10));
        assertEquals("XIII", romanNumeral.numberToRomanNumeral(13));
        assertEquals("XV", romanNumeral.numberToRomanNumeral(15));
        assertEquals("XL", romanNumeral.numberToRomanNumeral(40));

    }

    @Test
    public void checkThreeDigitNumberConversionToRomanNumerals() {

        assertEquals("CCIV", romanNumeral.numberToRomanNumeral(204));
        assertEquals("CMXCIX", romanNumeral.numberToRomanNumeral(999));

    }

    @Test
    public void checkFourDigitNumberConversionToRomanNumerals() {

        assertEquals("MMM", romanNumeral.numberToRomanNumeral(3000));
        assertEquals("MMCDLI", romanNumeral.numberToRomanNumeral(2451));
        assertEquals("ĪV̄", romanNumeral.numberToRomanNumeral(4000));

    }

    @Test
    public void checkFiveOrMoreDigitNumberConversionToRomanNumerals() {

        assertEquals("M̄M̄M̄C̄M̄L̄X̄X̄X̄V̄ĪĪDCLIV", romanNumeral.numberToRomanNumeral(3_987_654));
        assertEquals("C̄", romanNumeral.numberToRomanNumeral(100_000));
        assertEquals("L̄XX", romanNumeral.numberToRomanNumeral(50_020));

    }

    @Test
    public void checkZeroInputNumberThrowsAnException() {

        assertThrows(IllegalArgumentException.class, () -> romanNumeral.numberToRomanNumeral(0));

    }

    @Test
    public void checkNegativeInputNumberThrowsAnException() {

        assertThrows(IllegalArgumentException.class, () -> romanNumeral.numberToRomanNumeral(-5));

        assertThrows(IllegalArgumentException.class, () -> romanNumeral.numberToRomanNumeral(4_000_000));

    }

    @Test
    public void check4MillionOrMoreInputNumberThrowsAnException() {

        assertThrows(IllegalArgumentException.class, () -> romanNumeral.numberToRomanNumeral(4_000_000));

    }


    @Test
    public void checkSingleDigitConversionFromRomanNumeralToNumber() {

        assertEquals(1, romanNumeral.romanNumeralToNumber("I"));
        assertEquals(2, romanNumeral.romanNumeralToNumber("II"));
        assertEquals(3, romanNumeral.romanNumeralToNumber("III"));
        assertEquals(4, romanNumeral.romanNumeralToNumber("IV"));
        assertEquals(5, romanNumeral.romanNumeralToNumber("V"));
        assertEquals(6, romanNumeral.romanNumeralToNumber("VI"));
        assertEquals(7, romanNumeral.romanNumeralToNumber("VII"));
        assertEquals(8, romanNumeral.romanNumeralToNumber("VIII"));
        assertEquals(9, romanNumeral.romanNumeralToNumber("IX"));

    }

    @Test
    public void checkTwoDigitConversionFromRomanNumeralToNumber() {

        assertEquals(10, romanNumeral.romanNumeralToNumber("X"));
        assertEquals(13, romanNumeral.romanNumeralToNumber("XIII"));
        assertEquals(15, romanNumeral.romanNumeralToNumber("XV"));
        assertEquals(40, romanNumeral.romanNumeralToNumber("XL"));

    }

    @Test
    public void checkThreeDigitConversionFromRomanNumeralToNumber() {

        assertEquals(204, romanNumeral.romanNumeralToNumber("CCIV"));
        assertEquals(999, romanNumeral.romanNumeralToNumber("CMXCIX"));

    }

    @Test
    public void checkFourDigitConversionFromRomanNumeralToNumber() {

        assertEquals(3_000, romanNumeral.romanNumeralToNumber("MMM"));
        assertEquals(2_451, romanNumeral.romanNumeralToNumber("MMCDLI"));
        assertEquals(3_999, romanNumeral.romanNumeralToNumber("MMMCMXCIX"));

    }

    @Test
    public void checkBlankOrNoInputThrowsAnException() {

        assertThrows(IllegalArgumentException.class, () -> romanNumeral.romanNumeralToNumber(""));

    }

    @Test
    public void checkInvalidInputRomanNumeralThrowsAnException() {

        assertThrows(IllegalArgumentException.class, () -> romanNumeral.romanNumeralToNumber("ZOO"));
        assertThrows(IllegalArgumentException.class, () -> romanNumeral.romanNumeralToNumber("MMMM"));
    }


}
