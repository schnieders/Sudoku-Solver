package com.tars.dev.sudoku.solver.model;

/**
 * Class to represent a block (3x3) of a Sudoku puzzle.
 */
public class Block extends SudokuField {

    private final int position;

    public Block(int position) {
        super();
        this.position = position;
    }

    @Override
    public String toString() {
        return "Block{" +
                "position=" + this.position + ", " +
                "cells=" + getCells() +
                '}';
    }
}
