/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Play;
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
public class PlayDAO {

    public void createPlay(Play play) {
        String sql = "INSERT INTO Play (id_user, id_game, nb_win, nb_playedgames)" + "VALUES (?, ?, ?, ?) ";
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, play.getId_user());
            pstmt.setInt(2, play.getId_game());
            pstmt.setInt(3, play.getNb_playedgames());
            pstmt.setInt(4, play.getNb_win());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'insertion: " + e.getMessage());
        }
    }

    public List<Play> getPlaysByUserId(int id_user) {
        String sql = "SELECT * FROM Play WHERE id_user = ?";
        List<Play> plays = new ArrayList<>();
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_user);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Play play = new Play(rs.getInt("id_user"), rs.getInt("id_game"), rs.getInt("nb_win"), rs.getInt("nb_playedgames"));
                plays.add(play);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la selection: " + e.getMessage());
        }
        return plays;
    }

    public List<Play> getAllPlays() {
        String sql = "SELECT * FROM Play";
        List<Play> plays = new ArrayList<>();
        try (Connection conn = ConnectionManager.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Play play = new Play(rs.getInt("id_user"), rs.getInt("id_game"), rs.getInt("nb_win"), rs.getInt("nb_playedgames"));
                plays.add(play);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la selection: " + e.getMessage());
        }
        return plays;
    }

    public void updatePlay(Play play) {
        String sql = "UPDATE Play SET nb_win = ?, nb_playedgames = ? WHERE id_user = ? AND id_game = ?";
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, play.getNb_win());
            pstmt.setInt(2, play.getNb_playedgames());
            pstmt.setInt(3, play.getId_user());
            pstmt.setInt(4, play.getId_game());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification: " + e.getMessage());
        }
    }

    public void deletePlay(int id_user) {
        String sql = "DELETE FROM Play WHERE id_user = ?";
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_user);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression: " + e.getMessage());
        }
    }

}
