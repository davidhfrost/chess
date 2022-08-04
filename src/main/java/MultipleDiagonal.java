// interface that allows pieces to move by multiple squares diagonally
// directions: northeast, northwest, southeast, southwest
public interface MultipleDiagonal{
  
  // sole method of class
  default public boolean isLegalMultipleDiagonalMove(int toRow, int toColumn, ChessPiece piece){
    // boolean to keep track of whether a legal move has been found
    boolean returnTrue = false;
    // single diagonal moves are a subset of multiple diagonal moves, so they are allowed
    if (Math.abs(toRow - piece.getRow()) == 1 && Math.abs(toColumn - piece.getColumn()) == 1){
      return true;
    }
    // this methods checks the legality of northwest and southeast diagonal moves
    else if (toRow - piece.getRow() == toColumn - piece.getColumn()){
      // for loop to iterate through the entire diagonal
      for (int i = 1; i < toRow - piece.getRow(); i++){
        // if statement that checks whether there is a piece on the path blocking the diagonal
        if (piece.getChessBoard().numRows() > piece.getRow() + i && 
            piece.getChessBoard().numColumns() > piece.getColumn() + i &&
            piece.getChessBoard().hasPiece(piece.getRow() + i, piece.getColumn() + i)){
          // if there is a piece, the move is illegal
          return false;
        }
      }
      // if there is not a piece blocking the multiple diagonal piece, the move is legal
      returnTrue = true;
    }
    // if statement that covers slopes of -1
    else if (piece.getRow() - toRow == piece.getColumn() - toColumn){
      // for loop that iterates through the entire diagonal
      for (int i = 1; i < piece.getRow() - toRow; i++){
        // if statement catching pieces that are on the diagonal path
        if (piece.getRow() - i >= 0 && 
            piece.getColumn() - i >= 0 &&
            piece.getChessBoard().hasPiece(piece.getRow() - i, piece.getColumn() - i) == true){
          // if a piece is found on the diagonal, the move is illegal
          return false;
        }
      }
      // if no roadblock is found, the move is legal
      return true;
    }
    // if statement that looks at southeast diagonals
    else if (toRow - piece.getRow() == piece.getColumn() - toColumn){
      // for loop that iterates through the entire southeastern diagonal
      for (int i = 1; i < Math.abs(toRow - piece.getRow()); i++){
        // if statement that attempts to find pieces blocking the diagonal
        if (piece.getChessBoard().numRows() > piece.getRow() + i &&
            piece.getColumn() - i >= 0 &&
            piece.getChessBoard().hasPiece(piece.getRow() + i, piece.getColumn() - i)){
          // if a piece is found, the move is illegal
          return false;
        }
      }
      // otherwise, without a block, the move is definitely legal
      return true;
    }
    // if statement that looks at northeast diagonals
    else if (piece.getRow() - toRow == toColumn - piece.getColumn()){
      // a for loop that iterates through the northeast diagonals
      for (int i = 1; i < Math.abs(toRow - piece.getRow()); i++){
        // if statement that attempts to catch roadblocks
        if (piece.getRow() - i >= 0 &&
            piece.getColumn() + i < piece.getChessBoard().numColumns() &&
            piece.getChessBoard().hasPiece(piece.getRow() - i, piece.getColumn() + i)){
          // if such a block is found, the move is illegal
          return false;
        }
      }
      // if there are no pieces blocking the diagonal, the move is legal
      return true;
    }
    /*else if (piece.getRow() == piece.getColumn() - toColumn){
      for (int i = 1; i < Math.abs(piece.getRow() - toRow); i++){
        if (piece.getRow() - i >= 0 &&
            piece.getColumn() - i >= 0 &&
            piece.getChessBoard().hasPiece(piece.getRow() - i, piece.getColumn() - i)){
          return false;
        }
      }
      return true;
    }*/
    /*else if (toRow - piece.getRow() == piece.getColumn() - toColumn){
      for (int i = 1; i < toRow - piece.getRow(); i++){
        if (piece.getChessBoard().hasPiece(toRow + i, piece.getColumn() + i)){
          return false;
        }
      }
    }*/
    // returnTrue defaults to false so if no diagonal is found then this will return false
    else{
    return returnTrue;
    }
    return returnTrue;
  }
}
             