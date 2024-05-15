package entities.minesweeper;

/**
 *
 * @author Federico MANCA
 */
public class MineCell extends Cell{
    public MineCell(Position pos){
        super(pos);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" This is a Mine.");
        return sb.toString();
    }
    
}
