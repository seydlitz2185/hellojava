package Filter;
/**
 * @author LEGEND
 */
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class MyFilter implements Filter {
    private int count ;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 当前web应用程序运行时（web服务器启动）执行
        String param = filterConfig.getInitParameter("count");
        count = Integer.valueOf(param);

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // 业务逻辑处理，当有Web资源请求时执行
        // chain.doFilter(request, response);
        count++;
        HttpServletRequest request1 = (HttpServletRequest) request;
        ServletContext context = request1.getSession().getServletContext();
        context.setAttribute("count",count);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        // 释放资源，当web停止时执行
    }
}
