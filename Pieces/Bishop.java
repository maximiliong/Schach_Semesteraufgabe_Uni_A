/** Die Läuferfigur. */
public final class Bishop extends Piece {

    public Bishop(PieceColor color) {
        super(color);
    }

    @Override
    public String getName() {
        return "Bishop";
    }

    @Override
    public boolean isValidMove(int rowDelta, int columnDelta) {
        return Math.abs(rowDelta) == Math.abs(columnDelta) && rowDelta != 0;
    }
}
