/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

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
        String username = request.getParameter("user_username");
        
        if(username != null && !username.equals("")){
            UserDAO delete = new UserDAO();
            boolean isRemoved = delete.deleteUser(username);
            
           if (isRemoved == true) {

                forwardToJsp = "deleteUser.jsp";
            }else{
                 forwardToJsp = "error.jsp";

                HttpSession session = request.getSession();

                session.setAttribute("errorMessage", "No user found matching username");
            }

        }
          return  forwardToJsp;
    }

}
