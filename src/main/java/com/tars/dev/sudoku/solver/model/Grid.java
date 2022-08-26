package com.tars.dev.sudoku.solver.model;

import com.tars.dev.sudoku.solver.Utils;

import java.util.List;
import java.util.stream.IntStream;

import static com.tars.dev.sudoku.solver.Utils.PUZZLE_DYNAMIC;

/**
 * Class to represent a Sudoku puzzle grid.
 */
public class Grid {

    private final List<Row> rows;
    private final List<Column> columns;
    private final List<Block> blocks;

    /**
     * Parses the given grid of integer arrays to internal representation.
     *
     * @param grid to parse
     */
    public Grid(Integer[][] grid) {
        this();

        for (int i = 0; i < 9; i++) {
            Row row = this.rows.get(i);
            for (int j = 0; j < PUZZLE_DYNAMIC; j++) {
                Column column = this.columns.get(j);
                Block block = this.blocks.get(Utils.getBlockIndexFromRowAndColumn(j, i));

                Cell cell = new Cell(Value.fromInt(grid[i][j]), row, column, block);
                this.addCell(row, column, block, cell);
            }
        }
    }

    public Grid(Grid src) {
        this();
        for (int i = 0; i < 9; i++) {
            Row targetRow = this.rows.get(i);
            for (int j = 0; j < PUZZLE_DYNAMIC; j++) {
                Cell srcCell = src.columns.get(j).getCells().get(i);

                Column targetColumn = this.columns.get(j);
                Block targetBlock = this.blocks.get(Utils.getBlockIndexFromRowAndColumn(j, i));
                Cell targetCell = new Cell(srcCell);

                this.addCell(targetRow, targetColumn, targetBlock, targetCell);
            }
        }
    }

    private Grid() {
        //Build up the grid
        this.rows = IntStream.range(0, PUZZLE_DYNAMIC).mapToObj(Row::new).toList();
        this.columns = IntStream.range(0, PUZZLE_DYNAMIC).mapToObj(Column::new).toList();
        this.blocks = IntStream.range(0, PUZZLE_DYNAMIC).mapToObj(Block::new).toList();
    }

    private void addCell(Row row, Column column, Block block, Cell cell) {
        //Add cell to column, row and block
        column.getCells().add(cell);
        row.getCells().add(cell);
        block.getCells().add(cell);
    }

    /**
     * Checks if the complete {@link Grid} is valid.
     *
     * @return True if valid, otherwise false
     */
    public boolean isValid() {
        return this.blocks.stream().allMatch(Block::isValid)
                && this.columns.stream().allMatch(Column::isValid)
                && this.rows.stream().allMatch(Row::isValid);
    }

    /**
     * Checks if the complete {@link Grid} is terminal.
     *
     * @return True if terminal, otherwise false
     */
    public boolean isTerminal() {
        return this.blocks.stream().allMatch(Block::isTerminal)
                && this.columns.stream().allMatch(Column::isTerminal)
                && this.rows.stream().allMatch(Row::isTerminal);
    }

    /**
     * Checks if the Grid has {@link Cell}s that are solvable. This means, that a {@link Cell} is
     * terminal or has valid possible {@link Value}s.
     *
     * @return True if solvable, false otherwise
     */
    public boolean isSolvable() {
        return this.rows.stream().allMatch(r ->
                r.getCells().stream()
                        .allMatch(c -> c.isTerminal() || !c.getPossibleValues().isEmpty()));
    }

    public List<Row> getRows() {
        return this.rows;
    }

    public List<Column> getColumns() {
        return this.columns;
    }

    public List<Block> getBlocks() {
        return this.blocks;
    }

    @Override
    public String toString() {
        return "Grid{" +
                "rows=" + rows +
                ", columns=" + columns +
                ", blocks=" + blocks +
                '}';
    }
}
