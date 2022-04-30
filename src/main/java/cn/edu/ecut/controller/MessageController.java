package cn.edu.ecut.controller;

import cn.edu.ecut.mapper.MessageMapper;
import cn.edu.ecut.pojo.exceptions.NotFoundSupportedResponseEnumException;
import cn.edu.ecut.pojo.ResponseEntity;
import cn.edu.ecut.service.mapperimp.MessageMapperImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MessageController
{
    @Resource(name = "messageMapperImp")
    private MessageMapper messageMapper;

    private Logger log= LoggerFactory.getLogger(MessageController.class);

    @PostMapping(value = "queryMsg",produces = "application/*;charset=UTF-8")
    @ResponseBody
    public ResponseEntity<List<String>> queryMsg(HttpSession httpSession) throws NotFoundSupportedResponseEnumException {
       String account= (String) httpSession.getAttribute("account");
       ResponseEntity<List<String>> responseEntity;
       if(account==null)
       {
           log.warn("会话中不包含account参数，请求失败！");
           responseEntity=new ResponseEntity(500,"服务器请求失败,请重新登入！",null);
           return responseEntity;
       }
       List<String> list=messageMapper.queryMsg(account);
       responseEntity=new ResponseEntity(200,null,list);
       return responseEntity;
    }

}
