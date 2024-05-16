package graphics.minesweeper;

import entities.minesweeper.Cell;
import entities.minesweeper.Grid;
import entities.minesweeper.MineCell;
import entities.minesweeper.Minesweeper;
import entities.minesweeper.Position;
import entities.minesweeper.SafeCell;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Federico MANCA
 */
public class MinesweeperGUI extends JFrame{
    JPanel jp;
    Minesweeper mines;
    boolean firstClick;
    
    public MinesweeperGUI(){
        jp = new JPanel();
        initGui();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture
        this.setResizable(true);
        this.pack();
        this.setLocationRelativeTo(null); // On positionne la fenêtre au milieu de l'écran
        this.setVisible(true); // Affichage de la fenêtre
    }

    private void initGui() {
        mines = new Minesweeper(16, 30, 99);
        firstClick = true;
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(mines.getGridGameplay().getHeight(), mines.getGridGameplay().getWidth()));
        for (Cell c : mines.getGridGameplay().getDisposition().values()){
            CellButton cell = new CellButton(c);
            cell.setPreferredSize(new Dimension(50,50));
            cell.getCell().setButton(cell);
            c.setButton(cell);
            cell.addActionListener(ae -> {
                if (!cell.getCell().isIsFlagged()){
                    cell.setEnabled(false);
                    revealCells(cell);
                }
            });
            cell.addMouseListener(new MouseAdapter(){
                @Override
                public void mousePressed(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        if (cell.isEnabled()){
                            mines.getGridGameplay().getDisposition().get(cell.getCell().getPos()).toggleIsFlagged();
                            cell.setText((mines.getGridGameplay().getDisposition().get(cell.getCell().getPos()).isIsFlagged() ? "F": ""));
                            if (mines.getGridGameplay().getDisposition().get(cell.getCell().getPos()) instanceof MineCell)
                                mines.getGridGameplay().MinesFlaggedCounter(cell.getCell().getPos());
                        };
                    }
                }
            });
            grid.add(cell);
        }
        jp.add(grid);
        this.add(jp);
    }
    
    private void newPlay(){
        jp.removeAll();
        initGui();
        revalidate();
        repaint();
    }
    
    private void gameOver(){
        //Dans les deux cas, un bouton qui fait appel à newPlay
        if (mines.win()){
            //JOptionPane de victoire
        }
        else{
            newPlay();
            //JOptionPane de défaite
        }
    }
    
    private void revealCells(CellButton cell){
        if (firstClick){
            mines.getGridGameplay().MinesRepartition(mines.getNbMines(), cell.getCell().getPos());
            firstClick = false;
        }
        if (mines.getGridGameplay().getDisposition().get(cell.getCell().getPos()) instanceof MineCell){
            cell.setText("M");
            gameOver();
        }
        else{
            SafeCell tmp = new SafeCell(cell.getCell().getPos());
            tmp.setButton(cell);
            tmp.setMinesAround(mines.getGridGameplay().CheckMinesAround(cell.getCell().getPos()));
            mines.getGridGameplay().getDisposition().replace(cell.getCell().getPos(), tmp); 
            if (tmp.getMinesAround() > 0){
                cell.setText(String.valueOf(tmp.getMinesAround()));
            }
            else{
                mines.getGridGameplay().getDisposition().replace(cell.getCell().getPos(), cell.getCell());
                List <Position> surrounding = mines.getGridGameplay().GetSurroundingPositions(cell.getCell().getPos());
                for (Position p : surrounding){
                    CellButton buttonAround = mines.getGridGameplay().getDisposition().get(p).getButton();
                    if (buttonAround!= null && buttonAround.isEnabled()){
                        buttonAround.doClick();
                    }
                }
            }
        }
    }
}


