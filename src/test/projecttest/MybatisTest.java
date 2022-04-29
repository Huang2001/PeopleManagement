package projecttest;

import cn.edu.ecut.config.mybatisconfig.MybatisConfig;
import cn.edu.ecut.pojo.People;
import cn.edu.ecut.service.mapperimp.PeopleService;
import cn.edu.ecut.service.mapperimp.PeopleServiceImpl;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-hhl.xml"})
public class MybatisTest {

    @Resource
    private DruidDataSource dataSource;

    @Test
    public void test1() throws SQLException {
        Assert.notNull(dataSource, "dataSource is null");
        System.out.println("username:" + dataSource.getUsername());
        System.out.println("url:" + dataSource.getUrl());
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        String sql = "select 'huang'";
        ResultSet set = statement.executeQuery(sql);
        set.next();
        System.out.println(set.getString(1));
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext apx = new ClassPathXmlApplicationContext("applicationContext-hhl.xml");
        apx.refresh();
        PeopleService peopleService = (PeopleService) apx.getBean(PeopleServiceImpl.class);
//        for (People p : peopleService.queryPeopleList(1, 4, "", "", "", "男"))
//            System.out.println(p);
//        int i = peopleService.deletePeopleById(19);
        for (int i = 0; i < 20; i++) {
            System.out.println(peopleService.queryPeopleByCode("xiaoxiao"));
        }
    }
}
