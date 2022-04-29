package cn.edu.ecut.mapper;

import cn.edu.ecut.config.mybatisconfig.DataSourceType;
import cn.edu.ecut.pojo.DSType;
import cn.edu.ecut.pojo.Title;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface ItemMapper
{
    public int addTitle(@Param("title")Title title);
    public int addItems(@Param("id")int titleId,@Param("items") List<Map<String,String>> items);
    public List<Title> queryTitles();
    public List<Map<String,String>> queryItems(@Param("id")int titleId);
}
