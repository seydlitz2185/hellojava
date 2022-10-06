package Servlet;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author stevenyu
 */
@WebServlet(name = "Servlet.RegisteServlet", value = "/Servlet.RegisteServlet")
public class RegisteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*从Request中读取请求*/
        String loginStr = ServletHelper.getRequestPayload(request);
        String pattern = "(json=)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(loginStr);
        String result = URLDecoder.decode(m.replaceAll(""),"utf-8");
        JSONObject data = JSON.parseObject(result);
        result = data.getString("UserLogin");
        data = JSON.parseObject(result);
        String account=data.getString("account");
        String passwd=data.getString("Servlet.passwd");

        /*用Response返回请求*/
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
