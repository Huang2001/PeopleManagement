package cn.edu.ecut.service.mapperimp;

import cn.edu.ecut.pojo.People;

import java.util.List;

/**
 * @author DRW
 * @vsrsion 1.0
 */
public interface PeopleService {
    People queryPeople(String userCode,String userPassword);
    int deletePeopleById(int id);
    List<People> queryPeopleList(int page,int size,String username,String address,String state,String gender);
    People queryPeopleById(int id);
    int updatePeople(People people);
    int addPeople(People people);
    People queryPeopleByCode(String userCode);
}
