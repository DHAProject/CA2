/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandFactory;

import DAOS.UserDAO;
import DTOS.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dhruman
 */
public class LoginCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
         String forwardToJsp = null;
   
        String email = request.getParameter("email");
        String password = request.getParameter("password");
       
        if(email != null && password != null && !email.equals("") && !password.equals(""))
        {
            UserDAO uDao = new UserDAO("library_system");
            User u = uDao.getUserByEmailPassword(email, password);
         
            if(u!= null){
                
                HttpSession session = request.getSession();
                session.setAttribute("loginUser", u);
             
                forwardToJsp = "home.jsp";
            }
            else{
                
                String errorMessage = "No user found matching those details."
                        + "Please <a href='login.jsp'>go back</a> and try again.";
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", errorMessage);
                forwardToJsp = "error.jsp";
            }
        }
        else{
           
            String errorMessage = "Your username and/or password was missing. Please <a href='login.jsp'>go back</a> and try again.";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", errorMessage);
            forwardToJsp = "error.jsp";
        }
        return forwardToJsp;
    }
    }
    
    

