/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package entities;

import java.awt.LayoutManager;
import java.io.Serializable;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jonathan DAH
 */
public abstract class Game extends JFrame {

    Integer id_game;
    String name;
    int level;
    //boolean win;

    public abstract void start();

    public abstract boolean win();

    @SuppressWarnings("serial")
    public abstract class Game implements Identifiable, Serializable {

        int id_game;
        String gameName;
        //No variables as it's an interface (can only have constant variables)

        @Override
        public Integer getId() {
            return id_game;
        }

        ;
    public String getGameName() {
            return gameName;
        }

        @Override
        public void setId(Integer id) {
            id_game = id;
        }

        public void setGameName(String name) {
            gameName = name;
        }

        abstract void start();

        abstract boolean win();
    }
