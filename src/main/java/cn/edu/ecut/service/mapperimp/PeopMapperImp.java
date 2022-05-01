package cn.edu.ecut.service.mapperimp;

import cn.edu.ecut.mapper.peoplemapper.PeopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PeopMapperImp implements PeopMapper {
    @Autowired
    private PeopMapper peopMapper;

    @Override
    public void createTable(String tableName, List<Map<String, String>> fields) {
        peopMapper.createTable(tableName,fields);
    }

    @Override
    public List<Map<String, String>> queryTable(String tableName) {
        return peopMapper.queryTable(tableName);
    }

    @Override
    public int insertTable(String tableName, List<Object> items) {
       return peopMapper.insertTable(tableName,items);
    }

    @Override
    public List<Map<String, String>> descTable(String tableName) {
       return peopMapper.descTable(tableName);
    }
}
