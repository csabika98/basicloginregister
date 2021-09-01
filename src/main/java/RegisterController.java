import config.TemplateEngineUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(urlPatterns={"/register"})
public class RegisterController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req,resp, req.getServletContext());
        engine.process("register.html", context, resp.getWriter());
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{


        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String created_on = "2021-09-01";  //
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date()); // test
        String last_login = "today";


        UserDaoJdbc userDaoJdbc = null;

        try{
            userDaoJdbc = new UserDaoJdbc(username, password, email);
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }



        userDaoJdbc.add(new User(username, password, email));

        resp.sendRedirect("/");
    }






}
