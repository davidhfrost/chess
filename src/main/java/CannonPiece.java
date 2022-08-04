/**
 * @author David Frost
 * a cannon piece in Xiangqi. It can move any amount either horizontlly or vertically
 * like a rook can, but it can jump over other pieces unlike a rook if it is capturing a piece.
 */
public class CannonPiece extends ChessPiece implements NESW{

    /**
     * this method returns  the label of the cannon piece, "C"
     * @return the label of the piece
     */
    @Override
    public String getLabel() {
        return "C";
    }

    /**
     * determines whether a move is a capture move before determining its legality
     * @param toRow the row of the move whose legality is questioned
     * @param toColumn the column of the move whose legality is questioned
     * @return the legality of the proposed move involving the cannon piece
     */
    @Override
    public boolean isLegalMove(int toRow, int toColumn) {
        if (this.getChessBoard().hasPiece(toRow,toColumn))
            return isLegalCaptureMove(toRow, toColumn);
        else
            return isLegalNonCaptureMove(toRow,toColumn);
    }

    /**
     * determines whether a move is a legal noncapture move
     * @param toRow the row of the move whose legality is questioned
     * @param toColumn the column of the move whose legality is questioned
     * @return the legality of the proposed noncapture move involving the cannon piece
     */
    public boolean isLegalNonCaptureMove(int toRow, int toColumn) {
        return isLegalCardinalMove(toRow, toColumn, this);
    }

    /**
     * determines whether a move is a legal capture move
     * @param toRow the row of the move whose legality is questioned
     * @param toColumn the column of the move whose legality is questioned
     * @return the legality of the proposed capture move involving the cannon piece
     */
    public boolean isLegalCaptureMove(int toRow, int toColumn) {
        if (!noFriendlyPieceOnSquare(toRow, toColumn))
            return false;
        if (Math.abs(toRow - this.getRow()) == 2 && Math.abs(toColumn - this.getColumn()) == 0)
            return this.getChessBoard().hasPiece((toRow + this.getRow()) / 2, toColumn);
        else if (Math.abs(toRow - this.getRow()) == 0 && Math.abs(toColumn - this.getColumn()) == 2)
            return this.getChessBoard().hasPiece(toRow, (this.getColumn() + toColumn) / 2);
        else
            return false;
    }


    /**
     * constructor for the cannon
     * @param board the board that the cannon piece is to be put upon
     * @param side the player to which the cannon piece belongs
     * @param row the row that the cannon is initialized on
     * @param column the column that the cannon is initialized on
     */
    public CannonPiece(ChessBoard board, ChessGame.Side side, int row, int column) {
        super(board, side, row, column);
    }
}
