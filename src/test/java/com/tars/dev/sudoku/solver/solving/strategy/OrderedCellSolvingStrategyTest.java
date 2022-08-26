package com.tars.dev.sudoku.solver.solving.strategy;

import com.tars.dev.sudoku.solver.model.Grid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.tars.dev.sudoku.solver.TestConstants.INIT_GRID;
import static com.tars.dev.sudoku.solver.TestConstants.SOLVED_GRID;
import static org.assertj.core.api.Assertions.assertThat;

class OrderedCellSolvingStrategyTest {

    private OrderedCellSolvingStrategy classUnderTest;

    @BeforeEach
    void setUp() {
        this.classUnderTest = new OrderedCellSolvingStrategy();
    }

    @Test
    void testSolvePuzzle() {
        Grid result = classUnderTest.solvePuzzle(INIT_GRID);
        assertThat(result).isNotNull().hasToString(SOLVED_GRID.toString());
    }

    @Test
    void testSolvePuzzleWithAlreadyTerminalGrid() {
        Grid result = this.classUnderTest.solvePuzzle(SOLVED_GRID);
        assertThat(result).isEqualTo(SOLVED_GRID);
    }
}