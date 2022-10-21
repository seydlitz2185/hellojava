import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mybatis.simple.mapper.DiningMapper;
import mybatis.simple.model.Dining;
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
/**
 * @author stevenyu
 */
@WebServlet(name = "DiningServlet", value = "/DiningServlet")
public class DiningServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*从Request中读取请求*/
        String diningStr = ServletHelper.getRequestPayload(request);
        String pattern = "(json=)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(diningStr);
        String result = URLDecoder.decode(m.replaceAll(""),"utf-8");
        JSONObject data = JSON.parseObject(result);
        result = data.getString("Dining");
        data = JSON.parseObject(result);
        Dining dining=  new Dining();
        dining.setDiningUser(data.getString("userName"));
        dining.setDiningUserId(data.getString("userId"));
        dining.setDiningName(data.getString("name"));
        dining.setDiningTime(data.getString("time"));
        dining.setDiningPrice(data.getString("cost"));
        dining.setDiningContact(data.getString("contact"));
        dining.setDiningTags(data.getString("tags"));
        dining.setDiningInfo(data.getString("info"));
         /*用Response返回请求*/
        response.setContentType("text/html;charset=UTF-8");
        SqlSessionFactory sqlSessionFactory;
        PrintWriter out = response.getWriter();
        Reader reader = Resources.getResourceAsReader("/mybatis/simple/mybatis/mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DiningMapper diningMapper = sqlSession.getMapper(DiningMapper.class);

        //try{
        try {
            int res = diningMapper.insertNewDining(dining);
            if (res == 1) {
                UserLogin success = new UserLogin();
                success.setMsg("下单成功,单号为："+String.valueOf(dining.getDiningId()));
                success.setAccount(dining.getDiningUser());
                success.setName(dining.getDiningUser());
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
