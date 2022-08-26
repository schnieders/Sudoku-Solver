package com.tars.dev.sudoku.solver.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Class to represent a certain cell of a row, column or block.
 */
public class Cell {
    private Value value;
    private final Row row;
    private final Column column;

    private final Block block;

    public Cell(Value value, Row row, Column column, Block block) {
        this.value = value;
        this.row = row;
        this.column = column;
        this.block = block;
    }

    public Cell(Cell src) {
        this.value = src.getValue();
        this.row = src.getRow();
        this.column = src.getColumn();
        this.block = src.getBlock();
    }

    public boolean isTerminal() {
        return this.value != null;
    }

    public List<Value> getPossibleValues() {
        if (this.isTerminal()) {
            return Collections.emptyList();
        }

        return Stream.of(Value.values())
                .filter(v -> this.row.isPossibleValue(v)
                        && this.column.isPossibleValue(v)
                        && this.block.isPossibleValue(v))
                .toList();
    }

    public Block getBlock() {
        return this.block;
    }

    public Column getColumn() {
        return this.column;
    }

    public Row getRow() {
        return this.row;
    }

    public Value getValue() {
        return this.value;
    }

    public void setValue(Value v) {
        this.value = v;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "value=" + value +
                '}';
    }
}
