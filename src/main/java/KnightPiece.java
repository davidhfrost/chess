/**
 * a piece representing a knight in chess
 * @author David Frost
 */
public class KnightPiece extends ChessPiece implements LMove{

  /**
   * the constructor for a knight
   * @param board the board that the piece is on
   * @param side the player that the piece belongs to
   * @param row the row that the piece is initialized on
   * @param column the column that the piece is initialized on
   */
  public KnightPiece(ChessBoard board, ChessGame.Side side, int row, int column){
    super(board, side, row, column);
  }

  /**
   * returns "N", shorthand label for Knight
   * @return label for the piece
   */
  @Override
  public String getLabel(){
    return "N";
  }

  /**
   * checks if a move is legal. A knight move
   * must be an L move to be considered legal
   * @param toRow the row that the knight is trying to move to
   * @param toColumn the column that the knight is trying to move to
   * @return whether the move by the knight is legal
   */
  public boolean isLegalMove(int toRow, int toColumn){
    if (this.getChessBoard().hasPiece(toRow, toColumn) == true){
      return this.isLegalCaptureMove(toRow, toColumn);
    }
    else{
      return this.isLegalNonCaptureMove(toRow, toColumn);
    }
  }

  /**
   * determines whether a capture move by a knight is legal
   * @param toRow the row that the knight is trying to move to
   * @param toColumn the column that the knight is trying to move to
   * @return whether the capture move by the knight is legal
   */
  public boolean isLegalCaptureMove(int toRow, int toColumn){
    if (noFriendlyPieceOnSquare(toRow, toColumn) == false){
      return false;
    }
    else{
      return isLegalNonCaptureMove(toRow, toColumn);
    }
  }

  /**
   * determines whether a non-capture move by a knight is legal
   * @param toRow the row that the knight is trying to move to
   * @param toColumn the column that the knight is trying to move to
   * @return whether the non-capture move by the knight is legal
   */
  public boolean isLegalNonCaptureMove(int toRow, int toColumn){
    return this.isLegalLMove(toRow, toColumn, this);
  }
}