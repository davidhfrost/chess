/**
 * a king piece specifically used in Xiangqi. Can only move one unit vertically
 * or horizontally, and it has to stay in the three center columns or three edge rows
 * @author David Frost
 */
public class  XiangqiKingPiece extends ChessPiece implements StayInThreeCenterColumns {

    /**
     * the constructor for a Xiangqi king piece
     * @param board the board to which the Xiangqi king piece belongs
     * @param side the side to which the Xiangqi king piece belongs
     * @param row the row in which the Xiangqi king piece is initialized
     * @param column the column in which the Xiangqi king piece is initialized
     */
    public XiangqiKingPiece(ChessBoard board, ChessGame.Side side, int row, int column) {
        super(board, side, row, column);
    }

    /**
     * returns the label for the king piece
     * @return the "X" label for the Xiangqi king piece
     */
    @Override
    public String getLabel() {
        return "X";
    }

    /**
     * determines whether a move is legal
     * @param toRow the row to which the piece may or may not be moved
     * @param toColumn the column to which the piece may or may not be moved
     * @return the legality of the suggest move
     */
    @Override
    public boolean isLegalMove(int toRow, int toColumn){
        if (this.isInCenterColumns(this.getChessBoard().numColumns(), toColumn)){
            if (this.getChessBoard().hasPiece(toRow, toColumn)){
                return this.isLegalCaptureMove(toRow, toColumn);
            }
            else{
                return this.isLegalNonCaptureMove(toRow, toColumn);
            }
        }
        else{
            return false;
        }
    }

    /**
     * determines whether capture move is legal
     * @param toRow the row to which the piece may or may not be moved
     * @param toColumn the column to which the piece may or may not be moved
     * @return the legality of the suggest capture move
     */
    public boolean isLegalCaptureMove(int toRow, int toColumn){
        if (noFriendlyPieceOnSquare(toRow, toColumn)){
            if (toRow - this.getRow() == 0 && Math.abs(toColumn - this.getColumn()) == 1){
                return true;
            }
            else if (Math.abs(toRow - this.getRow()) == 1 && toColumn - this.getColumn() == 1){
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }

    /**
     * determines whether a noncapture move is legal
     * @param toRow the row to which the piece may or may not be moved
     * @param toColumn the column to which the piece may or may not be moved
     * @return the legality of the suggest noncapture move
     */
    public boolean isLegalNonCaptureMove(int toRow, int toColumn){
        return isLegalNonCaptureMove(toRow, toColumn);
    }
}
