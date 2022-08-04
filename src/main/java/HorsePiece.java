/**
 * A horse piece. Like a knight, but the adjacent square on the long part of the L-move
 * cannot have a piece on it.
 * @author David Frost
 */
public class HorsePiece extends ChessPiece {

    /**
     * creates a horse piece belonging to a specific side on a specific square on a specific board
     * @param board the board to which the Xiangqi horse piece belongs
     * @param side the side to which the Xiangqi horse piece belongs
     * @param row the row in which the Xiangqi horse piece is initialized
     * @param column the column in which the Xiangqi horse piece is initialized
     */
    public HorsePiece(ChessBoard board, ChessGame.Side side, int row, int column) {
        super(board, side, row, column);
    }

    /**
     * getter method for horse's label
     * @return the label of the horse piece, "H"
     */
    @Override
    public String getLabel() {
        return "H";
    }

    /**
     * determines whether a move by a horse piece is legal
     * @param toRow the row of the square that the piece is trying to move to
     * @param toColumn the row of the square that the piece is trying to move to
     * @return whether the move is a legal move
     */
    @Override
    public boolean isLegalMove(int toRow, int toColumn) {
        if (this.getChessBoard().hasPiece(toRow, toColumn)){
            return isLegalCaptureMove(toRow, toColumn);
        }
        else{
            return isLegalNonCaptureMove(toRow, toColumn);
        }
    }

    /**
     * determines whether a non-capture move by a horse piece is legal
     * @param toRow the row of the square that the piece is trying to move to
     * @param toColumn the row of the square that the piece is trying to move to
     * @return whether the move is a legal non-capture move
     */
    public boolean isLegalNonCaptureMove(int toRow, int toColumn){
        if (toRow > this.getChessBoard().numRows() || toColumn > this.getChessBoard().numColumns())
            return false;
        // the next eight if statements check if the move is one of the eight legal L-shaped moves
        if (toRow - this.getRow() == 1 && toColumn - this.getColumn() == -2)
            return true;
        else if (toRow - this.getRow() == 2 && toColumn - this.getColumn() == -1)
            return true;
        else if (toRow - this.getRow() == 2 && toColumn - this.getColumn() == 1)
            return true;
        else if (toRow - this.getRow() == 1 && toColumn - this.getColumn() == 2)
            return true;
        else if (toRow - this.getRow() == -1 && toColumn - this.getColumn() == 2)
            return true;
        else if (toRow - this.getRow() == -2 && toColumn - this.getColumn() == 1)
            return true;
        else if (toRow - this.getRow() == -2 && toColumn - this.getColumn() == -1)
            return true;
        else if (toRow - this.getRow() == -1 && toColumn - this.getColumn() == -2)
            return true;
        else
            return false;
    }

    /**
     * determines whether a capture move by a horse piece is legal
     * @param toRow the row of the square that the piece is trying to move to
     * @param toColumn the row of the square that the piece is trying to move to
     * @return whether the move is a legal capture move
     */
    public boolean isLegalCaptureMove(int toRow, int toColumn){
        return this.isLegalNonCaptureMove(toRow, toColumn);
    }
}
