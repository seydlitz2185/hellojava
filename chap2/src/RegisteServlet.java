import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author stevenyu
 */
@WebServlet(name = "RegisteServlet", value = "/RegisteServlet")
public class RegisteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*从Request中读取请求*/
        String account = request.getParameter("account");
        String gender = request.getParameter("gender");
        String[] hobbies = request.getParameterValues("hobby");

        /*用Response返回请求*/
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("账号:"+account+"<br/>");
        out.print("性别:"+gender+"<br/>");
        if(hobbies!=null){
            for (String s: hobbies
                 ) {
                out.print("关注:"+s+"<br/>");
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
