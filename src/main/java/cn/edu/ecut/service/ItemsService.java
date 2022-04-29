package cn.edu.ecut.service;

import cn.edu.ecut.mapper.ItemMapper;
import cn.edu.ecut.mapper.PeopMapper;
import cn.edu.ecut.pojo.Title;
import cn.edu.ecut.pojo.exceptions.FieldNotMatchException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;

@Service
public class ItemsService
{

    @Resource(name = "itemMapperImp")
    private ItemMapper itemMapper;

    @Resource(name = "peopMapperImp")
    private PeopMapper peopMapper;


    /**
    增加一个需要收集的表
     <p>添加一个需要收集的表名</p>
     <p>自动创建一个表</p>
    */
    public void addItems(String titleName, List<Map<String,String>> items)
    {
        Title title=new Title(titleName, Calendar.getInstance().getTimeInMillis());
        itemMapper.addTitle(title);
        int titleId=title.getId();
        if(titleId!=0)
        {
            itemMapper.addItem(titleId,items);
            peopMapper.createTable(titleName,items);
        }
    }


    /**
     * 添加用户提交的数据到指定的收集表中
     * @throws
     */
    public void renderItem(String tableName,int userId,String userName,Map<String,String> data) throws FieldNotMatchException {
        List<Object> renderData=new ArrayList<>();
        renderData.add(userId);
        renderData.add(userName);
        renderData.add(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        List<Map<String,String>> fields=peopMapper.descTable(tableName);
        for(int var=4;var<fields.size();var++)
        {
            Map<String,String> map=fields.get(var);
            String itemValue=data.get(map.get("Field"));
            if(itemValue==null)
            {
                throw new FieldNotMatchException("inserted field:"+map.get("Field")+" is not found!");
            }
            renderData.add(itemValue);
        }
        peopMapper.insertTable(tableName,renderData);
    }


}
