/**
 * a class that emulates the rules of a game of Xiangqi, typically played using 10x9 board
 * @author David Frost
 */
public class Xiangqi implements ChessGame{

    // field that remembers who gets to play this turn
    private ChessGame.Side currentSide = Side.NORTH;
    // an array to keep track of what pieces are xiangqi king pieces
    private ChessPiece[] kings = new ChessPiece[2];

    /**
     * getter method for whose turn it is
     * @return the side of the current player
     */
    public ChessGame.Side getCurrentSide(){
        return this.currentSide;
    }

    /**
     * a setter method for whose turn it is to play the game, typically alternating between the two players
     * @param newSide the new side whose turn it is to play
     */
    public void setCurrentSide(ChessGame.Side newSide){
        this.currentSide = newSide;
    }

    /**
     * determines whether the piece that a player has selected can be legally played
     * @param piece   the piece to be played
     * @param row     the row of the square the piece is on
     * @param column  the column of the square the piece is on
     * @return whether the piece can be legally played under any circumstances right now
     */
    public boolean legalPieceToPlay(ChessPiece piece, int row, int column){
        if (piece.getSide() == this.getCurrentSide()){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * moves a chess piece to the inputted location if the move is legal
     * @param piece     the piece to move
     * @param toRow     the row of the square the piece is moving to
     * @param toColumn  the column of the square the piece is moving to
     * @return whether the piece was moved
     */
    @Override
    public boolean makeMove(ChessPiece piece, int toRow, int toColumn){
        // first legality check: whether a move would lead to two kings facing off. That is not
        // legal in Xiangqi.
        //if (!facingKings(piece, toRow, toColumn))
          //  return false;
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

    /**
     * getter method for number of rows
     * @return the number of rows in Xiangqi
     */
    @Override
    public int getNumRows() {
        return 10;
    }

    /**
     * getter method for number of columns
     * @return the number of columns in Xiangqi
     */
    @Override
    public int getNumColumns() {
        return 9;
    }

    /**
     * starts a game of Xiangqi by putting all of the pieces on the board
     * and then giving control to the first player (the north player)
     * @param board the board needed to play the particular chess game
     */
    @Override
    public void startGame(ChessBoard board) {
        // the rules for the chess program
        Xiangqi rules = new Xiangqi();
        // the first side to play in the game
        rules.setCurrentSide(ChessGame.Side.NORTH);
        // the board upon which the game will be played. 8x8 grid by default
        //board = new SwingChessBoard(8, 8, (SwingChessBoardDisplay) display, this);
        // for loop that adds a lot of north pawns to the board
        for (int i = 0; i < 10; i += 2){
            board.addPiece(new SoldierPiece(board, ChessGame.Side.NORTH, 3, i), 3, i);
            board.addPiece(new SoldierPiece(board, ChessGame.Side.NORTH, 6, i), 6, i);
        }
        // the next four lines add the rooks to the board
        board.addPiece(new RookPiece(board, ChessGame.Side.NORTH, 0, 0), 0, 0);
        board.addPiece(new RookPiece(board, ChessGame.Side.NORTH, 0, 8), 0, 8);
        board.addPiece(new RookPiece(board, ChessGame.Side.SOUTH, 9, 0), 9, 0);
        board.addPiece(new RookPiece(board, ChessGame.Side.SOUTH, 9, 8), 9, 8);
        // next four lines add the cannons to the board
        board.addPiece(new CannonPiece(board, ChessGame.Side.NORTH, 2, 1), 2, 1);
        board.addPiece(new CannonPiece(board, ChessGame.Side.NORTH, 2, 7), 2, 7);
        board.addPiece(new CannonPiece(board, ChessGame.Side.SOUTH, 7, 1), 7, 1);
        board.addPiece(new CannonPiece(board, ChessGame.Side.NORTH, 7, 7), 7, 7);
        // next two lines add the king pieces to the board
        board.addPiece(new XiangqiKingPiece(board, ChessGame.Side.NORTH, 0, 5), 0, 5);
        board.addPiece(new XiangqiKingPiece(board, ChessGame.Side.SOUTH, 9, 5), 9, 5);
        // next four lines add the horse pieces to the board
        board.addPiece(new HorsePiece(board, ChessGame.Side.NORTH, 0, 1), 0, 1);
        board.addPiece(new HorsePiece(board, ChessGame.Side.NORTH, 0, 8), 0, 8);
        board.addPiece(new HorsePiece(board, ChessGame.Side.SOUTH, 9, 1), 9, 1);
        board.addPiece(new HorsePiece(board, ChessGame.Side.SOUTH, 9, 8), 9, 8);
        // next lines add the elephant pieces to the board
        board.addPiece(new ElephantPiece(board, ChessGame.Side.NORTH, 0, 2), 0, 2);
        board.addPiece(new ElephantPiece(board, ChessGame.Side.NORTH, 0, 6), 0, 6);
        board.addPiece(new ElephantPiece(board, ChessGame.Side.SOUTH, 9, 6), 9, 6);
        board.addPiece(new ElephantPiece(board, ChessGame.Side.SOUTH, 9, 2), 9, 2);
        // next four lines add the guard pieces to the board
        board.addPiece(new GuardPiece(board, ChessGame.Side.NORTH, 0, 4), 0, 4);
        board.addPiece(new GuardPiece(board, ChessGame.Side.NORTH, 0, 6), 0, 6);
        board.addPiece(new GuardPiece(board, ChessGame.Side.SOUTH, 9, 4), 9, 4);
        board.addPiece(new GuardPiece(board, ChessGame.Side.SOUTH, 9, 6), 9, 6);
        kings[0] = (ChessPiece)board.getPiece(0,5);
        kings[1] = (ChessPiece)board.getPiece(9,5);
    }

    /**
     * Determines whether two kings are facing off given a particular move. This is important for
     * determining the legality of a piece, as a piece may not move in Xiangqi if it will
     * lead to the facing off of the two kings.
     * @param movingPiece the piece that may be moved that could affect the facing of kings
     * @param toRow the row to which the piece may be moved
     * @param toColumn the column to which the piece may be moved
     * @return whether a move would lead to a facing kings situation
     */
    private boolean facingKings(ChessPiece movingPiece, int toRow, int toColumn) {
        // since there are always two kings, no if statement is necessary to check whether there are two kings
        /* if the two kings are not on the same column, they cannot be facing off. Thus, an
        if statement checking their columns is the first thing that should be checked to avoid wasted time */
        if (kings[0] == null || kings[1] == null || kings[0].getColumn() != kings[1].getColumn())
            return false;
        // the lowest row of either of the two kings
        int lowerRow = Math.min(kings[0].getRow(), kings[1].getRow());
        // the highest row of either of the two kings
        int upperRow = Math.max(kings[0].getRow(), kings[1].getRow());
        /* boolean that keeps track of whether there is a blocking piece between the two kings
        other than the piece that may be moved. */
        boolean blockingPieceAvailable = false;
        /* loop that goes through the spaces between the two kings to see if there are any pieces other
        than the piece that might be moved that are blocking the two kings. If there are, this will
        be noted. If not, nothing is changed.*/
        for (int i = lowerRow; i < upperRow; i++){
            if (kings[0].getChessBoard().hasPiece(i,kings[0].getColumn())
                && kings[0].getChessBoard().getPiece(i,kings[0].getColumn()).equals(movingPiece) == false){
                blockingPieceAvailable = true;
            }
        }
        /* if there is a blocking piece other than the moving piece, any move by the moving piece is legal
        and will not lead to two kings facing each other. */
        if (blockingPieceAvailable)
            return false;
        /* if the piece is not changing its column position and is only moving its row position, the
         move is always legal and will not lead to the two kings facing off*/
        else if (toColumn - movingPiece.getColumn() == 0)
            return false;
        // any other situation will lead to the two kings facing off and is illegal
        else
            return true;

    }
}