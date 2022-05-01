package cn.edu.ecut.mapper.peoplemapper;

import cn.edu.ecut.config.mybatisconfig.DataSourceType;
import cn.edu.ecut.pojo.annotations.DSType;
import cn.edu.ecut.pojo.annotations.PeopleDataBase;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.Alias;

import java.util.List;
import java.util.Map;

@DSType(type = DataSourceType.PEOPLE)
@PeopleDataBase
public interface PeopMapper
{
    public void createTable(@Param("tableName")String tableName, @Param("fields")List<Map<String,String>> fields);

    public List<Map<String,String>> queryTable(@Param("tableName")String tableName);

    public int insertTable(@Param("tableName")String tableName, @Param("items")List<Object> items);

    public List<Map<String,String>> descTable(@Param("tableName")String tableName);
}
