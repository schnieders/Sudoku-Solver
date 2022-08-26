package com.tars.dev.sudoku.solver.solving.strategy;

import com.tars.dev.sudoku.solver.model.Cell;
import com.tars.dev.sudoku.solver.model.Grid;
import com.tars.dev.sudoku.solver.model.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

/**
 * Abstract solving strategy to bundle the same logic for every solving strategy.
 */
public abstract class AbstractSolvingStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractSolvingStrategy.class);

    int steps;

    protected AbstractSolvingStrategy() {
        this.steps = 0;
    }

    /**
     * Tries to solve the given grid.
     *
     * @param grid Grid to solve
     * @return Solved puzzle or NULL if no solution was found
     */
    public Grid solvePuzzle(Grid grid) {
        this.steps++;
        if (!grid.isValid()) {
            LOGGER.debug("Could not solve grid because it is already invalid");
            return null;
        }
        if (grid.isTerminal() && grid.isValid()) {
            LOGGER.info("Solved grid successfully in {} steps", this.steps);
            return grid;
        }

        Cell nextCell = this.getNextCellToProcess(grid);
        if (nextCell == null) {
            //There is no next cell to process
            LOGGER.debug("Could not solve grid because I found no next cell to process for an none terminal Grid.");
            return null;
        }

        List<Value> possibleValues = nextCell.getPossibleValues();
        LOGGER.debug("Got possible values [{}] for Cell: {}", possibleValues, nextCell);

        if (possibleValues.isEmpty()) {
            LOGGER.debug("Could not solve grid because I got no possible values to set for this Cell");
            return null;
        }

        return possibleValues.stream().map(nextValue -> {
                    //Copy Grid to try to solve current Grid
                    LOGGER.debug("Set value {} for Cell: {}", nextValue, nextCell);
                    nextCell.setValue(nextValue);

                    return this.solvePuzzle(new Grid(grid));
                })
                .filter(Objects::nonNull)
                .findFirst().orElse(null);
    }

    /**
     * Returns the next none terminal Cell to solve.
     *
     * @param grid Grid to get next Cell to solve
     * @return Cell to solve next or NULL
     */
    abstract Cell getNextCellToProcess(Grid grid);
}
