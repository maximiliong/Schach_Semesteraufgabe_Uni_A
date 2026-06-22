/** Die Springerfigur. */
public final class Knight extends Piece {

    public Knight(PieceColor color) {
        super(color);
    }

    @Override
    public String getName() {
        return "Knight";
    }

    @Override
    public boolean isValidMove(int rowDelta, int columnDelta) {
        int rows = Math.abs(rowDelta);
        int columns = Math.abs(columnDelta);
        return rows * columns == 2;
    }
}
