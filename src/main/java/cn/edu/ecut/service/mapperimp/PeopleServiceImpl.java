package cn.edu.ecut.service.mapperimp;

import cn.edu.ecut.mapper.PeopleMapper;
import cn.edu.ecut.pojo.People;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DRW
 * @vsrsion 1.0
 */
@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    private PeopleMapper peopleMapper;
    @Override
    public People queryPeople(String userCode, String userPassword) {
        return peopleMapper.queryPeople(userCode,userPassword);
    }
    @Override
    public int deletePeopleById(int id) {
        return peopleMapper.deletePeopleById(id);
    }

    @Override
    public List<People> queryPeopleList(int page, int size, String username, String address, String state, String gender) {
        PageHelper.startPage(page,size);
        return peopleMapper.queryPeopleList(username,address,state,gender);
    }

    @Override
    public People queryPeopleById(int id) {
        return peopleMapper.queryPeopleById(id);
    }

    @Override
    public int updatePeople(People people) {
        return peopleMapper.updatePeople(people);
    }

    @Override
    public int addPeople(People people) {
        return peopleMapper.addPeople(people);
    }

    @Override
    public People queryPeopleByCode(String userCode) {
        return peopleMapper.queryPeopleByCode(userCode);
    }
}
