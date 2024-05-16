
package entities;

/**
 * @author Thaïs Genin
 */
public class Game {
    private int id_game;
    private String gameName;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Game{");
        sb.append("id_game=").append(id_game);
        sb.append(", gameName=").append(gameName);
        sb.append('}');
        return sb.toString();
    }

    public Game(int id_game, String gameName) {
        this.id_game = id_game;
        this.gameName = gameName;
    }

    public Game() {
    }

    public int getId_game() {
        return id_game;
    }

    public void setId_game(int id_game) {
        this.id_game = id_game;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

}
