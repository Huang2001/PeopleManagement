package projecttest.mybatistest;

import cn.edu.ecut.mapper.PeopMapper;
import cn.edu.ecut.service.ItemsService;
import cn.edu.ecut.service.mapperimp.PeopMapperImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringJUnitConfig(locations = "classpath:spring/applicationContext-hhl.xml")
public class PeopleMapperTest
{

    @Resource(name="peopMapperImp")
    private PeopMapper peopMapper;

    @Autowired
    private ItemsService itemsService;

    @Test
    public void queryTableTest()
    {
        System.out.println("table1"+peopMapper.descTable("table1"));
    }

    @Test
    public void addItemsTest()
    {
        List<Map<String,String>> items=new ArrayList<>();
        Map<String,String> map1=new HashMap<>();
        map1.put("itemName","体温");
        map1.put("itemType","text");
        items.add(map1);
        Map<String,String> map2=new HashMap<>();
        map2.put("itemName","是否感冒");
        map2.put("itemType","text");
        items.add(map2);
        itemsService.addItems("每日打卡",items);
    }
}
