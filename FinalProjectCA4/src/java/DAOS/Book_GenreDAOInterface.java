package DAOS;

import DTOS.Book;
import java.util.List;

/**
 *
 * @author Andrew
 */
public interface Book_GenreDAOInterface {

    public List<Book> getBookByGenre(String book_genre);
}
