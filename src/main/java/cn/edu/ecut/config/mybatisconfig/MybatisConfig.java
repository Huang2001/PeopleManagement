package cn.edu.ecut.config.mybatisconfig;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    @Bean
    public SqlSessionFactory manageSqlSessionFactory(@Qualifier("manageDS") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean=new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        ClassPathResource resource=new ClassPathResource("mybatis-test.xml");
        factoryBean.setConfigLocation(resource);
        PageInterceptor interceptor=new PageInterceptor();
        Properties properties=new Properties();
        properties.setProperty("helperDialect","mysql");
        interceptor.setProperties(properties);
        factoryBean.setPlugins(interceptor);
        return factoryBean.getObject();
    }

    @Bean
    public MapperScannerConfigurer manageMapperScanner()
    {
        MapperScannerConfigurer configurer=new MapperScannerConfigurer();
        configurer.setBasePackage("cn.edu.ecut.mapper.managemapper");
        configurer.setSqlSessionFactoryBeanName("manageSqlSessionFactory");
        return configurer;
    }


    @Autowired
    @Bean
    public SqlSessionFactory peopleSqlSessionFactory(@Qualifier("peopleDS") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean=new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        ClassPathResource resource=new ClassPathResource("mybatis-test.xml");
        factoryBean.setConfigLocation(resource);
        return factoryBean.getObject();
    }


    @Bean
    public MapperScannerConfigurer peopleMapperScanner()
    {
        MapperScannerConfigurer configurer=new MapperScannerConfigurer();
        configurer.setBasePackage("cn.edu.ecut.mapper.peoplemapper");
        configurer.setSqlSessionFactoryBeanName("peopleSqlSessionFactory");
        return configurer;
    }

}
