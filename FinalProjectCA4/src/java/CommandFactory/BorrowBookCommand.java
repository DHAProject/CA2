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
            boolean newId = lDao.insertRowLoan(ln);
            if(newId = true){
                
                forwardToJsp = "loan.jsp";
            }else{
                // Display error if unable to borrow book
                String errorMessage = "There was an error borrowing a book! Please try again.";
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", errorMessage);
                forwardToJsp = "error.jsp";
            }
        }else{
            // send error
            String errorMessage = "Fields were missing, please try again.";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", errorMessage);
            forwardToJsp = "error.jsp";
        }
        
        return forwardToJsp;
    }
}