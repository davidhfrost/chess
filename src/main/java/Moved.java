// interface to keep track of whether a chess piece has moved or not
// used for pawns, rooks, and kings
public interface Moved{
  
  // at the start of a game, a piece has not yet moved
  public abstract void setMoved(boolean newState);
  
  // getter method for moved field
  public abstract boolean getMoved();
  
}