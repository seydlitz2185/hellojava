import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mybatis.simple.mapper.ExpressMapper;
import mybatis.simple.model.Express;
import mybatis.simple.model.UserLogin;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "ExpressServlet", value = "/ExpressServlet")
public class ExpressServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*从Request中读取请求*/
        String expressStr = ServletHelper.getRequestPayload(request);
        String pattern = "(json=)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(expressStr);
        String result = URLDecoder.decode(m.replaceAll(""),"utf-8");
        JSONObject data = JSON.parseObject(result);
        result = data.getString("express");
        data = JSON.parseObject(result);
        Express express=  new Express();
        express.setExpressUser(data.getString("userName"));
        express.setExpressUserId(data.getString("userId"));
        express.setExpressName(data.getString("name"));
        express.setExpressCode(data.getString("code"));
        express.setExpressTime(data.getString("time"));
        express.setExpressPrice(data.getString("cost"));
        express.setExpressContact(data.getString("contact"));
        express.setExpressInfo(data.getString("info"));
        /*用Response返回请求*/
        response.setContentType("text/html;charset=UTF-8");
        SqlSessionFactory sqlSessionFactory;
        PrintWriter out = response.getWriter();
        Reader reader = Resources.getResourceAsReader("/mybatis/simple/mybatis/mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ExpressMapper expressMapper = sqlSession.getMapper(ExpressMapper.class);

        //try{
        try {
            int res = expressMapper.insertNewExpress(express);
            if (res == 1) {
                UserLogin success = new UserLogin();
                success.setMsg("下单成功,单号为："+String.valueOf(express.getExpressId()));
                success.setAccount(express.getExpressUser());
                success.setName(express.getExpressUser());
                String json = JSON.toJSONString(success);
                out.print(json);
            }else {

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
