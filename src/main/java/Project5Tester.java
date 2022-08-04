import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;
public class Project5Tester {

    @Test
    public void XiangqiChessUnitTester(){
       TestBoard board = new TestBoard();
        Xiangqi rules = new Xiangqi();
        // the first side to play in the game
        rules.setCurrentSide(ChessGame.Side.NORTH);
        // the board upon which the game will be played. 8x8 grid by default
        //board = new SwingChessBoard(8, 8, (SwingChessBoardDisplay) display, this);
        // for loop that adds a lot of north pawns to the board
        for (int i = 0; i < 10; i += 2){
            board.addPiece(new SoldierPiece(board, ChessGame.Side.NORTH, 3, i), 3, i);
            board.addPiece(new SoldierPiece(board, ChessGame.Side.SOUTH, 6, i), 6, i);
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

        for (int i = 0; i < 10; i += 2){
            assertTrue(board.getPiece(3,i).isLegalMove(4,i));
            assertTrue(board.getPiece(6,i).isLegalMove(5,i));
            assertFalse(board.getPiece(6,i).isLegalMove(4,i));
            assertFalse(board.getPiece(3,i).isLegalMove(5,i));
        }
        SoldierPiece soldier = new SoldierPiece(board, ChessGame.Side.NORTH, 3, 1);
        rules.makeMove(soldier, 4, 1);
        soldier = (SoldierPiece) board.getPiece(4,1);
        assertFalse(rules.makeMove(soldier, 4, 2));
        rules.makeMove(soldier, 5, 1);
        assertTrue(soldier.isLegalMove(6,1));
        rules.makeMove(soldier, 6, 1);
        soldier.setCrossedRiver();
        assertTrue(soldier.isLegalMove(6,2));
        assertTrue(soldier.isLegalMove(6,0));
    }
}
