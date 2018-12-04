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

    public List<User> findAllUser() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> user = new ArrayList<User>();

        try {
            con = this.getConnection();

            String query = "Select * from user ";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                User u = new User(rs.getInt("User_id"), rs.getString("user_fname"), rs.getString("user_lname"), rs.getString("user_password"), rs.getString("user_phoneno"), rs.getString("user_email"), 
                        rs.getBoolean("user_isadmin"), rs.getBoolean("user_status"));
                user.add(u);
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

        return user;
    }

    @Override
    public User Login(String uname, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;

        try {
             con = this.getConnection();
             
             String query = "SELECT * FROM members WHERE user_fname = ? , user_lname = ? , user_password = ? ";
             ps = con.prepareStatement(query);
             ps.setString(1, fname);
             ps.setString(2,lname);
             
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
                
                u = new User
        (user_id, user_fname, user_lname, user_email, user_password, user_phoneno, user_isadmin,user_status  );
             }
             
         }catch (SQLException e) {
             System.out.println("An error occurred in the findUserByUsername() method: " + e.getMessage());
             
         }finally {
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
                
             }catch (SQLException e) {
                System.out.println("An error occurred when shutting down the findMemberByUsername() method: " + e.getMessage());
            }
         }
         return u;
    }

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
            System.out.println("An error occurred in the insertUser() method: " + e.getMessage());
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

    @Override
    public int updateUser(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int isUpdate = 0;

        try {
            con = this.getConnection();
            String query = "UPDATE user set user_password = ?, user_type = ?, user_lname = ?, user_fname = ?, member_telephone = ?,"
                    + "member_address1 = ?, member_address2 = ?,   where user_username = ?";
            ps = con.prepareStatement(query);

            ps.setString(1, user.getUser_password());
            ps.setByte(2, user.getUser_isadmin());
            ps.setString(3, user.getUser_lname());
            ps.setString(4, user.getUser_fname());
            ps.setString(5, user.getUser_telephone());
            ps.setString(6, user.getUser_address1());
            ps.setString(7, user.getUser_address2());
           
            ps.setString(8, user.getUser_username());

            isUpdate = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("An error occurred in the updateUser() method: " + e.getMessage());
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
                System.out.println("An error occurred when shutting down the updateUser() method: " + e.getMessage());
            }
        }
        return isUpdate;
    }

    @Override
    public boolean deleteUser(String user_username) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rowsEffected = 0;
        boolean success = false;

        try {
            con = this.getConnection();
            ps = con.prepareStatement("delete from user where user_username = ?");

            ps.setString(1, user_username);
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
    public User checkIfUserExists(int user_id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;

        try {
            con = getConnection();
            String query = "Select * from members WHERE member_id = ?";
            ps = con.prepareStatement(query);

            ps.setInt(1, user_id);

            rs = ps.executeQuery();

            if (rs.next()) {
               u = new User(rs.getInt("user_id"), rs.getString("user_username"), rs.getString("user_password"), rs.getByte("user_isadmin"), rs.getString("user_name"), rs.getString("member_telephone"), rs.getString("member_address1"), rs.getString("member_address2"),  rs.getShort("member_numberOfLoans"));
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the checkIfUserExists() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of checkIfUserExists() method: " + e.getMessage());
            }
        }
        return u;
    }

    @Override
    public int getUserType(String user_username) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int type = 0;

        try {
            con = getConnection();

            String query = "Select isAdmin from user WHERE user_username = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, user_username);
            // ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {

                type = rs.getInt("isAdmin");

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

    public boolean isUsernameAvailable(String user_username) {
        boolean usernameCheck = false;

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();

            String query = "Select * from members WHERE memberUsername = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, user_username);
            rs = ps.executeQuery();

            if (!rs.next()) {
                usernameCheck = true;
            }

            return usernameCheck;
        } catch (SQLException e) {
            System.out.println("Exception in isUsernameTaken() method: " + e.getMessage());
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
        return usernameCheck;
    }

    public int changeDetails(String currentUsername, String changeUsername, String confirmPassword, String changePhoneNumber, String changeAddress1, String changeAddress2, String changeCity, String changeCountry) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsUpdated = 0;

        try {

            con = getConnection();

            String query = "UPDATE user SET user_username = ?,  user_password = ?, user_telephone = ?, user_address1 = ?, user_address2 = ? WHERE user_username = ?";
            ps = con.prepareStatement(query);

            ps.setString(1, changeUsername);
            ps.setString(2, confirmPassword);
            ps.setString(3, changePhoneNumber);
            ps.setString(4, changeAddress1);
            ps.setString(5, changeAddress2);
            //ps.setString(6, changeCity);
           // ps.setString(7, changeCountry);

            rowsUpdated = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("An exception occurred in the changeDeatails: " + e.getMessage());
        } finally {
            // Close prepared statement
            try {
                ps.close();
            } catch (SQLException e) {
                System.out.println("An exception occurred when closing the PreparedStatement of the changeDeatails: " + e.getMessage());
            }

            freeConnection(con);
        }

        return rowsUpdated;
    }
}

