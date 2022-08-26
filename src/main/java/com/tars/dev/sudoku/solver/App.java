package com.tars.dev.sudoku.solver;

import com.tars.dev.sudoku.solver.model.Grid;
import com.tars.dev.sudoku.solver.solving.strategy.LeastPossibleValueStrategy;
import com.tars.dev.sudoku.solver.solving.strategy.OrderedCellSolvingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * App with main method to start the application.
 */
public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        Grid gridToSolve = new Grid(new Integer[][]{
                {null, 3, null, null, null, 5, 1, 6, null},
                {null, 5, 7, null, null, null, null, 2, 8},
                {null, null, 8, 4, null, null, null, null, null},
                {3, null, 5, null, 8, 2, 6, 9, 7},
                {2, null, 6, 7, null, null, null, null, null},
                {1, null, 9, 6, 5, 4, null, 8, 3},
                {null, 6, null, null, null, null, null, null, 1},
                {null, null, null, 3, 4, null, 8, 7, null},
                {null, null, 3, null, 1, 8, null, null, null},
        });

        LOGGER.info("Start solving puzzle with OrderedCellSolvingStrategy");
        OrderedCellSolvingStrategy orderedCellSolvingStrategy = new OrderedCellSolvingStrategy();
        Grid solvedGridByOrderedStrategy = orderedCellSolvingStrategy.solvePuzzle(gridToSolve);
        LOGGER.info("Finished solving puzzle. Puzzle was solved: {}", solvedGridByOrderedStrategy != null);

        LOGGER.info("Start solving puzzle with LeastPossibleValueStrategy");
        LeastPossibleValueStrategy leastPossibleValueStrategy = new LeastPossibleValueStrategy();
        Grid solvedGridByLeastStrategy = leastPossibleValueStrategy.solvePuzzle(gridToSolve);
        LOGGER.info("Finished solving puzzle. Puzzle was solved: {}", solvedGridByLeastStrategy != null);
    }
}
