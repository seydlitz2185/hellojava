package mybatis.simple.mapper;

import mybatis.simple.model.Dining;
import mybatis.simple.model.DiningOrder;
import mybatis.simple.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author stevenyu
 */
public interface DiningMapper {
    Dining selectOne();
    List<Dining> selectRange(@Param("start") int start, @Param("offset") int offset);
    Dining selectById(int id);
    DiningOrder selectByOrderId(int id);
    List<Dining> selectByUserId(@Param("userId") String userId,@Param("start") int start, @Param("offset") int offset);
    List<DiningOrder> selectByUserOrderId(@Param("userId") String userId,@Param("start") int start, @Param("offset") int offset);
    List<DiningOrder> selectByUserProxyPickId(@Param("userId") String userId,@Param("start") int start, @Param("offset") int offset);
    int insertNewDining(Dining dining);
    int deleteById(int id);
    int deleteOrderById(int id);
    int insertOrder(DiningOrder diningOrder);
}
