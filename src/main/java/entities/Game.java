package entities;

import java.io.Serializable;

/**
 * @author Federico Manca
 */

@SuppressWarnings("serial")
public abstract class Game implements Identifiable, Serializable {
    int id_game;
    String gameName;
    //No variables as it's an interface (can only have constant variables)
    @Override
    public Integer getId(){
        return id_game;
    };
    public String getGameName(){
        return gameName;
    }
    @Override
    public void setId(Integer id){
        id_game = id;
    }
    public void setGameName(String name){
        gameName = name;
    }
    public abstract void start();
    public abstract boolean win();
}
