package cn.edu.ecut.controller;

import cn.edu.ecut.mapper.PeopMapper;
import cn.edu.ecut.pojo.People;
import cn.edu.ecut.pojo.ResponseEntity;
import cn.edu.ecut.pojo.exceptions.NotFoundSupportedResponseEnumException;
import cn.edu.ecut.service.ItemsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/item")
public class ItemController
{
    private final String TITLESTRING="title";
    private final String ITEM_NAME="item_name";
    private final String ITEM_TYPE="item_type";

    @Autowired
    private ItemsService itemsService;

    @Resource(name = "peopMapperImp")
    private PeopMapper peopMapper;

    private Logger logger= LoggerFactory.getLogger(ItemController.class);


    /**
     * warn:ITEM_TYPE 的值需要验证是否符合数据库枚举的内容；
     * @param items 包含需要添加的收集项目{itemName:itemType}，必须包含{title:titleName}这一项
     * @return
     * @throws NotFoundSupportedResponseEnumException
     */

    @RequestMapping(value = "addItem",consumes = "application/json")
    @ResponseBody
    public ResponseEntity<String> addItem(@RequestBody Map<String,String> items) throws NotFoundSupportedResponseEnumException {
        String titleString=items.get(TITLESTRING);
        if(titleString==null||items.size()<=1)
        {
            return new ResponseEntity<>(1,"未上传title或item",null);
        }
        items.remove(TITLESTRING);
        List<Map<String,String>> addData=new ArrayList<>();
        Map<String,String> map;
        for(Map.Entry<String,String> entry:items.entrySet())
        {
            map=new HashMap<>();
            map.put(ITEM_NAME,entry.getKey());
            map.put(ITEM_TYPE,entry.getValue());
            addData.add(map);
        }
        itemsService.addItems(titleString,addData);
        return new ResponseEntity<>(200,"添加成功！",null);
    }


    /**
     * 根据{title}表名查询表的结构即需要收集的项
     * @param tableName
     * @return
     * @throws NotFoundSupportedResponseEnumException
     */
    @RequestMapping(value = "descItems")
    @ResponseBody
    public ResponseEntity<List<Map<String,String>>> descItems(@RequestParam("title")String tableName) throws NotFoundSupportedResponseEnumException {
        ResponseEntity<List<Map<String,String>>> response=null;
        if(StringUtils.hasLength(tableName))
        {
            List<Map<String,String>> result=peopMapper.descTable(tableName);
            response=new ResponseEntity<>(200,"查询成功！",result);
            return response;
        }
        logger.warn("请求参数--title--为空");
        return response=new ResponseEntity<>(1,"请求参数不正确",null);
    }


    /**
     * 保存用户提交的收集信息
     *
     * @param renderItem
     * @return
     */
    @RequestMapping(value = "renderItems",consumes = "application/json")
    @ResponseBody
    public ResponseEntity<String> renderItems(@RequestBody Map<String,String> renderItem, @SessionAttribute People people)
    {

    }


}
