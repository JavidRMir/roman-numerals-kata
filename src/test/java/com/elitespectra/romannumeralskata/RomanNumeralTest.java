package com.elitespectra.romannumeralskata;

import org.junit.Test;
import static org.junit.Assert.*;

public class RomanNumeralTest {

    RomanNumeral romanNumeral = new RomanNumeral();

    @Test
    public void checkNumberToRomanNumeral() {

        assertEquals("I", romanNumeral.numberToRomanNumeral(1));
        assertEquals("II", romanNumeral.numberToRomanNumeral(2));
        assertEquals("III", romanNumeral.numberToRomanNumeral(3));
        assertEquals("IV", romanNumeral.numberToRomanNumeral(4));
        assertEquals("V", romanNumeral.numberToRomanNumeral(5));
        assertEquals("VI", romanNumeral.numberToRomanNumeral(6));
        assertEquals("VII", romanNumeral.numberToRomanNumeral(7));
        assertEquals("VIII", romanNumeral.numberToRomanNumeral(8));
        assertEquals("IX", romanNumeral.numberToRomanNumeral(9));
        assertEquals("X", romanNumeral.numberToRomanNumeral(10));

        assertEquals("XIII", romanNumeral.numberToRomanNumeral(13));
        assertEquals("XV", romanNumeral.numberToRomanNumeral(15));
        assertEquals("XL", romanNumeral.numberToRomanNumeral(40));
        assertEquals("CCIV", romanNumeral.numberToRomanNumeral(204));

        assertEquals("CMXCIX", romanNumeral.numberToRomanNumeral(999));
        assertEquals("MMM", romanNumeral.numberToRomanNumeral(3000));
        assertEquals("MMCDLI", romanNumeral.numberToRomanNumeral(2451));

        assertEquals("ĪV̄", romanNumeral.numberToRomanNumeral(4000));
        assertEquals("M̄M̄M̄C̄M̄L̄X̄X̄X̄V̄ĪĪDCLIV", romanNumeral.numberToRomanNumeral(3_987_654));
        assertEquals("C̄", romanNumeral.numberToRomanNumeral(100_000));
        assertEquals("L̄XX", romanNumeral.numberToRomanNumeral(50_020));

        assertEquals("", romanNumeral.numberToRomanNumeral(0));

        assertThrows(IllegalArgumentException.class, () -> {
            romanNumeral.numberToRomanNumeral(-5);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            romanNumeral.numberToRomanNumeral(4_000_000);
        });

    }

//    @Test
//    public void checkRomanNumeralToNumber() {
//
//        assertEquals(1, romanNumeral.romanNumeralToNumber("I"));
//        assertEquals(2, romanNumeral.romanNumeralToNumber("II"));
//        assertEquals(3, romanNumeral.romanNumeralToNumber("III"));
//        assertEquals(4, romanNumeral.romanNumeralToNumber("IV"));
//        assertEquals(5, romanNumeral.romanNumeralToNumber("V"));
//        assertEquals(6, romanNumeral.romanNumeralToNumber("VI"));
//        assertEquals(7, romanNumeral.romanNumeralToNumber("VII"));
//        assertEquals(8, romanNumeral.romanNumeralToNumber("VIII"));
//        assertEquals(9, romanNumeral.romanNumeralToNumber("IX"));
//        assertEquals(10, romanNumeral.romanNumeralToNumber("X"));
//
//    }

}
