package entities.minesweeper;

import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Federico MANCA
 */
public class Grid {
    private int height;
    private int width;
    private Map <Position, Cell> disposition;
    private int flaggedMines;
    
    public Grid(int h, int w){
        height = h;
        width = w;
        disposition = new TreeMap();
        flaggedMines = 0;
        for (int x = 1; x <= width; x++){
            for (int y = 1; y <= height; y++){
                Position tmpPos = new Position(x,y);
                Cell tmp = new Cell(tmpPos);
                disposition.put(tmpPos, tmp);
            }
        }
    }
    
    public List<Position> GetSurroundingPositions(Position center){
        List <Position> surrounding = new ArrayList();
        for (int x = center.getX()-1; x <= center.getX()+1; x++){
            for (int y = center.getY()-1; y <= center.getY()+1; y++){ 
                if (!(CheckForOutOfGrid(x, width) || CheckForOutOfGrid(y, height))){
                    Position tmpPos = new Position(x,y);
                    surrounding.add(tmpPos);
                }
            }
        }
        return surrounding;
    }
    
    public boolean CheckForOutOfGrid(int i, int check){
        return (i == 0 || i > check);
    }
    
    public void MinesRepartition(int nbMines, Position firstClick){
        Position randPos;
        List <Position> firstClickArea = GetSurroundingPositions(firstClick);
        List <Position> validPositions = new ArrayList <>(disposition.keySet());
        validPositions.removeAll(firstClickArea);
        for (int i = 0; i < nbMines; i++){  
            int randIdx = (int)(random()*validPositions.size());
            randPos = validPositions.get(randIdx);
            validPositions.remove(randIdx);
            MineCell tmp = new MineCell(randPos);
            disposition.replace(randPos, tmp);
        }
    }
    
    public int CheckMinesAround(Position center){
        int counter = 0;
        List <Position> surroundingArea = GetSurroundingPositions(center);
        for (Position p : surroundingArea){
            if (disposition.get(p) instanceof MineCell)
                counter++;
        }
        return counter;
    }
    
    /* Redundant - MineSweeperGUI does the same
    public boolean RevealCase(Position selection){
        //Method will skip everything if the case is already revealed
        if (!disposition.get(selection).isIsRevealed()){
            disposition.get(selection).setIsRevealed(true);
            //Check for mine
            if (disposition.get(selection) instanceof MineCell){
                return true;
            }
            else{
                SafeCell safe = new SafeCell(selection);
                safe.setMinesAround(CheckMinesAround(selection));
                disposition.replace(selection, safe);
                //If no minesAround, reveal all the other hidden cases
                if (safe.getMinesAround() == 0){
                    List <Position> surrounding = GetSurroundingPositions(selection);
                    for (Position p : surrounding){
                        RevealCase(p);
                    }
                }                    
           }
        }
        return false;
    }
    */
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Map <Position, Cell> getDisposition() {
        return disposition;
    }

    public void setDisposition(Map <Position, Cell> disposition) {
        this.disposition = disposition;
    }

    public int getFlaggedMines() {
        return flaggedMines;
    }

    public void setFlaggedMines(int flaggedMines) {
        this.flaggedMines = flaggedMines;
    }
    
    public void MinesFlaggedCounter(Position pos){
        if (disposition.get(pos).isIsFlagged())
            flaggedMines++;
        else
            flaggedMines--;
    }
}
