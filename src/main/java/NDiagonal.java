/**
 * @author David Frost
 * determines whether a diagonal move of n distance is legal
 */
public interface NDiagonal {

    /**
     *
     * @param toRow the row of the desired move whose legality is to be determined
     * @param toColumn the column of the desired move whose legality is to be determined
     * @param piece the piece whose move's legality is yet to be determined
     * @return the legality of the desired move
     */
    default public boolean isLegalNDiagonalMove(int toRow, int toColumn, int n, ChessPiece piece){
        if (Math.abs(toRow - piece.getRow()) == n && Math.abs(toColumn - piece.getColumn()) == n){
            return true;
        }
        else{
            return false;
        }
    }

}
