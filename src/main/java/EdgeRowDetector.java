/**
 * interface that can detect if a piece is trying to move out of the six top or bottom rows of a board
 * @author DavidFrost
 */
public interface EdgeRowDetector {

    /**
     * determines whether a piece will remain in an edge row after a move
     * @param numColumns the number of columns on the board
     * @param toColumn the column that the piece is trying to move into
     * @return the legality of such a move considering the condition of whether it will be in an edge row
     */
    default public boolean isInEdgeRow(int numColumns, int toColumn){
        if (toColumn > 2 && toColumn < numColumns - 3){
            return false;
        }
        else{
            return true;
        }
    }
}
