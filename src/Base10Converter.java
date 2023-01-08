/*
 * Copyright (c) 2022 Beaudelaire Tsoungui Nzodoumkouo. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under My consent.
 *
 * This code is shared on GitHub in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Please contact Me at +1 438 509 3906
 * or LinkedIn: https://www.linkedin.com/in/beaudelaire-tsoungui-nzodoumkouo-809744231
 * if you need additional information or have any questions.
 */

/**
 * A utility class for converting numbers between bases.
 */

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Base10Converter {
    /**
     * Converts a number from any base to base 10.
     *
     * @param number the number to be converted
     * @param base the base of the number
     * @return the equivalent base 10 number
     */
    public static BigDecimal convertToBase10(String number, int base) {
        // Find the index of the decimal point
        int decimalIndex = number.indexOf('.');
        BigDecimal decimal;
        // If there is no decimal point, just convert the integer part of the number
        if (decimalIndex == -1) {
            decimal = new BigDecimal(convertIntegerPartToBase10(number, base));
        } else {
            // If there is a decimal point, convert the integer and fractional parts separately and add them together
            BigDecimal integerPart = new BigDecimal(convertIntegerPartToBase10(number.substring(0, decimalIndex), base));
            BigDecimal fractionalPart = new BigDecimal(convertFractionalPartToBase10(number.substring(decimalIndex + 1), base));
            decimal = integerPart.add(fractionalPart);
        }
        return decimal;
    }

    /**
     * Converts a number from base 10 to any base.
     *
     * @param number the number to be converted
     * @param base the base to which the number should be converted
     * @param precision the number of decimal places to include in the conversion
     * @return the equivalent number in the specified base
     */
    public static String convertFromBase10(BigDecimal number, int base, int precision) {
        StringBuilder result = new StringBuilder();
        // If the number is negative, append a '-' to the result and make the number positive
        if (number.compareTo(BigDecimal.ZERO) < 0) {
            result.append('-');
            number = number.negate();
        }
        // Divide the number by 1 to get the integer and fractional parts
        BigDecimal[] divisionResult = number.divideAndRemainder(BigDecimal.ONE);
        // Convert the integer part and append it to the result
        result.append(convertIntegerPartFromBase10(divisionResult[0].toBigInteger(), base));
        // If there is a fractional part, convert it and append it to the result
        if (divisionResult[1].compareTo(BigDecimal.ZERO) > 0) {
            result.append('.');
            result.append(convertFractionalPartFromBase10(divisionResult[1], base, precision));
        }
        return result.toString();
    }


/**
 * Converts the integer part of a number from base 10 to any base.
 *
 * @param number the integer part of the number to be converted
 * @param base the base to which the number should be converted
 * @return the equivalent number in the specified base
 */
private static String convertIntegerPartFromBase10(BigInteger number, int base) {
    StringBuilder result = new StringBuilder();
    boolean isNegative = false;
    // If the number is negative, set a flag and make the number positive
    if (number.compareTo(BigInteger.ZERO) < 0) {
        isNegative = true;
        number = number.negate();
    }
    // If the number is 0, return "0"
    if (number.equals(BigInteger.ZERO)) {
        return "0";
    }
    long quotient = number.longValue();
    // Keep dividing the number by the base and adding the remainder to the result until the quotient is 0
    do {
        long remainder = quotient % base;
        char remainderChar;
        // If the remainder is greater than 9, convert it to a letter
        if (remainder > 9) {
            remainderChar = (char) ((remainder - 10) + 'A');
        } else {
            // Otherwise, convert it to a number
            remainderChar = (char) (remainder + '0');
        }
        result.insert(0, remainderChar);
        quotient /= base;
    } while (quotient > 0);
    // If the original number was negative, insert a '-' at the beginning of the result
    if (isNegative) {
        result.insert(0, '-');
    }
    return result.toString();
}

    /**
     * Converts the fractional part of a number from any base to base 10.
     *
     * @param number the fractional part of the number to be converted
     * @param base the base of the number
     * @return the equivalent base 10 number
     */
    private static String convertFractionalPartToBase10(String number, int base) {
        // Create a map to store the numeric values of letters
        Map<Character, Integer> CharactersValue = new HashMap<>();
        char[] Characters = {'A','B','C','D','E','F','G','H','I','J','K','L','M',
                'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int[] values = {10,11,12,13,14,15,16,17,18,19,20,21,22,
                23,24,25,26,27,28,29,30,31,32,33,34,35};
        for (int i = 0; i < values.length; i++){
            CharactersValue.put(Characters[i], values[i]);
        }
        BigDecimal decimal = BigDecimal.ZERO;
        // Iterate over the digits of the number
        for ( int i = 0, j = 1 ; i < number.length(); i++, j++ ){
            int intValue;
            // If the digit is a letter, get its numeric value from the map
            if(Character.isLetter(number.toUpperCase().charAt(i))){
                intValue = CharactersValue.get(number.toUpperCase().charAt(i));
            } else {
                // If the digit is a number, parse it as an integer
                intValue = Integer.parseInt(String.valueOf(number.charAt(i)));
            }
            // Add the current digit's value to the base 10 value, divided by the base raised to the power of its position
            decimal = decimal.add(BigDecimal.valueOf(intValue / Math.pow(base, j)));
        }


        return decimal.toString();
    }

    /**
     * Converts the integer part of a number from any base to base 10.
     *
     * @param number the integer part of the number to be converted
     * @param base the base of the number
     * @return the equivalent base 10 number
     */
    private static BigInteger convertIntegerPartToBase10(String number, int base) {
        Map<Character, Integer> CharactersValue = new HashMap<>();
        char[] Characters = {'A','B','C','D','E','F','G','H','I','J','K','L','M',
                'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        int[] values = {10,11,12,13,14,15,16,17,18,19,20,21,22,
                23,24,25,26,27,28,29,30,31,32,33,34,35};

        for (int i = 0; i < values.length; i++){
            CharactersValue.put(Characters[i], values[i]);
        }

        BigDecimal decimal = BigDecimal.ZERO;
        for ( int i = number.length() - 1, j = 0 ; i >= 0; i--, j++ ){

            int intValue;
            if(Character.isLetter(number.toUpperCase().charAt(i))){
                intValue = CharactersValue.get(number.toUpperCase().charAt(i));
            } else {
                intValue = Integer.parseInt(String.valueOf(number.charAt(i)));
            }
            // Multiply the current base 10 value by the base and add the current digit's value
            decimal = decimal.add(BigDecimal.valueOf(intValue * Math.pow(base, j)));
        }


        return decimal.toBigInteger();
    }

    /**
     * Converts the fractional part of a number from base 10 to any base.
     *
     * @param number the fractional part of the number to be converted
     * @param base the base to which the number should be converted
     * @param precision the number of decimal places to include in the conversion
     * @return the equivalent number in the specified base
     */
    private static String convertFractionalPartFromBase10(BigDecimal number, int base, int precision) {

        StringBuilder result = new StringBuilder();
        // Keep multiplying the number by the base and adding the integer part of the result to the result string
        // until the number is less than 1 or the desired precision is reached
        while (precision-- > 0) {
            number = number.multiply(new BigDecimal(base));
            BigDecimal[] divisionResult = number.divideAndRemainder(BigDecimal.ONE);
            int digit = divisionResult[0].intValue();
            result.append(digit > 9 ? (char) ((digit - 10) + 'A') : (char) (digit + '0'));
            number = divisionResult[1];
        }
        while (result.length() < precision) {
            result.append('0');
        }
        return result.toString();
    }
}