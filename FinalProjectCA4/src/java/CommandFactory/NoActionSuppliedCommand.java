/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andrew
 */
public class NoActionSuppliedCommand implements Command {
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        String forwardToJsp = "error.jsp";
        
        HttpSession session = request.getSession();

        session.setAttribute("errorMessage", "No action information was supplied");

        return forwardToJsp;
    }
}
