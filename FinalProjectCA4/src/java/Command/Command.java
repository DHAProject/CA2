package Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrew
 */
public interface Command {
    public String execute(HttpServletRequest request, HttpServletResponse response);
}
