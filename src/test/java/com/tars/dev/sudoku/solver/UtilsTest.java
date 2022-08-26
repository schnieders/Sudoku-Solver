package com.tars.dev.sudoku.solver;

import com.tars.dev.sudoku.solver.model.Cell;
import com.tars.dev.sudoku.solver.model.Value;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UtilsTest {


    @Test
    void testGetRowGetStartIndexForBlock() {
        assertThat(Utils.getRowStartIndexForBlock(0)).isZero();
        assertThat(Utils.getRowStartIndexForBlock(1)).isZero();
        assertThat(Utils.getRowStartIndexForBlock(2)).isZero();
        assertThat(Utils.getRowStartIndexForBlock(3)).isEqualTo(3);
        assertThat(Utils.getRowStartIndexForBlock(4)).isEqualTo(3);
        assertThat(Utils.getRowStartIndexForBlock(5)).isEqualTo(3);
        assertThat(Utils.getRowStartIndexForBlock(6)).isEqualTo(6);
        assertThat(Utils.getRowStartIndexForBlock(7)).isEqualTo(6);
        assertThat(Utils.getRowStartIndexForBlock(8)).isEqualTo(6);
    }

    @Test
    void testGetColumnGetStartIndexForBlock() {
        assertThat(Utils.getColumnStartIndexForBlock(0)).isZero();
        assertThat(Utils.getColumnStartIndexForBlock(1)).isEqualTo(3);
        assertThat(Utils.getColumnStartIndexForBlock(2)).isEqualTo(6);
        assertThat(Utils.getColumnStartIndexForBlock(3)).isZero();
        assertThat(Utils.getColumnStartIndexForBlock(4)).isEqualTo(3);
        assertThat(Utils.getColumnStartIndexForBlock(5)).isEqualTo(6);
        assertThat(Utils.getColumnStartIndexForBlock(6)).isZero();
        assertThat(Utils.getColumnStartIndexForBlock(7)).isEqualTo(3);
        assertThat(Utils.getColumnStartIndexForBlock(8)).isEqualTo(6);
    }

    @Test
    void testGetBlockIndexFromRowAndColumn() {
        assertThat(Utils.getBlockIndexFromRowAndColumn(0, 0)).isZero();
        assertThat(Utils.getBlockIndexFromRowAndColumn(0, 3)).isEqualTo(1);
        assertThat(Utils.getBlockIndexFromRowAndColumn(0, 6)).isEqualTo(2);
        assertThat(Utils.getBlockIndexFromRowAndColumn(3, 0)).isEqualTo(3);
        assertThat(Utils.getBlockIndexFromRowAndColumn(4, 4)).isEqualTo(4);
        assertThat(Utils.getBlockIndexFromRowAndColumn(5, 8)).isEqualTo(5);
        assertThat(Utils.getBlockIndexFromRowAndColumn(8, 0)).isEqualTo(6);
        assertThat(Utils.getBlockIndexFromRowAndColumn(7, 5)).isEqualTo(7);
        assertThat(Utils.getBlockIndexFromRowAndColumn(8, 8)).isEqualTo(8);
    }

    @Test
    void testIsValid() {
        List<Cell> validCells = Arrays.asList(
                new Cell(Value.ONE, null, null, null),
                new Cell(Value.TWO, null, null, null),
                new Cell(Value.THREE, null, null, null),
                new Cell(Value.FOUR, null, null, null),
                new Cell(Value.FIVE, null, null, null),
                new Cell(Value.SIX, null, null, null),
                new Cell(Value.SEVEN, null, null, null),
                new Cell(Value.EIGHT, null, null, null),
                new Cell(Value.NINE, null, null, null)
        );

        List<Cell> invalidCells = Arrays.asList(
                new Cell(Value.ONE, null, null, null),
                new Cell(Value.TWO, null, null, null),
                new Cell(Value.THREE, null, null, null),
                new Cell(Value.FOUR, null, null, null),
                new Cell(Value.ONE, null, null, null),
                new Cell(Value.SIX, null, null, null),
                new Cell(Value.SEVEN, null, null, null),
                new Cell(Value.EIGHT, null, null, null),
                new Cell(Value.NINE, null, null, null)
        );

        List<Cell> validNoneTerminalCells = Arrays.asList(
                new Cell(Value.ONE, null, null, null),
                new Cell(Value.TWO, null, null, null),
                new Cell(null, null, null, null),
                new Cell(Value.FOUR, null, null, null),
                new Cell(Value.FIVE, null, null, null),
                new Cell(Value.SIX, null, null, null),
                new Cell(Value.SEVEN, null, null, null),
                new Cell(null, null, null, null),
                new Cell(Value.NINE, null, null, null)
        );
        List<Cell> invalidNoneTerminalCells = Arrays.asList(
                new Cell(Value.ONE, null, null, null),
                new Cell(Value.TWO, null, null, null),
                new Cell(Value.THREE, null, null, null),
                new Cell(null, null, null, null),
                new Cell(Value.ONE, null, null, null),
                new Cell(Value.SIX, null, null, null),
                new Cell(Value.SEVEN, null, null, null),
                new Cell(Value.EIGHT, null, null, null),
                new Cell(null, null, null, null)
        );

        assertTrue(Utils.isValid(validCells));
        assertTrue(Utils.isValid(validNoneTerminalCells));

        assertFalse(Utils.isValid(invalidCells));
        assertFalse(Utils.isValid(invalidNoneTerminalCells));
    }
}