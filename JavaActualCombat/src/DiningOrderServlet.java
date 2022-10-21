import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mybatis.simple.mapper.DiningMapper;
import mybatis.simple.model.Dining;
import mybatis.simple.model.DiningOrder;
import mybatis.simple.model.UserLogin;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import mybatis.simple.model.User;
import mybatis.simple.mapper.UserMapper;
import com.alibaba.fastjson2.*;
import java.net.URLDecoder;

/**
 * @author stevenyu
 */

@WebServlet(name = "DiningOrderServlet", value = "/DiningOrderServlet")
public class DiningOrderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*从Request中读取请求*/
        String loginStr = ServletHelper.getRequestPayload(request);
        String pattern = "(json=)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(loginStr);
        String result = URLDecoder.decode(m.replaceAll(""),"utf-8");
        JSONObject data = JSON.parseObject(result);
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
            Dining oneDining = diningMapper.selectById(Integer.parseInt(data.getString("diningId")));
            DiningOrder newOrder = new DiningOrder(oneDining.getDiningId(),oneDining.getDiningUserId(),data.getString("deliverUserId"),oneDining.getDiningName(),oneDining.getDiningTime(),oneDining.getDiningPrice(),oneDining.getDiningContact(),oneDining.getDiningTags(),oneDining.getDiningInfo());
            int res = diningMapper.insertOrder(newOrder);
            if (res == 1) {
                res = diningMapper.deleteById(oneDining.getDiningId());
                if(res==1) {
                    UserLogin success = new UserLogin();
                    success.setMsg("接单成功");
                    String json = JSON.toJSONString(success);
                    out.print(json);
                    sqlSession.commit();
                }else {
                    sqlSession.rollback();
                }
            } }finally {

            //sqlSession.rollback();
            sqlSession.close();
        }
    }



    /*用Response返回请求*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
