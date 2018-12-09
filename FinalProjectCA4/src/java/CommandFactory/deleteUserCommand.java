/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandFactory;

import DAOS.UserDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HaiKuo
 */
public class deleteUserCommand implements Command {
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String forwardToJsp="";
        String useremail = request.getParameter("user_email");
        
        if(useremail != null && !useremail.equals("")){
            
            // UserDAO uDao = new UserDAO("library_system");
            
            UserDAO delete = new UserDAO("library_system");
            boolean isRemoved = delete.deleteUser(useremail);
            
           if (isRemoved == true) {

                forwardToJsp = "home.jsp";
            }else{
                 forwardToJsp = "error.jsp";

                HttpSession session = request.getSession();

                session.setAttribute("errorMessage", "No member found matching User_email");
            }

        }
          return  forwardToJsp;
    }

}
