package mybatis.simple.mapper;
import  java.io.IOException;
import  java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import mybatis.simple.model.User;
import mybatis.simple.mapper.UserMapper;
public class UserMapperTest {
    private static SqlSessionFactory sqlSessionFactory;
    public static void init(){
        try{
            Reader reader = Resources.getResourceAsReader("mybatis/simple/mybatis/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        }catch (IOException ignore) {
            ignore.printStackTrace();
        }
    }
    @Test
    public void testFindAll(){
        init();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            List<User> users = sqlSession.selectList("findAll");
            for (User user: users
                 ) {
                System.out.println(user.toString());
            }
        } finally {
            sqlSession.close();
        }
    }
    @Test
    public void testSelectById(){
        init();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        try{
            User user = userMapper.selectById(14119401);
            System.out.println(user.toString());

        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void runAllTest(){
        testFindAll();
    }
}
