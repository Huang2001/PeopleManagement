package projecttest;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-hhl.xml"})
public class MybatisTest {

    @Resource
    private DruidDataSource dataSource;

    @Test
    public void test1() throws SQLException {
        Assert.notNull(dataSource,"dataSource is null");
        System.out.println("username:"+dataSource.getUsername());
        System.out.println("url:"+dataSource.getUrl());
        Connection connection=dataSource.getConnection();
        Statement statement=connection.createStatement();
        String sql="select 'huang'";
        ResultSet set=statement.executeQuery(sql);
        set.next();
        System.out.println(set.getString(1));

    }
}
