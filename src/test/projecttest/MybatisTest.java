package projecttest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.Calendar;

@ContextConfiguration(locations = {"classpath:applicationContext-hhl.xml"})
public class MybatisTest {

    @Autowired
    private DataSource dataSource=

    @Test
    public void test1()
    {
        Date date=new Date(Calendar.getInstance().getTimeInMillis());
        System.out.println(date);
    }
}
