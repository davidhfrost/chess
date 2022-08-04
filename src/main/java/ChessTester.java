import org.junit.*;
import static org.junit.Assert.*;
// David Frost's Project 3 JUnit Testing Class
public class ChessTester{
  
  
  @Test
  public void KnightTester(){
    SwingEuropeanChessDisplay display = new SwingEuropeanChessDisplay();
    EuropeanChess rules = new EuropeanChess();
    SwingChessBoard board = new SwingChessBoard(8, 8, display, rules);
    KnightPiece knight = new KnightPiece(board, ChessGame.Side.NORTH, 4, 4);
    board.addPiece(knight, knight.getRow(), knight.getColumn());
    assertEquals("Test", null, board.getPiece(0,0));
    assertEquals("LabelTest", "N", knight.getLabel());
    assertEquals("columnTest", 4, knight.getColumn());
    assertEquals("IconTest", null, knight.getIcon());
    assertEquals("rowTest", 4, knight.getRow());
    assertFalse("NotRowTest", knight.getRow() == 3);
    assertFalse("NotColumnTest", knight.getRow() == 3);
    assertTrue("NNE", knight.isLegalMove(2, 5));
    assertTrue("ENE", knight.isLegalMove(3, 6));
    assertTrue("ESE", knight.isLegalMove(5, 6));
    assertTrue("SSE", knight.isLegalMove(6, 5));
    assertTrue("SSW", knight.isLegalMove(6, 3));
    assertTrue("WSW", knight.isLegalMove(5, 2));
    assertTrue("WNW", knight.isLegalMove(3, 2));
    assertTrue("NNW", knight.isLegalMove(2, 3));
    //
    assertTrue("NNE", knight.isLegalNonCaptureMove(2, 5));
    assertTrue("ENE", knight.isLegalNonCaptureMove(3, 6));
    assertTrue("ESE", knight.isLegalNonCaptureMove(5, 6));
    assertTrue("SSE", knight.isLegalNonCaptureMove(6, 5));
    assertTrue("SSW", knight.isLegalNonCaptureMove(6, 3));
    assertTrue("WSW", knight.isLegalNonCaptureMove(5, 2));
    assertTrue("WNW", knight.isLegalNonCaptureMove(3, 2));
    assertTrue("NNW", knight.isLegalNonCaptureMove(2, 3));
    //
    assertTrue("NNE", knight.isLegalCaptureMove(2, 5));
    assertTrue("ENE", knight.isLegalCaptureMove(3, 6));
    assertTrue("ESE", knight.isLegalCaptureMove(5, 6));
    assertTrue("SSE", knight.isLegalCaptureMove(6, 5));
    assertTrue("SSW", knight.isLegalCaptureMove(6, 3));
    assertTrue("WSW", knight.isLegalCaptureMove(5, 2));
    assertTrue("WNW", knight.isLegalCaptureMove(3, 2));
    assertTrue("NNW", knight.isLegalCaptureMove(2, 3));
    //
    assertFalse("NNE", knight.isLegalMove(2, 4));
    assertFalse("ENE", knight.isLegalMove(3, 5));
    assertFalse("ESE", knight.isLegalMove(5, 5));
    assertFalse("SSE", knight.isLegalMove(6, 6));
    assertFalse("SSW", knight.isLegalMove(6, 4));
    assertFalse("WSW", knight.isLegalMove(5, 3));
    assertFalse("WNW", knight.isLegalMove(3, 3));
    assertFalse("NNW", knight.isLegalMove(2, 4));
    //
    assertFalse("NNE", knight.isLegalNonCaptureMove(2, 4));
    assertFalse("ENE", knight.isLegalNonCaptureMove(3, 5));
    assertFalse("ESE", knight.isLegalNonCaptureMove(5, 5));
    assertFalse("SSE", knight.isLegalNonCaptureMove(6, 6));
    assertFalse("SSW", knight.isLegalNonCaptureMove(6, 4));
    assertFalse("WSW", knight.isLegalNonCaptureMove(5, 3));
    assertFalse("WNW", knight.isLegalNonCaptureMove(3, 3));
    assertFalse("NNW", knight.isLegalNonCaptureMove(2, 4));
    //
    assertFalse("NNE", knight.isLegalCaptureMove(2, 4));
    assertFalse("ENE", knight.isLegalCaptureMove(3, 5));
    assertFalse("ESE", knight.isLegalCaptureMove(5, 5));
    assertFalse("SSE", knight.isLegalCaptureMove(6, 6));
    assertFalse("SSW", knight.isLegalCaptureMove(6, 4));
    assertFalse("WSW", knight.isLegalCaptureMove(5, 3));
    assertFalse("WNW", knight.isLegalCaptureMove(3, 3));
    assertFalse("NNW", knight.isLegalCaptureMove(2, 4));
    //
    assertFalse("NNE", knight.isLegalMove(2, 6));
    assertFalse("ENE", knight.isLegalMove(3, 7));
    assertFalse("ESE", knight.isLegalMove(5, 7));
    assertFalse("SSE", knight.isLegalMove(6, 6));
    assertFalse("SSW", knight.isLegalMove(6, 4));
    assertFalse("WSW", knight.isLegalMove(5, 3));
    assertFalse("WNW", knight.isLegalMove(3, 3));
    assertFalse("NNW", knight.isLegalMove(2, 4));
    //
    assertFalse("NNE", knight.isLegalNonCaptureMove(2, 6));
    assertFalse("ENE", knight.isLegalNonCaptureMove(3, 7));
    assertFalse("ESE", knight.isLegalNonCaptureMove(5, 7));
    assertFalse("SSE", knight.isLegalNonCaptureMove(6, 6));
    assertFalse("SSW", knight.isLegalNonCaptureMove(6, 4));
    assertFalse("WSW", knight.isLegalNonCaptureMove(5, 3));
    assertFalse("WNW", knight.isLegalNonCaptureMove(3, 3));
    assertFalse("NNW", knight.isLegalNonCaptureMove(2, 4));
    //
    assertFalse("NNE", knight.isLegalCaptureMove(2, 6));
    assertFalse("ENE", knight.isLegalCaptureMove(3, 7));
    assertFalse("ESE", knight.isLegalCaptureMove(5, 7));
    assertFalse("SSE", knight.isLegalCaptureMove(6, 6));
    assertFalse("SSW", knight.isLegalCaptureMove(6, 4));
    assertFalse("WSW", knight.isLegalCaptureMove(5, 3));
    assertFalse("WNW", knight.isLegalCaptureMove(3, 3));
    assertFalse("NNW", knight.isLegalCaptureMove(2, 4));
    //
    assertFalse("NNE", knight.isLegalMove(1, 5));
    assertFalse("ENE", knight.isLegalMove(2, 6));
    assertFalse("ESE", knight.isLegalMove(4, 6));
    assertFalse("SSE", knight.isLegalMove(5, 5));
    assertFalse("SSW", knight.isLegalMove(5, 3));
    assertFalse("WSW", knight.isLegalMove(4, 2));
    assertFalse("WNW", knight.isLegalMove(2, 2));
    assertFalse("NNW", knight.isLegalMove(1, 3));
    //
    assertFalse("NNE", knight.isLegalNonCaptureMove(1, 5));
    assertFalse("ENE", knight.isLegalNonCaptureMove(2, 6));
    assertFalse("ESE", knight.isLegalNonCaptureMove(4, 6));
    assertFalse("SSE", knight.isLegalNonCaptureMove(5, 5));
    assertFalse("SSW", knight.isLegalNonCaptureMove(5, 3));
    assertFalse("WSW", knight.isLegalNonCaptureMove(4, 2));
    assertFalse("WNW", knight.isLegalNonCaptureMove(2, 2));
    assertFalse("NNW", knight.isLegalNonCaptureMove(1, 3));
    //
    assertFalse("NNE", knight.isLegalCaptureMove(1, 5));
    assertFalse("ENE", knight.isLegalCaptureMove(2, 6));
    assertFalse("ESE", knight.isLegalCaptureMove(4, 6));
    assertFalse("SSE", knight.isLegalCaptureMove(5, 5));
    assertFalse("SSW", knight.isLegalCaptureMove(5, 3));
    assertFalse("WSW", knight.isLegalCaptureMove(4, 2));
    assertFalse("WNW", knight.isLegalCaptureMove(2, 2));
    assertFalse("NNW", knight.isLegalCaptureMove(1, 3));
    //
    assertFalse("NNE", knight.isLegalMove(3, 5));
    assertFalse("ENE", knight.isLegalMove(4, 6));
    assertFalse("ESE", knight.isLegalMove(6, 6));
    assertFalse("SSE", knight.isLegalMove(7, 5));
    assertFalse("SSW", knight.isLegalMove(7, 3));
    assertFalse("WSW", knight.isLegalMove(6, 2));
    assertFalse("WNW", knight.isLegalMove(4, 2));
    assertFalse("NNW", knight.isLegalMove(3, 3));
    //
    assertFalse("NNE", knight.isLegalNonCaptureMove(3, 5));
    assertFalse("ENE", knight.isLegalNonCaptureMove(4, 6));
    assertFalse("ESE", knight.isLegalNonCaptureMove(6, 6));
    assertFalse("SSE", knight.isLegalNonCaptureMove(7, 5));
    assertFalse("SSW", knight.isLegalNonCaptureMove(7, 3));
    assertFalse("WSW", knight.isLegalNonCaptureMove(6, 2));
    assertFalse("WNW", knight.isLegalNonCaptureMove(4, 2));
    assertFalse("NNW", knight.isLegalNonCaptureMove(3, 3));
    //
    assertFalse("NNE", knight.isLegalCaptureMove(3, 5));
    assertFalse("ENE", knight.isLegalCaptureMove(4, 6));
    assertFalse("ESE", knight.isLegalCaptureMove(6, 6));
    assertFalse("SSE", knight.isLegalCaptureMove(7, 5));
    assertFalse("SSW", knight.isLegalCaptureMove(7, 3));
    assertFalse("WSW", knight.isLegalCaptureMove(6, 2));
    assertFalse("WNW", knight.isLegalCaptureMove(4, 2));
    assertFalse("NNW", knight.isLegalCaptureMove(3, 3));
    //
    KingPiece king1 = new KingPiece(board, ChessGame.Side.NORTH, 3, 4);
    KingPiece king2 = new KingPiece(board, ChessGame.Side.NORTH, 3, 5);
    KingPiece king3 = new KingPiece(board, ChessGame.Side.NORTH, 4, 5);
    KingPiece king4 = new KingPiece(board, ChessGame.Side.NORTH, 5, 5);
    KingPiece king5 = new KingPiece(board, ChessGame.Side.NORTH, 5, 4);
    KingPiece king6 = new KingPiece(board, ChessGame.Side.NORTH, 5, 3);
    KingPiece king7 = new KingPiece(board, ChessGame.Side.NORTH, 4, 3);
    KingPiece king8 = new KingPiece(board, ChessGame.Side.NORTH, 3, 3);
    board.addPiece(king1, 3, 4);
    board.addPiece(king2, 3, 5);
    board.addPiece(king3, 4, 5);
    board.addPiece(king4, 5, 5);
    board.addPiece(king5, 5, 4);
    board.addPiece(king6, 5, 3);
    board.addPiece(king7, 4, 3);
    board.addPiece(king8, 3, 3);
    //
    assertTrue("NNE", knight.isLegalMove(2, 5));
    assertTrue("ENE", knight.isLegalMove(3, 6));
    assertTrue("ESE", knight.isLegalMove(5, 6));
    assertTrue("SSE", knight.isLegalMove(6, 5));
    assertTrue("SSW", knight.isLegalMove(6, 3));
    assertTrue("WSW", knight.isLegalMove(5, 2));
    assertTrue("WNW", knight.isLegalMove(3, 2));
    assertTrue("NNW", knight.isLegalMove(2, 3));
    //
    KingPiece king9 = new KingPiece(board, ChessGame.Side.SOUTH, 2, 5);
    KingPiece king10 = new KingPiece(board, ChessGame.Side.SOUTH, 3, 6);
    KingPiece king11 = new KingPiece(board, ChessGame.Side.SOUTH, 5, 6);
    KingPiece king12 = new KingPiece(board, ChessGame.Side.SOUTH, 6, 5);
    KingPiece king13 = new KingPiece(board, ChessGame.Side.SOUTH, 6, 3);
    KingPiece king14 = new KingPiece(board, ChessGame.Side.SOUTH, 5, 2);
    KingPiece king15 = new KingPiece(board, ChessGame.Side.SOUTH, 3, 2);
    KingPiece king16 = new KingPiece(board, ChessGame.Side.SOUTH, 2, 3);
    assertTrue("NNE", knight.isLegalMove(2, 5));
    assertTrue("ENE", knight.isLegalMove(3, 6));
    assertTrue("ESE", knight.isLegalMove(5, 6));
    assertTrue("SSE", knight.isLegalMove(6, 5));
    assertTrue("SSW", knight.isLegalMove(6, 3));
    assertTrue("WSW", knight.isLegalMove(5, 2));
    assertTrue("WNW", knight.isLegalMove(3, 2));
    assertTrue("NNW", knight.isLegalMove(2, 3));
    //
    
  }
  
