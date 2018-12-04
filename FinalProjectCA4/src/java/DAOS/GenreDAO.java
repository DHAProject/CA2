package DAOS;

import DTOS.Book;
import DTOS.Genre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrew
 */
public class GenreDAO  extends DAO implements GenreDAOInterface{
    
    public GenreDAO(String databaseName){
        
      super(databaseName);
    }
    
    @Override
     public List<Genre> getAllGenres() {
         Connection con = null;
         PreparedStatement ps = null;
         ResultSet rs = null;
         List<Genre> genres = new ArrayList();
            
         try{
            con = getConnection();

            String query = "Select * from genre";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(); 
            
            while(rs.next()){
               Genre ge1 = new Genre(rs.getInt("genre_id"), rs.getString("genre_category"));
                genres.add(ge1);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllGenres() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getAllGenres() method: " + e.getMessage());
            }
        }
            
            return genres;
        }
}
