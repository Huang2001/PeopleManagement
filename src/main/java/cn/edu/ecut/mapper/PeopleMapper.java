package cn.edu.ecut.mapper;

import cn.edu.ecut.pojo.People;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author DRW
 * @vsrsion 1.0
 */
@Mapper
public interface PeopleMapper {
    People queryPeople(@Param("userCode") String userCode,@Param("userPassword") String userPassword);
    int addPeople(People people);
    int deletePeopleById(@Param("id") int id);
    People queryPeopleById(@Param("id") int id);
    int updatePeople(People people);
    List<People> queryPeopleList(@Param("username") String username,@Param("address") String address,@Param("state") String state,@Param("gender") String gender);
    People queryPeopleByCode(@Param("userCode") String userCode);
}
