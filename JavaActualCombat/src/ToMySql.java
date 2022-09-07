import sun.security.util.Password;

import java.sql.*;
public class ToMySql {
    public static void main(String[] args){
        System.out.println("hello JDBC～");
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序
            System.out.println("Success loading Mysql Driver!");
        }
        catch (Exception e)
        {
            System.out.print("Error loading Mysql Driver!");
            e.printStackTrace();
        }
        try{
            passwd token = new passwd();
            System.out.println("start connecting");
            Connection connect = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/JDBCtest","root",token.getPasswd());
            System.out.println("Success connect Mysql server!");
            String insertSql = "INSERT INTO student (sno,sname,score) VALUES(?,?,?)";
            PreparedStatement ps = connect.prepareStatement(insertSql);
            ps.setString(1,"14119409");
            ps.setString(2,"xxx");
            ps.setString(3,"100");
            int row = ps.executeUpdate();
            if(row >0 ){
                System.out.print("成功插入一条数据："+ps.toString());
            }

        }catch (Exception e){
            System.out.print("error");
        }
    }
}
