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
public class updateDetailsCommand implements Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp;

        String currentUsername = request.getParameter("currentUsername");
        String changeUsername = request.getParameter("changeUsername");
        String changeAddress1 = request.getParameter("changeAddress1");
        String changeAddress2 = request.getParameter("changeAddress2");
        
        String changePhoneNumber = request.getParameter("changePhoneNumber");
        String newPassword = request.getParameter("changePassword");
        String confirmPassword = request.getParameter("confirmPassword");

        if (currentUsername != null && !currentUsername.equals("") && changeUsername != null && !changeUsername.equals("") && newPassword != null && !newPassword.equals("") && confirmPassword != null && !confirmPassword.equals("") && changePhoneNumber != null && !changePhoneNumber.equals("")) {

            if (newPassword.equals(confirmPassword)) {

                String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{10,}";

                if (confirmPassword.matches(pattern)) {
                    UserDAO changedetails = new UserDAO();
                    int checkChangeDetails = changedetails.changeDetails(currentUsername, changeUsername, confirmPassword, changePhoneNumber, changeAddress1, changeAddress2, changeCity, changeCountry);

                    if (checkChangeDetails > 0) {
                        forwardToJsp = "changedDetailsSucces.jsp";
                    } else {
                        forwardToJsp = "error.jsp";
                        HttpSession session = request.getSession();
                        session.setAttribute("errorMessage", "Error with details");
                    }
                } else {
                    forwardToJsp = "error.jsp";
                    HttpSession session = request.getSession();
                    session.setAttribute("errorMessage", "Password not entered correctly");
                }
            } else {
                forwardToJsp = "error.jsp";
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", "Passwords dont match");
            }

        } else {
            forwardToJsp = "error.jsp";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", "Fields Cannot Be Empty");
        }
        return forwardToJsp;
    }

}
