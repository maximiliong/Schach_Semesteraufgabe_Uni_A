/**
 * Das Spielfeld und die grundlegende Zuglogik. Die Klasse kennt keine
 * Swing-Komponenten und kann daher unabhängig von der Benutzeroberfläche
 * getestet werden.
 */
public final class Board {

    private final Piece[][] squares = new Piece[Position.BOARD_SIZE][Position.BOARD_SIZE];

    /** Erstellt ein leeres Schachbrett. */
    public Board() {
    }

    /** Erstellt ein Brett mit der üblichen Startaufstellung. */
    public static Board createStandardSetup() {
        Board board = new Board();
        board.placeBackRow(0, PieceColor.BLACK);
        board.placePawns(1, PieceColor.BLACK);
        board.placePawns(6, PieceColor.WHITE);
        board.placeBackRow(7, PieceColor.WHITE);
        return board;
    }

    public Piece getPieceAt(Position position) {
        return squares[position.getRow()][position.getColumn()];
    }

    /** Platziert oder ersetzt eine Figur. Praktisch für Tests und Setups. */
    public void setPieceAt(Position position, Piece piece) {
        squares[position.getRow()][position.getColumn()] = piece;
    }

    /** Entfernt eine Figur und gibt sie zurück; bei leerem Feld {@code null}. */
    public Piece removePieceAt(Position position) {
        Piece removed = getPieceAt(position);
        setPieceAt(position, null);
        return removed;
    }

    /**
     * Prüft einen normalen Zug inklusive Schlagen und blockierten Wegen.
     * Rochade, en passant, Umwandlung und die Schach-Prüfung folgen später.
     */
    public boolean isMoveAllowed(Position from, Position to) {
        Piece piece = getPieceAt(from);
        if (piece == null || from.equals(to)) {
            return false;
        }

        Piece target = getPieceAt(to);
        if (target != null && target.getColor() == piece.getColor()) {
            return false;
        }

        if (piece instanceof Pawn) {
            return isPawnMoveAllowed((Pawn) piece, from, to, target);
        }

        return piece.canMove(from, to) && isPathClear(from, to);
    }

    /** Führt einen erlaubten Zug aus und gibt bei Erfolg {@code true} zurück. */
    public boolean tryMove(Position from, Position to) {
        if (!isMoveAllowed(from, to)) {
            return false;
        }

        Piece piece = getPieceAt(from);
        setPieceAt(to, piece);
        setPieceAt(from, null);
        return true;
    }

    private boolean isPawnMoveAllowed(Pawn pawn, Position from, Position to, Piece target) {
        int rowDelta = to.getRow() - from.getRow();
        int columnDelta = to.getColumn() - from.getColumn();
        int direction = pawn.isBlack() ? 1 : -1;
        int startRow = pawn.isBlack() ? 1 : 6;

        if (pawn.canCapture(rowDelta, columnDelta)) {
            return target != null;
        }

        if (columnDelta != 0 || target != null) {
            return false;
        }
        if (rowDelta == direction) {
            return true;
        }
        if (from.getRow() == startRow && rowDelta == 2 * direction) {
            Position middle = new Position(from.getRow() + direction, from.getColumn());
            return getPieceAt(middle) == null;
        }
        return false;
    }

    private boolean isPathClear(Position from, Position to) {
        Piece piece = getPieceAt(from);
        if (piece instanceof Knight) {
            return true;
        }

        int rowStep = Integer.compare(to.getRow(), from.getRow());
        int columnStep = Integer.compare(to.getColumn(), from.getColumn());
        int row = from.getRow() + rowStep;
        int column = from.getColumn() + columnStep;

        while (row != to.getRow() || column != to.getColumn()) {
            if (squares[row][column] != null) {
                return false;
            }
            row += rowStep;
            column += columnStep;
        }
        return true;
    }

    private void placePawns(int row, PieceColor color) {
        for (int column = 0; column < Position.BOARD_SIZE; column++) {
            setPieceAt(new Position(row, column), new Pawn(color));
        }
    }

    private void placeBackRow(int row, PieceColor color) {
        setPieceAt(new Position(row, 0), new Rook(color));
        setPieceAt(new Position(row, 1), new Knight(color));
        setPieceAt(new Position(row, 2), new Bishop(color));
        setPieceAt(new Position(row, 3), new Queen(color));
        setPieceAt(new Position(row, 4), new King(color));
        setPieceAt(new Position(row, 5), new Bishop(color));
        setPieceAt(new Position(row, 6), new Knight(color));
        setPieceAt(new Position(row, 7), new Rook(color));
    }
}