  //tests rooks
  @Test
  public void RookTester(){
    SwingEuropeanChessDisplay display = new SwingEuropeanChessDisplay();
    EuropeanChess rules = new EuropeanChess();
    SwingChessBoard board = new SwingChessBoard(8, 8, display, rules);
    RookPiece rook = new RookPiece(board, ChessGame.Side.NORTH, 4, 4);
    board.addPiece(rook, 4, 4);
    assertEquals("LabelTest", "R", rook.getLabel());
    assertEquals("rowTest", 4, rook.getRow());
    assertEquals("columntest", 4, rook.getColumn());
    assertFalse("NotRowTest", rook.getRow() == 3);
    assertFalse("NotColumnTest", rook.getRow() == 3);
    assertSame("IconTest", null, rook.getIcon());
    //
    assertTrue("South move max", rook.isLegalMove(7, 4));
    assertTrue("South move 2", rook.isLegalMove(6, 4));
    assertTrue("South move 1", rook.isLegalMove(5, 4));
    assertTrue("North move 1", rook.isLegalMove(3, 4));
    assertTrue("North move 2", rook.isLegalMove(2, 4));
    assertTrue("North move 3", rook.isLegalMove(1, 4));
    assertTrue("North move max", rook.isLegalMove(0, 4));
    //
    assertTrue("South move max", rook.isLegalNonCaptureMove(7, 4));
    assertTrue("South move 2", rook.isLegalNonCaptureMove(6, 4));
    assertTrue("South move 1", rook.isLegalNonCaptureMove(5, 4));
    assertTrue("North move 1", rook.isLegalNonCaptureMove(3, 4));
    assertTrue("North move 2", rook.isLegalNonCaptureMove(2, 4));
    assertTrue("North move 3", rook.isLegalNonCaptureMove(1, 4));
    assertTrue("North move max", rook.isLegalNonCaptureMove(0, 4));
    //
    assertTrue("South move max", rook.isLegalCaptureMove(7, 4));
    assertTrue("South move 2", rook.isLegalCaptureMove(6, 4));
    assertTrue("South move 1", rook.isLegalCaptureMove(5, 4));
    assertTrue("North move 1", rook.isLegalCaptureMove(3, 4));
    assertTrue("North move 2", rook.isLegalCaptureMove(2, 4));
    assertTrue("North move 3", rook.isLegalCaptureMove(1, 4));
    assertTrue("North move max", rook.isLegalCaptureMove(0, 4));
    //
    assertTrue("East move 1", rook.isLegalMove(4, 5));
    assertTrue("East move 2", rook.isLegalMove(4, 6));
    assertTrue("East move max", rook.isLegalMove(4, 7));
    assertTrue("West move 1", rook.isLegalMove(4, 3));
    assertTrue("West move 2", rook.isLegalMove(4, 2));
    assertTrue("West move 3", rook.isLegalMove(4, 1));
    assertTrue("West move max", rook.isLegalMove(4, 0));
    //
    assertTrue("East move 1", rook.isLegalNonCaptureMove(4, 5));
    assertTrue("East move 2", rook.isLegalNonCaptureMove(4, 6));
    assertTrue("East move max", rook.isLegalNonCaptureMove(4, 7));
    assertTrue("West move 1", rook.isLegalNonCaptureMove(4, 3));
    assertTrue("West move 2", rook.isLegalNonCaptureMove(4, 2));
    assertTrue("West move 3", rook.isLegalNonCaptureMove(4, 1));
    assertTrue("West move max", rook.isLegalNonCaptureMove(4, 0));
    //
    assertTrue("East move 1", rook.isLegalCaptureMove(4, 5));
    assertTrue("East move 2", rook.isLegalCaptureMove(4, 6));
    assertTrue("East move max", rook.isLegalCaptureMove(4, 7));
    assertTrue("West move 1", rook.isLegalCaptureMove(4, 3));
    assertTrue("West move 2", rook.isLegalCaptureMove(4, 2));
    assertTrue("West move 3", rook.isLegalCaptureMove(4, 1));
    assertTrue("West move max", rook.isLegalCaptureMove(4, 0));
    // the beginning of 49 tests of isLegalMove (64 - 1 - 2*7)
    assertFalse("0,0", rook.isLegalMove(0,0));
    assertFalse("0,1", rook.isLegalMove(0,1));
    assertFalse("0,2", rook.isLegalMove(0,2));
    assertFalse("0,3", rook.isLegalMove(0,3));
    assertFalse("0,5", rook.isLegalMove(0,5));
    assertFalse("0,6", rook.isLegalMove(0,6));
    assertFalse("0,7", rook.isLegalMove(0,7));
    //
    assertFalse("1,0", rook.isLegalMove(1,0));
    assertFalse("1,1", rook.isLegalMove(1,1));
    assertFalse("1,2", rook.isLegalMove(1,2));
    assertFalse("1,3", rook.isLegalMove(1,3));
    assertFalse("1,5", rook.isLegalMove(1,5));
    assertFalse("1,6", rook.isLegalMove(1,6));
    assertFalse("1,7", rook.isLegalMove(1,7));
    //
    assertFalse("2,0", rook.isLegalMove(2,0));
    assertFalse("2,1", rook.isLegalMove(2,1));
    assertFalse("2,2", rook.isLegalMove(2,2));
    assertFalse("2,3", rook.isLegalMove(2,3));
    assertFalse("2,5", rook.isLegalMove(2,5));
    assertFalse("2,6", rook.isLegalMove(2,6));
    assertFalse("2,7", rook.isLegalMove(2,7));
    //
    assertFalse("3,0", rook.isLegalMove(3,0));
    assertFalse("3,1", rook.isLegalMove(3,1));
    assertFalse("3,2", rook.isLegalMove(3,2));
    assertFalse("3,3", rook.isLegalMove(3,3));
    assertFalse("3,5", rook.isLegalMove(3,5));
    assertFalse("3,6", rook.isLegalMove(3,6));
    assertFalse("3,7", rook.isLegalMove(3,7));
    //
    assertFalse("5,0", rook.isLegalMove(5,0));
    assertFalse("5,1", rook.isLegalMove(5,1));
    assertFalse("5,2", rook.isLegalMove(5,2));
    assertFalse("5,3", rook.isLegalMove(5,3));
    assertFalse("5,5", rook.isLegalMove(5,5));
    assertFalse("5,6", rook.isLegalMove(5,6));
    assertFalse("5,7", rook.isLegalMove(5,7));
    //
    assertFalse("6,0", rook.isLegalMove(6,0));
    assertFalse("6,1", rook.isLegalMove(6,1));
    assertFalse("6,2", rook.isLegalMove(6,2));
    assertFalse("6,3", rook.isLegalMove(6,3));
    assertFalse("6,5", rook.isLegalMove(6,5));
    assertFalse("6,6", rook.isLegalMove(6,6));
    assertFalse("6,7", rook.isLegalMove(6,7));
    //
    assertFalse("7,0", rook.isLegalMove(7,0));
    assertFalse("7,1", rook.isLegalMove(7,1));
    assertFalse("7,2", rook.isLegalMove(7,2));
    assertFalse("7,3", rook.isLegalMove(7,3));
    assertFalse("7,5", rook.isLegalMove(7,5));
    assertFalse("7,6", rook.isLegalMove(7,6));
    assertFalse("7,7", rook.isLegalMove(7,7));
    //
    assertFalse("0,0", rook.isLegalNonCaptureMove(0,0));
    assertFalse("0,1", rook.isLegalNonCaptureMove(0,1));
    assertFalse("0,2", rook.isLegalNonCaptureMove(0,2));
    assertFalse("0,3", rook.isLegalNonCaptureMove(0,3));
    assertFalse("0,5", rook.isLegalNonCaptureMove(0,5));
    assertFalse("0,6", rook.isLegalNonCaptureMove(0,6));
    assertFalse("0,7", rook.isLegalNonCaptureMove(0,7));
    //
    assertFalse("1,0", rook.isLegalNonCaptureMove(1,0));
    assertFalse("1,1", rook.isLegalNonCaptureMove(1,1));
    assertFalse("1,2", rook.isLegalNonCaptureMove(1,2));
    assertFalse("1,3", rook.isLegalNonCaptureMove(1,3));
    assertFalse("1,5", rook.isLegalNonCaptureMove(1,5));
    assertFalse("1,6", rook.isLegalNonCaptureMove(1,6));
    assertFalse("1,7", rook.isLegalNonCaptureMove(1,7));
    //
    assertFalse("2,0", rook.isLegalNonCaptureMove(2,0));
    assertFalse("2,1", rook.isLegalNonCaptureMove(2,1));
    assertFalse("2,2", rook.isLegalNonCaptureMove(2,2));
    assertFalse("2,3", rook.isLegalNonCaptureMove(2,3));
    assertFalse("2,5", rook.isLegalNonCaptureMove(2,5));
    assertFalse("2,6", rook.isLegalNonCaptureMove(2,6));
    assertFalse("2,7", rook.isLegalNonCaptureMove(2,7));
    //
    assertFalse("3,0", rook.isLegalNonCaptureMove(3,0));
    assertFalse("3,1", rook.isLegalNonCaptureMove(3,1));
    assertFalse("3,2", rook.isLegalNonCaptureMove(3,2));
    assertFalse("3,3", rook.isLegalNonCaptureMove(3,3));
    assertFalse("3,5", rook.isLegalNonCaptureMove(3,5));
    assertFalse("3,6", rook.isLegalNonCaptureMove(3,6));
    assertFalse("3,7", rook.isLegalNonCaptureMove(3,7));
    //
    assertFalse("5,0", rook.isLegalNonCaptureMove(5,0));
    assertFalse("5,1", rook.isLegalNonCaptureMove(5,1));
    assertFalse("5,2", rook.isLegalNonCaptureMove(5,2));
    assertFalse("5,3", rook.isLegalNonCaptureMove(5,3));
    assertFalse("5,5", rook.isLegalNonCaptureMove(5,5));
    assertFalse("5,6", rook.isLegalNonCaptureMove(5,6));
    assertFalse("5,7", rook.isLegalNonCaptureMove(5,7));
    //
    assertFalse("6,0", rook.isLegalNonCaptureMove(6,0));
    assertFalse("6,1", rook.isLegalNonCaptureMove(6,1));
    assertFalse("6,2", rook.isLegalNonCaptureMove(6,2));
    assertFalse("6,3", rook.isLegalNonCaptureMove(6,3));
    assertFalse("6,5", rook.isLegalNonCaptureMove(6,5));
    assertFalse("6,6", rook.isLegalNonCaptureMove(6,6));
    assertFalse("6,7", rook.isLegalNonCaptureMove(6,7));
    //
    assertFalse("7,0", rook.isLegalNonCaptureMove(7,0));
    assertFalse("7,1", rook.isLegalNonCaptureMove(7,1));
    assertFalse("7,2", rook.isLegalNonCaptureMove(7,2));
    assertFalse("7,3", rook.isLegalNonCaptureMove(7,3));
    assertFalse("7,5", rook.isLegalNonCaptureMove(7,5));
    assertFalse("7,6", rook.isLegalNonCaptureMove(7,6));
    assertFalse("7,7", rook.isLegalNonCaptureMove(7,7));
    //
    assertFalse("0,0", rook.isLegalCaptureMove(0,0));
    assertFalse("0,1", rook.isLegalCaptureMove(0,1));
    assertFalse("0,2", rook.isLegalCaptureMove(0,2));
    assertFalse("0,3", rook.isLegalCaptureMove(0,3));
    assertFalse("0,5", rook.isLegalCaptureMove(0,5));
    assertFalse("0,6", rook.isLegalCaptureMove(0,6));
    assertFalse("0,7", rook.isLegalCaptureMove(0,7));
    //
    assertFalse("1,0", rook.isLegalCaptureMove(1,0));
    assertFalse("1,1", rook.isLegalCaptureMove(1,1));
    assertFalse("1,2", rook.isLegalCaptureMove(1,2));
    assertFalse("1,3", rook.isLegalCaptureMove(1,3));
    assertFalse("1,5", rook.isLegalCaptureMove(1,5));
    assertFalse("1,6", rook.isLegalCaptureMove(1,6));
    assertFalse("1,7", rook.isLegalCaptureMove(1,7));
    //
    assertFalse("2,0", rook.isLegalCaptureMove(2,0));
    assertFalse("2,1", rook.isLegalCaptureMove(2,1));
    assertFalse("2,2", rook.isLegalCaptureMove(2,2));
    assertFalse("2,3", rook.isLegalCaptureMove(2,3));
    assertFalse("2,5", rook.isLegalCaptureMove(2,5));
    assertFalse("2,6", rook.isLegalCaptureMove(2,6));
    assertFalse("2,7", rook.isLegalCaptureMove(2,7));
    //
    assertFalse("3,0", rook.isLegalCaptureMove(3,0));
    assertFalse("3,1", rook.isLegalCaptureMove(3,1));
    assertFalse("3,2", rook.isLegalCaptureMove(3,2));
    assertFalse("3,3", rook.isLegalCaptureMove(3,3));
    assertFalse("3,5", rook.isLegalCaptureMove(3,5));
    assertFalse("3,6", rook.isLegalCaptureMove(3,6));
    assertFalse("3,7", rook.isLegalCaptureMove(3,7));
    //
    assertFalse("5,0", rook.isLegalCaptureMove(5,0));
    assertFalse("5,1", rook.isLegalCaptureMove(5,1));
    assertFalse("5,2", rook.isLegalCaptureMove(5,2));
    assertFalse("5,3", rook.isLegalCaptureMove(5,3));
    assertFalse("5,5", rook.isLegalCaptureMove(5,5));
    assertFalse("5,6", rook.isLegalCaptureMove(5,6));
    assertFalse("5,7", rook.isLegalCaptureMove(5,7));
    //
    assertFalse("6,0", rook.isLegalCaptureMove(6,0));
    assertFalse("6,1", rook.isLegalCaptureMove(6,1));
    assertFalse("6,2", rook.isLegalCaptureMove(6,2));
    assertFalse("6,3", rook.isLegalCaptureMove(6,3));
    assertFalse("6,5", rook.isLegalCaptureMove(6,5));
    assertFalse("6,6", rook.isLegalCaptureMove(6,6));
    assertFalse("6,7", rook.isLegalCaptureMove(6,7));
    //
    assertFalse("7,0", rook.isLegalCaptureMove(7,0));
    assertFalse("7,1", rook.isLegalCaptureMove(7,1));
    assertFalse("7,2", rook.isLegalCaptureMove(7,2));
    assertFalse("7,3", rook.isLegalCaptureMove(7,3));
    assertFalse("7,5", rook.isLegalCaptureMove(7,5));
    assertFalse("7,6", rook.isLegalCaptureMove(7,6));
    assertFalse("7,7", rook.isLegalCaptureMove(7,7));
    //
    KingPiece k1 = new KingPiece(board, ChessGame.Side.SOUTH, 3, 4);
    KingPiece k2 = new KingPiece(board, ChessGame.Side.SOUTH, 4, 3);
    KingPiece k3 = new KingPiece(board, ChessGame.Side.SOUTH, 4, 5);
    KingPiece k4 = new KingPiece(board, ChessGame.Side.SOUTH, 5, 4);
    board.addPiece(k1, 3, 4);
    board.addPiece(k2, 4, 3);
    board.addPiece(k3, 4, 5);
    board.addPiece(k4, 5, 4);
    assertFalse("South move max", rook.isLegalMove(7, 4));
    assertFalse("South move 2", rook.isLegalMove(6, 4));
    assertTrue("South move 1", rook.isLegalMove(5, 4));
    assertTrue("North move 1", rook.isLegalMove(3, 4));
    assertFalse("North move 2", rook.isLegalMove(2, 4));
    assertFalse("North move 3", rook.isLegalMove(1, 4));
    assertFalse("North move max", rook.isLegalMove(0, 4));
    //
    assertTrue("East move 1", rook.isLegalMove(4, 5));
    assertFalse("East move 2", rook.isLegalMove(4, 6));
    assertFalse("East move max", rook.isLegalMove(4, 7));
    assertTrue("West move 1", rook.isLegalMove(4, 3));
    assertFalse("West move 2", rook.isLegalMove(4, 2));
    assertFalse("West move 3", rook.isLegalMove(4, 1));
    assertFalse("West move max", rook.isLegalMove(4, 0));
    //
    assertFalse("South move max", rook.isLegalCaptureMove(7, 4));
    assertFalse("South move 2", rook.isLegalCaptureMove(6, 4));
    assertTrue("South move 1", rook.isLegalCaptureMove(5, 4));
    assertTrue("North move 1", rook.isLegalCaptureMove(3, 4));
    assertFalse("North move 2", rook.isLegalCaptureMove(2, 4));
    assertFalse("North move 3", rook.isLegalCaptureMove(1, 4));
    assertFalse("North move max", rook.isLegalCaptureMove(0, 4));
    //
    assertTrue("East move 1", rook.isLegalCaptureMove(4, 5));
    assertFalse("East move 2", rook.isLegalCaptureMove(4, 6));
    assertFalse("East move max", rook.isLegalCaptureMove(4, 7));
    assertTrue("West move 1", rook.isLegalCaptureMove(4, 3));
    assertFalse("West move 2", rook.isLegalCaptureMove(4, 2));
    assertFalse("West move 3", rook.isLegalCaptureMove(4, 1));
    assertFalse("West move max", rook.isLegalCaptureMove(4, 0));
    
    
    
  }
  
