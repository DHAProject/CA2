/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandFactory;

/**
 *
 * @author Dhruman
 */
public class CommandFactory {

    private CommandFactory() {

    }

    public static Command createCommand(String action) {
        Command c = null;
        // If there was an action provided, choose which method should run and where the user should go next
        switch (action) {
            case "login":
                // Handle where the user wants to login
                c = new LoginCommand();
                break;

            case "register":
                // Handle where the user register and insert to database
                c = new RegisterCommand();
                break;

            case "deleteUser":
                // Handle where the user deleted from the database
                c = new deleteUserCommand();
                break;

            case "ViewLoanUser":
                c = new ViewLoanCommand();
                break;
                
            case "Profile":
                c = new ViewProfileCommand();
                break;
                
            case "ViewBooks":
                c = new ViewBooksCommand();
                break;
                
            case "ViewAllLoan":
                c = new ViewAllLoanCommand();
                break;
                
            case "logout":
                c = new LoginCommand();
                break;
        }
        return c;
    }

}
