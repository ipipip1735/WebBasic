package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * Created by Administrator on 2019/8/29.
 */
@WebFilter(filterName = "OneFilter",
        servletNames={"oneServlet"},
        urlPatterns = {"/one", "/oneServlet"},
        initParams = {@WebInitParam(name="one", value = "111"),
                @WebInitParam(name = "two", value = "222")})
public class OneFilter implements Filter {
    public OneFilter() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    public void destroy() {
        System.out.println("~~" + getClass().getSimpleName() + ".destroy~~");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("~~" + getClass().getSimpleName() + ".doFilter~~");

        chain.doFilter(req, resp);
        resp.getWriter().println("ddddd");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("~~" + getClass().getSimpleName() + ".init~~");
        System.out.println(this);

        System.out.println(config.getInitParameter("one"));
        System.out.println(config.getInitParameter("two"));
    }

}
