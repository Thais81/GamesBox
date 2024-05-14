package entities;

import java.io.Serializable;

/**
 * @author Federico Manca
 */

@SuppressWarnings("serial")
public abstract class Game implements Serializable {
    int id_game;
    String gameName;
    //No variables as it's an interface (can only have constant variables)
    Integer getIdGame(){
        return id_game;
    };
    String getGameName(){
        return gameName;
    }
    void setIdGame(int id){
        id_game = id;
    }
    void setGameName(String name){
        gameName = name;
    }
    abstract void start();
    abstract boolean win();
}
