import com.kdu.AOP.StringClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(StringClass.class);
        String string1 = "Hey", string2= "Hey";
        StringClass stringObject = context.getBean(StringClass.class);
        System.out.println(stringObject.comparingStrings(string1, string2));;
    }



}
