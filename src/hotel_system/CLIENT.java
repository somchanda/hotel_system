/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_system;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Somchanda
 */
public class CLIENT {

    My_Connection mycon = new My_Connection();
    private int id;
    private String firtName;
    private String lastName;

    public CLIENT() {
    }

    public CLIENT(int id){
        this.id = id;
    }
    
    public CLIENT(int id, String firtName, String lastName) {
        this.id = id;
        this.firtName = firtName;
        this.lastName = lastName;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return getFirtName()+" "+ getLastName();
    }
    
    // popup when jtable click
    public String getFullName(int id){
        PreparedStatement ps;
        ResultSet rs;
        String sql = "select * from clients where id =?";
        try {
            ps = mycon.createConnection().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                String name = rs.getString("first_name") + " " +rs.getString("last_name");
                return name;
            }else{
                return "";
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        
        
    }
    
//get lastName id firstName
    public ResultSet loading(){
        PreparedStatement ps;
        String sql = "select id, first_name, last_name from clients";
        try {
            ps = mycon.createConnection().prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
//add client method
    public boolean addClient(String fname, String lname, String phone, String mail) {
        PreparedStatement ps;
        ResultSet rs;
        String addQuery = "INSERT INTO clients (first_name,last_name,phone,mail) values(?,?,?,?)";
        try {
            ps = mycon.createConnection().prepareStatement(addQuery);
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, phone);
            ps.setString(4, mail);
            return (ps.executeUpdate() > 0);
//            if (ps.executeUpdate() > 0) {
//                return true;
//            } else {
//                return false;
//            }
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //update client
    public boolean updateClient(int id, String fname, String lname, String phone, String mail) {
        PreparedStatement ps;
        ResultSet rs;
        String updateQuery = "update clients set first_name=?,last_name=?,phone=?,mail=? where id=?";
        try {
            ps = mycon.createConnection().prepareStatement(updateQuery);

            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, phone);
            ps.setString(4, mail);
            ps.setInt(5, id);
            return (ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //Remove selected cient
    public boolean removeClient(int id) {
        PreparedStatement ps;
        ResultSet rs;
        String DeleteQuery = "delete from clients where id=?";
        try {
            ps = mycon.createConnection().prepareStatement(DeleteQuery);
            ps.setInt(1, id);

            return (ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //populate data to table 
    public void fillClientJtable(JTable table) {
        PreparedStatement ps;
        ResultSet rs;
        String selectQuery = "select * from clients";
        try {
            ps = mycon.createConnection().prepareStatement(selectQuery);
            rs = ps.executeQuery();
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

            Object[] row;
            while (rs.next()) {
                row = new Object[5];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
