package cn.edu.ecut.mapper;

import cn.edu.ecut.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * @author huanghl
 */
@Mapper
public interface GoodsMapper
{
    //添加一个请求物资
    public int addGoods(Goods goods);

    //如果为null则表示查询全部
    public List<Goods> queryGoods(@Nullable @Param("completeFlag") String completeFlag);
}
