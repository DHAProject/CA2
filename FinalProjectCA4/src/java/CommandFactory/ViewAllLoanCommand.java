/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandFactory;

import DAOS.LoanDAO;
import DTOS.Loan;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dhruman
 */
public class ViewAllLoanCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        LoanDAO ldao = new LoanDAO("library_system");
        List<Loan> loans = ldao.getAllLoan();
        if(loans!=null){
        HttpSession session = request.getSession();
        session.setAttribute("Loans",loans);
        forwardToJsp = "ViewLoans.jsp";
        }
        else{
                
                String errorMessage = "No user found matching those details."
                        + "Please <a href='login.jsp'>go back</a> and try again.";
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", errorMessage);
                forwardToJsp = "error.jsp";
            }
        return forwardToJsp;
    }
    
}
