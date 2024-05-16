package graphics.minesweeper;

import entities.minesweeper.Cell;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JButton;

/**
 *
 * @author Federico MANCA
 */
public class CellButton extends JButton{
    private Cell cell;

    public CellButton(Cell c) {
        this.setPreferredSize(new Dimension(40, 40));
        this.setMargin(new Insets(0, 0, 0, 0));

        this.cell = c;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }



}
