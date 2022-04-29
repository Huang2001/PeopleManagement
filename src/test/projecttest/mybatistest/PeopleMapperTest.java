package projecttest.mybatistest;

import cn.edu.ecut.mapper.PeopMapper;
import cn.edu.ecut.service.mapperimp.PeopMapperImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.annotation.Resource;

@SpringJUnitConfig(locations = "classpath:spring/applicationContext-hhl.xml")
public class PeopleMapperTest
{

    @Resource(name="peopMapperImp")
    private PeopMapper peopMapper;

    @Test
    public void queryTableTest()
    {
        System.out.println("table1"+peopMapper.descTable("table1"));
    }
}
