/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.HangmanWord;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thaïs GENIN
 */
public class HangmanWordDAO {

    public void create(HangmanWord word) {
        String sql = "INSERT INTO HangmanWord (word) VALUES (?)";
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS
                )) {
            pstmt.setString(1, word.getGuessed_word());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'insertion: " + e.getMessage());
        }
    }

    public HangmanWord getWordById(int id_HangmanWord) {
        String sql = "SELECT * FROM HangmanWord WHERE id_HangmanWord = ?";
        HangmanWord word = null;
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_HangmanWord);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                word = new HangmanWord(rs.getInt("id_HangmanWord"), rs.getString("guessed_word"));
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche: " + e.getMessage());

        }
        return word;
    }

    public List<HangmanWord> getAllWords() {
        String sql = "SELECT * FROM HangmanWord";
        List<HangmanWord> words = new ArrayList<>();
        try (Connection conn = ConnectionManager.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                HangmanWord word = new HangmanWord(rs.getInt("id_HangmanWord"), rs.getString("guessed_word"));
                words.add(word);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche: " + e.getMessage());
        }
        return words;
    }

    public void deleteWord(int id_HangmanWord) {
        String sql = "DELETE FROM HangmanWord WHERE id_HangmanWord = ?";
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_HangmanWord);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression: " + e.getMessage());

        }

    }

    public HangmanWord getRandomHangmanWord() throws SQLException {

        HangmanWord word = null;
        String sql = "SELECT * FROM HangmanWord ORDER BY RAND() LIMIT 1";
        try ( Connection conn = ConnectionManager.getConnection();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                word = new HangmanWord();
                word.setId_HangmanWord(rs.getInt("id_HangmanWord"));
                word.setGuessed_word(rs.getString("guessed_word"));
            }
        }
        return word;

    }

}
