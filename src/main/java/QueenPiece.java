// a class for queen pieces in chess
public class QueenPiece extends ChessPiece implements NESW, MultipleDiagonal{
  
  // the constructor for the queen
  public QueenPiece(ChessBoard board, ChessGame.Side side, int row, int column){
    super(board, side, row, column);
  }
  
  // returns the label "Q" for the queen
  public String getLabel(){
    return "Q";
  }
  
  // method that checks whether a move by a queen is legal
  public boolean isLegalMove(int toRow, int toColumn){
    if (this.getChessBoard().hasPiece(toRow, toColumn)){
      return this.isLegalCaptureMove(toRow, toColumn);
    }
    else{
      return this.isLegalNonCaptureMove(toRow, toColumn);
    }
  }
  
  // method that checks if a capture move is legal
  public boolean isLegalCaptureMove(int toRow, int toColumn){
    // if there is a piece from the same player as the queen's piece on the same square, then
    // the move is automatically illegal
    if (this.noFriendlyPieceOnSquare(toRow, toColumn) == false){
      return false;
    }
    // in all other cases, capture moves behave identically to non-capture moves
    else{
      return this.isLegalNonCaptureMove(toRow, toColumn);
    }
  }
    /*// if the movement is going straight up or down then it's
    // a move in either north or south directions, which must be checked for legality
    if (toRow - this.getRow() != 0 && toColumn - this.getColumn() == 0){
      return this.isLegalCardinalMove(toRow, toColumn, this);
    }
    // if the movement is going straight left or right then the move
    // is in either east or west directions, which must have legality confirmed
    else if (toColumn - this.getColumn() != 0 && toRow - this.getRow() == 0){
      return this.isLegalCardinalMove(toRow, toColumn, this);
    }
    // if the move is not a line in one of the eight directions, then
    // the move is illegal. The queen cannot make irregular moves like a knight.
    else{
      return false;
    }*/
  
  // method that checks if a non-capture move is legal
  public boolean isLegalNonCaptureMove(int toRow, int toColumn){
    // if the movement is going straight up or down then it's
    // a move in either north or south directions, which must be checked for legality
    if (toRow - this.getRow() != 0 && toColumn - this.getColumn() == 0){
      return this.isLegalCardinalMove(toRow, toColumn, this);
    }
    // if the movement is going straight left or right then the move
    // is in either east or west directions, which must have legality confirmed
    else if (toColumn - this.getColumn() != 0 && toRow - this.getRow() == 0){
      return this.isLegalCardinalMove(toRow, toColumn, this);
    }
    // if the move is diagonal, then there must not be any other pieces
    // on the diagonal path. If there are, false is returned. Otherwise, a clear path leads to true.
    else if (Math.abs(toColumn - this.getColumn()) == Math.abs(toRow - this.getRow())){
      return this.isLegalMultipleDiagonalMove(toRow, toColumn, this);
    }
    // if the move is not a line in one of the eight directions, then
    // the move is illegal. The queen cannot make irregular moves like a knight.
    else{
      return false;
    }
  }
}