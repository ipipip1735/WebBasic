package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Administrator on 2019/8/31 8:50.
 */
public class TwoServlet extends HttpServlet {
    public TwoServlet() {
        super();
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
        System.out.println(this);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("~~" + getClass().getSimpleName() + ".doPost~~");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("~~" + getClass().getSimpleName() + ".doGet~~");
    }
}
