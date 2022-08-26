package com.tars.dev.sudoku.solver.model;

/**
 * Class to represent a column of a Sudoku puzzle.
 */
public class Column extends SudokuField {

    private final int position;

    public Column(int position) {
        super();
        this.position = position;
    }

    @Override
    public String toString() {
        return "Column{" +
                "position=" + this.position + ", " +
                "cells=" + getCells() +
                '}';
    }
}
