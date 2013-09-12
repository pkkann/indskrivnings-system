/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.user;

import date.ADate;
import db.DBTool;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author patrick
 */
public class UserDAO {

    private Connection conn;

    public UserDAO() {
        conn = DBTool.getInstance();
    }

    public void insertUser(User u) throws SQLException {
        Statement s = conn.createStatement();
        int id = u.getId();
        String email = u.getEmail();
        String password = u.getPassword();
        String firstname = u.getFirstname();
        String middlename = u.getMiddlename();
        String lastname = u.getLastname();
        String creationDate = u.getCreationDate().toString();
        int administrator = 0;
        int reserve = 0;

        if (u.isAdministrator()) {
            administrator = 1;
        }
        if (u.isReserve()) {
            reserve = 1;
        }

        s.execute("INSERT INTO user (id, email, password, firstname, middlename, lastname, creationdate, administrator, reserve) "
                + "VALUES('" + id + "', '" + email + "', '" + password + "', '" + firstname + "', '" + middlename + "', '" + lastname + "', '" + creationDate + "', '" + administrator + "', '" + reserve + "')");
        s.close();
    }
    
    public ArrayList<User> getAllUsers() throws SQLException {
        Statement s = conn.createStatement();
        ArrayList<User> users = new ArrayList<>();
        
        ResultSet rs = s.executeQuery("SELECT * FROM user");
        while(rs.next()) {
            int id = rs.getInt("id");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String firstname = rs.getString("firstname");
            String middlename = rs.getString("middlename");
            String lastname = rs.getString("lastname");
            ADate creationDate = new ADate(rs.getString("creationdate"));
            boolean administrator = false;
            boolean reserve = false;
            if(rs.getInt("administrator") == 1) {
                administrator = true;
            }
            if(rs.getInt("reserve") == 1) {
                reserve = true;
            }
            User u = new User(email, password, firstname, middlename, lastname, creationDate, administrator, reserve);
            u.setId(id);
            users.add(id, u);
        }
        
        return users;
    }
}
