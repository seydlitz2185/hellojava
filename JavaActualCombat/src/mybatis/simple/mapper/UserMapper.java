package mybatis.simple.mapper;
import mybatis.simple.model.User;
import org.springframework.dao.DataAccessException;
/**
 * @author stevenyu
 */
public interface UserMapper {
    /**
     * Make sure UserMapper.xml has an select with id="selectById"
     */
    User selectById(String id) ;
    User selectByEmail(String userEmail);
    int insertNewUser(User user);
}
