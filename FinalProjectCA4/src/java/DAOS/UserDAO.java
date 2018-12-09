/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DTOS.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HaiKuo
 */
public class UserDAO extends DAO implements UserDAOInterface {

    public UserDAO(String databaseName) {
        super(databaseName);
    }

    /**
     * get the users informatino from database
     */
    @Override
    public List<User> getAllUsers() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList();

        try {
            con = getConnection();

            String query = "Select * from user ";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                User u = new User(rs.getInt("User_id"), rs.getString("user_fname"), rs.getString("user_lname"), rs.getString("user_password"), rs.getString("user_phoneno"), rs.getString("user_email"),
                        rs.getBoolean("user_isadmin"), rs.getBoolean("user_status"));
                users.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllUsers() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getAllUsers() method: " + e.getMessage());
            }
        }

        return users;
    }

    /**
     * get type status og users
     */
    @Override
    public int getUserStatus(String user_fname, String user_lname) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int type = 0;

        try {
            con = getConnection();

            String query = "Select stauts from users WHERE user_fname = ? &&  user_lname = ? ";

            ps = con.prepareStatement(query);
            // ps.setBoolean(1, user_status);
            ps.setString(1, user_fname);
            ps.setString(2, user_lname);
            // ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {

                type = rs.getInt("stauts");

            }

        } catch (SQLException e) {
            System.out.println("Exception occured in the getUserType() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the  getUserType() method: " + e.getMessage());
            }
        }

        return type;
    }

    /**
     * Disabling user by admin
     */
    @Override
    public int disabling(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        int Updated = 0;

        try {

            conn = getConnection();

            String query = "UPDATE user SET user_status = ?,  user_password = ?, user_fname = ?, user_lname = ?";
            ps = conn.prepareStatement(query);

            ps.setBoolean(1, user.isUser_status());
            // ps.setBoolean(1, changeuser_status);
            // ps.setString(2, confirmPassword);
            //ps.setString(3, changePhoneNumber);

            Updated = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("An exception occurred in the changeDeatails: " + e.getMessage());
        } finally {
            // Close prepared statement
            try {
                ps.close();
            } catch (SQLException e) {
                System.out.println("An exception occurred when closing the PreparedStatement of the changeDeatails: " + e.getMessage());
            }

            freeConnection(conn);
        }

        return Updated;
    }

    /**
     * Disabling a userr from the library
     */
    @Override
    public boolean isUserAvailable(String user_fname, String user_lname, Boolean user_status) {
        boolean userCheck = false;

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();

            String query = "Select * from user WHERE user_fname = ?, WHERE user_lname =? ";
            ps = con.prepareStatement(query);
            ps.setString(1, user_fname);
            ps.setString(2, user_lname);

            rs = ps.executeQuery();

            if (!rs.next()) {
                userCheck = true;
            }

            return userCheck;
        } catch (SQLException e) {
            System.out.println("Exception in isUserTaken() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the checkUsername() method: " + e.getMessage());
            }
        }
        return userCheck;
    }

    /**
     * check cuurent loged
     */
    @Override
    public User checkLogin(String user_fname, String user_lname, String user_password) {

        //check
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            con = this.getConnection();

            String query = "SELECT * FROM user WHERE user_fname = ? , user_password = ? ,user_lname = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, user_fname);
            ps.setString(2, user_password);
            ps.setString(3, user_lname);

            rs = ps.executeQuery();
            if (rs.next()) {
                int User_id = rs.getInt("user_id");
                String User_fname = rs.getString("user_fname");
                String User_lname = rs.getString("user_lname");
                String User_password = rs.getString("user_password");
                String User_phoneno = rs.getString("user_phoneno");
                String User_email = rs.getString("user_email");
                boolean User_isadmin = rs.getBoolean("user_isadmin");
                boolean User_status = rs.getBoolean("user_status");

                u = new User(User_id, User_fname, User_lname, User_password, User_phoneno, User_email, User_isadmin, User_status);
            }
        } catch (SQLException e) {
            System.out.println("An error occurred in the findUserByUsernamePassword() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("An error occurred when shutting down the findUserByUsernamePassword() method: " + e.getMessage());
            }
        }
        return u;
    }

    @Override
    public User getUserByEmailPassword(String email, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            con = this.getConnection();

            String query = "SELECT * FROM user WHERE user_email = ? AND user_password = ? ";
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);

            rs = ps.executeQuery();
            if (rs.next()) {
                int user_id = rs.getInt("user_id");
                String user_fname = rs.getString("user_fname");
                String user_lname = rs.getString("user_lname");
                String user_email = rs.getString("user_email");
                String user_password = rs.getString("user_password");
                String user_phoneno = rs.getString("user_phoneno");
                boolean user_isadmin = rs.getBoolean("user_isadmin");
                boolean user_status = rs.getBoolean("user_status");

                u = new User(user_id, user_fname, user_lname, user_email, user_password, user_phoneno, user_isadmin, user_status);
            }
        } catch (SQLException e) {
            System.err.println("\tA problem occurred during the findUserByUsernamePassword method:");
            System.err.println("\t" + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.err.println("A problem occurred when closing down the findUserByUsernamePassword method:\n" + e.getMessage());
            }
        }
        return u;
    }
    
    
    
    public boolean deleteUser(String user_email) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rowsEffected = 0;
        boolean success = false;

        try {
            con = this.getConnection();
            ps = con.prepareStatement("delete from user where user_email = ?");

            ps.setString(1, user_email);
            rowsEffected = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("An error occurred in the deleteOrders() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("An error occurred when shutting down the deleteOrders() method: " + e.getMessage());
            }
        }
        return success;
    }
    

    @Override
    public boolean checkIfUserIsAdmin(String uname) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean isAdmin = false;
        try {
            con = this.getConnection();

            String query = "SELECT * FROM user WHERE user_fname = ? AND user_isadmin = True";
            ps = con.prepareStatement(query);
            ps.setString(1, uname);

            rs = ps.executeQuery();
            if (rs.next()) {
                isAdmin = true;
            }
        } catch (SQLException e) {
            System.err.println("\tA problem occurred during the checkIfUserIsAdmin method:");
            System.err.println("\t" + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.err.println("A problem occurred when closing down the checkIfUserIsAdmin method:\n" + e.getMessage());
            }
        }
        return isAdmin;
    }

    @Override
    public boolean registerUser(User u ) {
        
    
        Connection con = null;
        PreparedStatement ps = null;
        
        if(getUserByEmailPassword(u.getUser_email(), u.getUser_password()) == null)
        {
           
        try {
            con = this.getConnection();

            String query = "INSERT INTO user(user_fname,user_lname,user_email, user_password, user_phoneno , user_isadmin, user_status) VALUES (?, ?, ?, ?,?,False,True)";

            // Need to get the id back, so have to tell the database to return the id it generates
            // That is why we include the Statement.RETURN_GENERATED_KEYS parameter
            ps = con.prepareStatement(query);

            ps.setString(1, u.getUser_fname());
            ps.setString(2, u.getUser_lname());
            ps.setString(3, u.getUser_email());
            ps.setString(4, u.getUser_password());
            ps.setString(5, u.getUser_phoneno());
//            ps.setBoolean(6, u.isUser_isadmin());
//            ps.setBoolean(7, u.isUser_status());

            // Because this is CHANGING the database, use the executeUpdate method
           ps.execute();
            } 
            catch (SQLException e) 
            {
                System.err.println("\tA problem occurred during the addUser method:");
                System.err.println("\t"+e.getMessage());
            } 
            finally 
            {
                try 
                {
                    if (ps != null) 
                    {
                        ps.close();
                    }
                    if (con != null) 
                    {
                        freeConnection(con);
                    }
                } 
                catch (SQLException e) 
                {
                    System.err.println("A problem occurred when closing down the addUser method:\n" + e.getMessage());
                }
            }
            return true;
        }
        else
        {
            return false;
        }
        }

    public boolean getUserByUserEmail(String useremail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
