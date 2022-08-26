package com.tars.dev.sudoku.solver.model;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static com.tars.dev.sudoku.solver.TestConstants.INIT_GRID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SudokuFieldTest {


    @Test
    void testGetPossibleValues() {
        Cell cell = INIT_GRID.getRows().get(0).getCells().get(0);
        assertThat(cell.getPossibleValues()).containsExactly(Value.FOUR, Value.NINE);
    }

    @Test
    void testGetPossibleValuesEmptyGrid() {
        Row r = new Row(0);
        Column c = new Column(0);
        Block b = new Block(0);

        Cell cell = new Cell(null, r, c, b);
        assertThat(cell.getPossibleValues()).containsExactly(Value.values());
    }

    @Test
    void testGetPossibleValuesTerminalCell() {
        Cell c = new Cell(Value.SIX, null, null, null);
        assertThat(c.getPossibleValues()).isEmpty();
    }

    @Test
    void testIsTerminalTrue() {
        SudokuField f = new SudokuField();
        //Set all cells
        f.setCells(Stream.of(Value.values())
                .map(v -> new Cell(v, null, null, null))
                .toList());
        assertTrue(f.isTerminal());
    }

    @Test
    void testIsTerminalFalse() {
        SudokuField f = new SudokuField();
        //Set all cells except the first one
        f.setCells(Stream.of(Value.values())
                .map(v -> new Cell(v, null, null, null))
                .toList());
        f.getCells().get(0).setValue(null);

        assertFalse(f.isTerminal());
    }

    @Test
    void testIsValueTrue() {
        SudokuField f = new SudokuField();
        //Init check
        assertTrue(f.isValid());

        //Set all cells
        f.setCells(Stream.of(Value.values())
                .map(v -> new Cell(v, null, null, null))
                .toList());
        assertTrue(f.isValid());
    }

    @Test
    void testIsValueFalse() {
        SudokuField f = new SudokuField();
        //Set to invalid state
        f.setCells(Stream.of(Value.values())
                .map(v -> new Cell(v, null, null, null))
                .toList());
        f.getCells().get(1).setValue(Value.ONE);

        assertFalse(f.isValid());
    }
}