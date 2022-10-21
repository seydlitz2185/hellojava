package mybatis.simple.mapper;
import mybatis.simple.model.User;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * @author stevenyu
 */
public interface UserMapper {
    /**
     * Make sure UserMapper.xml has an select with id="selectById"
     */
    User selectById(String id) ;
    int insertNewUser(User user);
    List<User> findAll();
}
