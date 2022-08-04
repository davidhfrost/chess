import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 * @author David Frost
 */
public interface JavaFXChessBoardDisplay {

    /**
     * determines how to display an empty square on a JavaFXChessBoard
     * @param button the button that represents a square on the  board
     * @param row the row of the square on the board
     * @param column the column of the square on the board
     */
    void displayEmptySquare(Button button, int row, int column);

    /**
     *  determines how to display a square with a piece on it on a JavaFXChessBoard
     * @param button the button that represents a square with it piece on it on the board
     * @param row the horizontal location of the square on the board
     * @param column the vertical location of the square on the board
     * @param piece the piece that is currently occupying the filled square on the board
     */
    void displayFilledSquare(Button button, int row, int column, ChessPiece piece);

    /**
     * Adds or removes highlights for a square. This is useful for displaying squares that the
     * player has selected to show which piece they are trying to move.
     * @param highlight false if the square should be de-highlighted, true if it should be highlighted
     * @param button the square of the board whose highlighting state may be changed
     * @param row the horizontal location of the square on the board
     * @param column the vertical location of the square on the board
     * @param piece the piece that is dwelling on the square that may be highlighted
     */
    default public void highlightSquare(boolean highlight, Button button, int row, int column, ChessPiece piece){
        // if the piece is to be highlighted, the entire square is made bright green
        if (highlight) {
            button.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY))); //placeholder
        }
        /* if there is not a piece on the square, it is empty and must be displayed as such. Thus,
        it is not highlighted. */
        else if (piece == null)
            displayEmptySquare(button, row, column);
        /* otherwise, the square is filled but is not supposed to be highlighted, and
        should be treated like a regular filled square that has not been clicked.
         */
        else
            displayFilledSquare(button, row, column, piece);
    }

    /**
     * a private helper method that determines which color to display for a particular square
     * on a chess board
     * @param row the horizontal location of the square
     * @param column the vertical location of the square
     * @return the ideal color of the square
     */
    Color colorDeterminer(int row, int column);
}