  // testing method for kings
  @Test
  public void KingTester(){
    SwingEuropeanChessDisplay display = new SwingEuropeanChessDisplay();
    EuropeanChess rules = new EuropeanChess();
    SwingChessBoard board = new SwingChessBoard(8, 8, display, rules);
    KingPiece king = new KingPiece(board, ChessGame.Side.NORTH, 4, 4);
    board.addPiece(king, king.getRow(), king.getColumn());
    assertEquals("LabelTest", "K", king.getLabel());
    assertEquals("rowTest", 4, king.getRow());
    assertEquals("ColumnTest", 4, king.getColumn());
    assertFalse("NotRowTest", king.getRow() == 3);
    assertFalse("NotColumnTest", king.getRow() == 3);
    //
    assertTrue("LegalityTest", king.isLegalMove(5,4));
    assertTrue("LegalityTest", king.isLegalMove(4,5));
    assertTrue("LegalityTest", king.isLegalMove(3,4));
    assertTrue("LegalityTest", king.isLegalMove(4,3));
    assertTrue("LegalityTest", king.isLegalMove(3,5));
    assertTrue("LegalityTest", king.isLegalMove(5,5));
    assertTrue("LegalityTest", king.isLegalMove(5,3));
    assertTrue("LegalityTest", king.isLegalMove(3,3));
    //
    assertTrue("LegalityTest", king.isLegalNonCaptureMove(5,4));
    assertTrue("LegalityTest", king.isLegalNonCaptureMove(4,5));
    assertTrue("LegalityTest", king.isLegalNonCaptureMove(3,4));
    assertTrue("LegalityTest", king.isLegalNonCaptureMove(4,3));
    assertTrue("LegalityTest", king.isLegalNonCaptureMove(3,5));
    assertTrue("LegalityTest", king.isLegalNonCaptureMove(5,5));
    assertTrue("LegalityTest", king.isLegalNonCaptureMove(5,3));
    assertTrue("LegalityTest", king.isLegalNonCaptureMove(3,3));
    RookPiece enemyRook = new RookPiece(board, ChessGame.Side.SOUTH, 4, 3);
    board.addPiece(enemyRook, 4, 3);
    assertTrue("CaptureTest", king.isLegalMove(4, 3));
  }
  
