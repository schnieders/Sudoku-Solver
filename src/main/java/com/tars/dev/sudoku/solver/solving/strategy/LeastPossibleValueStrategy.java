package com.tars.dev.sudoku.solver.solving.strategy;

import com.tars.dev.sudoku.solver.model.Cell;
import com.tars.dev.sudoku.solver.model.Grid;
import com.tars.dev.sudoku.solver.model.Row;

import java.util.Comparator;
import java.util.List;

/**
 * Sudoku solving strategy that tries to solve the {@link com.tars.dev.sudoku.solver.model.Grid} by selecting
 * the {@link com.tars.dev.sudoku.solver.model.Cell} with the least number of possible values.
 */
public class LeastPossibleValueStrategy extends AbstractSolvingStrategy {
    @Override
    Cell getNextCellToProcess(Grid grid) {
        return grid.getRows().stream()
                .map(Row::getCells)
                .flatMap(List::stream)
                .filter(c -> !c.isTerminal())
                .min(Comparator.comparingInt(c -> c.getPossibleValues().size()))
                .orElse(null);
    }
}
