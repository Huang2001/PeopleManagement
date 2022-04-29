package cn.edu.ecut.pojo;


import cn.edu.ecut.config.mybatisconfig.DataSourceType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author huanghl
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DSType {
    DataSourceType type() default DataSourceType.MANAGE;
}
