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
 * @author HaiKuo
 */
public class RegisterCommand implements Command{
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = null;
        
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phoneno = request.getParameter("phoneno");
        
        
        if(fname != null && !fname.equals("") && lname != null && !lname.equals("") && email != null && !email.equals("")&& password != null && !password.equals("")&& phoneno != null && !phoneno.equals("")){
            UserDAO uDao = new UserDAO("library_system");
            User ur = new User(0, fname, lname, email, password, phoneno, true, true);
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

