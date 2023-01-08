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

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class for parsing user input for base conversion.
 */
public class InputParser {
    private static String errorMessage; // A message describing an error that occurred during parsing
    private static int sourceBase; // The source base for the conversion
    private static int targetBase; // The target base for the conversion
    private static int precision; // The number of decimal places to include in the conversion

    private static Scanner sc = new Scanner(System.in); // A scanner for reading user input

    /**
     * Parses input for base conversion.
     *
     * @return a ConversionInput object representing the parsed input, or null if the input is invalid
     */
    public static ConversionInput parseInputString() {
        System.out.print("Enter three numbers in format: {source base} {target base} {conversion precision} (To quit type /exit) ");
        String input = sc.nextLine();

        // Split the input string by spaces
        String[] bases = input.split(" ");

        if (bases[0].equalsIgnoreCase("/exit")) {
            // exit program
            return new ConversionInput("exit");
        }

        if (bases.length != 3) {
            // Invalid input format
            errorMessage = "Invalid input format";
            return null;
        }

        // Parse the source base
        try {
            sourceBase = Integer.parseInt(bases[0]);
            if (sourceBase < 2 || sourceBase > 36) {
                // Invalid base
                errorMessage = sourceBase + " is an invalid source base";
                return null;
            }
        } catch (NumberFormatException e) {
            // Not a valid integer
            errorMessage = sourceBase + " is not a valid integer";
            return null;
        }

        // Parse the target base
        try {
            targetBase = Integer.parseInt(bases[1]);
            if (targetBase < 2 || targetBase > 36) {
                // Invalid base
                errorMessage = targetBase + " is an invalid target base";
                return null;
            }
        } catch (NumberFormatException e) {
            // Not a valid integer
            errorMessage = targetBase + " is not a valid integer";
            return null;
        }

        // Precision
        try {
            precision = Integer.parseInt(bases[2]);
        } catch (NumberFormatException e) {
            // Not a valid integer
            errorMessage = precision + " is not a valid integer";
            return null;
        }

        // Return the parsed input
        return parseBackInputString();
    }

    /**
     * Parses input for a number to convert.
     *
     * @return a ConversionInput object representing the parsed input, or null if the input is invalid
     */
    public static ConversionInput parseBackInputString() {
        System.out.print("Enter number in base " + sourceBase + " to convert to base " + targetBase
                + " (To go back type /back) ");
        String inputNumber = sc.nextLine();

        if (inputNumber.equalsIgnoreCase("/back")){
            // exit program
            return new ConversionInput("back");
        }

// Validate input character
        int i;
        ArrayList<Character> invalidCharacters = new ArrayList<>();
        for (i = 0; i < inputNumber.length() ; i++) {
            if (!Character.isDigit(inputNumber.charAt(i)) && !Character.isLetter(inputNumber.charAt(i))) {
                if(inputNumber.charAt(i) == '.') continue;
                invalidCharacters.add(inputNumber.charAt(i));
            }
        }

        if (i == inputNumber.length() && invalidCharacters.size() != 0){
            errorMessage = (invalidCharacters.size() == 1) ? invalidCharacters + " is not a valid character"
                    : invalidCharacters + " are not valid characters";
            return null;
        }

        // Return the parsed input
        return new ConversionInput(inputNumber, sourceBase, targetBase, precision);
    }

    /**
     * Gets the error message describing an error that occurred during parsing.
     */
    public static void getMessage() {
        System.out.println(errorMessage + "\n");
    }
}