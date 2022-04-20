package cn.edu.ecut.config.mybatisconfig;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author huanghl
 */
@Configuration
@Import(DruidDataSourceConfig.class)
public class MybatisConfig {
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        System.out.println("create factory!");
        SqlSessionFactoryBean factoryBean=new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        ClassPathResource resource=new ClassPathResource("mybatis-test.xml");
        factoryBean.setConfigLocation(resource);
        PageInterceptor interceptor=new PageInterceptor();
        Properties properties=new Properties();
        properties.setProperty("dialect","mysql");
        interceptor.setProperties(properties);
        factoryBean.setPlugins(interceptor);
        return factoryBean.getObject();
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer()
    {
        MapperScannerConfigurer configurer=new MapperScannerConfigurer();
        configurer.setBasePackage("cn.edu.ecut.mapper");
        return configurer;
    }
}
