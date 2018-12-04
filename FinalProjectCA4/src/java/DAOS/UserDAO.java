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

    //   @Override
    //   public boolean isLogin(String user_fname,String user_lname, String user_password) {
    //check your username and password is login
    //      Connection con = null;
    //      ResultSet rs = null;
    //      PreparedStatement ps = null;
    //getdate from login table make loop and match username and password
    //      ArrayList<User> users = new ArrayList<User>();
    //      try {
    //          con = getConnection();
    //         String query = "SELECT * FROM User  ";
    //         ps = con.prepareStatement(query);
    //        rs = ps.executeQuery();
    //         while (rs.next()) {
    //           User s = new User( rs.getString("user_fname"),rs.getString("user_lname"), rs.getString("user_password"));
    //            users.add(s);
    //         }
    //       } catch (SQLException e) {
    //           System.out.println("Exception occured in the isLogin() method");
    //          e.getMessage();
    //       } finally {
    //           try {
    //              if (rs != null) {
    //                  rs.close();
    //                 rs = null;
    //             }
    //             if (ps != null) {
    //                 ps.close();
    //                 ps = null;
    //             }
    //              if (con != null) {
    //                  freeConnection(con);
    //              }
    //          } catch (SQLException e) {
    //              System.out.println("Exception occured in the finally section of the isLogin() method");
    //              e.getMessage();
    //          }
    //      }
    //       boolean flag = false;
    //      for (User s : users) {
    //          if (s.getUser_fname().equals(user_fname) && s.getUser_lname().equals(user_lname) && s.getUser_password().equals(user_password)) {
    //              flag = true;
    //               break;
    //           }
    //       }
//        return flag;
//    }
    /**
     *
     *
     *
     * /**
     * added user row data in database
     */
    @Override
    public boolean insertUser(User user) {

        //add
        Connection connn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int isInsert = 0;

        boolean successInsert = false;

        try {
            connn = this.getConnection();

            String query = "INSERT into users values(?,?,?,?,?,?,?)";
            ps = connn.prepareStatement(query);
            ps.setString(1, user.getUser_fname());
            ps.setString(2, user.getUser_lname());
            ps.setString(3, user.getUser_email());
            ps.setString(4, user.getUser_password());
            ps.setString(5, user.getUser_phoneno());
            ps.setBoolean(6, user.isUser_isadmin());
            ps.setBoolean(7, user.isUser_status());

            isInsert = ps.executeUpdate();
            successInsert = true;
        } catch (SQLException e) {
            System.out.println("An error occurred in the addUser() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connn != null) {
                    freeConnection(connn);
                }
            } catch (SQLException e) {
                System.out.println("An error occurred when shutting down the insertUser() method: " + e.getMessage());
            }
        }
        return successInsert;
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
        try 
        {
            con = this.getConnection();
            
            String query = "SELECT * FROM user WHERE user_email = ? AND user_password = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            
            rs = ps.executeQuery();
            if (rs.next()) 
            {
                int user_id = rs.getInt("user_id");
                String user_fname = rs.getString("user_fname");
                String user_lname = rs.getString("user_lname");
                String user_email = rs.getString("user_email");
                String user_password = rs.getString("user_password");
                String user_phoneno = rs.getString("user_phoneno");
                 boolean user_isadmin = rs.getBoolean("user_isadmin");
                boolean user_status = rs.getBoolean("user_status");
               
                u = new User(user_id,user_fname,user_lname,user_email,user_password,user_phoneno,user_isadmin,user_status);
            }
        } 
        catch (SQLException e) 
        {
            System.err.println("\tA problem occurred during the findUserByUsernamePassword method:");
            System.err.println("\t"+e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
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
                System.err.println("A problem occurred when closing down the findUserByUsernamePassword method:\n" + e.getMessage());
            }
        }
        return u;     // u may be null 
    }

//    public User login(String fname, String lname, String password) {
//        Connection con = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        User u = null;
//
//        try {
//            con = this.getConnection();
//
//            String query = "SELECT * FROM members WHERE user_fname = ? , user_lname = ? , user_password = ? ";
//            ps = con.prepareStatement(query);
//            ps.setString(1, fname);
//            ps.setString(2, lname);
//
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                int user_id = rs.getInt("user_id");
//                String user_fname = rs.getString("user_fname");
//                String user_lname = rs.getString("user_lname");
//                String user_email = rs.getString("user_email");
//                String user_password = rs.getString("user_password");
//                String user_phoneno = rs.getString("user_phoneno");
//                Boolean user_isadmin = rs.getBoolean("user_isadmin");
//                Boolean user_status = rs.getBoolean("user_status");
//
//                u = new User(user_id, user_fname, user_lname, user_email, user_password, user_phoneno, user_isadmin, user_status);
//            }
//
//        } catch (SQLException e) {
//            System.out.println("An error occurred in the findUserByUsername() method: " + e.getMessage());
//
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (ps != null) {
//                    ps.close();
//                }
//                if (con != null) {
//                    freeConnection(con);
//                }
//
//            } catch (SQLException e) {
//                System.out.println("An error occurred when shutting down the findMemberByUsername() method: " + e.getMessage());
//            }
//        }
//        return u;
//    }
}
