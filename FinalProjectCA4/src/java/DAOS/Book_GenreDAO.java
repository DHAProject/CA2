package DAOS;

import DTOS.Genre;
import DTOS.Book_Genre;
import DTOS.Book;
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
public class Book_GenreDAO extends DAO implements Book_GenreDAOInterface{
    
    public Book_GenreDAO(String databaseName){
        super(databaseName);
    }
    
    @Override
     public List<Book> getBookByGenre(String book_genre){
         Connection con = null;
         PreparedStatement ps = null;
         ResultSet rs = null;
         List<Book> books = new ArrayList();
            
         try{
            con = getConnection();

            String query = "Select * from book where book_genre = ?";
            ps.setString(1, book_genre);
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(); 
            
            while(rs.next()){
                Book bk1 = new Book(rs.getInt("book_isbn"), rs.getString("book_title"), rs.getString("book_author"), rs.getString("book_publisher"), rs.getString("book_description"), rs.getInt("book_quantity"), rs.getDouble("book_stock"));
                books.add(bk1);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getBookByGenre() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getBookByGenre() method: " + e.getMessage());
            }
        }
            
            return books;
        }
}
