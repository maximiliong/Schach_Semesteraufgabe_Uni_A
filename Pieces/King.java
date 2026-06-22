/** Die Königsfigur. */
public final class King extends Piece {

    public King(PieceColor color) {
        super(color);
    }

    @Override
    public String getName() {
        return "King";
    }

    @Override
    public boolean isValidMove(int rowDelta, int columnDelta) {
        return Math.max(Math.abs(rowDelta), Math.abs(columnDelta)) == 1;
    }
}
