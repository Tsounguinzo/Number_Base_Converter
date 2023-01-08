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

public class NumberBaseConverter {
    public static void main(String[] args) {

        while (true) {
            // Parse the input
            ConversionInput input = InputParser.parseInputString();

            if (input == null) {
                // Input is invalid, display error message and exit
                InputParser.getMessage();
                continue;
            }

            if (input.exit()) {
                // User wants to exit the program
                break;
            }

            if (input.goBack()) {
                // User wants to go back to the previous menu
                continue;
            }

            // Convert the number
            ConversionResult result = NumberConverter.convert(input.getNumber(), input.getSourceBase(), input.getTargetBase(), input.getPrecision());
            if (result == null) {
                // Conversion failed, display error message and exit
                NumberConverter.getMessage();
                continue;
            }

            // Display the result
            System.out.println("Conversion result: " + result.getNumber() + "\n");

            while (true) {
                input = InputParser.parseBackInputString();

                if (input == null) {
                    // Input is invalid, display error message and exit
                    InputParser.getMessage();
                    continue;
                }

                if (input.goBack()) {
                    // User wants to go back to the previous menu
                    break;
                }

                // Convert the number
                result = NumberConverter.convert(input.getNumber(), input.getSourceBase(), input.getTargetBase(), input.getPrecision());
                if (result == null) {
                    // Conversion failed, display error message and exit
                    NumberConverter.getMessage();
                    continue;
                }

                // Display the result
                System.out.println("Conversion result: " + result.getNumber() + "\n");
            }
        }
    }
}
