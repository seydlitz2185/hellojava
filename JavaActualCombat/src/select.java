import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.PrintWriter;
import java.sql.*;
import java.io.IOException;
/**
 * @author stevenyu
 */
@WebServlet(name = "select", value = "/select")
public class select extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        passwd psw = new passwd();
        PreparedStatement ps ;
        Connection connect;
        ResultSet rs;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/JDBCtest","root",psw.getPasswd());
            String insertSql = "SELECT * FROM register WHERE account = ?";
            ps = connect.prepareStatement(insertSql);
            ps.setString(1,account);
            rs = ps.executeQuery();
            if(rs.next()){
                out.write("查询成功："+"<br/>");
                out.write("账户："+rs.getString("account")+"<br/>");
                out.write("性别："+rs.getString("gender")+"<br/>");
                out.write("关注："+rs.getString("hobbies")+"<br/>");
            }else {
                out.write("查询成功："+"<br/>");
                out.print ("账号："+account+"不存在"+"<br/>");
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
