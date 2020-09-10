package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;

/**
 * Created by Administrator on 2019/8/31 8:50.
 */
public class TwoServlet extends HttpServlet {

    String one, appOne;

    public TwoServlet() {
        super();
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
        System.out.println(this);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("~~~~  " + getClass().getSimpleName() + ".init2  ~~~~");
        super.init(config);


        Enumeration<String> e = config.getInitParameterNames();//获取初始化参数
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
        one = config.getInitParameter("one");

        System.out.println("----------");


        config.getServletContext()//获取应用上下文
                .getInitParameterNames()//获取初始化参数
                .asIterator()
                .forEachRemaining(System.out::println);
        appOne = config.getServletContext().getInitParameter("appOne");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("~~" + getClass().getSimpleName() + ".doPost~~");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("~~" + getClass().getSimpleName() + ".doGet~~");

        System.out.println("one is " + one);
        System.out.println("appOne is " + appOne);


    }
}
