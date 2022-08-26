package com.tars.dev.sudoku.solver;

import com.tars.dev.sudoku.solver.model.Grid;

/**
 * Some constants exclusively for testing.
 */
public class TestConstants {

    public static final Integer[][] GRID_SRC = new Integer[][]{
            {null, 3, null, null, null, 5, 1, 6, null},
            {null, 5, 7, null, null, null, null, 2, 8},
            {null, null, 8, 4, null, null, null, null, null},
            {3, null, 5, null, 8, 2, 6, 9, 7},
            {2, null, 6, 7, null, null, null, null, null},
            {1, null, 9, 6, 5, 4, null, 8, 3},
            {null, 6, null, null, null, null, null, null, 1},
            {null, null, null, 3, 4, null, 8, 7, null},
            {null, null, 3, null, 1, 8, null, null, null}
    };
    public static final Grid INIT_GRID = new Grid(GRID_SRC);

    public static final Grid SOLVED_GRID = new Grid(new Integer[][]{
            {9, 3, 2, 8, 7, 5, 1, 6, 4},
            {4, 5, 7, 9, 6, 1, 3, 2, 8},
            {6, 1, 8, 4, 2, 3, 7, 5, 9},
            {3, 4, 5, 1, 8, 2, 6, 9, 7},
            {2, 8, 6, 7, 3, 9, 4, 1, 5},
            {1, 7, 9, 6, 5, 4, 2, 8, 3},
            {8, 6, 4, 2, 9, 7, 5, 3, 1},
            {5, 9, 1, 3, 4, 6, 8, 7, 2},
            {7, 2, 3, 5, 1, 8, 9, 4, 6}
    });
}
