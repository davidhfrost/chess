/**
 * A soldier piece. Similar to a pawn, but it can only move one at a time. It can
 * move horizontally after crossing the river in the middle of the board. It cannot
 * do a diagonal capture like a pawn can
 * @David Frost
 */
public class SoldierPiece extends ChessPiece{

    // a boolean to keep track of whether the soldier has crossed the river
    private boolean crossedRiver = false;

    /**
     * @return the label for the soldier, "S"
     */
    @Override
    public String getLabel() {
        return "S";
    }

    /**
     * determines whether a move by a soldier piece is legal
     * @param toRow the row of the square that the piece is trying to move to
     * @param toColumn the row of the square that the piece is trying to move to
     * @return whether the move is a legal move
     */
    @Override
    public boolean isLegalMove(int toRow, int toColumn) {
        if (this.getColumn() == 5){
            this.setCrossedRiver();
        }
        if (this.getChessBoard().hasPiece(toRow, toColumn))
            return isLegalCaptureMove(toRow, toColumn);
        else
            return isLegalNonCaptureMove(toRow, toColumn);
    }

    /**
     * determines whether a noncapture move by a horse piece is legal
     * @param toRow the row of the square that the piece is trying to move to
     * @param toColumn the row of the square that the piece is trying to move to
     * @return whether the move is a legal noncapture move
     */
    public boolean isLegalNonCaptureMove(int toRow, int toColumn){
        if (isLegalPolarMove(toRow, toColumn))
            return true;
        else
            return isLegalHorizontalMove(toRow, toColumn);
    }

    /**
     * determines whether a capture move by a soldier piece is legal
     * @param toRow the row of the square that the piece is trying to move to
     * @param toColumn the row of the square that the piece is trying to move to
     * @return whether the move is a legal capture move
     */
    public boolean isLegalCaptureMove(int toRow, int toColumn){
        return isLegalNonCaptureMove(toRow, toColumn);
    }

    /**
     * getter method for river crossing
     * @return whether the soldier has crossed the river
     */
    public boolean getCrossedRiver(){
        return crossedRiver;
    }

    /**
     * Setter method for rivver crossing.
     * Just as Caesar crossing the Rubicon marked a turning point, a soldier
     * crossing the river cannot uncross it.
     */
    public void setCrossedRiver(){
        this.crossedRiver = true;
    }


    /**
     *
     * @param board
     * @param side
     * @param row
     * @param column
     */
    public SoldierPiece(ChessBoard board, ChessGame.Side side, int row, int column) {
        super(board, side, row, column);
    }

    /**
     * private helper method to see if a soldier is moving towards the other side
     * @param toRow the row it is trying to move to
     * @param toColumn the column that it is trying to move to
     * @return whether the move is a legal polar move
     */
    private boolean isLegalPolarMove(int toRow, int toColumn){
        if (this.getSide() == ChessGame.Side.NORTH)
            return toRow - this.getRow() == 1 && toColumn - this.getColumn() == 0;
        else
            return toRow - this.getRow() == -1 && toColumn - this.getColumn() == 0;
    }

    /**
     * private helper method that checks if a soldier can move horizontaly
     * @param toRow the row that it is trying to move to
     * @param toColumn the column that it is trying to move to
     * @return whether the move is a legal polar move
     */
    private boolean isLegalHorizontalMove(int toRow, int toColumn){
        return Math.abs(toColumn - this.getColumn()) == 1 && Math.abs(toRow - this.getRow()) == 0 && getCrossedRiver();
    }
}
