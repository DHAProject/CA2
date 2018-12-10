package CommandFactory;

/**
 *
 * @author Andrew
 */

import DTOS.Book;
import DAOS.BookDAO;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewBooksAlphabeticallyCommand {
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        String title = request.getParameter("book_title");
        BookDAO bookdao = new BookDAO("library_system");
        ArrayList<Book> books = bookdao.getAllBooksOrderedByName(title);
        HttpSession session = request.getSession();
        session.setAttribute("bookList", books);
        forwardToJsp = "BookDetails.jsp";
        
        return forwardToJsp;
    }
}
