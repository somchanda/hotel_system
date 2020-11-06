/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Somchanda
 */
public class User {

    private int id;
    private String username;
    private String password;
    My_Connection con = new My_Connection();
    private Connection mycon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int id, String username, String password) {
        this.mycon = con.createConnection();
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User() {
        this.mycon = con.createConnection();
    }

    public void setUserById(int id) {
        try {
            PreparedStatement ps;
            ResultSet rs;

            String sql = "SELECT * FROM users WHERE id = ?";
            ps = mycon.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                this.setId(id);
                this.setUsername(rs.getString("username"));
                this.setPassword(rs.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void changePassword(String password) {
        PreparedStatement ps;
        String sql = "update users set password = ? where id = ?";
        try {
            ps = mycon.prepareStatement(sql);
            ps.setString(1, password);
            ps.setInt(2, this.getId());
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Password updated", "Changed password", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Your password not update", "Update problem", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
