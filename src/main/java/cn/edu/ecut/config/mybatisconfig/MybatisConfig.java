package cn.edu.ecut.config.mybatisconfig;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

/**
 * @author huanghl
 */
@Configuration
@Import(DruidDataSourceConfig.class)
public class MybatisConfig {
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource)
    {
        SqlSessionFactoryBean factoryBean=new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        ClassPathResource resource=new ClassPathResource("datasource-config.xml");
        factoryBean.setConfigLocation(resource);
        return factoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer()
    {
        MapperScannerConfigurer configurer=new MapperScannerConfigurer();
        configurer.setBasePackage("cn.edu.ecut.*");
        return configurer;
    }
}
