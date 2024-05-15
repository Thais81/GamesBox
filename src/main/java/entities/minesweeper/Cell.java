package entities.minesweeper;

import graphics.minesweeper.CellButton;

/**
 *
 * @author Federico MANCA
 */
public class Cell {
    private Position pos;
    private boolean isRevealed;
    private CellButton button;

    
    
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
    
    public CellButton getButton() {
        return button;
    }

    public void setButton(CellButton button) {
        this.button = button;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cell{");
        sb.append("pos=").append(pos);
        sb.append(", isRevealed=").append(isRevealed);
        sb.append('}');
        return sb.toString();
    }
    
    
}
