
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOS;


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
public class BookDAO extends DAO implements BookDAOInterface {
    
    public BookDAO(String databaseName){
        super(databaseName);
    }
    
   

    @Override
    public ArrayList<Book> getAllBooks() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Book> books = new ArrayList();
        
        try {
            con = getConnection();
            
            String query = "Select * from book";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                Book b = new Book();
                
                b.setBook_isbn(rs.getInt("book_isbn"));
                b.setBook_title(rs.getString("book_title"));
                b.setBook_author(rs.getString("book_author"));
                b.setBook_publisher(rs.getString("book_publisher"));
                b.setBook_description(rs.getString("book_description"));
                b.setBook_quantity(rs.getInt("book_quantity"));
                b.setBook_stock(rs.getDouble("book_stock"));
                books.add(b);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllBooks() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getAllProducts() method: " + e.getMessage());
            }
        }
        
        return books; }
    
    @Override
    public ArrayList<Book> getBookByISBN(String book_isbn) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Book> books = new ArrayList();
        
        try {
            con = getConnection();
            
            String query = "Select * from book where book_isbn = ?";
            ps.setString(1, book_isbn);
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Book bk1 = new Book(rs.getInt("book_isbn"), rs.getString("book_title"), rs.getString("book_author"), rs.getString("book_publisher"), rs.getString("book_description"), rs.getInt("book_quantity"), rs.getDouble("book_stock"));
                books.add(bk1);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getBookByISBN() method: " + e.getMessage());
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
                 System.out.println("Exception occured in the finally section of the getAllBooks() method: " + e.getMessage());
                 }
        }
        
        return books;
    }
    
    @Override
    public ArrayList<Book> getBookByTitle(String book_title) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Book> books = new ArrayList();
        
        try {
            con = getConnection();
            
            String query = "Select * from book where book_title = ?";
            ps.setString(1, book_title);
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Book bk1 = new Book(rs.getInt("book_isbn"), rs.getString("book_title"), rs.getString("book_author"), rs.getString("book_publisher"), rs.getString("book_description"), rs.getInt("book_quantity"), rs.getDouble("book_stock"));
                books.add(bk1);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getBookByTitle() method: " + e.getMessage());
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
                 System.out.println("Exception occured in the finally section of the getBookByTitle() method: " + e.getMessage());
                 }
        }
        
        return books;
    }
    
    @Override
         public boolean addNewBook(Book newbook){
                  
         Connection con = null;
         PreparedStatement ps = null;
         int rowsAffected = 0;
         
         try{
               con = this.getConnection();
               String query =("insert into book values(?, ?, ?, ?, ?, ?, ?") ;
               ps =  ps = con.prepareStatement(query);
               
                ps.setInt(1, newbook.getBook_isbn());
                ps.setString(2, newbook.getBook_title());
                ps.setString(3, newbook.getBook_author());
                ps.setString(4, newbook.getBook_publisher());
                ps.setString(5, newbook.getBook_description());
                ps.setInt(6, newbook.getBook_quantity());
                ps.setDouble(7, newbook.getBook_stock());
                
                rowsAffected = ps.executeUpdate();
         }
         
         catch(SQLException se)
        {
            System.out.println( "SQL Exception occurred: " + se.getMessage() );
            se.printStackTrace();
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
            
            System.out.println("New book was added successfully.");
        }
        else if(rowsAffected < 0){
            System.out.println("New book was not added. Please try again.");
        }
         return true;
     
    }
         
         @Override
         public int changeQuantity(int book_isbn, int book_quantity){
         Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            int rowsAffected = 0;
            
            try{
                con = getConnection();
                String query = "UPDATE book SET quantity = ? WHERE book_isbn = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, book_quantity);
                ps.setInt(2, book_isbn);
            
            rowsAffected = ps.executeUpdate(); 
            }
            catch (SQLException e) {
            System.out.println("Exception occured in the changeQuantity() method: " + e.getMessage());
            } finally {
                try {
                    if (ps != null) {
                    ps.close();
                    }
                    if (con != null) {
                        freeConnection(con);
                    }
                     } catch (SQLException e) {
                    System.out.println("Exception occured in the finally section of the changeQuantity() method");
                    e.getMessage();
                }
            }
            
             return rowsAffected;
    }
         
         @Override
          public int updateBook(int book_isbn, String book_title, String book_author, String book_publisher, String book_description, int book_quantity, double book_stock) {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            int rowsAffected = 0;
            
            try{
                con = getConnection();
                String query = "UPDATE book SET book_isbn = ?, book_title = ?, book_author = ?, book_publisher = ?, book_description = ?, book_quantity = ?, book_stock = ? WHERE book_id = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, book_isbn);
                ps.setString(2, book_title);
                ps.setString(3, book_author);
                ps.setString(4, book_publisher);
                ps.setString(5, book_description);
                ps.setInt(6, book_quantity);
                ps.setDouble(7, book_stock);
            
            rowsAffected = ps.executeUpdate(); 
            }
            catch (SQLException e) {
            System.out.println("Exception occured while updating title: " + e.getMessage());
        } finally {
                try {
                    if (ps != null) {
                    ps.close();
                   }
                   if (con != null) {
                        freeConnection(con);
                   }
                } catch (SQLException e) {
                    System.out.println("Exception occured while updating title");
                    e.getMessage();
                }
            }
            
             return rowsAffected;
          }
          
     // Programmer-Defined Function by Andrew - Alternatively sorting books alphabetically by name
     @Override
     public ArrayList<Book> getAllBooksOrderedByName(String title) {
         Connection con = null;
         PreparedStatement ps = null;
         ResultSet rs = null;
         ArrayList<Book> book = new ArrayList();
            
         try{
            con = getConnection();

            String query = "SELECT * FROM book ORDER BY title";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(); 
            
            while(rs.next()){
                Book b = new Book();
               
                b.setBook_isbn(rs.getInt("book_isbn"));
                b.setBook_title(rs.getString("book_title"));
                b.setBook_author(rs.getString("book_author"));
                b.setBook_publisher(rs.getString("book_publisher"));
                b.setBook_description(rs.getString("book_description"));
                b.setBook_quantity(rs.getInt("book_quantity"));
                book.add(b);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllBooksOrderedByName method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getAllBooksOrderedByName method: " + e.getMessage());
            }
        }
            
            return book;
        }

 
}
