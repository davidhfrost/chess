import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 * A class the displays a game of Xiangqi chess using a JavaFX graphical interface.
 * @author David Frost
 */
public class JavaFXXiangqiDisplay implements JavaFXChessBoardDisplay {

    // the number of rows in the Xiangqi game
    private final int rows;
    // the number of columns in the Xiangqi game
    private final int columns;

    /**
     * determines how to display an empty square on a JavaFXChessBoard for game of Xiangqi
     * @param button the button that represents a square on the  board
     * @param row    the row of the square on the board
     * @param column the column of the square on the board
     */
    @Override
    public void displayEmptySquare(Button button, int row, int column) {
        Insets insets = new Insets(3);
        button.setBackground(new Background(new BackgroundFill(colorDeterminer(row, column), CornerRadii.EMPTY, insets)));
        button.setText(null);
    }

    /**
     * determines how to display a square with a piece on it on a JavaFXChessBoard for a game of Xiangqi
     *
     * @param button the button that represents a square with it piece on it on the board
     * @param row    the horizontal location of the square on the board
     * @param column the vertical location of the square on the board
     * @param piece  the piece that is currently occupying the filled square on the board
     */
    @Override
    public void displayFilledSquare(Button button, int row, int column, ChessPiece piece) {
        // keeps track of which color a piece should be
        Color pieceColor;

        /* if a piece is north/east, it is red. If it is south/west, it is blue. The current
        version of this european chess game is only designed for north vs south games.
         */
        switch (piece.getSide()) {
            case NORTH:   pieceColor = Color.RED;
                break;
            case SOUTH:   pieceColor = Color.BLUE;
                break;
            case EAST:    pieceColor = Color.RED;
                break;
            default:      pieceColor = Color.BLUE;
        }
        // something to round out the corners
        CornerRadii cornerRadii = new CornerRadii(5);
        Insets insets = new Insets(2);

        button.setBackground(new Background(new BackgroundFill[]{new BackgroundFill(colorDeterminer(row, column), CornerRadii.EMPTY, new Insets(2)),
                new BackgroundFill(pieceColor, new CornerRadii(5), new Insets(5))}));
        // puts the label of the piece on the square to make it clear that there is a particular piece on the square
        button.setText(piece.getLabel());
        // makes the label of the piece neon green for maximum visibility
        button.setTextFill(Color.GREEN);
    }


    /**
     * getter method for rows
     * @return number of rows on display
     */
    public int getRows() {
        return rows;
    }

    /**
     * getter method for columns
     * @return number of columns on display
     */
    public int getColumns() {
        return columns;
    }


    /**
     * a private helper method that determines which color to display for a particular square
     * on a chess board
     * @param row the horizontal location of the square
     * @param column the vertical location of the square
     * @return the ideal color of the square
     */
    public Color colorDeterminer(int row, int column){
        if (row <= 2 || rows - row <= 2){
            return Color.LIGHTGRAY;
        }
        else{
            return Color.DARKGRAY;
        }
    }
    /**
     * The constructor for a JavaFXXiangqiDisplay. It determines the size of the display by looking
     * at the number of rows and columns
     * @param rows the number of rows on the board that is to be displayed
     * @param columns the number of columns on the board that is to be displayed
     */
    public JavaFXXiangqiDisplay(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }
}
