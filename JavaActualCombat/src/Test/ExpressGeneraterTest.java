package Test;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import mybatis.simple.mapper.ExpressMapper;
import mybatis.simple.mapper.UserMapper;
import mybatis.simple.model.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.DatagramPacket;
import java.net.URLDecoder;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ExpressGeneraterTest {
    @Test
    public  void randomGenerateTest() throws IOException {
        Random rand =new Random(25);
        SqlSessionFactory sqlSessionFactory;
        Reader reader = Resources.getResourceAsReader("mybatis/simple/mybatis/mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ExpressMapper expressMapper = sqlSession.getMapper(ExpressMapper.class);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUsers = userMapper.findAll();
        String[] expressNames = {"南苑顺丰","南苑中通","南苑申通","南苑圆通","南苑韵达","南苑邮政","南苑京东","南苑快递柜","北苑快递柜"};
        String expressCodes ="FF-FF-FF-FF-FF-FF";
        String[] expressPrice = {"10","11","12","13","14","15","16","17","18","19","20",};
        String expressInfo="南苑20舍4XX";

        for (int i =0; i<200;i++){
            int userIndex =rand.nextInt(allUsers.size());
            User thisUser = allUsers.get(userIndex);
            String expressName = expressNames[rand.nextInt(expressNames.length)];
            String expressPr = expressPrice[rand.nextInt(expressPrice.length)];
            String expressTime =String.valueOf(System.currentTimeMillis()+ rand.nextInt(1000)*1000000);
            String expressCode = expressCodes;
            Express express = new Express(thisUser.getUserName(),thisUser.getId(), expressName,expressCode,expressTime,expressPr, thisUser.getPhoneNum(),expressInfo);
            try {
                int res = expressMapper.insertNewExpress(express);
                if (res == 1) {

                }else {

                } }finally {

            }
        }
        sqlSession.commit();
        //sqlSession.rollback();
        sqlSession.close();
    }
    public static void main(String[] args){

    }
}
