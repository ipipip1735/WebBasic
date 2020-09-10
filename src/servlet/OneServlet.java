package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Administrator on 2019/8/29.
 */
@WebServlet(name = "OneServlet", urlPatterns = {"/one"})
public class OneServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("~~  " + getClass().getSimpleName() + ".init2  ~~");
        System.out.println("config is " + config);
        super.init(config);
        System.out.println("2222222222");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("~~  " + getClass().getSimpleName() + ".init1  ~~");
        super.init();
        System.out.println("1111111");
    }

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
        } else {
            response.getWriter().println(request.getSession().getAttribute("name"));
            System.out.println("session|name = " + request.getSession().getAttribute("name"));
        }





        //获取初始化参数
        Enumeration<String> e = getInitParameterNames();//获取初始化参数
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }

        System.out.println("----------");

        getServletContext()//获取应用上下文
                .getInitParameterNames()//获取初始化参数
                .asIterator()
                .forEachRemaining(System.out::println);
    }
}
