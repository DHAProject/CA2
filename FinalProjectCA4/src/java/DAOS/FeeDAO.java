package DAOS;

import DTOS.Fee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class FeeDAO extends DAO implements FeeDAOInterface {
    
    public FeeDAO(String databaseName){
        super(databaseName);
    }
    
    @Override
     public ArrayList<Fee> getAllFees() {
         Connection con = null;
         PreparedStatement ps = null;
         ResultSet rs = null;
         ArrayList<Fee> fee = new ArrayList();
            
         try{
            con = getConnection();

            String query = "SELECT * FROM fee";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(); 
            
            while(rs.next()){
                Fee f = new Fee();
               
                f.setFee_id(rs.getInt("loan_id"));
                f.setUser_id(rs.getInt("user_id"));
                f.setBook_id(rs.getInt("book_id"));
                f.setCard_no(rs.getInt("card_no"));
                fee.add(f);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllFees() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getAllFee() method: " + e.getMessage());
            }
        }
            
            return fee;
        }
     
     @Override
     public boolean payFees(int user_id) {
         Connection con = null;
         PreparedStatement ps = null;
         int rowsAffected = 0;
            
         try{
            con = this.getConnection();

            String query = "DELETE FROM fee WHERE user_id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1,  user_id);
                
            rowsAffected = ps.executeUpdate();
            
            }
         catch( Exception e )
        {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
            finally
        {
            if(ps != null)
            {
                try{
                    ps.close() ;
                } 
                catch (SQLException ex){
                    System.out.println("Exception occurred when attempting to close the PreparedStatement: " + ex.getMessage());
                }
            }
            if(con != null)
            {
                try{
                    con.close() ;
                } 
                catch (SQLException ex){
                    System.out.println("Exception occurred when attempting to close the Connection: " + ex.getMessage());
                }
            }
        }
        
        if(rowsAffected > 0)
        {
            
            System.out.println("Fees successfully paid. Thank you!.");
        }
        else if(rowsAffected < 0){
            System.out.println("There was an error paying your fees at this time. Please try again.");
        }
         return true;
      }
}