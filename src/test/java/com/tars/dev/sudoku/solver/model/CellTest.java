package com.tars.dev.sudoku.solver.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CellTest {

    @Test
    void testInit() {
        Row r = new Row(0);
        Column c = new Column(0);
        Block b = new Block(0);
        Value v = Value.SIX;

        Cell cell = new Cell(v, r, c, b);
        assertThat(cell.getValue()).isEqualTo(v);
        assertThat(cell.getColumn()).isEqualTo(c);
        assertThat(cell.getBlock()).isEqualTo(b);
        assertThat(cell.getRow()).isEqualTo(r);
    }

    @Test
    void testInitClone() {
        Row r = new Row(0);
        Column c = new Column(0);
        Block b = new Block(0);
        Value v = Value.SIX;

        Cell cell = new Cell(v, r, c, b);
        Cell clone = new Cell(cell);

        assertThat(clone.getValue()).isEqualTo(v);
        assertThat(clone.getColumn()).isEqualTo(c);
        assertThat(clone.getBlock()).isEqualTo(b);
        assertThat(clone.getRow()).isEqualTo(r);
    }

    @Test
    void testChangeClone() {
        Row r = new Row(0);
        Column c = new Column(0);
        Block b = new Block(0);

        Cell cell = new Cell(null, r, c, b);
        Cell clone = new Cell(cell);

        Value change = Value.ONE;
        clone.setValue(change);

        assertThat(clone.getValue()).isEqualTo(change);
        assertThat(cell.getValue()).isNull();
    }
}