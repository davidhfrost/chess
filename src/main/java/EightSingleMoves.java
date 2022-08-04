// an interface that allows chess pieces that implement it
// to move to any of the eight squares adjacent to the piece
public interface EightSingleMoves{
  // the default method that checks for the legality of a move
  default public boolean isLegalSingleEightMove(int toRow, int toColumn, ChessPiece piece){
    // if the piece is moving left or right by one square, the move is legal
    if (toRow - piece.getRow() == 1 && toColumn - piece.getColumn() == 0){
      return true;
    }
    else if (piece.getRow() - toRow == 1 && toColumn - piece.getColumn() == 0){
      return true;
    }
    else if (toColumn - piece.getColumn() == 1 && toRow - piece.getRow() == 0){
      return true;
    }
    else if (piece.getColumn() - toColumn == 1 && toRow - piece.getRow() == 0){
      return true;
    }
    else if (toColumn - piece.getColumn() == 1 && toRow - piece.getRow() == -1){
      return true;
    }
    else if (toColumn - piece.getColumn() == 1 && toRow - piece.getRow() == 1){
      return true;
    }
    else if (toColumn - piece.getColumn() == -1 && toRow - piece.getRow() == 1){
      return true;
    }
    else if (toColumn - piece.getColumn() == -1 && toRow - piece.getRow() == -1){
      return true;
    }
    else{
      return false;
    }
    /*if (toRow - piece.getRow() == 0 && Math.abs(toColumn - piece.getColumn()) == 1){
      return true;
    }
    // if the piece is moving up or down by one square, the move is legal
    else if (Math.abs(toRow - piece.getRow()) == 1 && toColumn - piece.getColumn() == 0){
      return true;
    }
    // if the piece is moving northeast, northwest, southeast, or southwest
    // by one square, the move is legal
    else if (Math.abs(toRow - piece.getRow()) == 1 && Math.abs(toColumn - piece.getColumn()) == 1){
      return true;
    }
    else{
      return false;
    }*/
  }
}