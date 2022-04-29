package cn.edu.ecut.controller;

import cn.edu.ecut.pojo.Goods;
import cn.edu.ecut.pojo.exceptions.NotFoundSupportedResponseEnumException;
import cn.edu.ecut.pojo.ResponseEntity;
import cn.edu.ecut.service.mapperimp.GoodsMapperImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

/**
 * @author huanghl
 */

@Controller
@RequestMapping("/goods")
public class GoodsController
{
    @Autowired
    private GoodsMapperImp goodsMapperImp;

    private Logger logger= LoggerFactory.getLogger(GoodsController.class);

    @PostMapping(value = "/requGoods",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseEntity<String> requGoods(@RequestBody Goods goods) throws NotFoundSupportedResponseEnumException
    {
        ResponseEntity<String> entity = null;
        if(!StringUtils.hasLength(goods.getAddress()))
        {
            logger.warn("请求参数中未添加地址！"+goods.toString());
            entity=new ResponseEntity<String>(1,"未添加联系地址！",null);
            return entity;
        }
        if(!StringUtils.hasLength(goods.getUrgentGoods()))
        {
            logger.warn("请求参数中未添加物资详细描述！"+goods.toString());
            entity=new ResponseEntity<>(1,"未添加物资详细描述！",null);
            return entity;
        }
        if(!StringUtils.hasLength(goods.getPhoneNumber()))
        {
            logger.warn("请求参数中未添加联系方式！"+goods.toString());
            entity=new ResponseEntity<>(1,"未添加联系方式！",null);
            return entity;
        }
        entity=new ResponseEntity<>(200,null,null);
        goods.setRequestTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        goodsMapperImp.addGoods(goods);
        return entity;
    }



    /*completeFlag的可选值为:
        "完成","未完成","all";*/

    @GetMapping(value = "/queryGoods",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseEntity<List<Goods>> queryGoods(@RequestParam("completeFlag") String completeFlag) throws NotFoundSupportedResponseEnumException {
        List<Goods> goodsList=null;
        if(StringUtils.hasLength(completeFlag))
        {
            if(completeFlag.equals("完成"))
            {
                goodsList=goodsMapperImp.queryCompletedGoods();
            }
            else
            {
                if(completeFlag.equals("未完成"))
                {
                    goodsList=goodsMapperImp.queryUnCompletedGoods();
                }
                else
                {
                    goodsList=goodsMapperImp.queryAllGoods();
                }
            }
        }
        else
        {
           goodsList=goodsMapperImp.queryAllGoods();
        }

        ResponseEntity<List<Goods>> responseEntity=new ResponseEntity<>(200,null,goodsList);
        return responseEntity;

    }





}
