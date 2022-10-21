import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mybatis.simple.mapper.DiningMapper;
import mybatis.simple.mapper.UserMapper;
import mybatis.simple.model.Dining;
import mybatis.simple.model.DiningOrder;
import mybatis.simple.model.User;
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

@WebServlet(name = "DiningProxyPickCancelServlet", value = "/DiningProxyPickCancelServlet")
public class DiningProxyPickCancelServlet  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*从Request中读取请求*/
        String loginStr = ServletHelper.getRequestPayload(request);
        String pattern = "(json=)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(loginStr);
        String result = URLDecoder.decode(m.replaceAll(""),"utf-8");
        JSONObject data = JSON.parseObject(result);
        int diningId=Integer.parseInt(data.getString("diningId"));

        response.setContentType("text/html;charset=UTF-8");
        SqlSessionFactory sqlSessionFactory;
        PrintWriter out = response.getWriter();
        Reader reader = Resources.getResourceAsReader("/mybatis/simple/mybatis/mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        DiningMapper diningMapper = sqlSession.getMapper(DiningMapper.class);
        //try{
        try {
            DiningOrder diningOrder = diningMapper.selectByOrderId(diningId);
            if (diningOrder != null) {
                User hostUser = userMapper.selectById(diningOrder.getHostUserId());
                if(hostUser != null) {
                    Dining rollbackDining = new Dining(hostUser.getUserName(),diningOrder.getHostUserId(),diningOrder.getDiningName(),diningOrder.getDiningTime(),diningOrder.getDiningPrice(),diningOrder.getDiningContact(),diningOrder.getDiningTags(),diningOrder.getDiningInfo());
                    int res = diningMapper.deleteOrderById(diningId);
                    int res2 = diningMapper.insertNewDining(rollbackDining);
                    if(res == 1 && res2 == 1){
                        UserLogin success = new UserLogin("", "代取已取消", "", "");
                        String json = JSON.toJSONString(success);
                        out.print(json);
                    }
                }
            }else{
                UserLogin success = new UserLogin("", "代取取消失败", "", "");
                String json = JSON.toJSONString(success);
                out.print(json);
            } }finally {
            sqlSession.commit();
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
