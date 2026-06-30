/** Die Damenfigur. */
public final class Queen extends Piece {

    public Queen(PieceColor color) {
        super(color);
    }

    @Override
    public String getName() {
        return "Queen";
    }

    @Override
    public boolean isValidMove(int rowDelta, int columnDelta) {
        int rows = Math.abs(rowDelta);
        int columns = Math.abs(columnDelta);
        return (rows == 0 && columns > 0)
                || (columns == 0 && rows > 0)
                || (rows == columns && rows > 0);
    }
}
