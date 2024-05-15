package entities.minesweeper;

import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Federico MANCA
 */
public class Grid {
    private int height;
    private int width;
    private Map <Position, Cell> disposition;
    
    public Grid(int h, int w){
        height = h;
        width = w;
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
                if (!(x == center.getX() && y == center.getY())){
                    Position tmpPos = new Position(x,y);
                    surrounding.add(tmpPos);
                }
            }
        }
        return surrounding;
    }
    
    public void MinesRepartition(int nbMines, Position firstClick){
        int counter = 0;
        Position randPos;
        List <Position> firstClickArea = GetSurroundingPositions(firstClick);
        while (counter < nbMines){  
            do{
                int randX, randY;
                randX = (int)(random() * width);
                randY = (int)(random() * height);
                randPos = new Position(randX, randY);
            } while (!firstClickArea.contains(randPos));
            if (!(disposition.get(randPos) instanceof MineCell)){
                MineCell tmp = new MineCell(randPos);
                disposition.replace(randPos, tmp);
                counter++; 
            }                     
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
}
