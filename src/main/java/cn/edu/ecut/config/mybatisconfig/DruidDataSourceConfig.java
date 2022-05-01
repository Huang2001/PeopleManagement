package cn.edu.ecut.config.mybatisconfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author huanghl
 */
public class DruidDataSourceConfig
{
    @Bean(initMethod = "init",destroyMethod = "close")
    public DruidDataSource manageDS() throws Exception
    {
        Properties properties=Resources.getResourceAsProperties("ds-manage.properties");
        return (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
    }

    @Bean(initMethod = "init",destroyMethod = "close")
    public DruidDataSource peopleDS() throws Exception {
        Properties properties=Resources.getResourceAsProperties("ds-people.properties");
        return (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
    }

    /*@Bean
    public DataSource dataSource(@Qualifier("manageDS") DruidDataSource manageDS,@Qualifier("peopleDS") DruidDataSource peopleDS )
    {
        DynamicDataSource dataSource=new DynamicDataSource();
        Map<Object,Object> dsMap=new HashMap<>();
        dsMap.put(DataSourceType.MANAGE,manageDS);
        dsMap.put(DataSourceType.PEOPLE,peopleDS);
        dataSource.setTargetDataSources(dsMap);
        return dataSource;
    }*/



}
