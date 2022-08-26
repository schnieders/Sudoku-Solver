package com.tars.dev.sudoku.solver.model;

import com.tars.dev.sudoku.solver.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for {@link Row}, {@link Column} and {@link Block} to bundle some code.
 */
public class SudokuField {

    private List<Cell> cells;

    public SudokuField() {
        this.cells = new ArrayList<>(9);
    }
    
    public boolean isValid() {
        return Utils.isValid(this.cells);
    }

    public boolean isTerminal() {
        return this.cells.stream().allMatch(Cell::isTerminal);
    }

    public boolean isPossibleValue(Value v) {
        return this.getCells().stream().noneMatch(c -> c.getValue() == v);
    }

    public List<Cell> getCells() {
        return this.cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }
}
