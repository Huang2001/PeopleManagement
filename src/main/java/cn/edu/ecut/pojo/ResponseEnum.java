package cn.edu.ecut.pojo;

import cn.edu.ecut.pojo.exceptions.NotFoundSupportedResponseEnumException;
import org.springframework.lang.Nullable;

public enum ResponseEnum
{
    SUCCESS(200,"请求成功!"),
    FAILUE(500,"服务器内部出错!"),
    NOTFOUND(404,"未找到请求路径资源!"),
    PARAMERROR(1,"请求参数不符合标准!");

    private int code;
    private String message;

    private ResponseEnum(int code,String message){
        this.code=code;
        this.message=message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ResponseEnum createResponse(int codeNum, @Nullable String message) throws NotFoundSupportedResponseEnumException {
        for(ResponseEnum responseEnum:ResponseEnum.values())
        {
            if(responseEnum.getCode()==codeNum)
            {
                if(message!=null)
                {
                    responseEnum.setMessage(message);
                }
                return responseEnum;
            }
        }
        throw new NotFoundSupportedResponseEnumException();
    }

}

