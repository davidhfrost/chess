public class EuropeanChess implements ChessGame{
  
  // field that remembers who gets to play this turn
  private ChessGame.Side currentSide = Side.NORTH;
  
  // getter method for the current player
  public ChessGame.Side getCurrentSide(){
    return this.currentSide;
  }
  
  // setter method for the current player (alternates between two sides)
  public void setCurrentSide(ChessGame.Side newSide){
    this.currentSide = newSide;
  }
  
  // checks whether the piece that someone is trying to move actually belongs
  // to them and that the current turn is theirs
  public boolean legalPieceToPlay(ChessPiece piece, int row, int column){
    if (piece.getSide() == this.getCurrentSide()){
      return true;
    }
    else{
      return false;
    }
  }
  
  // moves a chess piece to the inputted location if the move is legal
  public boolean makeMove(ChessPiece piece, int toRow, int toColumn){
    if (piece.isLegalMove(toRow, toColumn) == true){
      piece.getChessBoard().removePiece(piece.getRow(), piece.getColumn());
      piece.getChessBoard().removePiece(toRow, toColumn);
      piece.setLocation(toRow, toColumn);
      piece.getChessBoard().addPiece(piece, toRow, toColumn);
      if (getCurrentSide() == ChessGame.Side.NORTH){
        setCurrentSide(ChessGame.Side.SOUTH);
      }
      else{
        setCurrentSide(ChessGame.Side.NORTH);
      }
      piece.moveDone();
      if (piece instanceof PawnPiece){
        if (toRow == 0 || toRow == piece.getChessBoard().numRows() - 1){
          piece.getChessBoard().removePiece(toRow, toColumn);
          String newPiece = javax.swing.JOptionPane.showInputDialog("Pick a new piece");
          if (newPiece.equals("Q")){
            piece.getChessBoard().addPiece(new QueenPiece(piece.getChessBoard(), piece.getSide(), toRow, toColumn), toRow, toColumn);
          }
          else if (newPiece.equals("N")){
            piece.getChessBoard().addPiece(new KnightPiece(piece.getChessBoard(), piece.getSide(), toRow, toColumn), toRow, toColumn);
          }
          else if (newPiece.equals("B")){
            piece.getChessBoard().addPiece(new BishopPiece(piece.getChessBoard(), piece.getSide(), toRow, toColumn), toRow, toColumn);
          }
          else if (newPiece.equals("R")){
            piece.getChessBoard().addPiece(new RookPiece(piece.getChessBoard(), piece.getSide(), toRow, toColumn), toRow, toColumn);
          }
          else{
            piece.getChessBoard().addPiece(piece, toRow, toColumn);
          }
        }
      }
      return true;
    }
    else{
      return false;
    }
  }

  @Override
  public int getNumRows() {
    return 8;
  }

  @Override
  public int getNumColumns() {
    return 8;
  }

  @Override
  public void startGame(ChessBoard board) {

    // the rules for the chess program
    EuropeanChess rules = new EuropeanChess();
    // the first side to play in the game
    rules.setCurrentSide(ChessGame.Side.NORTH);
    // the board upon which the game will be played. 8x8 grid by default
    //board = new SwingChessBoard(8, 8, (SwingChessBoardDisplay) display, this);
    // for loop that adds a lot of north pawns to the board
    for (int i = 0; i < 8; i++){
      board.addPiece(new PawnPiece(board, ChessGame.Side.NORTH, 1, i), 1, i);
    }
    // the next 8 lines of code add the north's top line of pieces
    // in order: rook, knight, bishop, queen, king, bishop, knight, rook
    board.addPiece(new RookPiece(board, ChessGame.Side.NORTH, 0, 0), 0, 0);
    board.addPiece(new KnightPiece(board, ChessGame.Side.NORTH, 0, 1), 0, 1);
    board.addPiece(new BishopPiece(board, ChessGame.Side.NORTH, 0, 2), 0, 2);
    board.addPiece(new QueenPiece(board, ChessGame.Side.NORTH, 0, 3), 0, 3);
    board.addPiece(new KingPiece(board, ChessGame.Side.NORTH, 0, 4), 0, 4);
    board.addPiece(new BishopPiece(board, ChessGame.Side.NORTH, 0, 5), 0, 5);
    board.addPiece(new KnightPiece(board, ChessGame.Side.NORTH, 0, 6), 0, 6);
    board.addPiece(new RookPiece(board, ChessGame.Side.NORTH, 0, 7), 0, 7);

    // the next 8 lines of code add the south's bottom line of pieces
    // in order: rook, knight, bishop, queen, king, bishop, knight, rook
    board.addPiece(new RookPiece(board, ChessGame.Side.SOUTH, 7, 0), 7, 0);
    board.addPiece(new KnightPiece(board, ChessGame.Side.SOUTH, 7, 1), 7, 1);
    board.addPiece(new BishopPiece(board, ChessGame.Side.SOUTH, 7, 2), 7, 2);
    board.addPiece(new QueenPiece(board, ChessGame.Side.SOUTH, 7, 3), 7, 3);
    board.addPiece(new KingPiece(board, ChessGame.Side.SOUTH, 7, 4), 7, 4);
    board.addPiece(new BishopPiece(board, ChessGame.Side.SOUTH, 7, 5), 7, 5);
    board.addPiece(new KnightPiece(board, ChessGame.Side.SOUTH, 7, 6), 7, 6);
    board.addPiece(new RookPiece(board, ChessGame.Side.SOUTH, 7, 7), 7, 7);
    // this for loop adds all of the south's pawns
    for (int i = 0; i < 8; i++){
      board.addPiece(new PawnPiece(board, ChessGame.Side.SOUTH, 6, i), 6, i);
    }
  }

  public static void main(String[] args){
    EuropeanChess ec = new EuropeanChess();
    ec.startGame(null);
  }
}