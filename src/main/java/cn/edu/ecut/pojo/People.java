package cn.edu.ecut.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author DRW
 * @vsrsion 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class People {

    private int id;//编号
    private String userCode;//用户账号
    private String userPassword;//用户密码
    private String username;//用户真实姓名
    private String gender;//性别
    private int age;//年龄
    private String address;//住址
    private String phoneNumber;//电话号码
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date applicationTime;//申请时间
    private String roleName;//角色名
    private String state;//申请时间
}
