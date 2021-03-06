package com.elitespectra.romannumeralskata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {

    public String numberToRomanNumeral(long number) {

        if (number < 1 || number >= 4_000_000) throw new IllegalArgumentException(
                "Roman Numerals only support from 1 to 3,999,999");

        Map<String, Map<String, String>> romanNumeralCharMap = Map.of(
                "millions", Map.of(
                        "startChar", "M̄",
                        "middleChar", "",
                        "endChar", ""),

                "hundredThousands", Map.of(
                        "startChar", "C̄",
                        "middleChar", "D̄",
                        "endChar", "M̄"),

                "tenThousands", Map.of(
                        "startChar", "X̄",
                        "middleChar", "L̄",
                        "endChar", "C̄"),

                "thousandsGreaterThanEqualTo4", Map.of(
                        "startChar", "Ī",
                        "middleChar", "V̄",
                        "endChar", "X̄"),

                "thousandsLessThan4", Map.of(
                        "startChar", "M",
                        "middleChar", "",
                        "endChar", ""),

                "hundreds", Map.of(
                        "startChar", "C",
                        "middleChar", "D",
                        "endChar", "M"),

                "tens", Map.of(
                        "startChar", "X",
                        "middleChar", "L",
                        "endChar", "C"),

                "ones", Map.of(
                        "startChar", "I",
                        "middleChar", "V",
                        "endChar", "X")
        );


        String result = "";

        int millions = (int) (number / 1000_000);
        result += appendChars(millions, romanNumeralCharMap.get("millions"));

        int hundredThousands = (int) (number / 100_000 % 10);
        result += appendChars(hundredThousands, romanNumeralCharMap.get("hundredThousands"));

        int tenThousands = (int) (number / 10_000 % 10);
        result += appendChars(tenThousands, romanNumeralCharMap.get("tenThousands"));

        int thousands = (int) (number / 1_000 % 10);
        if (thousands >= 4) {
            result += appendChars(thousands, romanNumeralCharMap.get("thousandsGreaterThanEqualTo4"));
        } else {
            result += appendChars(thousands, romanNumeralCharMap.get("thousandsLessThan4"));
        }

        int hundreds = (int) (number / 100 % 10);
        result += appendChars(hundreds, romanNumeralCharMap.get("hundreds"));

        int tens = (int) (number / 10 % 10);
        result += appendChars(tens, romanNumeralCharMap.get("tens"));

        int ones = (int) (number % 10);
        result += appendChars(ones, romanNumeralCharMap.get("ones"));

        return result;
    }

    public long romanNumeralToNumber(String romanNumeral) {

        if (romanNumeral.isEmpty()) throw new IllegalArgumentException("Blank numerals not allowed");

        romanNumeral = romanNumeral.toUpperCase();

        if (!romanNumeral.matches("M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})"))
            throw new IllegalArgumentException("Invalid Roman Numeral");


        var romanNumeralValues = new HashMap<>();
        romanNumeralValues.put("I", 1);
        romanNumeralValues.put("II", 2);
        romanNumeralValues.put("III", 3);
        romanNumeralValues.put("IV", 4);
        romanNumeralValues.put("V", 5);
        romanNumeralValues.put("VI", 6);
        romanNumeralValues.put("VII", 7);
        romanNumeralValues.put("VIII", 8);
        romanNumeralValues.put("IX", 9);
        romanNumeralValues.put("X", 10);
        romanNumeralValues.put("L", 50);
        romanNumeralValues.put("C", 100);
        romanNumeralValues.put("D", 500);
        romanNumeralValues.put("M", 1_000);
        romanNumeralValues.put("Ī", 1_000);
        romanNumeralValues.put("V̄", 5_000);
        romanNumeralValues.put("X̄", 10_000);
        romanNumeralValues.put("L̄", 50_000);
        romanNumeralValues.put("C̄", 100_000);
        romanNumeralValues.put("D̄", 500_000);
        romanNumeralValues.put("M̄", 1000_000);


        long result = 0;
        var romanNumeralList = Arrays.asList(romanNumeral.split(""));

        for (var i = 0; i < romanNumeralList.size(); i++) {
            var romanValueOne = (int) romanNumeralValues.get(romanNumeralList.get(i));

            if (i + 1 == romanNumeralList.size()) {
                result += (int) romanNumeralValues.get(romanNumeralList.get(i));
                break;
            } else {
                var romanValueTwo = (int) romanNumeralValues.get(romanNumeralList.get(i + 1));
                if (romanValueOne >= romanValueTwo) {
                    result += romanValueOne;
                } else {
                    result -= romanValueOne;
                }
            }
        }

        return result;
    }


    private String appendChars(int times, Map<String, String> romanNumeralCharMap) {

        return switch (times) {
            case 0 -> "";
            case 1, 2, 3 -> romanNumeralCharMap.get("startChar").repeat(times);
            case 4 -> romanNumeralCharMap.get("startChar") + romanNumeralCharMap.get("middleChar");
            case 5 -> romanNumeralCharMap.get("middleChar");
            case 6, 7, 8 -> romanNumeralCharMap.get("middleChar") + romanNumeralCharMap.get("startChar").repeat(times - 5);
            case 9 -> romanNumeralCharMap.get("startChar") + romanNumeralCharMap.get("endChar");
            default -> throw new IllegalArgumentException("Only single digits allowed");
        };
    }

}
