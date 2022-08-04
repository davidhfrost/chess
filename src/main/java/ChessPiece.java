/**
 * chess piece class. abstract because an instance must be a specific chess piece
 * @author David Frost
 */
public abstract class ChessPiece{
  // which side the piece belongs to
  private ChessGame.Side side;
  // the chessboard that the piece is on
  private ChessBoard chessBoard;
  // the current row of the piece
  private int row;
  // the current column of the piece
  private int column;

  /**
   * the constructor requires which player the piece belongs to and where it goes
   * @param board the board that the piece is to be put unto
   * @param side the player that the piece belongs to
   * @param row the row upon which the piece is initialized
   * @param column the column upon which the piece is initialized
   */
  public ChessPiece(ChessBoard board, ChessGame.Side side, int row, int column){
    this.chessBoard = board;
    this.side = side;
    this.row = row;
    this.column = column;
  }

  /**
   * returns which player controls the piece
   * @return the side of the piece
   */
  ChessGame.Side getSide(){
    return this.side;
  }

  /**
   * getter method for the label of the piece
   * @return label of the piece
   */
  public abstract String getLabel();

  /**
   * getter method for icon of piece
   * @return icon of piece
   */
  Object getIcon(){
    return null;
  }

  /**
   * setter method for the location of a piece
   * @param row the row that the piece will move to
   * @param column the column that the piece will move to
   */
  void setLocation(int row, int column){
    if (this.isLegalMove(row, column)){
      this.row = row;
      this.column = column;
    }
    else{
    }
  }

  /**
   * method that says whether a specific move is legal
   * @param toRow the row that the piece is trying to move to
   * @param toColumn the column that the piece is trying to move to
   * @return whether the move is legal
   */
  public abstract boolean isLegalMove(int toRow, int toColumn);

  /**
   * returns the chessboard that the piece is on
   * @return the chessboard that the piece is on
   */
  ChessBoard getChessBoard(){
    return this.chessBoard;
  }

  /**
   * returns the row that the piece is on
   * @return the piece's row
   */
  int getRow(){
    return this.row;
  }

  /**
   * returns the column that the piece is on
   * @return the piece's column
   */
  int getColumn(){
    return this.column;
  }

  /**
   * a processing method that does finishing touches with some pieces like pawns
   */
  void moveDone(){
  }

  /**
   * method that checks if the square that a piece is to be moved to has a piece
   * from the same player. If it does, the move is automatically illegal
   * @param toRow the row of the square that needs to be checked
   * @param toColumn the column of the square that needs to be checked
   * @return if there is not a friendly piece on the square
   */
  public boolean noFriendlyPieceOnSquare(int toRow, int toColumn){
    if (this.getChessBoard().hasPiece(toRow, toColumn) 
          && this.getSide() == this.getChessBoard().getPiece(toRow, toColumn).getSide()){
      return false;
    }
    else{
      return true;
    }
  }
  
}