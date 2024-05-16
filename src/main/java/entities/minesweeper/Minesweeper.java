package entities.minesweeper;

import entities.Game;

/**
 *
 * @author Federico Manca
 */
public class Minesweeper extends Game {
    
    private Grid gridGameplay;
    private int nbMines;

    public Minesweeper(int height, int width, int mines) {
        gridGameplay = new Grid(height, width);
        nbMines = mines;
    }
 
    
    public Grid getGridGameplay() {
        return gridGameplay;
    }

    public void setGridGameplay(Grid gridGameplay) {
        this.gridGameplay = gridGameplay;
    }
    
    @Override
    public void start(){
        //as soon as we implement difficutly levels.
    }
    
    @Override
    public boolean win(){
        if (gridGameplay.getFlaggedMines() == nbMines)
            return true;
        else
            return false;
    }

    public int getNbMines() {
        return nbMines;
    }

    public void setNbMines(int nbMines) {
        this.nbMines = nbMines;
    }


 
}
