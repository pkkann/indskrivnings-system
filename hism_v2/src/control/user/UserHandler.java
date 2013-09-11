/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.user;

import date.ADate;
import model.User;

/**
 *
 * @author patrick
 */
public class UserHandler {
    
    private UserRegister userRegister;
    
    public UserHandler() {
        userRegister = new UserRegister();
    }
    
    public boolean usersIsEmpty() {
        return userRegister.isEmpty();
    }
    
    public void createUser(String email, String password, String firstname, String middlename, String lastname, ADate creationDate, boolean administrator, boolean reserve) {
        User u = new User(email, password, firstname, middlename, lastname, creationDate, administrator, reserve);
        userRegister.add(u);
        u.setId(userRegister.indexOf(u));
    }
    
    public User checkUser(String email, String password) {
        return userRegister.checkUser(email, password);
    }
    
    public boolean isEmailFree(String email) {
        return userRegister.isEmailFree(email);
    }
    
}
