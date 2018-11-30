package Command;

/**
 *
 * @author Andrew
 */
public class CommandFactory {
    private volatile static CommandFactory currentInstance;
    
    private CommandFactory() {
        
    }
    
    public static CommandFactory getInstance() {
        
        if (currentInstance == null) {
            synchronized(CommandFactory.class) {
                if (currentInstance == null) {
                    currentInstance = new CommandFactory();
                }
            }
        }
        return currentInstance;
    }
    
    public static Command createCommand(String action) {
        Command command = null;
        
        if (action != null) {
            switch(action) {
                case "login":
                    command = new LoginCommand();
                    break;
                case "register":
                    command = new RegisterCommand();
                    break;
                case "viewBook":
                    command = new ViewBooksCommand();
                    break;
                    default:
                    command = new NoValidActionCommand();
                    break;
            }
        } else {
            command = new NoActionSuppliedCommand();
        }
        return command;
    }
}
