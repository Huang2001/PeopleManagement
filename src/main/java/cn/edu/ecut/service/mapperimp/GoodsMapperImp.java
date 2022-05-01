package cn.edu.ecut.service.mapperimp;

import cn.edu.ecut.mapper.managemapper.GoodsMapper;
import cn.edu.ecut.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huanghl
 */

@Service
public class GoodsMapperImp{
    @Autowired
    private GoodsMapper goodsMapper;

    /*添加请求物资*/
    public int addGoods(Goods goods) {
        return goodsMapper.addGoods(goods);
    }

    /*查询所有请求的物资*/
    public List<Goods> queryAllGoods()
    {
        return goodsMapper.queryGoods(null);
    }

    /*查询未处理的物资*/
    public List<Goods> queryCompletedGoods()
    {
        return goodsMapper.queryGoods("完成");
    }

    /*查询已处理完毕的物资*/
    public List<Goods> queryUnCompletedGoods()
    {
        return goodsMapper.queryGoods("未完成");
    }


}
