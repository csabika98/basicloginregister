
import config.TemplateEngineUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/"})
public class HomeController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException{
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req,resp, req.getServletContext());
        engine.process("index.html", context, resp.getWriter());

    }

}
