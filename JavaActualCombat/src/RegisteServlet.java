import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import mybatis.simple.mapper.UserMapper;
import mybatis.simple.model.User;
import mybatis.simple.model.UserLogin;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.dao.DataAccessException;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.exceptions.PersistenceException;
/**
 * @author stevenyu
 */
@WebServlet(name = "RegisteServlet", value = "/RegisteServlet")
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
        result = data.getString("UserRegist");
        data = JSON.parseObject(result);
        User user=  new User();
        user.setId(data.getString("id"));
        user.setUsername(data.getString("userName"));
        user.setPassword(data.getString("userPassword"));
        user.setPhoneNum(data.getString("userPhoneNum"));
        /*用Response返回请求*/
        response.setContentType("text/html;charset=UTF-8");
        SqlSessionFactory sqlSessionFactory;
        PrintWriter out = response.getWriter();
        Reader reader = Resources.getResourceAsReader("/mybatis/simple/mybatis/mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User userTestId = userMapper.selectById(user.getId());
        if(userTestId != null){
            out.print("该学号已注册账户");
            return;
        }
        //try{
                try {
                    int res = userMapper.insertNewUser(user);
                    if (res == 1) {
                        UserLogin success = new UserLogin();
                        success.setMsg("注册成功");
                        success.setAccount(user.getId());
                        success.setName(user.getUserName());
                        String json = JSON.toJSONString(success);
                        out.print(json);
                }else {
                        UserLogin unsuccess = new UserLogin();
                        unsuccess.setMsg("注册失败");
                        String json = JSON.toJSONString(unsuccess);
                        out.print(json);
                } }finally {
                        sqlSession.commit();
                        //sqlSession.rollback();
                        sqlSession.close();
                }

        /**}catch (IOException ignore) {
            ignore.printStackTrace();
        }*/
    }



        /*用Response返回请求*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
