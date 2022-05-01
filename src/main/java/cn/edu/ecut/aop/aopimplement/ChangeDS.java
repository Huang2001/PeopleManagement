package cn.edu.ecut.aop.aopimplement;

import cn.edu.ecut.config.mybatisconfig.DynamicDataSource;
import cn.edu.ecut.pojo.annotations.DSType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author huanghl
 * @deprecated
 */
//@Configuration
//@EnableAspectJAutoProxy
//@Aspect
public class ChangeDS
{
    @Pointcut("within(cn.edu.ecut.service.mapperimp.*)")
    public void mapperPoint(){};

    @Before("mapperPoint()")
    public void determineDataSource(JoinPoint point)
    {
        Class interfaceClass=point.getSignature().getDeclaringType();
        DSType dsType= (DSType) interfaceClass.getDeclaredAnnotation(DSType.class);
        if(dsType!=null)
        {
            DynamicDataSource.setDsType(dsType.type());
        }
    }


}
