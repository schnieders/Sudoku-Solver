package com.tars.dev.sudoku.solver.model;

import org.junit.jupiter.api.Test;

import static com.tars.dev.sudoku.solver.TestConstants.GRID_SRC;
import static com.tars.dev.sudoku.solver.TestConstants.INIT_GRID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GridTest {


    @Test
    void testInit() {
        verifyGrid(INIT_GRID);
    }

    @Test
    void testInitClone() {
        Grid g = new Grid(INIT_GRID);

        verifyGrid(g);
        assertThat(g).isNotEqualTo(INIT_GRID);
    }

    private void verifyGrid(Grid g) {
        //Verify number of cells for rows, columns and blocks
        assertThat(g.getRows()).hasSize(9).allMatch(r -> r.getCells().size() == 9, "expecting exactly nine cells in each Row");
        assertThat(g.getBlocks()).hasSize(9).allMatch(b -> b.getCells().size() == 9, "expecting exactly nine cells in each Column");
        assertThat(g.getColumns()).hasSize(9).allMatch(c -> c.getCells().size() == 9, "expecting exactly nine cells in each Block");

        //Verify some cells
        assertThat(g.getRows().get(0).getCells().get(0).getValue()).isNull();
        assertThat(g.getRows().get(0).getCells().get(1).getValue()).isEqualTo(Value.THREE);
        assertThat(g.getRows().get(1).getCells().get(0).getValue()).isNull();
        assertThat(g.getRows().get(1).getCells().get(1).getValue()).isEqualTo(Value.FIVE);
        assertThat(g.getColumns().get(6).getCells().get(1).getValue()).isNull();
    }

    @Test
    void testIsSolvable() {
        //Init grid should be solvable
        Grid g = new Grid(GRID_SRC);
        assertTrue(g.isSolvable());
    }

    @Test
    void testIsSolvableNotSolvable() {
        Grid g = new Grid(GRID_SRC);
        //Make grid unsolvable
        g.getRows().get(0).getCells().get(2).setValue(Value.NINE);
        g.getRows().get(0).getCells().get(3).setValue(Value.TWO);
        g.getRows().get(0).getCells().get(4).setValue(Value.ONE);
        g.getRows().get(0).getCells().get(8).setValue(Value.SEVEN);
        g.getRows().get(1).getCells().get(0).setValue(Value.FOUR);
        assertFalse(g.isSolvable());
    }
}