package com.tars.dev.sudoku.solver.solving.strategy;

import com.tars.dev.sudoku.solver.model.Cell;
import com.tars.dev.sudoku.solver.model.Grid;
import com.tars.dev.sudoku.solver.model.Row;

import java.util.List;

/**
 * Sudoku solving strategy that tries to solve the {@link Grid} by
 * walking from the top left to the bottom right.
 */
public class OrderedCellSolvingStrategy extends AbstractSolvingStrategy {

    public OrderedCellSolvingStrategy() {
        super();
    }

    @Override
    Cell getNextCellToProcess(Grid grid) {
        return grid.getRows().stream()
                .map(Row::getCells)
                .flatMap(List::stream)
                .filter(c -> !c.isTerminal())
                .findFirst()
                .orElse(null);
    }
}
