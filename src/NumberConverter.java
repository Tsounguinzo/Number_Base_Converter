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

import java.math.BigDecimal;

public class NumberConverter {
    private static String errorMessage;
    public static ConversionResult convert(String number, int sourceBase, int targetBase, int precision) {
        // Convert the number to base 10
        BigDecimal base10 = Base10Converter.convertToBase10(number, sourceBase);
        if (base10 == null) {
            // Conversion to base 10 failed, return null
            errorMessage = "Conversion to base 10 failed";
            return null;
        }

        // Convert the base 10 number to the target base
        String targetBaseNumber = Base10Converter.convertFromBase10(base10, targetBase, precision);
        if (targetBaseNumber == null) {
            // Conversion from base 10 failed, return null
            errorMessage = "Conversion from base 10 failed";
            return null;
        }

        // Return the result
        return new ConversionResult(targetBaseNumber, targetBase);
    }

    public static void getMessage(){
        System.out.println(errorMessage);
    }
}
