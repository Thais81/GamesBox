package entities.minesweeper;

import entities.Game;

/**
 *
 * @author Federico Manca
 */
public class Minesweeper extends Game {
    
    private Grid gridGameplay;
    private boolean gameStarted;
    int nbMines;
    //redundant.
 

    public Grid getGridGameplay() {
        return gridGameplay;
    }

    public void setGridGameplay(Grid gridGameplay) {
        this.gridGameplay = gridGameplay;
    }
    
    @Override
    public void start(){
        //Level will determine the grid size
        gridGameplay = new Grid(16, 30);
    }
    
    @Override
    public boolean win(){
        if (true)
        //if winCondition
            return true;
        else
            return false;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }
 
}