  @Test
  public void PawnTester(){
    SwingEuropeanChessDisplay display = new SwingEuropeanChessDisplay();
    EuropeanChess rules = new EuropeanChess();
    SwingChessBoard board = new SwingChessBoard(8, 8, display, rules);
    PawnPiece pawn = new PawnPiece(board, ChessGame.Side.NORTH, 4, 4);
    board.addPiece(pawn, pawn.getRow(), pawn.getColumn());
    assertEquals("LabelTest", "P", pawn.getLabel());
    assertEquals("rowTest", 4, pawn.getRow());
    assertEquals("ColumnTest", 4, pawn.getColumn());
    assertFalse("NotRowTest", pawn.getRow() == 3);
    assertFalse("NotColumnTest", pawn.getRow() == 3);
    assertFalse("MovedTest", pawn.getMoved());
    pawn.setMoved(true);
    assertTrue("SetMovedTest", pawn.getMoved());
    assertTrue("GetMovedTestTrue", pawn.getMoved());
    pawn.setMoved(false);
    assertFalse("GetMovedFalse", pawn.getMoved());
    //
    assertFalse("LeftTest", pawn.isLegalMove(4, 3));
    assertFalse("RightTest", pawn.isLegalMove(4, 5));
    assertFalse("BackwardsTest", pawn.isLegalMove(3, 4));
    assertTrue("OneForwardsTest", pawn.isLegalMove(5, 4));
    assertTrue("TwoMoveLegalTest", pawn.isLegalMove(6, 4));
    assertTrue("TwoMoveLegalTest", pawn.isLegalNonCaptureMove(6, 4));
    assertFalse("TwoMoveLegalTest", pawn.isLegalCaptureMove(6, 4));
    assertTrue("TwoSquareMoveTest", rules.makeMove(pawn, 6, 4));
    assertFalse("GoingBackwardsTest", pawn.isLegalMove(5, 4));
    RookPiece southRook = new RookPiece(board, ChessGame.Side.SOUTH, 5, 5);
    assertTrue("CaptureTest", rules.makeMove(pawn, 5, 5));
    PawnPiece pawn2 = new PawnPiece(board, ChessGame.Side.SOUTH, 1, 1);
    board.addPiece(pawn2, 1, 1);
  }
  
