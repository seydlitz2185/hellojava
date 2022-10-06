package mybatis.simple.mapper;
import mybatis.simple.model.User;
/**
 * @author stevenyu
 */
public interface UserMapper {
    /**
     * Make sure UserMapper.xml has an Servlet.select with id="selectById"
     */
    User selectById(long id);
}
