package entities.minesweeper;

/**
 *
 * @author Federico MANCA
 */

public class SafeCell extends Cell{
    private int minesAround;
    
    public SafeCell(Position pos){
        super(pos);
        this.setIsRevealed(true);
    }
    
    public int getMinesAround() {
        return minesAround;
    }

    public void setMinesAround(int minesAround) {
        this.minesAround = minesAround;
    }
    
}
