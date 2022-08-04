import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * <p>Creates a chessboard in a window on the desktop.  The ChessBoard has a ChessBoardDisplay object that determines
 * how the individual squares of the chessboard should be drawn.</p>
 * 
 * <p>The chessboard uses a ChessGame object to determine how the game should be played.  The way the chessboard works
 * is as follows.  The player selects a piece by clicking on the board, and
 * and the chessboard calls the <tt>legalPieceToPlay</tt> method of the ChessGame object.
 * If the player is allowed to select the piece, the board highlights it, and the player can select another square on
 * the board.  The chessboard then calls the <tt>makeMove</tt> method of the ChessGame object.  The ChessGame is 
 * responsible for determining if the move is valid, and if it is to update the game and the chessboard
 * with the results of making that move.</p>
 * 
 * @author Harold Connamacher
 */
public interface ChessBoard {
  
  /*private JFrame board;                          // the game board
  private JButton[][] squares;                   // the squares of the board*/
  /*private ChessPiece[][] pieces;                 // stores the pieces
  private ChessGame gameRules;                   // global rules for this particular game
  private ChessBoardDisplay boardDisplay;        // rules for how to draw the chess board*/

  /**
   * Builds a board of the desired size, the display parameters, and the rules for the chess game.
   *
   * @param numRows      the number of rows for the chessboard
   * @param numColumns   the number of columns for the chessboard
   * @param boardDisplay an object that determines how the squares on the chessboard should be drawn
   * @param gameRules    an object that determines when player selection is valid and to update the game with the result of a move
   */
  //public ChessBoard(final int numRows, final int numColumns, ChessBoardDisplay boardDisplay, ChessGame gameRules);

  /**
   * Returns the rules of the game.
   * @return the rules of the game
   */
  ChessGame getGameRules();
  
  /**
   * Changes the rules of the game
   * @param newRules the new rules for the game
   */
  void setGameRules(ChessGame newRules);

  /**
   * Returns the number of rows in the board.
   * @return the number of rows
   */
  int numRows();

  /**
   * Returns the number of columns in the board.
   * @return the number of columns
   */
  int numColumns();
  
  /**
   *  Adds a piece to the board at the desired location.  Any piece currently
   *  at that location is lost.
   *  @param piece   the piece to add
   *  @param row     the row for the piece
   *  @param col     the column for the piece
   */

  // set the piece on the board, tell the piece where it is, and then use the display rules to display the square
  // run the display code on the event dispatch thread
  public abstract void addPiece(final ChessPiece piece, final int row, final int col);
  /**
   *  Removes a piece from the board
   *  @param row  the row of the piece
   *  @param col  the column of the piece
   *  @return  the piece removed of null if there was no piece at that square
   */
  ChessPiece removePiece(final int row, final int col);
    // remove the piece from the board, use the display rules to show an empty square,
    // and run the display code on the event dispatch thread
  
  /**
   *  Returns true if there is a piece at a specific location of the board.
   *  @param row   the row to examine
   *  @param col   the column to examine
   *  @return   true if there is a piece a this row and column and false
   *            if the square is empty
   */
  boolean hasPiece(int row, int col);
  
  /**
   *  Returns the chess piece at a specific location on the board.
   *  @param row   the row for the piece
   *  @param col   the column for the piece
   *  @return      the piece at the row and column or null if there is no piece there.
   */
  ChessPiece getPiece(int row, int col);
  
  /** The code the responds when the user clicks on the game board */

  
  /**
   * Returns true if a particular square is threatened by an opposing piece.
   * @param row     the row of the square
   * @param column  the column of the square
   * @param piece   a piece of the game
   * @return  true if the square can be attacked by a piece of an opposing side as the parameter piece
   */
  boolean squareThreatened(int row, int column, ChessPiece piece);
}


