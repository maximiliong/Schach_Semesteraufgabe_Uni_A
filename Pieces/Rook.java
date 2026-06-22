/** Die Turmfigur. */
public final class Rook extends Piece {

    public Rook(PieceColor color) {
        super(color);
    }

    @Override
    public String getName() {
        return "Rook";
    }

    @Override
    public boolean isValidMove(int rowDelta, int columnDelta) {
        return (rowDelta == 0) != (columnDelta == 0);
    }
}
