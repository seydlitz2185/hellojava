import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mybatis.simple.mapper.ExpressMapper;
import mybatis.simple.mapper.UserMapper;
import mybatis.simple.model.Express;
import mybatis.simple.model.ExpressOrder;
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

@WebServlet(name = "ExpressProxyPickCancelServlet", value = "/ExpressProxyPickCancelServlet")
public class ExpressProxyPickCancelServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*从Request中读取请求*/
        String loginStr = ServletHelper.getRequestPayload(request);
        String pattern = "(json=)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(loginStr);
        String result = URLDecoder.decode(m.replaceAll(""),"utf-8");
        JSONObject data = JSON.parseObject(result);
        int expressId=Integer.parseInt(data.getString("expressId"));

        response.setContentType("text/html;charset=UTF-8");
        SqlSessionFactory sqlSessionFactory;
        PrintWriter out = response.getWriter();
        Reader reader = Resources.getResourceAsReader("/mybatis/simple/mybatis/mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        ExpressMapper expressMapper = sqlSession.getMapper(ExpressMapper.class);
        //try{
        try {
            ExpressOrder expressOrder = expressMapper.selectByOrderId(expressId);
            if (expressOrder != null) {
                User hostUser = userMapper.selectById(expressOrder.getHostUserId());
                if(hostUser != null) {
                    Express rollbackExpress = new Express(hostUser.getUserName(),expressOrder.getHostUserId(),expressOrder.getExpressName(),expressOrder.getExpressCode(),expressOrder.getExpressTime(),expressOrder.getExpressPrice(),expressOrder.getExpressContact(),expressOrder.getExpressInfo());
                    int res = expressMapper.deleteOrderById(expressId);
                    int res2 = expressMapper.insertNewExpress(rollbackExpress);
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
