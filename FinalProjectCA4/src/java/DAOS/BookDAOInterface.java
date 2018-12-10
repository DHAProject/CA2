/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;
import DTOS.Book;
import java.util.ArrayList;
/**
 *
 * @author Andrew
 */
public interface BookDAOInterface {
    public ArrayList<Book> getAllBooks();
    public ArrayList<Book> getBookByISBN(String book_isbn);
    public ArrayList<Book> getBookByTitle(String book_title);
    public boolean addNewBook(Book newbook);
    public int changeQuantity(int book_isbn, int book_quantity);
    public int updateBook(int book_isbn, String book_title, String book_author, String book_publisher, String book_description, int book_quantity, double book_stock);
    public ArrayList<Book> getAllBooksOrderedByName(String title);
}
