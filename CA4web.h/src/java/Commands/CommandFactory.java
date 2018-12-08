/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

/**
 *
 * @author HaiKuo
 */
public class CommandFactory {
    public Command createCommand(String action){
        switch(action){
            
            case "login":
                return new loginCommand();
            case "register":
                return new registerCommand();
           
            case "deleteUser":
                return new deleteUserCommand();
            case "changeDetails":
                return new updateDetailsCommand();
            default:
                break;
        }
        return null;
    }
}
