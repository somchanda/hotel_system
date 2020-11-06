/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_system;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Somchanda
 */
public class ROOM {

    My_Connection mycon = new My_Connection();
//retrive room id
    public ResultSet getId(){
        PreparedStatement ps ;
        ResultSet rs;
        String sql = "Select r_number from rooms";
        try {
            ps = mycon.createConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ROOM.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    //fill data to jtable room type
    public void fillRoomTypeJtable(JTable table) {
        PreparedStatement ps;
        ResultSet rs;
        String selectQuery = "select * from room_type";
        try {
            ps = mycon.createConnection().prepareStatement(selectQuery);

            rs = ps.executeQuery();

            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

            Object[] row;
            while (rs.next()) {
                row = new Object[3];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //method to fill combo with room id

    public void fillRoomTypeJcombo(JComboBox combo) {
        PreparedStatement ps;
        ResultSet rs;
        String selectQuery = "select * from room_type";
        try {
            ps = mycon.createConnection().prepareStatement(selectQuery);

            rs = ps.executeQuery();

            while (rs.next()) {
                combo.addItem(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //method to add new room
    public boolean addRoom(int r_num, int type, String phone) {
        PreparedStatement ps;
        //ResultSet rs;
        String addQuery = "INSERT INTO rooms (r_number,type,phone,reserved) values(?,?,?,?)";
        try {
            ps = mycon.createConnection().prepareStatement(addQuery);
            ps.setInt(1, r_num);
            ps.setInt(2, type);
            ps.setString(3, phone);
            ps.setString(4, "No");

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
    //fill data to jtable 

    public void fillRoomJtable(JTable table) {
        PreparedStatement ps;
        ResultSet rs;
        String selectQuery = "select * from rooms";
        try {
            ps = mycon.createConnection().prepareStatement(selectQuery);

            rs = ps.executeQuery();

            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

            Object[] row;
            while (rs.next()) {
                row = new Object[4];
                row[0] = rs.getInt(1);
                row[1] = rs.getInt(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //method to update room

    public boolean updateRoom(int r_num, int type, String phone, String reserved) {
        PreparedStatement ps;
        ResultSet rs;
        String updateQuery = "update rooms set type=?,phone=?,reserved=? where r_number=?";
        try {
            ps = mycon.createConnection().prepareStatement(updateQuery);

            ps.setInt(1, type);
            ps.setString(2, phone);
            ps.setString(3, reserved);
            ps.setInt(4, r_num);

            return (ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean removeRoom(int r_num) {
        PreparedStatement ps;
        ResultSet rs;
        String DeleteQuery = "delete from rooms where r_number=?";
        try {
            ps = mycon.createConnection().prepareStatement(DeleteQuery);
            ps.setInt(1, r_num);

            return (ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean setRoomToReserved(int r_num, String reserved) {
        PreparedStatement ps;
        ResultSet rs;
        String updateQuery = "update rooms set reserved=? where r_number=?";
        try {
            ps = mycon.createConnection().prepareStatement(updateQuery);
            
            ps.setString(1, reserved);
            ps.setInt(2, r_num);

            return (ps.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
     public String isRoomToReserved(int r_num) {
        PreparedStatement ps;
        ResultSet rs;
        String selectQuery = "select reserved from rooms where r_number=?";
        try {
            ps = mycon.createConnection().prepareStatement(selectQuery);
        
            ps.setInt(1, r_num);
            rs= ps.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }else{
                return "";
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
     }
}
