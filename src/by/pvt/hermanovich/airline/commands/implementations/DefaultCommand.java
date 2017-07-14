package by.pvt.hermanovich.airline.commands.implementations;

import by.pvt.hermanovich.airline.commands.BasicCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 * Created by Yauheni Hermanovich on 14.07.2017.
 */
public class DefaultCommand implements BasicCommand {
    /**
     * The basic method for all implementations of the interface.
     *
     * @param request   - request which will be processed.
     * @return          - a page which user will be directed to.
     */
    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}
