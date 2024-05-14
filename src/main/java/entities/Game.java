package entities;

import java.io.Serializable;

/**
 * @author Federico Manca
 */

@SuppressWarnings("serial")
public interface Game extends Serializable {
    //No variables as it's an interface (can only have constant variables)
    Integer getIdGame();
    String getGameName();
    void start();
    boolean win();
}
