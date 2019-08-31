package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2019/8/29.
 */
@WebServlet(name = "OneServlet", urlPatterns = {"/one"})
public class OneServlet extends HttpServlet {
    public OneServlet() {
        super();
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
        System.out.println(this);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("~~" + getClass().getSimpleName() + ".doPost~~");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("~~" + getClass().getSimpleName() + ".doGet~~");

        if (request.getSession().getAttribute("name") == null) {
            request.getSession().setAttribute("name", "bob");
            System.out.println("set seesion name!");
        }
        response.getWriter().println(request.getSession().getAttribute("name"));
    }
}
