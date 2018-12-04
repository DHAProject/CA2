/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import DAOS.UserDAO;
import DTOS.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HaiKuo
 */
public class loginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp;
        HttpSession session = request.getSession();

        String username = request.getParameter("user_username");
        String password = request.getParameter("user_password");

        if (username != null && !username.equals("") && password != null && !password.equals("")) {
            
            
            UserDAO checkUserType = new UserDAO();
            
            
            int type = checkUserType.getUserType(username);

            UserDAO checkLogin = new UserDAO();
            User checkDetails = checkLogin.Login(username, password);

            switch (type) {
                case 0:
                    if (checkDetails != null) {
                        UserDAO loginUser = new UserDAO();
                        User loggedIn = loginUser.Login(username, password);
                        session.setAttribute("login", loggedIn);
                        forwardToJsp = "sucessfulLogin.jsp";
                    } else {
                        forwardToJsp = "error.jsp";
                        session.setAttribute("errorMessage", "Username or Password Incorrect");
                    }
                    break;
                case 1:
                    if (checkDetails != null) {
                        UserDAO loginUser = new UserDAO();
                        User loggedIn = loginUser.Login(username, password);
                        session.setAttribute("login", loggedIn);
                        forwardToJsp = "adminLogin.jsp";
                    } else {
                        forwardToJsp = "error.jsp";
                        session.setAttribute("errorMessage", "Username or Password Incorrect");
                    }
                    break;
                case 2:
                    forwardToJsp = "blockedUser.jsp";
                    break;
                default:

                    forwardToJsp = "error.jsp";
                    session.setAttribute("errorMessage", "Username or Password Incorrect..Please Try Again!!..");

                    break;
            }

        } else {

            forwardToJsp = "error.jsp";

            session.setAttribute("errorMessage", "Please Enter Username and Password");
        }

        return forwardToJsp;
    }

}
