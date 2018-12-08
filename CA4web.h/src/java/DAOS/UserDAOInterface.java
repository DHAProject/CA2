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
 * @author HaiKuo
 */
interface UserDAOInterface {
    
    public List<User> findAllMembers();

    public User Login (String uname, String password);

    public boolean insertUser(User user);

    public int updateUser(User user);

    public boolean deleteUser(String user_username);
    
    public User checkIfUserExists(int user_id);
    
    public int getUserType (String user_username);
    
}