  @Test
  public void BishopTester(){
    SwingEuropeanChessDisplay display = new SwingEuropeanChessDisplay();
    EuropeanChess rules = new EuropeanChess();
    SwingChessBoard board = new SwingChessBoard(8, 8, display, rules);
    BishopPiece bishop = new BishopPiece(board, ChessGame.Side.NORTH, 4, 4);
    board.addPiece(bishop, bishop.getRow(), bishop.getColumn());
    assertEquals("LabelTest", "B", bishop.getLabel());
    assertEquals("rowTest", 4, bishop.getRow());
    assertEquals("ColumnTest", 4, bishop.getColumn());
    assertFalse("NotRowTest", bishop.getRow() == 3);
    assertFalse("NotColumnTest", bishop.getRow() == 3);
    assertTrue("MovementTestNW", bishop.isLegalMove(0, 0));
    assertTrue("MovementTestSE", rules.makeMove(bishop, 7, 7));
    assertTrue("MovementTestCenter", rules.makeMove(bishop, 4, 4));
    assertTrue("MovementTestSW", bishop.isLegalMove(5, 3));
    assertTrue("MovementTestNE", bishop.isLegalMove(3, 5));
    rules.makeMove(bishop, 4, 4);
    KingPiece k1 = new KingPiece(board, ChessGame.Side.SOUTH, 3, 3);
    KingPiece k2 = new KingPiece(board, ChessGame.Side.NORTH, 5, 5);
    board.addPiece(k1, 3, 3);
    board.addPiece(k2, 5, 5);
    assertFalse("BlockedMovementTest1", bishop.isLegalMove(2, 2));
    assertFalse("BlockedMovementTest1", bishop.isLegalCaptureMove(2, 2));
    assertFalse("BlockedMovementTest1", bishop.isLegalNonCaptureMove(2, 2));
    assertFalse("BlockedMovementTest1", rules.makeMove(bishop, 2, 2));
    assertFalse("BlockedMovementTest2", bishop.isLegalMove(6, 6));
    assertFalse("BlockedMovementTest2", bishop.isLegalCaptureMove(6, 6));
    assertFalse("BlockedMovementTest2", bishop.isLegalNonCaptureMove(6, 6));
    assertFalse("BlockedMovementTest2", rules.makeMove(bishop, 6, 6));
  }
  
