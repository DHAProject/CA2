/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * in this class we going to connect the database by using sql driver to connect
 * the database
 *
 * @author Dhruman
 */
public class DAO {
    private String databaseName;
    
    public DAO(String databaseName)
    {
        this.databaseName = databaseName;
    }
// in this method we going to make a connection to the database and load the driver 
    public Connection getConnection() {

        String driver = "com.mysql.jdbc.Driver";
        //which database u need to connect write the name of the database 
        String url = "jdbc:mysql://localhost:3306/"+ databaseName;
        //User name to access the database server
        String username = "root";
        //password to acess the database server
        String password = "";
        //declaring a variable and put value is null  goe connection 
        Connection con = null;
        //usring try and ctach for exception 
        try {
            // load driver to translation between code and database
            Class.forName(driver);
            //  connect to database
            con = DriverManager.getConnection(url, username, password);
            //if it cant find the driver then disapy this massage which we using in exception 
        } catch (ClassNotFoundException ex1) {
            System.out.println("Failed to find driver class " + ex1.getMessage());
            System.exit(1);
        } // when there is somthing wrong while connection to database then print this exception 
        catch (SQLException ex2) {
            System.out.println("Connection failed " + ex2.getMessage());
            System.exit(2);
        }
        //send connection back to database
        return con;
    }
    
// this method is going to close the database if there is no connection and ther is something wrong then it going use this catch and throw excetion meassage

    public void freeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
                con = null;
            }
        } catch (SQLException e) {
            System.out.println("Failed to free connection: " + e.getMessage());
            System.exit(1);
        }
    }

}
