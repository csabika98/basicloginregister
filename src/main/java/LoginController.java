import config.TemplateEngineUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req,resp, req.getServletContext());
        engine.process("login.html", context, resp.getWriter());
    }


    UserDaoJdbc userDaoJdbc = new UserDaoJdbc();

    public LoginController() throws SQLException{

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        if(username != null && password != null){
            if(userDaoJdbc.findByName(username, password) != null){
                HttpSession session = req.getSession();
                session.setAttribute("name", username);

            }
        }
        resp.sendRedirect(req.getHeader("referer"));
    }


}
