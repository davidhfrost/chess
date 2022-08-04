// an interface that provides a default method
// for checking whether a move is in an L shape
// Primarily used for knights, but the interface
// allows it to be used for future types of pieces
public interface LMove{
  
  
  // there are 8 different ways to moving in an L pattern
  // this method will check whether a move fits one of the 8
  default public boolean isLegalLMove(int toRow, int toColumn, ChessPiece p){
    // returns false if the square does not exist
    if (toRow > p.getChessBoard().numRows() || toColumn > p.getChessBoard().numColumns())
      return false;
    // the next eight if statements check if the move is one of the eight legal L-shaped moves
    if (toRow - p.getRow() == 1 && toColumn - p.getColumn() == -2)
      return true;
    else if (toRow - p.getRow() == 2 && toColumn - p.getColumn() == -1)
      return true;
    else if (toRow - p.getRow() == 2 && toColumn - p.getColumn() == 1)
      return true;
    else if (toRow - p.getRow() == 1 && toColumn - p.getColumn() == 2)
      return true;
    else if (toRow - p.getRow() == -1 && toColumn - p.getColumn() == 2)
      return true;
    else if (toRow - p.getRow() == -2 && toColumn - p.getColumn() == 1)
      return true;
    else if (toRow - p.getRow() == -2 && toColumn - p.getColumn() == -1)
      return true;
    else if (toRow - p.getRow() == -1 && toColumn - p.getColumn() == -2)
      return true;
    else
      return false;
  }
}