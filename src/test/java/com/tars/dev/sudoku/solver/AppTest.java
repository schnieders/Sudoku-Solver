package com.tars.dev.sudoku.solver;

import org.junit.jupiter.api.Test;

import static com.tars.dev.sudoku.solver.TestConstants.INIT_GRID;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {


    @Test
    void testInitial() {
        assertTrue(INIT_GRID.isValid());
        assertFalse(INIT_GRID.isTerminal());
    }
}
