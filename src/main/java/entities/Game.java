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
public class Game extends JPanel implements Identifiable, Serializable {
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

    public  void start(){}
    public  boolean win(){
        return false;
    }
}