  @Test
  public void QueenTester(){
    SwingEuropeanChessDisplay display = new SwingEuropeanChessDisplay();
    EuropeanChess rules = new EuropeanChess();
    SwingChessBoard board = new SwingChessBoard(8, 8, display, rules);
    QueenPiece queen = new QueenPiece(board, ChessGame.Side.NORTH, 4, 4);
    board.addPiece(queen, queen.getRow(), queen.getColumn());
    assertEquals("LabelTest", "Q", queen.getLabel());
    assertEquals("rowTest", 4, queen.getRow());
    assertEquals("ColumnTest", 4, queen.getColumn());
    assertFalse("NotRowTest", queen.getRow() == 3);
    assertFalse("NotColumnTest", queen.getRow() == 3);
    //
    assertTrue("MovementTestNWCorner", queen.isLegalMove(0, 0));
    assertTrue("MovementTestNWThree", queen.isLegalMove(1, 1));
    assertTrue("MovementTestNWTwo", queen.isLegalMove(2, 2));
    assertTrue("MovementTestNWOne", queen.isLegalMove(3, 3));
    assertTrue("MovementTestSEOne", queen.isLegalMove(5, 5));
    assertTrue("MovementTestSETwo", queen.isLegalMove(6, 6));
    assertTrue("MovementTestSECorner", queen.isLegalMove(7, 7));
    //
    assertTrue("MovementTestNWCorner", queen.isLegalNonCaptureMove(0, 0));
    assertTrue("MovementTestNWThree", queen.isLegalNonCaptureMove(1, 1));
    assertTrue("MovementTestNWTwo", queen.isLegalNonCaptureMove(2, 2));
    assertTrue("MovementTestNWOne", queen.isLegalNonCaptureMove(3, 3));
    assertTrue("MovementTestSEOne", queen.isLegalNonCaptureMove(5, 5));
    assertTrue("MovementTestSETwo", queen.isLegalNonCaptureMove(6, 6));
    assertTrue("MovementTestSECorner", queen.isLegalNonCaptureMove(7, 7));
    //
    assertTrue("MovementTestNWCorner", queen.isLegalCaptureMove(0, 0));
    assertTrue("MovementTestNWThree", queen.isLegalCaptureMove(1, 1));
    assertTrue("MovementTestNWTwo", queen.isLegalCaptureMove(2, 2));
    assertTrue("MovementTestNWOne", queen.isLegalCaptureMove(3, 3));
    assertTrue("MovementTestSEOne", queen.isLegalCaptureMove(5, 5));
    assertTrue("MovementTestSETwo", queen.isLegalCaptureMove(6, 6));
    assertTrue("MovementTestSECorner", queen.isLegalCaptureMove(7, 7));
  }
  
