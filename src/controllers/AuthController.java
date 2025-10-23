/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import database.DatabaseConnection;
import models.User;
import utils.SessionManager;

import java.sql.*;
/**
 *
 * @author earlc
 */
public class AuthController {
    public static User login(String username, String passwordHash) {
        try (
                Connection conn = DatabaseConnection.getConnection(); 
                PreparedStatement ps = conn.prepareStatement("SELECT id, username, password_hash, full_name, role FROM users WHERE username = ?")) {
                    ps.setString(1, username);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        String hash = rs.getString("password_hash");
                        if (hash.equals(passwordHash)) {
                            User u = new User(rs.getInt("id"), rs.getString("username"), rs.getString("full_name"), rs.getString("role"));
                            SessionManager.setCurrentUser(u);
                            return u;
                        }
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean registerUser(String username, String passwordHash, String fullName) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO users(username, password_hash, full_name) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, passwordHash);
            ps.setString(3, fullName);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
