package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 The purpose of Login is to...

 @author kasper
 */
public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {

        HttpSession session = request.getSession();
        User userNow = (User) session.getAttribute("user");
        if (userNow == null) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = LogicFacade.login(email, password);

            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());

            if (user.getRole().equals("employee")) {
                List<User> userList = UserMapper.loadUser();
                session.setAttribute("userList", userList);

                for (int i = 0; i < userList.size(); i++) {
                    System.out.println(userList.get(i).toString());
                }

            }
            return user.getRole() + "page";

        } else {
            return userNow.getRole() + "page";
        }

    }
}
