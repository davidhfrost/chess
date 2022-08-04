/**
 * @author David Frost
 * interface that checks whether a piece is trying to move to a column
 * outside of the three central columns
 */
public interface StayInThreeCenterColumns {

    /**
     *
     * @param numColumns the number of columns on the board
     * @param toColumn the column that the piece is trying to move to
     * @return whether the piece is moving out of the three central columns of the board
     */
    default public boolean isInCenterColumns(int numColumns, int toColumn){
        // int to keep track of which column is in the center
        int centerColumn = numColumns/2;
        /* if the column is either to the left of the three central columns
           or to the right, the piece is moving out of the three central columns
         */
        // otherwise, the piece is not moving out of the three central columns
        return toColumn >= centerColumn - 1 && toColumn <= centerColumn + 1;
    }
}
