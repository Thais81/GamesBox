package graphics.minesweeper;

import entities.minesweeper.Cell;
import entities.minesweeper.MineCell;
import entities.minesweeper.Minesweeper;
import entities.minesweeper.Position;
import entities.minesweeper.SafeCell;
import graphics.Home;
import graphics.ReceptionPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Federico MANCA
 */

@SuppressWarnings("serial")
public class MinesweeperGUI extends JPanel{
    JPanel jp;
    Minesweeper mines;
    boolean firstClick;
    int flags;
    JPanel homePanel;

    public MinesweeperGUI() {
        mines = new Minesweeper();
        jp = new JPanel();
        initGui();
    }

    private void initGui() {
        mines.setUserInterface(this);
        mines.start();
        firstClick = true;
        flags = 0;
        jp.setLayout(new BorderLayout());
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        JLabel placedFlags = new JLabel(flags + " / " + mines.getNbMines(), SwingConstants.CENTER);
        Dimension placedFlagsDimension = new Dimension(150, 100);
        placedFlags.setMinimumSize(placedFlagsDimension);
        placedFlags.setMaximumSize(placedFlagsDimension);
        placedFlags.setPreferredSize(placedFlagsDimension);
        JButton playButton = new JButton("Nouvelle Partie");
        playButton.setPreferredSize(new Dimension(150, 30));
        playButton.setMaximumSize(new Dimension(150, 30));
        playButton.setMinimumSize(new Dimension(150, 30));
        playButton.addActionListener(ae -> {
            newPlay();
        });
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(mines.getGridGameplay().getHeight(), mines.getGridGameplay().getWidth()));
        for (Cell c : mines.getGridGameplay().getDisposition().values()){
            CellButton cell = new CellButton(c);
            cell.getCell().setButton(cell);
            c.setButton(cell);
            cell.addActionListener(ae -> {
                if (!cell.getCell().isIsFlagged()){
                    cell.setEnabled(false);
                    revealCells(cell);
                }
                if (mines.getGridGameplay().getFlaggedMines() == mines.getNbMines()) {
                    gameOver();
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
                            if (mines.getGridGameplay().getDisposition().get(cell.getCell().getPos()).isIsFlagged()) {
                                flags++;
                            } else {
                                flags--;
                            }
                            placedFlags.setText(flags + " / " + mines.getNbMines());
                            if (mines.getGridGameplay().getFlaggedMines() == mines.getNbMines()) {
                                gameOver();
                            }
                        }
                    }
                }
            });
            grid.add(cell);
        }
        grid.setBorder(new EmptyBorder(10, 10, 10, 10));
        rightPanel.setBorder(new EmptyBorder(0, 0, 0, 10));
        rightPanel.add(placedFlags);
        rightPanel.add(playButton);
        jp.add(grid, BorderLayout.CENTER);
        jp.add(rightPanel, BorderLayout.LINE_END);
        this.add(jp);
    }

    public void newPlay() {

        jp.removeAll();
        levelSelector();
        initGui();
        revalidate();
        repaint();
    }

    private void goHome() {
        jp.removeAll();
        homePanel = new ReceptionPanel();
        revalidate();
        repaint();
        homePanel.setVisible(true);
    }
    private void gameOver(){
        //Dans les deux cas, un bouton qui fait appel à newPlay
        Object[] options = {"Nouvelle Partie", "Accueil"};
        JPanel popUp = new JPanel();
        int result;
        String title;
        if (mines.win()){
            popUp.add(new JLabel("Vous avez gagné !"));
            title = "Bravo !";
        }
        else {
            popUp.add(new JLabel("Vous avez touché une mine"));
            title = "Dommage :c";
        }
        result = JOptionPane.showOptionDialog(null, popUp, title, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, null);

        if (result == JOptionPane.YES_OPTION) {
            newPlay();
        } else {
            goHome();
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

    private void levelSelector() {
        String[] levelText = {"Niveau 1 : 8x8 - 10 mines", "Niveau 2 : 10x10 - 40 mines", "Niveau 3 : 30x16 - 99 mines"};
        JRadioButton levels[] = new JRadioButton[levelText.length];
        ButtonGroup levelSelection = new ButtonGroup();
        for (int i = 0; i < levels.length; i++) {
            levels[i] = new JRadioButton(levelText[i]);
            levelSelection.add(levels[i]);
        }
        int result = JOptionPane.showConfirmDialog(
                null,
                levels,
                "Choisir une difficulté",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );
        if (result == JOptionPane.OK_OPTION) {
            // Find the selected option
            int selectedOption = -1;
            for (int i = 0; i < levels.length; i++) {
                if (levels[i].isSelected()) {
                    selectedOption = i;
                    break;
                }
            }
            if (selectedOption != -1) {
                // Adjust the level index by adding 1 (arrays are zero-based)
                // Here, 'selectedOption' will be 0, 1, or 2 based on the selected option
                mines.setLevel(selectedOption + 1);
            }
        }
    }
}


