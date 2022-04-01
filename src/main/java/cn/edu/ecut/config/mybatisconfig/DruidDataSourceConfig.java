package cn.edu.ecut.config.mybatisconfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @author huanghl
 */
public class DruidDataSourceConfig
{
    @Bean
    public DataSource dataSource() throws Exception
    {
        Properties properties=Resources.getResourceAsProperties("datasource.properties");
        return DruidDataSourceFactory.createDataSource(properties);
    }
}
