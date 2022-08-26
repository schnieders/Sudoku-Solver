package com.tars.dev.sudoku.solver;

import com.tars.dev.sudoku.solver.model.Cell;
import com.tars.dev.sudoku.solver.model.Value;

import java.util.Collection;
import java.util.stream.Stream;

/**
 * Some utility methods.
 */
public class Utils {

    private Utils() {
    }

    public static final int BLOCK_SIZE = 3;
    public static final int PUZZLE_DYNAMIC = 9;

    public static int getRowStartIndexForBlock(int blockIndex) {
        return (blockIndex / BLOCK_SIZE) * BLOCK_SIZE;
    }

    public static int getColumnStartIndexForBlock(int blockIndex) {
        return (blockIndex % BLOCK_SIZE) * BLOCK_SIZE;
    }

    public static int getBlockIndexFromRowAndColumn(int rowIndex, int columnIndex) {
        return ((rowIndex / BLOCK_SIZE) * BLOCK_SIZE) + (columnIndex / BLOCK_SIZE);
    }

    public static boolean isValid(Collection<Cell> cells) {
        return Stream.of(Value.values())
                .allMatch(v -> cells.stream()
                        .filter(c -> c.getValue() == v)
                        .count() <= 1);
    }
}
