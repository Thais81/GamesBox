/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package entities;

import graphics.HangManPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jonathan DAH
 */
public class HangManTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HangManPanel());
    }
}
