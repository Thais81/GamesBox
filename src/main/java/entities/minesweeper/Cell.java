package entities.minesweeper;

/**
 *
 * @author Federico MANCA
 */
public class Cell {
    private Position pos;
    private boolean isRevealed;
    
    public Cell(Position P){
        this.pos = P;
        isRevealed = false;
    }
    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public boolean isIsRevealed() {
        return isRevealed;
    }

    public void setIsRevealed(boolean isRevealed) {
        this.isRevealed = isRevealed;
    }
    
}
