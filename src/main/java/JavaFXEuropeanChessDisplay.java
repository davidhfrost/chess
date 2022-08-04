import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import javax.swing.*;

/**
 * a display that visually repsents a game of european chess (the most common type of chess)
 * on a JavaFX graphical interface.
 * @author David Frost
 */
public class JavaFXEuropeanChessDisplay implements JavaFXChessBoardDisplay {

    private int rows;    // the number of rows on the JavaFXEuropeanChessDisplay
    private int columns; // the number of columns on the JavaFXEuropeanChessDisplay

    /**
     * determines how an empty square on a european JavaFX chess board should be displayed
     * @param button the button that represents a square on the  board
     * @param row the row of the square on the board
     * @param column the column of the square on the board
     */
    @Override
    public void displayEmptySquare(Button button, int row, int column) {
        /*if ((row + column) % 2 == 0){
            button.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, CornerRadii.EMPTY, Insets.EMPTY)));
        }
        else{
            button.setBackground(new Background(new BackgroundFill(Color.DARKOLIVEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        }*/
        // sets the color of the empty square
        button.setBackground(new Background(new BackgroundFill(colorDeterminer(row, column), CornerRadii.EMPTY, Insets.EMPTY)));
        // sets the text to be null to make it clear that there is not a piece on the square
        button.setText(null);
    }

    /**
     * determines how a filled square on a european JavaFX chess board should be displayed
     * @param button the button that represents a square with it piece on it on the board
     * @param row the horizontal location of the square on the board
     * @param column the vertical location of the square on the board
     * @param piece the piece that is currently occupying the filled square on the board
     */
    @Override
    public void displayFilledSquare(Button button, int row, int column, ChessPiece piece) {
        // keeps track of which color a piece should be
        Color pieceColor;

        /* if a piece is north/east, it is white. If it is south/west, it is black. The current
        version of this european chess game is only designed for north vs south games.
         */
        switch (piece.getSide()) {
            case NORTH:   pieceColor = Color.WHITE;
                break;
            case SOUTH:   pieceColor = Color.BLACK;
                break;
            case EAST:    pieceColor = Color.WHITE;
                break;
            default:      pieceColor = Color.BLACK;
        }
        // something to round out the corners
        CornerRadii cornerRadii = new CornerRadii(5);
        Insets insets = new Insets(5);
        button.setBackground(new Background(new BackgroundFill[]{new BackgroundFill(colorDeterminer(row, column), CornerRadii.EMPTY, Insets.EMPTY),
                new BackgroundFill(pieceColor, cornerRadii, insets)}));
        // puts the label of the piece on the square to make it clear that there is a particular piece on the square
        button.setText(piece.getLabel());
        // makes the label of the piece neon green for maximum visibility
        button.setTextFill(Color.GREEN);
    }

    /**
     * private getter method that returns the number of rows
     * @return number of rows on the chess display
     */
    private int getRows(){
        return rows;
    }

    private int getColumns(){
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
        // simple algorithm that returns one of two colors
        if ((row + column) % 2 == 0){
            return Color.BLANCHEDALMOND;
            //return new Background(new BackgroundFill(Color.BLANCHEDALMOND, CornerRadii.EMPTY, Insets.EMPTY));
        }
        else{
            return Color.DARKOLIVEGREEN;
            //return new Background(new BackgroundFill(Color.DARKOLIVEGREEN, CornerRadii.EMPTY, Insets.EMPTY));
        }

    }

    /**
     * the constructor for a JavaFXEuropeanChessDisplay. Takes a set of rules
     * and then determines how many rows and columns are needed for that type of chess.
     * @param rules the type of chess that is to be played on this board
     */
    public JavaFXEuropeanChessDisplay(ChessGame rules){
        rows = rules.getNumRows();
        columns = rules.getNumColumns();
    }
}
