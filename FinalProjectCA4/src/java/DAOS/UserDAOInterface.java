/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DTOS.User;
import java.util.List;

/**
 *
 * @author Dhruman
 */
interface UserDAOInterface {

    public List<User> getAllUsers();

    //  public User login (String fname,String lname,String password);
    public User getUserByEmailPassword(String email, String password);

   

    public boolean registerUser(User u);

    public int getUserStatus(String user_fname, String user_lname);

    public int disabling(User user);

    public boolean isUserAvailable(String user_fname, String user_lname, Boolean user_status);

    public User checkLogin(String user_fname, String user_lname, String user_password);

    public boolean checkIfUserIsAdmin(String uname);

}
