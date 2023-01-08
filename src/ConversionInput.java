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
 * A class for storing input for base conversion.
 */
public class ConversionInput {
    private String number; // The number to be converted
    private int sourceBase; // The base of the number
    private int targetBase; // The base to which the number should be converted
    private String action = "Nothing"; // The action to be taken (exit, back, or nothing)
    private int precision; // The number of decimal places to include in the conversion

    /**
     * Creates a ConversionInput object for a base conversion.
     *
     * @param number the number to be converted
     * @param sourceBase the base of the number
     * @param targetBase the base to which the number should be converted
     * @param precision the number of decimal places to include in the conversion
     */
    public ConversionInput(String number, int sourceBase, int targetBase, int precision) {
        this.number = number;
        this.sourceBase = sourceBase;
        this.targetBase = targetBase;
        this.precision = precision;
    }

    /**
     * Creates a ConversionInput object for an action (exit or back).
     *
     * @param action the action to be taken
     */
    public ConversionInput(String action) {
        this.action = action;
    }

    /**
     * Gets the number to be converted.
     *
     * @return the number to be converted
     */
    public String getNumber() {
        return number;
    }
/**
 * Gets the base of the number.
 *
 * @return the base of the given number.
 */
    public int getSourceBase() {
        return sourceBase;
    }

    /**
     * Gets the base to which the number should be converted.
     *
     * @return the base to which the number should be converted
     */
    public int getTargetBase() {
        return targetBase;
    }

    /**
     * Gets the number of decimal places to include in the conversion.
     *
     * @return the number of decimal places to include in the conversion
     */
    public int getPrecision() {
        return precision;
    }

    /**
     * Returns whether the action is "exit".
     *
     * @return true if the action is "exit", false otherwise
     */
    public boolean exit() {
        return this.action.equalsIgnoreCase("exit");
    }

    /**
     * Returns whether the action is "back".
     *
     * @return true if the action is "back", false otherwise
     */
    public boolean goBack() {
        return this.action.equalsIgnoreCase("back");
    }
}
