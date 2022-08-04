// a class for bishop pieces in chess
public class BishopPiece extends ChessPiece implements MultipleDiagonal{
  
  // the constructor for a bishop
  // takes which player it belongs to and where it goes on a specific board
  public BishopPiece(ChessBoard board, ChessGame.Side side, int row, int column){
    super(board, side, row, column);
  }
  
  // returns the label for the bishop, "B"
  public String getLabel(){
    return "B";
  }
  
  // determines whether a move is legal
  public boolean isLegalMove(int toRow, int toColumn){
    // if the square that is to be moved to has a piece on it, see
    // if the bishop can capture the other piece
    if (this.getChessBoard().hasPiece(toRow, toColumn)){
      return this.isLegalCaptureMove(toRow, toColumn);
    }
    // non-capture moves should have the same legality anyway for the bishop
    else{
      return this.isLegalNonCaptureMove(toRow, toColumn);
    }
  }
  
  // checks whether a capture move is legal
  public boolean isLegalCaptureMove(int toRow, int toColumn){
    if (noFriendlyPieceOnSquare(toRow, toColumn) == false){
      return false;
    }
    else{
      return this.isLegalMultipleDiagonalMove(toRow, toColumn, this);
    }
  }
  
  // checks whether a non capture move is legal
  public boolean isLegalNonCaptureMove(int toRow, int toColumn){
    return this.isLegalMultipleDiagonalMove(toRow, toColumn, this);
  }
}