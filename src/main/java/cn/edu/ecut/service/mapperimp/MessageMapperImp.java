package cn.edu.ecut.service.mapperimp;

import cn.edu.ecut.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageMapperImp implements MessageMapper {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<String> queryMsg(String account) {
        return messageMapper.queryMsg(account);
    }

    @Override
    public int publishMsg(String msg) {
        return messageMapper.publishMsg(msg);
    }
}
