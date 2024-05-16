/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Thaïs GENIN
 */
public class Play {
    private int id_user;
    private int id_game;
    private int nb_win;
    private int nb_playedgames;

    public Play() {

    }
    public Play(int id_user, int id_game, int nb_win, int nb_playedgames) {
        this.id_user = id_user;
        this.id_game = id_game;
        this.nb_win = nb_win;
        this.nb_playedgames = nb_playedgames;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Play{");
        sb.append("id_user=").append(id_user);
        sb.append(", id_game=").append(id_game);
        sb.append(", nb_win=").append(nb_win);
        sb.append(", nb_playedgames=").append(nb_playedgames);
        sb.append('}');
        return sb.toString();
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_game() {
        return id_game;
    }

    public int getNb_win() {
        return nb_win;
    }

    public void setNb_win(int nb_win) {
        this.nb_win = nb_win;
    }

    public int getNb_playedgames() {
        return nb_playedgames;
    }

    public void setNb_playedgames(int nb_playedgames) {
        this.nb_playedgames = nb_playedgames;
    }

}
