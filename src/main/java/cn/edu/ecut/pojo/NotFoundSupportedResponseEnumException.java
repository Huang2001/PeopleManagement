package cn.edu.ecut.pojo;

public class NotFoundSupportedResponseEnumException extends Exception
{
    public NotFoundSupportedResponseEnumException()
    {
        super("没有找到匹配的响应枚举类！");
    }
}

