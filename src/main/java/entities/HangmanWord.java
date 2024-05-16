/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Thaïs GENIN
 */
public class HangmanWord {
    private int id_HangmanWord;
    private String guessed_word;

    public HangmanWord() {
    }

    public HangmanWord(int id_HangmanWord, String guessed_word) {
        this.id_HangmanWord = id_HangmanWord;
        this.guessed_word = guessed_word;
    }


    public HangmanWord(String guessed_word) {
        this.guessed_word = guessed_word;
    }

    public int getId_HangmanWord() {
        return id_HangmanWord;
    }
    public void setId_HangmanWord(int id_HangmanWord) {
        this.id_HangmanWord = id_HangmanWord;
    }

    public String getGuessed_word() {
        return guessed_word;
    }

    public void setGuessed_word(String guessed_word) {
        this.guessed_word = guessed_word;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HangmanWord{");
        sb.append("id_HangmanWord=").append(id_HangmanWord);
        sb.append(", guessed_word=").append(guessed_word);
        sb.append('}');
        return sb.toString();
    }


}
