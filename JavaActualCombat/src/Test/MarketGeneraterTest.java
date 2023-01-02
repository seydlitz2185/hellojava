package Test;

import mybatis.simple.mapper.MarketMapper;
import mybatis.simple.mapper.ExpressMapper;
import mybatis.simple.mapper.UserMapper;
import mybatis.simple.model.Market;
import mybatis.simple.model.Express;
import mybatis.simple.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Random;

public class MarketGeneraterTest {
    @Test
    public  void randomGenerateTest() throws IOException {
        Random rand =new Random(25);
        SqlSessionFactory sqlSessionFactory;
        Reader reader = Resources.getResourceAsReader("mybatis/simple/mybatis/mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MarketMapper marketMapper = sqlSession.getMapper(MarketMapper.class);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUsers = userMapper.findAll();
        String[] marketDishTags = {"饼干","面包","咖啡","可乐","方便面","香肠","果汁","雪碧","纯净水",};
        String[] marketPreferencesTags = {"一份","两份","三份","四份","五份",};
        String[] marketPrice = {"10","11","12","13","14","15","16","17","18","19","20",};
        String marketInfo="南苑20舍4XX";

        String currTime = String.valueOf(System.currentTimeMillis());
        for (int i =0; i<200;i++){
            int userIndex =rand.nextInt(allUsers.size());
            User thisUser = allUsers.get(userIndex);
            String marketPr = marketPrice[rand.nextInt(marketPrice.length)];
            String marketTime =String.valueOf(System.currentTimeMillis()+ rand.nextInt(1000)*1000000);
            String marketDishTag = marketDishTags[rand.nextInt(marketDishTags.length)];
            String marketPreferenceTag = marketPreferencesTags[rand.nextInt(marketPreferencesTags.length)];
            String tags = "[\""+marketDishTag+"\","+"\""+marketPreferenceTag+"\"]" ;

            Market market = new Market(thisUser.getUserName(),thisUser.getId(), marketTime,marketPr, thisUser.getPhoneNum(), tags,marketInfo);
            try {
                int res = marketMapper.insertNewMarket(market);
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
