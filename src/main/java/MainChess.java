// David Frost's class holding the main method for the chess project
public class MainChess{
  
  // the main method that launches the chess program
  public static void main (String[] args){
    // the display for the chess program
    SwingEuropeanChessDisplay display = new SwingEuropeanChessDisplay();
    // the rules for the chess program
    EuropeanChess rules = new EuropeanChess();
    // the first side to play in the game
    rules.setCurrentSide(ChessGame.Side.NORTH);
    // the board upon which the game will be played. 8x8 grid by default
    ChessBoard board = new SwingChessBoard(8, 8, (SwingChessBoardDisplay) display, rules);
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
}