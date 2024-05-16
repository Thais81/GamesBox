package entities;

import java.io.Serializable;

/**
 * @author Federico Manca
 */

@SuppressWarnings("serial")
public abstract class Game implements Identifiable, Serializable {
    protected int id_game;
    protected String gameName;
    protected int level;

    @Override
    public Integer getId(){
        return id_game;
    };
    public String getGameName(){
        return gameName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
