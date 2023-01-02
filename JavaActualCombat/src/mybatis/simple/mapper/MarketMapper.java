package mybatis.simple.mapper;

import mybatis.simple.model.Market;
import mybatis.simple.model.MarketOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MarketMapper {
    Market selectOne();
    List<Market> selectRange(@Param("start") int start, @Param("offset") int offset);
    Market selectById(int id);
    MarketOrder selectByOrderId(int id);
    List<Market> selectByUserId(@Param("userId") String userId,@Param("start") int start, @Param("offset") int offset);
    List<MarketOrder> selectByUserOrderId(@Param("userId") String userId,@Param("start") int start, @Param("offset") int offset);
    List<MarketOrder> selectByUserProxyPickId(@Param("userId") String userId,@Param("start") int start, @Param("offset") int offset);
    int insertNewMarket(Market market);
    int deleteById(int id);
    int deleteOrderById(int id);
    int insertOrder(MarketOrder marketOrder);
}
