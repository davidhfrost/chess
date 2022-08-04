/**
 * @author David Frost
 * An elephant piece. It can move two units diagonally on a single move. Elephants cannot
 * cross the river in the middle of the board
 */
public class ElephantPiece extends ChessPiece implements NDiagonal {


    /**
     * returns the label of the elephant piece, "E"
     * @return the label of the piece
     */
    @Override
    public String getLabel() {
        return null;
    }

    /**
     * determines whether an elephant piece move is legal
     * @param toRow the row that it is trying to move to
     * @param toColumn the column that it is trying to move to
     * @return whether the move is legal
     */
    @Override
    public boolean isLegalMove(int toRow, int toColumn) {
        if (this.getSide() == ChessGame.Side.NORTH && toRow >= 5){
            return false;
        }
        else if (this.getSide() == ChessGame.Side.SOUTH && toRow <= 4){
            return false;
        }
        if (this.getChessBoard().hasPiece(toRow, toColumn))
            return isLegalCaptureMove(toRow, toColumn);
        else
            return isLegalNonCaptureMove(toRow, toColumn);
    }

    /**
     * determines if a capture move is legal
     * @param toRow the row of the desired square
     * @param toColumn the column of the desired square
     * @return whether the move is a legal capture move
     */
    public boolean isLegalCaptureMove(int toRow, int toColumn) {
        if (!noFriendlyPieceOnSquare(toRow, toColumn))
            return false;
        if (isLegalNDiagonalMove(toRow, toColumn, 2, this)){
            if (toRow - this.getRow() == 2 && toColumn - this.getColumn() == 0
                    && this.getChessBoard().hasPiece(this.getRow() + 1, this.getColumn()))
                return true;
            else if (toRow - this.getRow() == -2 && toColumn - this.getColumn() == 0
                    && this.getChessBoard().hasPiece(this.getRow() + -1, this.getColumn()))
                return true;
            else if (toRow - this.getRow() == 0 && toColumn - this.getColumn() == 2
                    && this.getChessBoard().hasPiece(this.getRow(), this.getColumn() + 1))
                return true;
            else if (toRow - this.getRow() == 0 && toColumn - this.getColumn() == -2
                    && this.getChessBoard().hasPiece(this.getRow(), this.getColumn()))
                return true;
            else
                return false;
        }
        else{
            return false;
        }
    }

    /**
     * determines if a non-capture move is legal
     * @param toRow the row of the desired square
     * @param toColumn the column of the desired square
     * @return whether the move is a legal non-capture move
     */
    public boolean isLegalNonCaptureMove(int toRow, int toColumn) {
        return isLegalCaptureMove(toRow, toColumn);
    }

    /**
     * creates a elephant piece belonging to a specific side on a specific square on a specific board
     * @param board the board to which the Xiangqi elephant piece belongs
     * @param side the side to which the Xiangqi elephant piece belongs
     * @param row the row in which the Xiangqi elephant piece is initialized
     * @param column the column in which the Xiangqi elephant piece is initialized
     */
    public ElephantPiece(ChessBoard board, ChessGame.Side side, int row, int column) {
        super(board, side, row, column);
    }
}
