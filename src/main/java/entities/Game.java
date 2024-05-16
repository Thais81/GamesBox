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
    @SuppressWarnings("serial")
    public abstract class Game extends JPanel implements Identifiable, Serializable {

        int id_game;
        String gameName;
        //No variables as it's an interface (can only have constant variables)

 
        public Integer getId_game() {
            return id_game;
        }

        ;
    public String getGameName() {
            return gameName;
        }

        public void setId_game(Integer id) {
            id_game = id;
        }

        public void setGameName(String name) {
            gameName = name;
        }

        abstract void start();

        abstract boolean win();
    }
