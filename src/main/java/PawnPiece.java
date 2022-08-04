// a class for pawns
public class PawnPiece extends ChessPiece implements Moved{
  
  // has this pawn moved yet? important for determining its function
  private boolean moved = false;
  
  // pawn constructor
  public PawnPiece(ChessBoard board, ChessGame.Side side, int row, int column){
    super(board, side, row, column);
  }
  
  // returns P, short for pawn
  @Override
  public String getLabel(){
    return "P";
  }
  
  // getter method for moved
  public boolean getMoved(){
    return this.moved;
  }
  
  // setter method for the moved field
  public void setMoved(boolean newState){
    this.moved = newState;
  }
  
  // checks whether a pawn's move is legal
  @Override
  public boolean isLegalMove(int toRow, int toColumn){
    if (this.getChessBoard().hasPiece(toRow, toColumn) == true){
      return this.isLegalCaptureMove(toRow, toColumn);
    }
    else if (Math.abs(toRow - this.getRow()) == 1 || Math.abs(toRow - this.getRow()) == 2){
      return this.isLegalNonCaptureMove(toRow, toColumn);
    }
    else{
      return false;
    }
  }
  
  // checks whether a non capture move is legal
  public boolean isLegalNonCaptureMove(int toRow, int toColumn){
    // since pawn movement is dependent on the side the pawn belongs to, this method is split in two
    if (this.getSide() == ChessGame.Side.NORTH){
      // if the pawn has not moved then it can move straight ahead by two if there is not a piece in front of it
      if (this.getMoved() == false && toRow - this.getRow() == 2
          && toColumn - this.getColumn() == 0
          && this.getChessBoard().hasPiece(this.getRow() + 1, toColumn) == false){
        return true;
      }
      // it is legal for a pawn to move ahead by one
      else if (toRow - this.getRow() == 1 && toColumn - this.getColumn() == 0
               && this.getChessBoard().hasPiece(toRow, toColumn) == false){
        return true;
      }
      // any other non-capture move by a pawn is illegal
      else{
        return false;
      }
    }
    // this is similar to the last section but is designed for southern pawns instead
    else{
      // 
      if (this.getMoved() == false && this.getRow() - toRow == 2
          && toColumn - this.getColumn() == 0
          && this.getChessBoard().hasPiece(this.getRow() - 1, toColumn) == false){
        return true;
      }
      else if (toRow - this.getRow() == -1 && toColumn - this.getColumn() == 0
               && this.getChessBoard().hasPiece(toRow, toColumn) == false){
        return true;
      }
      else{
        return false;
      }
    }
  }
  
  @Override
  public void moveDone(){
    this.setMoved(true);
  }
    
  public boolean isLegalCaptureMove(int toRow, int toColumn){
    if (this.getSide() == ChessGame.Side.NORTH){
      if (toRow - this.getRow() == 1 && Math.abs(toColumn - this.getColumn()) == 1
          && this.getChessBoard().hasPiece(toRow, toColumn)
          && this.getChessBoard().getPiece(toRow, toColumn).getSide() == ChessGame.Side.SOUTH){
        return true;
      }
      else{
        return false;
      }
    }
    else{
      if (toRow - this.getRow() == -1 && Math.abs(toColumn - this.getColumn()) == 1
          && this.getChessBoard().hasPiece(toRow, toColumn)
          && this.getChessBoard().getPiece(toRow, toColumn).getSide() == ChessGame.Side.NORTH){
        return true;
      }
      else{
        return false;
      }
    }
  }
}