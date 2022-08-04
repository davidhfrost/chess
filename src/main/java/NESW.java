/* an interface that allows chess pieces to
 * move in North, South, East, and West directions */
public interface NESW{
  
  // the sole method of the interface
  default public boolean isLegalCardinalMove(int toRow, int toColumn, ChessPiece piece){
    /* there are four different if statements that can return true, since
     * four different directions of movement are possible. Anything else returns false. */
    // this checks north movement
    if (toRow - piece.getRow() > 0 && toColumn - piece.getColumn() == 0){
      // for loop that iterates through the north line to find a piece blocking the path
      for (int i = 1; i < toRow - piece.getRow(); i++){
        if (piece.getChessBoard().hasPiece(piece.getRow() + i, toColumn)){
          // if there is a piece blocking the path, the move is illegal
          return false;
        }
      }
      // if there is no obstacle, the move is legal
      return true;
    }
    // if statement that handles southern movement
    else if (toRow - piece.getRow() < 0 && toColumn - piece.getColumn() == 0){
      // for loop that iterates through every square in the line
      for (int i = 1; i < piece.getRow() - toRow; i++){
        // if statement that tries to find other pieces interfering with  the line
        if (piece.getChessBoard().hasPiece(toRow + i, toColumn)){
          // if such a piece is found, the move is illegal
          return false;
        }
      }
      // if there is no block, the move is legal
      return true;
    }
    // if statement that covers eastern movement
    else if (toColumn - piece.getColumn() > 0 && toRow - piece.getRow() == 0){
      // for loop that iterates through every square on the eastern line
      for (int i = 1; i < toColumn - piece.getColumn(); i++){
        // if statement that tries to find obstacles on the road
        if (piece.getChessBoard().hasPiece(piece.getColumn() + i, toRow)){
          // if such an obstacle is detected, the move is not legal
          return false;
        }
      }
      // if no blocking pieces are located, the move is legal
      return true;
    }
    // if statement that covers western movement
    else if (toColumn - piece.getColumn() < 0 && toRow - piece.getRow() == 0){
      // for loop that iterates through the western line
      for (int i = 1; i < piece.getColumn() - toColumn; i++){
        // if statement that tries to find a blocking piece on the western line
        if (piece.getChessBoard().hasPiece(toColumn + i, toRow)){
          // if such an obstacle is found, the move is illegal
          return false;
        }
      }
      // otherwise, the move is legal
      return true;
    }
    // if the move is not in a north/south/east/west direction, it is not a NESW move
    else{
      return false;
    }
  }
}