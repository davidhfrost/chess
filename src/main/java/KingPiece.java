// a class for a king piece in chess
public class KingPiece extends ChessPiece implements Moved, EightSingleMoves{
  
  // field to remember whether the king has been moved (important for castling)
  private boolean moved = false;
  
  // the constructor for a king. Takes which player it belongs to and where it goes on what board
  public KingPiece(ChessBoard board, ChessGame.Side side, int row, int column){
    super(board, side, row, column);
  }
  
  // getter method checking whether the king has been moved
  public boolean getMoved(){
    return this.moved;
  }
  
  // setter method for setting the king as having been moved
  public void setMoved(boolean newState){
    this.moved = newState;
  }
  
  // getter method that returns the king's label, "K"
  public String getLabel(){
    return "K";
  }
  
  // checks whether a king's move is legal
  public boolean isLegalMove(int toRow, int toColumn){
    // if there is already a piece on the specific square, check whether it is a legal capture move
    if (this.getChessBoard().hasPiece(toRow, toColumn)){
      return this.isLegalCaptureMove(toRow, toColumn);
    }
    // otherwise, see if it is a legal non-capture move
    else{
      return this.isLegalNonCaptureMove(toRow, toColumn);
    }
  }
  
  // legal capture moves
  public boolean isLegalCaptureMove(int toRow, int toColumn){
    // if there is a piece belonging to the player on the square, the move is automatically illegal
    if (noFriendlyPieceOnSquare(toRow, toColumn) == false)
      return false;
    // returns true if the move is one of the eight legal single moves that a king can make, false otherwise
    return this.isLegalSingleEightMove(toRow, toColumn, this);
  }
  
  // checks whether moving a king to a square without a piece on it is a legal move
  // params: the square that the king is to be moved to
  public boolean isLegalNonCaptureMove(int toRow, int toColumn){
    // if the king is being moved by two squares, then the player is trying to castle.
    // these nested and long if statements check whether castling is legal
    if (toColumn - this.getColumn() == 2 || toColumn - this.getColumn() == -2){
      // preconditions for castling: the king and adjacent rook must not have been moved, and
      // there must not be any pieces between the king and the rook
      if (this.getColumn() - toColumn == 2 && toRow - this.getRow() == 0
        && this.getChessBoard().getPiece(toRow, 0) instanceof RookPiece
        && this.getMoved() == false
        && this.getChessBoard().getPiece(toRow,0).getSide() == this.getSide()
        && this.getChessBoard().hasPiece(toRow, this.getColumn() - 1) == false
        && this.getChessBoard().hasPiece(toRow, 2) == false
        && this.getChessBoard().hasPiece(toRow, 1) == false
        && this.getChessBoard().getPiece(toRow, 0) != null){
        RookPiece leftRook = (RookPiece)this.getChessBoard().getPiece(toRow, 0);
        if (leftRook.getMoved() == false){
          this.setMoved(true);
          leftRook.setMoved(true);
          return true;
        }
      }
      // another if statement that checks the right side of the board as the first one
      // did for the left side. Otherwise, it is the same.
      else if (toColumn - this.getColumn() == 2 && toRow - this.getRow() == 0
              && this.getChessBoard().getPiece(toRow,this.getChessBoard().numColumns()) instanceof RookPiece
              && this.getMoved() == false
              && this.getChessBoard().getPiece(toRow, toColumn + 1).getSide() == this.getSide()
              && this.getChessBoard().hasPiece(toRow, this.getColumn() + 1) == false
              && this.getChessBoard().hasPiece(toRow, this.getColumn() + 2) == false
              && this.getChessBoard().getPiece(toRow, toColumn + 1) != null){
        RookPiece rightRook = (RookPiece)this.getChessBoard().getPiece(toRow, toColumn + 1);
        if (rightRook.getMoved() == false){
          this.setMoved(true);
          rightRook.setMoved(true);
          return true;
        }
      }
      // this else statement covers any move other than a castling move
      // this will only return true if the move is a single square away from the current square
      else{
        return false;
      }
    }
    else{
      return this.isLegalSingleEightMove(toRow, toColumn, this);
    }
    return false;
  }
}