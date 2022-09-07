import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.PrintWriter;
import java.sql.*;
import java.io.IOException;

@WebServlet(name = "add", value = "/add")
public class add extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*从Request中读取请求*/
        String account = request.getParameter("account");
        String passwd = request.getParameter("passwd");
        String gender = request.getParameter("gender");
        String[] hobbies = request.getParameterValues("hobby");
        String hobbiesToString = "null";
        if(hobbies!=null){
            for (String s: hobbies
            ) {
                if(hobbiesToString.equals("null")){
                    hobbiesToString = s;
                }else {
                    hobbiesToString += s;
                    hobbiesToString += ",";
                }
            }
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        PreparedStatement ps ;
        Connection connect;
        try{
            passwd psw = new passwd();
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/JDBCtest","root",psw.getPasswd());

            String insertSql = "INSERT INTO register (account,passwd,gender,hobbies) VALUES(?,?,?,?)";
            ps = connect.prepareStatement(insertSql);
            ps.setString(1,account);
            ps.setString(2,passwd);
            ps.setString(3,gender);
            if(hobbiesToString!=null){
                ps.setString(4,hobbiesToString);
            }else {
                ps.setString(4,"null");
            }

            int row = ps.executeUpdate();
            if(row >0 ){
                out.print ("成功插入一条数据："+"<br/>");
                out.print("账号:"+account+"<br/>");
                out.print("性别:"+gender+"<br/>");
                if(hobbies!=null){
                    out.print("关注:"+hobbiesToString+"<br/>");
                }
            }

        }catch (Exception e){
            out.print("Error loading Mysql Driver!");
            e.printStackTrace();
        }finally {

        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
