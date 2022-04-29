package cn.edu.ecut.service.mapperimp;

import cn.edu.ecut.mapper.ItemMapper;
import cn.edu.ecut.pojo.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ItemMapperImp implements ItemMapper
{

    @Autowired
    private ItemMapper itemMapper;


    @Override
    public int addTitle(Title title)
    {
        return itemMapper.addTitle(title);
    }

    @Override
    public int addItem(int titleId, List<Map<String, String>> items)
    {
        return itemMapper.addItem(titleId,items);
    }


    @Override
    public List<Title> queryTitles()
    {
        return itemMapper.queryTitles();
    }


    @Override
    public List<Map<String, String>> queryItems(int titleId)
    {
        return itemMapper.queryItems(titleId);
    }
}
