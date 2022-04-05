package cn.edu.ecut.config.mybatisconfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @author huanghl
 */
public class DruidDataSourceConfig
{
    @Bean(initMethod = "init",destroyMethod = "close")
    public DruidDataSource dataSource() throws Exception
    {
        Properties properties=Resources.getResourceAsProperties("datasource-config.properties");
        return (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
    }
}
