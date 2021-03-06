/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandFactory;

import DTOS.Book;
import DAOS.BookDAO;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andrew
 */
public class ViewBooksCommand implements Command {
    
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        BookDAO bookdao = new BookDAO("library_system");

        List<Book> books = bookdao.getAllBooks();

     

        HttpSession session = request.getSession();
        session.setAttribute("bookList", books);
        forwardToJsp = "BookDetails.jsp";
        
        return forwardToJsp;
    }
}
