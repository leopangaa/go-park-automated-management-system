/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author earlc
 */
public class Queries {
    public static final String INSERT_USER = "INSERT INTO users(username, password_hash, full_name) VALUES (?,?,?)";
    public static final String FIND_USER_BY_USERNAME = "SELECT id, username, password_hash, full_name, role FROM users WHERE username = ?";
}
