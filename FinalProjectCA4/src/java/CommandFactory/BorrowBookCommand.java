package CommandFactory;

import DAOS.UserDAO;
import DTOS.User;
import DAOS.LoanDAO;
import DTOS.Loan;
import DAOS.BookDAO;
import DTOS.Book;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andrew
 */
public class BorrowBookCommand implements Command{
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = null;
        
        int isbn = Integer.parseInt(request.getParameter("book_isbn"));
        String loanStart = request.getParameter("loan_startdate");
        String loanDue = request.getParameter("loan_duedate");
        String loanEnd = request.getParameter("loan_enddate");
        
        
        if(isbn != null && loanStart != null && !loanStart.equals("") && loanDue != null && !loanDue.equals("")&& loanEnd != null && !loanEnd.equals("")){
            LoanDAO lDao = new LoanDAO("library_system");
            Loan ln = new Loan(isbn, loanStart, loanDue, loanEnd);
            boolean newId = uDao.registerUser(ur);
            if(newId = true){
                // Registration was successful, log the user in!
             User u = uDao.getUserByEmailPassword(email, password);
                HttpSession session = request.getSession();
                session.setAttribute("loginUser", u);
                
                forwardToJsp = "home.jsp";
            }else{
                // The user couldn't be added to the database
                // Send the user to the error page and inform them of this
                String errorMessage = "User couldn't be added to the database at this time"
                        + "Please <a href='register.jsp'>go back</a> and try again.<br/>Try a different username!";
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", errorMessage);
                forwardToJsp = "error.jsp";
            }
        }else{
            // One or more fields were missing
            // Send the user to the error page and inform them of this
            String errorMessage = "One or more fields were missing. Please <a href='register.jsp'>go back</a> and try again.";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", errorMessage);
            forwardToJsp = "error.jsp";
        }
        
        return forwardToJsp;
    }
}