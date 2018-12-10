/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandFactory;

import DAOS.UserDAO;
import DTOS.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HaiKuo
 */
public class displayAllUserCommand implements Command {
    
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        UserDAO udao = new UserDAO("library_system");

        List<User> user = udao.getAllUsers();

     

        HttpSession session = request.getSession();
        session.setAttribute("bookList", user);
        forwardToJsp = "displayAllUser.jsp";
        
        return forwardToJsp;
    }
}