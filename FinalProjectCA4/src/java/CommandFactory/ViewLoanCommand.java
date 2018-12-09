/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandFactory;

import DAOS.UserDAO;
import DAOS.LoanDAO;
import DTOS.Loan;
import DTOS.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dhruman
 */
public class ViewLoanCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
      String forwardToJsp = null;
   
       String userid = request.getParameter("userid");
        
       
       // if(userid != null && !userid.equals(""))
       // {
            LoanDAO lDao = new LoanDAO("library_system");
            List<Loan> u = lDao.getLoanByUserId(userid);
         
            if(u!= null){
                
                HttpSession session = request.getSession();
                session.setAttribute("ViewLoan", u);
             
                forwardToJsp = "loan.jsp";
            }
            else{
                
                String errorMessage = "No user found matching those details."
                        + "Please <a href='login.jsp'>go back</a> and try again.";
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", errorMessage);
                forwardToJsp = "error.jsp";
            }
//        }
//        else{
//           
//            String errorMessage = "Your username and/or password was missing. Please <a href='login.jsp'>go back</a> and try again.";
//            HttpSession session = request.getSession();
//            session.setAttribute("errorMessage", errorMessage);
//            forwardToJsp = "error.jsp";
//        }
      return forwardToJsp;
   }
    
}
