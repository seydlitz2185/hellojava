import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mybatis.simple.mapper.ExpressMapper;
import mybatis.simple.model.Express;
import mybatis.simple.model.ExpressOrder;
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

@WebServlet(name = "ExpressOrderServlet", value = "/ExpressOrderServlet")
public class ExpressOrderServlet extends HttpServlet {
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
        ExpressMapper expressMapper = sqlSession.getMapper(ExpressMapper.class);
        //try{
        try {
            Express oneExpress = expressMapper.selectById(Integer.parseInt(data.getString("expressId")));
            ExpressOrder newOrder = new ExpressOrder(oneExpress.getExpressId(),oneExpress.getExpressUserId(),data.getString("deliverUserId"),oneExpress.getExpressName(),oneExpress.getExpressCode(), oneExpress.getExpressTime(),oneExpress.getExpressPrice(),oneExpress.getExpressContact(),oneExpress.getExpressInfo());
            int res = expressMapper.insertOrder(newOrder);
            if (res == 1) {
                res = expressMapper.deleteById(oneExpress.getExpressId());
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
