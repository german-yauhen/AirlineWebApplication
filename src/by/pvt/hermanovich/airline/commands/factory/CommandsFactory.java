package by.pvt.hermanovich.airline.commands.factory;

import by.pvt.hermanovich.airline.commands.BasicCommand;
import by.pvt.hermanovich.airline.constants.MessageConstants;
import by.pvt.hermanovich.airline.constants.Parameters;
import by.pvt.hermanovich.airline.managers.ConfigManagerMessages;
import by.pvt.hermanovich.airline.utils.controllerUtils.RequestParameterIdentifier;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 * Description: This class generates commands.
 *
 * Created by Yauheni Hermanovich on 14.07.2017.
 */
public class CommandsFactory {
    private static final Logger logger = Logger.getLogger(CommandsFactory.class);
    private volatile static CommandsFactory instance;

    public CommandsFactory() {
    }

    /**
     * Singleton realization with "Double Checked Locking & Volatile" principle for high performance and thread safety.
     *
     * @return      - an instance of the class.
     */
    public static CommandsFactory getInstance() {
        if (instance == null) {
            synchronized (CommandsFactory.class) {
                if (instance == null) {
                    instance = new CommandsFactory();
                }
            }
        }
        return instance;
    }

    /**
     * This method generate a particular command to business logic.
     *
     * @param request   - an object of request from a client.
     * @return          - a particular command that will be executed.
     */
    public BasicCommand defineCommand(HttpServletRequest request) {
        BasicCommand currentCommand;
        try {
            CommandType commandType = RequestParameterIdentifier.getCommandFromRequest(request);
            currentCommand = commandType.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            logger.error(ConfigManagerMessages.getInstance().getProperty(MessageConstants.WRONG_COMMAND), e);
            currentCommand  = CommandType.DEFAULT.getCurrentCommand();
        }
        return currentCommand;
    }
}
