/** Die Bauernfigur. */
public final class Pawn extends Piece {

    public Pawn(PieceColor color) {
        super(color);
    }

    @Override
    public String getName() {
        return "Pawn";
    }

    @Override
    public boolean isValidMove(int rowDelta, int columnDelta) {
        int direction = isBlack() ? 1 : -1;
        return rowDelta == direction && columnDelta == 0;
    }

    /**
     * Prüft einen diagonalen Bauernschlag. Das Board muss zusätzlich prüfen,
     * dass auf dem Zielfeld eine gegnerische Figur steht.
     */
    public boolean canCapture(int rowDelta, int columnDelta) {
        int direction = isBlack() ? 1 : -1;
        return rowDelta == direction && Math.abs(columnDelta) == 1;
    }
}
