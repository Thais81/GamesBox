/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import dao.HangmanWordDAO;
import entities.Game;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jonathan DAH
 */
public class HangManGame extends Game {

    Integer id_hangmanWord;
    String guessed_word;

    int nbr = (int) (Math.random() * 35);
    int wrongGuessCount = 0;
    int winOrLoose;
    JPanel haut = new JPanel();
    JPanel penduPanel = new JPanel();
    JPanel word = new JPanel();
    JLabel guessedWord = new JLabel(guessed_word);
    String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
        "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    JPanel keyboardPanel = new JPanel(new GridLayout(3, 9));
    JPanel StartGame = new JPanel();
    ImageIcon imageIcon1 = new ImageIcon("/home/stag/NetBeansProjects/projet-boite-de-jeux/ressources/Pendu_11.png");
    ImageIcon imageIcon2 = new ImageIcon("/home/stag/NetBeansProjects/projet-boite-de-jeux/ressources/Pendu_12.png");
    ImageIcon imageIcon3 = new ImageIcon("/home/stag/NetBeansProjects/projet-boite-de-jeux/ressources/Pendu_13.png");
    ImageIcon imageIcon4 = new ImageIcon("/home/stag/NetBeansProjects/projet-boite-de-jeux/ressources/Pendu_14.png");
    ImageIcon imageIcon5 = new ImageIcon("/home/stag/NetBeansProjects/projet-boite-de-jeux/ressources/Pendu_15.png");
    ImageIcon imageIcon6 = new ImageIcon("/home/stag/NetBeansProjects/projet-boite-de-jeux/ressources/Pendu_16.png");
    ImageIcon imageIcon7 = new ImageIcon("/home/stag/NetBeansProjects/projet-boite-de-jeux/ressources/Pendu_17.png");
    ImageIcon imageIcon8 = new ImageIcon("/home/stag/NetBeansProjects/projet-boite-de-jeux/ressources/Pendu_18.png");
    ImageIcon imageIcon9 = new ImageIcon("/home/stag/NetBeansProjects/projet-boite-de-jeux/ressources/Pendu_19.png");
    ImageIcon imageIcon10 = new ImageIcon("/home/stag/NetBeansProjects/projet-boite-de-jeux/ressources/Pendu_110.png");
    ImageIcon imageIcon11 = new ImageIcon("/home/stag/NetBeansProjects/projet-boite-de-jeux/ressources/Pendu_112.png");
    JLabel imgPendu = new JLabel(imageIcon11);

    ImageIcon[] tabImage = {imageIcon1, imageIcon2, imageIcon3, imageIcon4, imageIcon5, imageIcon6, imageIcon7, imageIcon8, imageIcon9, imageIcon10, imageIcon11};
    JButton[] keyboardButtons = new JButton[alphabet.length];
    JButton restartButton = new JButton("RESTART");



    public HangManGame() {
        DisplayRandomWord();
        initGui();
        win();

    }

