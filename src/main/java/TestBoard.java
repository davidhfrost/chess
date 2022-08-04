/**
 * @author David Frost
 * a test chess board used for testing piece without any graphical display
 */
public class TestBoard implements ChessBoard {

    private ChessPiece[][] pieces;                 // stores the pieces
    private ChessGame gameRules;                   // global rules for this particular game
    private JavaFXChessBoardDisplay boardDisplay; // the display for the board
    private int numRows; // the number of rows on this chess board
    private int numColumns; // the number of columns on this chess board
    private boolean xiangqiIntended = false; // boolean to remember which type of chess is being played
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
        for (int i = 0; i < numRows(); i++) {
            for (int j = 0; j < numColumns(); j++) {
                if (hasPiece(i,j) && getPiece(i, j).getSide() != piece.getSide() &&
                        getPiece(i, j).isLegalMove(row, column))
                    return true;
            }
        }
        return false;
    }

    /**
     * getter method for a piece
     * @param row   the row for the piece
     * @param col   the column for the piece
     * @return the piece
     */
    public ChessPiece getPiece(int row, int col) {
        return pieces[row][col];
    }

    /**
     * checks whether there is a piece on a square
     * @param row   the row to examine
     * @param col   the column to examine
     * @return whether a piece is there
     */
    public boolean hasPiece(int row, int col) {
        return (pieces[row][col] != null);
    }

    /**
     * method to remove a piece from a square
     * @param row  the row of the piece
     * @param col  the column of the piece
     * @return whether the piece has been removed
     */
    public ChessPiece removePiece(final int row, final int col) {
        // remove the piece from the board, use the display rules to show an empty square,
        // and run the display code on the event dispatch thread
        ChessPiece save = pieces[row][col]; // the piece being removed
        pieces[row][col] = null; // deleting the piece from the board
        return save; // returning the removed piece
    }

    /**
     * method to add a piece to a square
     * @param piece   the piece to add
     * @param row     the row for the piece
     * @param col     the column for the piece
     */
    public void addPiece(final ChessPiece piece, final int row, final int col) {
        // set the piece on the board, tell the piece where it is, and then use the display rules to display the square
        // run the display code on the event dispatch thread

        pieces[row][col] = piece;
        piece.setLocation(row, col);
        // run the code to change the display on the event dispatch to avoid drawing errors
    }

    /**
     * creates a testing chess board
     */
    public TestBoard(){
        xiangqiIntended = true;
        numRows = 10;
        numColumns = 9;
        boardDisplay = new JavaFXXiangqiDisplay(10, 9);
        gameRules = new Xiangqi();
        // initialize the board
        this.gameRules = gameRules;
        this.boardDisplay = boardDisplay;
        pieces = new ChessPiece[numRows][numColumns]; // creates storage for all of the pieces
        // the event handler for the buttons

        // create a grid for the squares and the listener for the user clicks
        //ActionListener responder = new SwingChessBoard.ChessAction();
        // puts all of the pieces on the board
        gameRules.startGame(this);
        // puts the grid onto the graphical display
    }

}
