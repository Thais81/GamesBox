/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package entities;

import java.awt.LayoutManager;
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

}
