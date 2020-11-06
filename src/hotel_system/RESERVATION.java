/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_system;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Somchanda
 */
public class RESERVATION {

    My_Connection mycon = new My_Connection();
    ROOM room = new ROOM();

    //add reservations
    public boolean addReservation(int client_id, int room_num, String dateIn, String dateOut) {
        PreparedStatement ps;
        ResultSet rs;
        String addQuery = "INSERT INTO reservation (client_id,room_num,date_in,date_out) values(?,?,?,?)";
        try {
            ps = mycon.createConnection().prepareStatement(addQuery);
            ps.setInt(1, client_id);
            ps.setInt(2, room_num);
            ps.setString(3, dateIn);
            ps.setString(4, dateOut);

            //return (ps.executeUpdate() > 0);
            if (room.isRoomToReserved(room_num).equals("No")) {
                if (ps.executeUpdate() > 0) {
                    room.setRoomToReserved(room_num, "Yes");
                    return true;
                } else {
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "this room is already reserved ","Room reserved",JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateReservation(int id, int client_id, int room_num, String dateIn, String dateOut,int current_room) {
        PreparedStatement ps;
        ResultSet rs;
        String updateQuery = "update reservation set client_id=?,room_num=?,date_in=?,date_out=? where id=?";
        try {
            ps = mycon.createConnection().prepareStatement(updateQuery);

            ps.setInt(1, client_id);
            ps.setInt(2, room_num);
            ps.setString(3, dateIn);
            ps.setString(4, dateOut);
            ps.setInt(5, id);
            room.setRoomToReserved(current_room, "No");
            room.setRoomToReserved(room_num, "Yes");
            return (ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean removeReservation(int id) {
        PreparedStatement ps;
        ResultSet rs;
        String DeleteQuery = "delete from reservation where id=?";
        try {
            ps = mycon.createConnection().prepareStatement(DeleteQuery);
            ps.setInt(1, id);
            int room_num = this.getRoomNumberFromReservation(id);
            if (ps.executeUpdate() > 0) {
                room.setRoomToReserved(room_num, "No");
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void fillReservationJtable(JTable table) {
        PreparedStatement ps;
        ResultSet rs;
        String selectQuery = "select * from reservation";
        try {
            ps = mycon.createConnection().prepareStatement(selectQuery);

            rs = ps.executeQuery();

            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

            Object[] row;
            while (rs.next()) {
                row = new Object[5];
                row[0] = rs.getInt(1);
                row[1] = rs.getInt(2);
                row[2] = rs.getInt(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    int getRoomNumberFromReservation(int reservationId) {
        PreparedStatement ps;
        ResultSet rs;
        String selectQuery = "select room_num from reservation where id = ?";
        try {
            ps = mycon.createConnection().prepareStatement(selectQuery);
            ps.setInt(1, reservationId);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }
}
