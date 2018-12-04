package DAOS;

import DTOS.Book;
import java.util.List;

/**
 *
 * @author Andrew
 */
public interface BookDAOInterface {

    public List<Book> getAllBooks();

    public List<Book> getBookByGenre(String genre);

    public boolean addNewBook(Book newbook);

    public int changeQuantity(int book_id, int quantity);

    public boolean RemoveTitle(int book_id);

    public int updateBook(int book_isbn, String book_title, String book_author, String book_publisher, String book_description, int book_quantity, double book_stock);
}
