package projecttest.mybatistest;

import cn.edu.ecut.mapper.peoplemapper.PeopMapper;
import cn.edu.ecut.pojo.exceptions.FieldNotMatchException;
import cn.edu.ecut.service.ItemsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.annotation.Resource;
import java.util.HashMap;
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
        Map<String,String> map=new HashMap<>();
        map.put("体温","text");
        map.put("是否感冒","text");
        itemsService.addItems("每日打卡",map);
    }

    @Test
    public void renderItemsTest() throws FieldNotMatchException {
        Map<String,String> map=new HashMap<>();
        map.put("体温","36.7");
        map.put("是否感冒","否");
        itemsService.renderItem("每日打卡",4,"张三",map);
        itemsService.renderItem("每日打卡",4,"张三",map);
    }
}
