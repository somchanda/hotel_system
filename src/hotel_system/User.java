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
    private String lastName;
    private String firstName;
    private String email;
    private String phone;
    private int isAdmin;
    private int changePassword;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public My_Connection getCon() {
        return con;
    }

    public void setCon(My_Connection con) {
        this.con = con;
    }

    public Connection getMycon() {
        return mycon;
    }

    public void setMycon(Connection mycon) {
        this.mycon = mycon;
    }

    public void setChangePassword(int changePassword) {
        this.changePassword = changePassword;
    }

    public int getChangePassword() {
        return changePassword;
    }
    
    

    public User(int id, String username, String password, String lastName, String firstName, String email, String phone, int isAdmin) {
        this.mycon = con.createConnection();
        this.id = id;
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.isAdmin = isAdmin;
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
                this.setEmail(rs.getString("email"));
                this.setFirstName(rs.getString("first_name"));
                this.setLastName(rs.getString("last_name"));
                this.setPassword(rs.getString("password"));
                this.setPhone(rs.getString("phone"));
                this.setIsAdmin(rs.getInt("is_admin"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int changePassword(String password) {
        PreparedStatement ps;
        int status = 0;
        String sql = "update users set password = ?, change_password = 0 where id = ?";
        try {
            ps = mycon.prepareStatement(sql);
            ps.setString(1, password);
            ps.setInt(2, this.getId());
            status = ps.executeUpdate();
            if(status != 0){
                JOptionPane.showMessageDialog(null, "Password updated", "Changed password", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Your password not update", "Update problem", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Your password not update", "Update problem", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
    public boolean isAdmin(){
        boolean admin = false;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            ps = mycon.prepareStatement(sql);
            ps.setInt(1, this.getId());
            rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getInt("is_admin") == 1){
                    admin = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return admin;
    }
    
    public int insert(){
        String sql = "insert into users(first_name, last_name, email, phone, username, password, is_admin) values (?, ?, ?, ?, ?, ?, ?)";
        int status = 0;
        PreparedStatement ps;
        try {
            ps = mycon.prepareStatement(sql);
            ps.setString(1, this.getFirstName());
            ps.setString(2, this.getLastName());
            ps.setString(3, this.getEmail());
            ps.setString(4, this.getPhone());
            ps.setString(5, this.getUsername());
            ps.setString(6, this.getPassword());
            ps.setInt(7, this.getIsAdmin());
            status = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
    public boolean isChangePassword(){
        boolean change = false;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            ps = mycon.prepareStatement(sql);
            ps.setInt(1, this.getId());
            rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getInt("change_password") == 1){
                    change = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return change;
    }
}
