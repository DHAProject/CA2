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
public class registerCommand implements Command{
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp;
        boolean successReg = false;
        User newUser;
        String user_username = request.getParameter("user_username");
        String user_password = request.getParameter("user_password");
        byte user_isadmin = 0;
        String user_name = request.getParameter("user_name");
        String user_telephone = request.getParameter("user_telephone");
        String user_address1 = request.getParameter("user_address1");
        String user_address2 = request.getParameter("user_address2");
        
        short member_numOfLoans = 0;
        
        UserDAO checkUsername = new UserDAO();
        boolean check = checkUsername.isUsernameAvailable(user_username);
        
        if(check == true){
            if(user_username != null && !user_username.equals("") && user_password != null && !user_password.equals("") && user_isadmin != null && !user_isadmin.equals("") && user_name != null && !user_name.equals("") && user_telephone != null && user_telephone.equals("") && user_address1 != null && !user_address1.equals("") && user_address2 != null && !user_address2.equals("") ){
                
                
                String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{10,}";
                
                if(user_password.matches(pattern)){
                    newUser = new User(0, user_username, user_password, user_isadmin, user_name, user_telephone, user_address1, user_address2,  user_numOfLoans);
                    UserDAO insertUser = new UserDAO();
                    successReg = insertUser.insertUser(newUser);
                }
                if (successReg == true) {

                    HttpSession session = request.getSession();
                    session.setAttribute("login", newUser);

                    forwardToJsp = "sucessfullRegistration.jsp";
                } else {
                    forwardToJsp = "error.jsp";

                    HttpSession session = request.getSession();

                    session.setAttribute("errorMessage", "Password Needs To Be 10 charactors Long With 1 UpperCase letter "
                            + "And At Least 1 Number And No Spaces");
                }

            } else {
                forwardToJsp = "error.jsp";

                HttpSession session = request.getSession();

                session.setAttribute("errorMessage", "Please Ensure All Fields Are Filled In");
            }
        } else {
            forwardToJsp = "error.jsp";

            HttpSession session = request.getSession();

            session.setAttribute("errorMessage", "Username already Taken");
        }

        return forwardToJsp;
    }
}

