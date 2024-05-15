package graphics.minesweeper;

import entities.minesweeper.Cell;
import entities.minesweeper.Position;
import javax.swing.JButton;

/**
 *
 * @author Federico MANCA
 */
public class CellButton extends JButton{
    private Cell cell;

    public CellButton(Cell c) {
        
        this.cell = c;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
    
    
    
}
