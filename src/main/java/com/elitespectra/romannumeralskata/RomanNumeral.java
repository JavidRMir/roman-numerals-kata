package com.elitespectra.romannumeralskata;

public class RomanNumeral {

    public String numberToRomanNumeral(int number) {

        if (number > 3000) throw new IllegalArgumentException("Roman Numerals only support up to 3000");

        String result = "";

        int thousands = number / 1000;
        result += appendChars(thousands, "M", "", "");

        int hundreds = number / 100 % 10;
        result += appendChars(hundreds, "C", "D", "M");

        int tens = number / 10 % 10;
        result += appendChars(tens, "X", "L", "C");

        int ones = number % 10;
        result += appendChars(ones, "I", "V", "X");

        return result;

    }

    public int romanNumeralToNumber(String romanNumeral) {

        int number = 0;

        return number;
    }


    private String appendChars(int times, String startChar,
                               String middleChar, String endChar) {
        switch (times) {
            case 0:
                return "";
            case 1:
            case 2:
            case 3:
                return startChar.repeat(times);
            case 4:
                return startChar + middleChar;
            case 5:
                return middleChar;
            case 6:
            case 7:
            case 8:
                return middleChar + startChar.repeat(times - 5);
            case 9:
                return startChar + endChar;
            default:
                throw new IllegalArgumentException("Only single digits allowed");
        }
    }
}
