package entities.minesweeper;

import entities.Game;
import graphics.minesweeper.MinesweeperGUI;

/**
 *
 * @author Federico Manca
 */
public class Minesweeper extends Game {

    private Minesweeper instance;
    private Grid gridGameplay;
    private int nbMines;
    //This will be used when custom user difficulty will be added
    private MinesweeperGUI userInterface;


    public Minesweeper() {

    }


    public Grid getGridGameplay() {
        return gridGameplay;
    }

    public void setGridGameplay(Grid gridGameplay) {
        this.gridGameplay = gridGameplay;
    }

    @Override
    public void start() {
        switch (level) {
            case 1:
                gridGameplay = new Grid(8, 8);
                nbMines = 10;
                break;
            case 2:
                gridGameplay = new Grid(10, 10);
                nbMines = 40;
                break;
            case 3:
                gridGameplay = new Grid(16, 30);
                nbMines = 99;
                break;
            default:
                gridGameplay = new Grid(8, 8);
                nbMines = 10;
        }
    }

    @Override
    public boolean win(){
        return (gridGameplay.getFlaggedMines() == nbMines);
    }

    public int getNbMines() {
        return nbMines;
    }

    public void setNbMines(int nbMines) {
        this.nbMines = nbMines;
    }

    public MinesweeperGUI getUserInterface() {
        return userInterface;
    }

    public void setUserInterface(MinesweeperGUI userInterface) {
        this.userInterface = userInterface;
    }


}
