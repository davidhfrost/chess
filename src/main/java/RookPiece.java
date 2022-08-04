public class RookPiece extends ChessPiece implements NESW{
  
  // important to know if a rook has been moved for castling
  public boolean moved = false;
  
  // the constructor for a rook
  public RookPiece(ChessBoard board, ChessGame.Side side, int row, int column){
    super(board, side, row, column);
  }
  
  // returns "R", short for rook
  public String getLabel(){
    return "R";
  }
  
  // setter method for whether the rook has been moved
  public void setMoved(boolean newState){
    this.moved = newState;
  }
  
  //getter method for whether the rook has been moved
  public boolean getMoved(){
    return this.moved;
  }
  
  /* checks if the square that the piece is to be moved to has a piece on it already, and
   * then decides if the move is legal */
  public boolean isLegalMove(int toRow, int toColumn){
    if (this.getChessBoard().hasPiece(toRow, toColumn)){
      return this.isLegalCaptureMove(toRow, toColumn);
    }
    else{
      return this.isLegalNonCaptureMove(toRow, toColumn);
    }
  }
  
  // checks to see if a capture move is legal
  public boolean isLegalCaptureMove(int toRow, int toColumn){
    if (noFriendlyPieceOnSquare(toRow, toColumn) == false){
      return false;
    }
    if (this.isLegalCardinalMove(toRow, toColumn, this) == true){
      this.setMoved(true);
      return true;
    }
    else{
      return false;
    }
  }
  
  // checks to see if a non capture move is legal
  public boolean isLegalNonCaptureMove(int toRow, int toColumn){
    return this.isLegalCardinalMove(toRow, toColumn, this);
  }
}