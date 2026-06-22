/**
 * Gemeinsame Basisklasse aller Schachfiguren.
 *
 * <p>Die Methode {@link #isValidMove(int, int)} bewertet nur das
 * Bewegungsmuster einer Figur. Ob der Weg frei ist, das Zielfeld von einer
 * eigenen Figur belegt ist oder ein Zug den König im Schach lässt, muss ein
 * zukünftiges Board-Modell prüfen.</p>
 */
public abstract class Piece {

    private final PieceColor color;

    protected Piece(PieceColor color) {
        if (color == null) {
            throw new IllegalArgumentException("A piece needs a color.");
        }
        this.color = color;
    }

    public PieceColor getColor() {
        return color;
    }

    public boolean isBlack() {
        return color == PieceColor.BLACK;
    }

    /** Komfortmethode für Aufrufer, die mit Brettpositionen arbeiten. */
    public final boolean canMove(Position from, Position to) {
        if (from == null || to == null) {
            return false;
        }
        return isValidMove(to.getRow() - from.getRow(),
                to.getColumn() - from.getColumn());
    }

    /**
     * @return der lesbare Name der Figur
     */
    public abstract String getName();

    /**
     * Prüft das grundlegende Bewegungsmuster.
     *
     * @param rowDelta Änderung der Zeile (Ziel minus Start)
     * @param columnDelta Änderung der Spalte (Ziel minus Start)
     * @return {@code true}, wenn die Figur sich so bewegen darf
     */
    public abstract boolean isValidMove(int rowDelta, int columnDelta);
}
