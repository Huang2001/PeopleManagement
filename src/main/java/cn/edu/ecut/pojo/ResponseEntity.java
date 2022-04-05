package cn.edu.ecut.pojo;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class ResponseEntity<T>
{
    private int code;
    private String message;
    private T data;

    public ResponseEntity(int code, @Nullable String message,@Nullable T data) throws NotFoundSupportedResponseEnumException {
        ResponseEnum responseEnum=ResponseEnum.createResponse(code,message);
        this.code=code;
        this.message=responseEnum.getMessage();
        if(data!=null)
        {
            this.data=data;
        }
    }
}
