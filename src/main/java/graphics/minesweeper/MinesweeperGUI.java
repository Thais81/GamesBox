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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
        mines = new Minesweeper();
        firstClick = true;
        initGui();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture
        this.setResizable(true);
        this.pack();
        this.setLocationRelativeTo(null); // On positionne la fenêtre au milieu de l'écran
        this.setVisible(true); // Affichage de la fenêtre
    }

    private void initGui() {
        
        JPanel grid = new JPanel();
        Grid test = new Grid(8,8);
        mines.setGridGameplay(test);
        grid.setLayout(new GridLayout(mines.getGridGameplay().getHeight(), mines.getGridGameplay().getWidth()));
        for (Cell c : mines.getGridGameplay().getDisposition().values()){
            CellButton cell = new CellButton(c);
            cell.setPreferredSize(new Dimension(50,50));
            cell.getCell().setButton(cell);
            c.setButton(cell);
            cell.addActionListener(ae -> {
               System.out.println(mines.getGridGameplay().getDisposition().get(c.getPos()));
                if (firstClick){
                    mines.getGridGameplay().MinesRepartition(10, c.getPos());
                    firstClick = false;
                }
                if (mines.getGridGameplay().getDisposition().get(c.getPos()) instanceof MineCell)
                    cell.setText("M");
                else{
                    SafeCell tmp = new SafeCell(c.getPos());
                    tmp.setMinesAround(mines.getGridGameplay().CheckMinesAround(c.getPos()));
                    mines.getGridGameplay().getDisposition().replace(c.getPos(), tmp); 
                    if (tmp.getMinesAround() > 0){
                        cell.setText(String.valueOf(tmp.getMinesAround()));
                    }
                    else{
                        mines.getGridGameplay().getDisposition().replace(c.getPos(), cell.getCell());
                        List <Position> surrounding = mines.getGridGameplay().GetSurroundingPositions(c.getPos());
                        for (Position p : surrounding){
                            CellButton buttonAround = mines.getGridGameplay().getDisposition().get(p).getButton();
                            if (!buttonAround.isEnabled()){
                                continue;
                            }
                            buttonAround.doClick();
                        }
                        
                    }
                }
                cell.setEnabled(false);
            });
            grid.add(cell);
        }
       
        jp.add(grid);
        this.add(jp);
    }
    
   
    //Déclaré ici car l'évènement est appélé à la fois par le bouton de verification, mais aussi si on appui la touche Entrée dans le champ textuel
    /*void verifEvent (JTextField answer){
        int tmp;
                try {
                    tmp = parseInt(answer.getText());
                } catch (NumberFormatException e){
                    //Si dans le champ il a été saisi quelque chose qui n'est pas un nombre, on force une mauvaise réponse
                    tmp = calc.getResult()-1;
                }
                if (tmp == calc.getResult()){
                    JOptionPane.showMessageDialog(null, "C'est la bonne réponse !", "Congratulations", JOptionPane.PLAIN_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Mauvaise réponse, réessayez !", "Dommage", JOptionPane.WARNING_MESSAGE);
                }
    }
    */
}


