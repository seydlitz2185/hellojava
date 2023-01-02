package Test;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
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

public class DiningGeneraterTest {
    @Test
    public  void randomGenerateTest() throws IOException {
        Random rand =new Random(25);
        SqlSessionFactory sqlSessionFactory;
        Reader reader = Resources.getResourceAsReader("mybatis/simple/mybatis/mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DiningMapper diningMapper = sqlSession.getMapper(DiningMapper.class);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUsers = userMapper.findAll();
        String[] diningNames = {"南苑一食堂","南苑二食堂","南苑三食堂","南苑香樟树","教工食堂","北苑四食堂","北苑五食堂","北苑民族食堂"};
        String[] diningDishTags = {"黄焖鸡","掉渣饼","两荤一素","一荤一素","鱼粉","包子","烤肠","奶茶","炒饭","鸭血粉丝","烤盘饭","麻辣香锅","烤冷面"
        ,"三鲜烩饼","牛肉汤","韩式石锅饭","辛拉面","板烧鸡腿堡","双层吉士堡","麦辣鸡腿堡",};
        String[] diningPreferencesTags = {"不要餐具","多加米饭","不要辣椒","多加辣椒","不要香菜","多加香菜","不要葱花","多加葱花","半份","加鸡蛋","加香肠","加鸡腿","加卤蛋"};
        String[] diningPrice = {"10","11","12","13","14","15","16","17","18","19","20",};
        String diningInfo="南苑20舍4XX";

        String currTime = String.valueOf(System.currentTimeMillis());
        for (int i =0; i<200;i++){
            int userIndex =rand.nextInt(allUsers.size());
            User thisUser = allUsers.get(userIndex);
            String diningName = diningNames[rand.nextInt(diningNames.length)];
            String diningPr = diningPrice[rand.nextInt(diningPrice.length)];
            String diningTime =String.valueOf(System.currentTimeMillis()+ rand.nextInt(1000)*1000000);
            String diningDishTag = diningDishTags[rand.nextInt(diningDishTags.length)];
            String diningPreferenceTag = diningPreferencesTags[rand.nextInt(diningPreferencesTags.length)];
            String tags = "[\""+diningDishTag+"\","+"\""+diningPreferenceTag+"\"]" ;

            Dining dining = new Dining(thisUser.getUserName(),thisUser.getId(), diningName,diningTime,diningPr, thisUser.getPhoneNum(), tags,diningInfo);
            try {
                int res = diningMapper.insertNewDining(dining);
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
