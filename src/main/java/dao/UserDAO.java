/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.User;
import jakarta.persistence.TransactionRequiredException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thaïs GENIN
 */
public class UserDAO {

    public void Create(User user) {
        String sql = "INSERT INTO User (login, password, mail ) "
                + " VALUES (?, ?, ?) ";
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql,
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, user.getLogin());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getMail());
            int nbLines = pstmt.executeUpdate();
            if (nbLines == 1) {
                ResultSet autoGeneratedKeys = pstmt.getGeneratedKeys();
                autoGeneratedKeys.first();
                int id_user = autoGeneratedKeys.getInt(1);
                user.setId_user(id_user);
            }

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la création du compte: " + ex.getMessage());
        }
    }

    public User ReadUser(int id_user) {
        User user = null;
        String sql = "SELECT * FROM User WHERE id_user=?";
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_user);
            ResultSet rs = pstmt.executeQuery();
            if (rs.first()) {
                user = new User();
                user.setId_user(rs.getInt("id_user"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setMail(rs.getString("mail"));
            } else {
                System.out.println("Aucun utilisateur trouvé avec l'ID: " + id_user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, "Erreur lors de la lecture de l'utilisateur avec l'ID: " + id_user, ex);
        }
        return user;
    }
    
    public User ReadUser(String login) {
        User user = null;
        String sql = "SELECT * FROM User WHERE login=?";
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, login);
            ResultSet rs = pstmt.executeQuery();
            if (rs.first()) {
                user = new User();
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setMail(rs.getString("mail"));
                user.setId_user(rs.getInt("id_user"));
            } else {
                System.out.println("Aucun utilisateur trouvé avec ce login: " + login);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, "Erreur lors de la lecture de l'utilisateur avec le login: " + login, ex);
        }
        return user;
    }

    

    public List<User> ReadAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM User";
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId_user(rs.getInt("id_user"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setMail(rs.getString("mail"));
                users.add(user);
            }
        } catch (SQLException ex) {
            System.err.println("Erreur lors du comptage : " + ex.getMessage());
        }
        return users;
    }

    public void Update(User user) {
        String sql = "UPDATE User SET login = ? , password = ? , mail = ?"
                + "WHERE id_user = ?";
        try (Connection conn = ConnectionManager.getConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, user.getId_user());//  On ne peut pas changer l'id puisqu'auto incrémenté
            pstmt.setString(2, user.getLogin());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getMail());
            pstmt.executeUpdate();
            System.out.println("Compte utilisateur modifié");
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.lang.IllegalStateException | java.lang.IllegalArgumentException | TransactionRequiredException e) {
            System.err.println(e.getMessage());
        }
    }

    public void Delete(int id_user) {
        String sql = "DELETE FROM User WHERE id_user = ?";
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_user);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur lors du delete : " + ex.getMessage());
        }
    }
}