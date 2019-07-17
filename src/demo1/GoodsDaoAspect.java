package demo1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class GoodsDaoAspect {

    @Before(value = "execution(* demo1.GoodsDaoImpl.save(..)) || execution(* demo1.GoodsDaoImpl.find(.. ))")
    public void log(){
        System.out.println("添加日志");
    }

    //后置通知可以有返回值也可以没有返回值
    @AfterReturning(value = "execution(* demo1.GoodsDaoImpl.update(..))",returning = "result")
    public void afterReturning(Object result){
        System.out.println("后置通知-----"+result);
    }

    //环绕通知要求有返回值
    @Around(value = "execution(* demo1.GoodsDaoImpl.delete(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {//环绕通知的参数是ProceedingJoinPoint
        System.out.println("delete方法执行前");
        Object proceed = joinPoint.proceed();
        System.out.println("delete方法执行后");
        return proceed;
    }
}
