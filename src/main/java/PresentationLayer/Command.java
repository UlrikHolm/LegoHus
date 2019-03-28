package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "choice", new ChoiceJ());
        commands.put( "build", new HouseDim());
        commands.put( "order", new OrderJ());
        commands.put( "showorder", new OrderOutJ());
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
        //getOrDefault(Object key, V defaultValue)
        //Returns the value to which the specified key is mapped,
        // or defaultValue if this map contains no mapping for the key.

    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginSampleException;

}
