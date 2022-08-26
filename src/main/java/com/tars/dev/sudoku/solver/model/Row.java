package com.tars.dev.sudoku.solver.model;

/**
 * Class to represent a row of a Sudoku puzzle.
 */
public class Row extends SudokuField {

    private final int position;

    public Row(int position) {
        super();
        this.position = position;
    }

    @Override
    public String toString() {
        return "Row{" +
                "position=" + this.position + ", " +
                "cells=" + getCells() +
                '}';
    }
}
