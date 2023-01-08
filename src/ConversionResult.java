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
 * A class for storing the result of a base conversion.
 */
public class ConversionResult {
    private String number; // The converted number
    private int base; // The base of the number

    /**
     * Creates a ConversionResult object.
     *
     * @param number the converted number
     * @param base the base of the number
     */
    public ConversionResult(String number, int base) {
        this.number = number;
        this.base = base;
    }

    /**
     * Gets the converted number.
     *
     * @return the converted number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Gets the base of the number.
     *
     * @return the base of the number
     */
    public int getBase() {
        return base;
    }
}