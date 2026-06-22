import java.util.Objects;

/** Eine unveränderliche Position auf einem 8-mal-8-Schachbrett. */
public final class Position {

    public static final int BOARD_SIZE = 8;

    private final int row;
    private final int column;

    public Position(int row, int column) {
        if (row < 0 || row >= BOARD_SIZE || column < 0 || column >= BOARD_SIZE) {
            throw new IllegalArgumentException("Row and column must be between 0 and 7.");
        }
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Position)) {
            return false;
        }
        Position position = (Position) other;
        return row == position.row && column == position.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
