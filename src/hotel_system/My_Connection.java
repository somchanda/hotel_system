/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_system;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Somchanda
 */
public class My_Connection {

    public Connection createConnection() {
        Connection con = null;
        MysqlDataSource mds = new MysqlDataSource();
        mds.setServerName("localhost");
        mds.setPortNumber(3308);
        mds.setUser("root");
        mds.setPassword("");
        mds.setDatabaseName("hotel_system");
        try {
            con = mds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(My_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public static boolean isAdmin(){
        User u = new User();
        u.setId(user_id);
        return u.isAdmin();
    }
    public static boolean isChangePassword(){
        User u =new User();
        u.setId(user_id);
        return u.isChangePassword();
    }
    public static int user_id;
    public static String username;
}
