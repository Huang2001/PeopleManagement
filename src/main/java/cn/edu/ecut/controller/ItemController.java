package cn.edu.ecut.controller;

import cn.edu.ecut.mapper.managemapper.ItemMapper;
import cn.edu.ecut.mapper.peoplemapper.PeopMapper;
import cn.edu.ecut.pojo.People;
import cn.edu.ecut.pojo.ResponseEntity;
import cn.edu.ecut.pojo.Title;
import cn.edu.ecut.pojo.exceptions.FieldNotMatchException;
import cn.edu.ecut.pojo.exceptions.NotFoundSupportedResponseEnumException;
import cn.edu.ecut.service.ItemsService;
import cn.edu.ecut.service.mapperimp.ItemMapperImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@Controller
@RequestMapping("/items")
public class ItemController {
    private final String TITLE_FIELD_NAME = "title";


    @Autowired
    private ItemsService itemsService;

    @Resource(name = "peopMapperImp")
    private PeopMapper peopMapper;

    @Qualifier("itemMapperImp")
    @Autowired
    private ItemMapper itemMapper;

    private Logger logger = LoggerFactory.getLogger(ItemController.class);


    /**
     * 管理员创建一个需要收集的表项，表中包含表的标题，还有需要收集的各项内容，内容的形式为   内容名称：内容类型   其中类型包括”text"和“image"
     *
     * @param items 包含需要添加的收集项目{itemName:itemType}，必须包含{title:titleName}这一项
     *              warn:ITEM_TYPE 的值需要验证是否符合数据库枚举的内容；
     * @return
     * @throws NotFoundSupportedResponseEnumException
     */
    @RequestMapping(value = "addItem", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<String> addItem(@RequestBody Map<String, String> items) throws NotFoundSupportedResponseEnumException {
        String titleString = items.get(TITLE_FIELD_NAME);
        if (titleString == null || items.size() <= 1) {
            return new ResponseEntity<>(1, "未上传param:title或item", null);
        }
        items.remove(TITLE_FIELD_NAME);
        itemsService.addItems(titleString, items);
        return new ResponseEntity<>(200, "添加成功！", null);
    }


    /**
     * 前端查询表的数据时，需要动态生成表格，所以需要在这里查询表的格式（各个字段中的内容）
     * 根据{title}表名查询表的结构即需要收集的项
     *
     * @param tableName
     * @return
     * @throws NotFoundSupportedResponseEnumException
     */
    @PostMapping(value = "descItems")
    @ResponseBody
    public ResponseEntity<List<Map<String, String>>> descItems(@RequestParam("title") String tableName) throws NotFoundSupportedResponseEnumException {
        ResponseEntity<List<Map<String, String>>> response = null;
        if (StringUtils.hasLength(tableName)) {
            List<Map<String, String>> result = peopMapper.queryTable(tableName);
            response = new ResponseEntity<>(200, "查询成功！", result);
            return response;
        }
        logger.warn("请求参数--title--为空");
        return response = new ResponseEntity<>(1, "请求参数不正确", null);
    }


    /**
     * 保存用户提交的收集信息(添加用户信息)
     *
     * @param renderItem
     * @return
     */
    @RequestMapping(value = "renderItems", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<String> renderItems(@RequestBody Map<String, String> renderItem, @SessionAttribute People people) throws NotFoundSupportedResponseEnumException, FieldNotMatchException {
        String tableName = null;
        int userId;
        String userName = null;
        if ((tableName = renderItem.get(TITLE_FIELD_NAME)) != null && StringUtils.hasLength(tableName)) {
            return new ResponseEntity<String>(1, "没有@param:tilte", null);
        }
        renderItem.remove(TITLE_FIELD_NAME);
        userId = people.getId();
        userName = people.getUsername();
        itemsService.renderItem(tableName, userId, userName, renderItem);
        return new ResponseEntity<>(200, "提交数据成功！", null);
    }


    /**
     *
     */
    @GetMapping("queryTables")
    @ResponseBody
    public ResponseEntity<List<Title>> queryTables() throws NotFoundSupportedResponseEnumException {
        List<Title> data = itemMapper.queryTitles();
        return new ResponseEntity<>(200, null, data);
    }
}