    public void initGui() {
        setTitle("PENDU");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        /**
         * Haut de page*
         */
        JLabel titre = new JLabel("PENDU");
        titre.setFont(new Font("Serif", Font.BOLD, 45));
        titre.setAlignmentX(Component.CENTER_ALIGNMENT);
        haut.add(titre);
        add(titre);

        /**
         * JPanel pour l'image du pendu
         *
         */
        penduPanel.add(imgPendu);
        add(penduPanel);

        /**
         * Mot du Pendu 
         *
         */
        word.setPreferredSize(new Dimension(85, 85));
        word.add(guessedWord);
        add(word);

        /** JPanel pour le clavier virtuel*
         */

        for (int i = 0; i < alphabet.length; i++) {
            JButton button = new JButton(alphabet[i]);
            keyboardButtons[i] = button; // Ajoutez le bouton au tableau
            keyboardPanel.add(button);
        }
        add(keyboardPanel);

        StartGame.setLayout(new FlowLayout());
        StartGame.setPreferredSize(new Dimension(50, 50));
        StartGame.add(restartButton);
        add(StartGame);

        /**
         * GAME START*
         */
        //guessedWord.setText(hideWord(guessedWord.getText()));
            imgPendu.setIcon(imageIcon1);

        start();
        Restart();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void DisplayRandomWord() {
        try {
            HangmanWordDAO hdao = new HangmanWordDAO();
            HangmanWord word = hdao.getRandomHangmanWord();
            if (word != null) {
                guessed_word = word.getGuessed_word(); // Mettre à jour guessed_word avec le mot récupéré
                guessedWord.setText(hideWord(guessed_word)); // Mettre à jour le texte de guessedWord
                guessedWord.setFont(new Font("Serif", Font.BOLD, 30));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void Restart() {
        restartButton.addActionListener((ActionEvent ae) -> {
            imgPendu.setIcon(imageIcon1);
            for (JButton button : keyboardButtons) {
                button.setBackground(new JButton().getBackground());
            }
            guessedWord.setText("");
            DisplayRandomWord();

        });
    }

    public String hideWord(String myWord) {
        StringBuilder hiddenWord = new StringBuilder();
        for (int i = 0; i < myWord.length(); i++) {
            hiddenWord.append("_ ");
        }
        return hiddenWord.toString();
    }


    @Override
    public void start() {


        for (JButton button : keyboardButtons) {
            button.addActionListener((ActionEvent ae) -> {
                button.setBackground(Color.LIGHT_GRAY);
                // Je récupére la lettre associée au bouton
                String letter = button.getText();
                // Je vérifie si la lettre est dans le mot caché
                boolean letterFound = false;
                StringBuilder revealedWord = new StringBuilder(guessedWord.getText());

                for (int i = 0; i < guessed_word.length(); i++) {
                    if (letter.equals(String.valueOf(guessed_word.charAt(i)))) {
                        // La lettre a été trouvée, révéler la lettre dans le mot caché
                        revealedWord.setCharAt(i * 2, guessed_word.charAt(i));
                        letterFound = true;
                    }
                }

                if (!letterFound) {
                    wrongGuessCount++; // Incrémente le nombre d'erreurs
                    if (wrongGuessCount < tabImage.length) {
                        // Change l'image du pendu uniquement si le nombre d'erreurs est dans la limite du tableau d'images
                        imgPendu.setIcon(tabImage[wrongGuessCount]);
                    }
                    for (int i = 0; i < guessed_word.length(); i++) {
                        if (revealedWord.charAt(i * 2) == '_') {
                            revealedWord.setCharAt(i * 2, '_');
                        }
                    }

                }

                // Mise a jour du mot caché
                guessedWord.setText(revealedWord.toString());

                if (revealedWord.indexOf("_") == -1) {
                    String[] options = {"Restart"};
                    int choice = JOptionPane.showOptionDialog(null, "Vous avez gagné ! ", "Bravo!",
                            0, 1, null, options, options[0]);
                    if (choice == 0) {
                        DisplayRandomWord();
                        imgPendu.setIcon(imageIcon1);
                    }
                    winOrLoose = 1;
                    for (JButton mybutton : keyboardButtons) {
                        mybutton.setBackground(new JButton().getBackground());
                    }

                }
                if (imgPendu.getIcon().equals(imageIcon11)) {
                    String[] options = {"Restart"};
                    int choice = JOptionPane.showOptionDialog(null, "Vous avez perdu :( ! ", "Dommage!",
                            0, 0, null, options, options[0]);
                    if (choice == 0) {
                        DisplayRandomWord();
                        imgPendu.setIcon(imageIcon1);
                    }
                    winOrLoose = 0;
                    for (JButton mybutton : keyboardButtons) {
                        mybutton.setBackground(new JButton().getBackground());
                    }

                }
            });
        }

    }

    @Override
    public boolean win() {

        if (winOrLoose == 1) {
            return true;
        }
        else
            return false;

    }


}