  @Test
  public void CastlingTest(){
    SwingEuropeanChessDisplay display = new SwingEuropeanChessDisplay();
    EuropeanChess rules = new EuropeanChess();
    SwingChessBoard board = new SwingChessBoard(8, 8, display, rules);
    RookPiece rook = new RookPiece(board, ChessGame.Side.NORTH, 0, 7);
    board.addPiece(rook, 0, 7);
    KingPiece king = new KingPiece(board, ChessGame.Side.NORTH, 0, 4);
    assertTrue(king.isLegalMove(0,6));
    assertEquals(king.getRow(), 0);
    assertEquals(king.getColumn(), 6);
    assertEquals(rook.getRow(), 0);
    assertEquals(rook.getColumn(), 5);
    board.removePiece(0, 6);
    board.removePiece(0, 5);
    KingPiece king2 = new KingPiece(board, ChessGame.Side.NORTH, 0, 4);
    RookPiece rook2 = new RookPiece(board, ChessGame.Side.NORTH, 0, 0);
    assertTrue(king.isLegalMove(0, 2));
    assertEquals(king.getRow(), 0);
    assertEquals(king.getColumn(), 2);
    assertEquals(rook.getRow(), 0);
    assertEquals(rook.getColumn(), 3);
  }
  
  @Test
  public void lastTest(){
    assertTrue(true);
  }
}