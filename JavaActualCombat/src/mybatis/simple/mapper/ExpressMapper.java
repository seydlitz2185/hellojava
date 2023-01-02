package mybatis.simple.mapper;

import mybatis.simple.model.Express;
import mybatis.simple.model.ExpressOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExpressMapper  {
    Express selectOne();
    List<Express> selectRange(@Param("start") int start, @Param("offset") int offset);
    Express selectById(int id);
    ExpressOrder selectByOrderId(int id);
    List<Express> selectByUserId(@Param("userId") String userId,@Param("start") int start, @Param("offset") int offset);
    List<ExpressOrder> selectByUserOrderId(@Param("userId") String userId,@Param("start") int start, @Param("offset") int offset);
    List<ExpressOrder> selectByUserProxyPickId(@Param("userId") String userId,@Param("start") int start, @Param("offset") int offset);
    int insertNewExpress(Express express);
    int deleteById(int id);
    int deleteOrderById(int id);
    int insertOrder(ExpressOrder expressOrder);
}
