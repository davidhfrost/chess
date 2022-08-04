/**
 * @author David Frost
 */
import javafx.application.*;
import javafx.application.Application.Parameters;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * a JavaFX representation of a chess board that can work with multiple types of chess.
 * This board's number of rows and columns are adjustable
 */
public class JavaFXChessBoard extends Application implements ChessBoard {


    private Scene scene;                          // the game board
    private GridPane gridPane;                    // the grid pane of the JavaFX graphics that buttons are in
    private Button[][] squares;                   // the squares of the board
    private ChessPiece[][] pieces;                 // stores the pieces
    private ChessGame gameRules;                   // global rules for this particular game
    private JavaFXChessBoardDisplay boardDisplay; // the display for the board
    private int numRows; // the number of rows on this chess board
    private int numColumns; // the number of columns on this chess board
    private boolean xiangqiIntended = false; // boolean to remember which type of chess is being played
    // rules for how to draw the chess board
    // boolean to keep track of whether the play wants to play Xiangqi or european chess
    /**
     * This is the primary method that drives the program, it first checks whether the player wants
     * to play Xiangqi or european chess. Next, it initializes the number of rows/columns/squares
     * based on that prior information and then creates a display for that specific type of chess.
     * After that, it places all of the squares into a grid and makes the squares responsive to clicks.
     * Finally, the pieces are all put into place, the GUI is displayed, and the game begins.
     * @param stage the stage upon which the action happens
     */
    public void start(Stage stage) throws NullPointerException{
        Parameters params = getParameters(); // the parameters for which chess game is to be played
        List<String> args = params.getRaw(); // a better form of the parameters
        // if the launch arguments contain xiangqi, the board is 10x9
        if (args.contains("xiangqi")){
            xiangqiIntended = true;
            numRows = 10;
            numColumns = 9;
            boardDisplay = new JavaFXXiangqiDisplay(10, 9);
            gameRules = new Xiangqi();
        }
        // if the launch arguments do not contain xiangqi, it is a european chess game and the board is 8x8
        else{
            xiangqiIntended = false;
            numRows = 8;
            numColumns = 8;
            gameRules = new EuropeanChess();
            boardDisplay = new JavaFXEuropeanChessDisplay(gameRules);
        }

        // initialize the board
        this.gameRules = gameRules;
        this.boardDisplay = boardDisplay;
        pieces = new ChessPiece[numRows][numColumns]; // creates storage for all of the pieces
        squares = new Button[numRows][numColumns];    // creates storage for all of the squares
        // the grid of buttons on the chess board
        GridPane buttonGrid = new GridPane();
        // the event handler for the buttons
        SquareHandler handler = new SquareHandler();

        // create a grid for the squares and the listener for the user clicks
        //ActionListener responder = new SwingChessBoard.ChessAction();

        // creates the squares
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                // puts a clickable button on each square
                squares[i][j] = new Button();
                // adds that button to the grid
                buttonGrid.add(squares[i][j], j, i);
                // displays the square
                boardDisplay.displayEmptySquare(squares[i][j], i, j);
                // there is not currently a piece on the square
                pieces[i][j] = null;
                squares[i][j].setPrefSize(75,100);
                // assigns the click handler to the square
                squares[i][j].setOnAction(handler);
            }
        }
        // puts all of the pieces on the board
        gameRules.startGame(this);
        // puts the grid onto the graphical display
        Scene scene = new Scene(buttonGrid, 800, 800);
        stage.setScene(scene);
        // displays the GUI
        stage.show();
        //board.setSize(boardDisplay.getSquareSize() * numColumns, boardDisplay.getSquareSize() * numRows);
        //board.setVisible(true);
        /*if (args.contains("xiangqi")){
            gameRules = new Xiangqi();
            Button[][] buttons = new Button[10][9];
            for (int i = 0; i < 10; i++){
                for (int j = 0; j < 9; j++){
                    Button currentButton = new Button();
                    currentButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {

                        }
                    });
                    buttons[i][j] = currentButton;
                }
            }
        }
        else {
            xiangqiIntended = false;
            gameRules = new EuropeanChess();
        }*/

    }

    /*@Override
    public void init() throws Exception {
        super.init();
        List<String> params = this.getParameters().getRaw();
        if (params.contains("xiangqi")){
            throw new Exception();
        }
        System.out.println(xiangqiOrNot);
    }*/

    /**
     * returns the game rules for this board, either Xiangqi or european chess
     * @return the rules for how games on this board should be played
     */
    @Override
    public ChessGame getGameRules() {
        return this.gameRules;
    }

    /**
     * setter method for the game rules for this board
     * @param newRules the new rules for the game
     */
    @Override
    public void setGameRules(ChessGame newRules) {
        this.gameRules = newRules;
    }

    /**
     * return the number of rows on this chess board. Xiangqi board have ten rows
     * and european chess boards have eight rows
     * @return the number of rows on this particular board
     */
    @Override
    public int numRows() {
        if (xiangqiIntended)
            return 10;
        else
            return 8;
    }

    /**
     * returns the number of columns on this chess board. Xiangqi boards have nine columns
     * and european chess boards have eight columns
     * @return the number of columns on the chessboard
     */
    @Override
    public int numColumns() {
        if (xiangqiIntended)
            return 9;
        else
            return 8;
    }

    public boolean squareThreatened(int row, int column, ChessPiece piece) {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                if (hasPiece(i,j) && getPiece(i, j).getSide() != piece.getSide() &&
                        getPiece(i, j).isLegalMove(row, column))
                    return true;
            }
        }
        return false;
    }

    public ChessPiece getPiece(int row, int col) {
        return pieces[row][col];
    }

    public boolean hasPiece(int row, int col) {
        return (pieces[row][col] != null);
    }

    public ChessPiece removePiece(final int row, final int col) {
        // remove the piece from the board, use the display rules to show an empty square,
        // and run the display code on the event dispatch thread
        ChessPiece save = pieces[row][col]; // the piece being removed
        pieces[row][col] = null; // deleting the piece from the board
        boardDisplay.displayEmptySquare(squares[row][col], row, col); // displaying the empty square
        return save; // returning the removed piece
    }

    public void addPiece(final ChessPiece piece, final int row, final int col) {
        // set the piece on the board, tell the piece where it is, and then use the display rules to display the square
        // run the display code on the event dispatch thread

        pieces[row][col] = piece;
        piece.setLocation(row, col);
        boardDisplay.displayFilledSquare(squares[row][col], row, col, piece);
        // run the code to change the display on the event dispatch to avoid drawing errors
    }

    /**
     * launches the chess application
     * @param args the version of chess to be played; either european or xiangqi
     */
    public static void main(String[] args){
        Application.launch(args);
        /*List<String> params = chessBoard.getParameters().getRaw();
        System.out.println(params);
        if (params != null && params.contains("xiangqi")){
            xiangqiOrNot = true;
        }*/
    }

    private class SquareHandler implements EventHandler<ActionEvent>{
        private boolean firstPick = true;  // if true, we a selecting a piece
        private int pieceRow;              // remember row of selected piece
        private int pieceCol;              // remember column of selected piece
        public void handle(ActionEvent squareClick){
            Button button = (Button)squareClick.getSource();
            int col = -1;
            int row = -1;

            // first find which button (board square) was clicked.
            for (int i = 0; i < squares.length; i++) {
                for (int j = 0; j < squares[i].length; j++) {
                    if (squares[i][j] == button) {
                        row = i;
                        col = j;
                    }
                }
            }

            if (firstPick) {
                processFirstSelection(row, col);
            }
            else {
                processSecondSelection(row, col);
            }
        }

        /**
         * What we do when the user chooses the piece to move.
         * @param row the row of the chosen piece
         * @param col the column of the chosen piece
         */
        private void processFirstSelection(int row, int col) {
            if ((pieces[row][col] != null) &&
                    (getGameRules() == null || getGameRules().legalPieceToPlay(pieces[row][col], row, col))) {
                /*
                 * if this is the first pick and a square with a piece was picked,
                 * remember the piece's location and highlight the square.
                 */
                pieceRow = row;
                pieceCol = col;
                boardDisplay.highlightSquare(true, squares[row][col], row, col, pieces[row][col]);
                firstPick = false;
            }
        }

        /**
         * What we do when the user chooses the square to move the piece to.
         * @param row the row the piece will move to
         * @param col the column the piece will move to
         */
        private void processSecondSelection(int row, int col) {
            if (row == pieceRow && col == pieceCol)
                return;

            boolean moveMade = getGameRules().makeMove(pieces[pieceRow][pieceCol], row, col);

            // if the move was made or if it was not made and the user select a new piece, then reset to choose a new move
            if (moveMade || getGameRules().canChangeSelection(pieces[pieceRow][pieceCol], pieceRow, pieceCol)) {
                boardDisplay.highlightSquare(false, squares[pieceRow][pieceCol], pieceRow, pieceCol, pieces[pieceRow][pieceCol]);
                firstPick = true;
            }
        }
    }
    
}
