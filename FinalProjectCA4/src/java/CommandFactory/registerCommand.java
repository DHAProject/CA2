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
public class registerCommand implements Command{
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp;
        boolean successReg = false;
        User newUser;
        
        String user_email = request.getParameter("user_email");
        String user_password = request.getParameter("user_password");
        byte user_isadmin = 0;
        String user_fname = request.getParameter("user_fname");
        String user_lname = request.getParameter("user_lname");
        
        String user_phoneno = request.getParameter("user_phoneno");
        String user_address1 = request.getParameter("user_address1");
        String user_address2 = request.getParameter("user_address2");
        
        short member_numOfLoans = 0;
        
        UserDAO checkUser = new UserDAO();
        boolean check = checkUser.isUserIsadmin(user_isadmin);
        
        if(check == true){
            if(user_email != null && !user_email.equals("") && user_password != null && !user_password.equals("") && user_isadmin != null && !user_isadmin.equals("") && user_fname != null && !user_fname.equals("") && user_lname != null && !user_lname.equals("") && user_phoneno != null && user_phoneno.equals("") && user_address1 != null && !user_address1.equals("") && user_address2 != null && !user_address2.equals("") ){
                
                
                String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{10,}";
                
                if(user_password.matches(pattern)){
                    newUser = new User(0, user_email, user_password, user_isadmin, user_email, user_phoneno, user_address1, user_address2,  user_numOfLoans);
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

