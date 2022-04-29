package cn.edu.ecut.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {
    public List<String> queryMsg(String account);

    public int publishMsg(String msg);
}
