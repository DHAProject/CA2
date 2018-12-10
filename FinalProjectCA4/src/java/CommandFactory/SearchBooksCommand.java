package CommandFactory;

import DAOS.BookDAO;
import DTOS.Book;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andrew
 */
public class SearchBooksCommand implements Command {
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        String forwardToJsp = null;
        
        // get the information entered into the form
        String book = request.getParameter("book_title");

        // validate entered information 
        if (book != null && !book.equals(""))
        {
            // call the DAO to get the book matching the search
            BookDAO bDao = new BookDAO("library_system");
            ArrayList<Book> books = bDao.getBookByTitle(book);

            // get the running session to add information to it
            HttpSession session = request.getSession();

            // add the search results to the session 
            session.setAttribute("book", book);

            // set the next page to be search results page
            forwardToJsp = "searchResults.jsp";

        } else
        {
            // forward to the  error page
            forwardToJsp = "error.jsp";
            // get session
            HttpSession session = request.getSession();

            // error message for the user
            String errorMessage = "There was an error try again.";
            session.setAttribute("errorMessage", errorMessage);
        }
        return forwardToJsp;
    }
}
