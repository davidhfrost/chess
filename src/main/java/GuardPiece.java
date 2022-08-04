/**
 * @author David Frost
 * GuardPiece is a piece that can move one square diagonally, and thus NDiagonal is implemented with n = 1
 */
public class GuardPiece extends ChessPiece implements StayInThreeCenterColumns, NDiagonal{
    /**
     * constructor for guard piece
     * @param board the board to which the guard piece belongs
     * @param side the side to which the guard piece belongs
     * @param row the row upon which the guard piece is initialized
     * @param column the column upon which the guard piece is initialized
     */
    public GuardPiece(ChessBoard board, ChessGame.Side side, int row, int column) {
        super(board, side, row, column);
    }

    /**
     * gives the label of the guard
     * @return the label for the guard piece, "G"
     */
    @Override
    public String getLabel() {
        return "G";
    }

    /**
     * determines if a move by a guard piece is legal
     * @param toRow the row that the piece is trying to move to
     * @param toColumn the column that the piece is trying to move to
     * @return
     */
    @Override
    public boolean isLegalMove(int toRow, int toColumn) {
        if (isInCenterColumns(this.getChessBoard().numColumns(), toColumn)) {
            if (this.getChessBoard().hasPiece(toRow, toColumn))
                return isLegalCaptureMove(toRow, toColumn);
            else
                return isLegalNonCaptureMove(toRow, toColumn);
        }
        else{
            return false;
        }
    }

    /**
     * determines whether a capture move by a guard piece is legal
     * @param toRow the row of the square that the piece is trying to move to
     * @param toColumn the row of the square that the piece is trying to move to
     * @return whether the move is a legal capture move
     */
    public boolean isLegalCaptureMove(int toRow, int toColumn){
        if (noFriendlyPieceOnSquare(toRow, toColumn)
            && isLegalNDiagonalMove(toRow, toColumn, 1, this)) {
            return true;
        }
        else
            return false;
    }

    /**
     * determines whether a non-capture move by a guard piece is legal
     * @param toRow the row of the square that the piece is trying to move to
     * @param toColumn the row of the square that the piece is trying to move to
     * @return whether the move is a legal non-capture move
     */
    public boolean isLegalNonCaptureMove(int toRow, int toColumn){
        if (isLegalNDiagonalMove(toRow, toColumn, 1, this)){
            return true;
        }
        else
            return false;
    }
}
