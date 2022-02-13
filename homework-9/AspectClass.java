import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectClass {
    @Pointcut("execution(public * *())")
    public void comp() {

    }

    @Before("comp()")
    public void before() {
        System.out.println("Before ");
    }

    @After("comp()")
    public void After(JoinPoint joinPoint) {
        System.out.println("After "+ joinPoint);
    }

    @AfterReturning("comp()")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.println("After Returning: " + joinPoint);
    }


}
