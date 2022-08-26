package com.tars.dev.sudoku.solver.model;

/**
 * Enum to represent Sudoku field values.
 */
public enum Value {
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE;

    /**
     * Parses the given Integer value to a {@link Value} representation.
     *
     * @param value to parse
     * @return Parsed value
     */
    public static Value fromInt(Integer value) {
        if (value == null) {
            return null;
        }
        return Value.values()[value - 1];
    }
}