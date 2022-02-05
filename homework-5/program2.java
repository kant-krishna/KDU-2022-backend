/*
Program 2
Create a simple custom annotation, apply it and use it.
 */

/*
Three types: class level, method level , field level
 */


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

class  Program2 {
    public static void main(String[] args) {

        Student student1 = new Student(982357, "Krishna");
        Student student2 = new Student(982358, "Alice");

        System.out.println(student1.getClass().getDeclaredFields()[0]);

    }
}

// Creating all 3 types of annotations and using it in the main class

class Student {

    @CustomAnnotationField(name = "id")
    private  Integer id;
    @CustomAnnotationField(name = "name")
    String name;

    Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CustomAnnotation {

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CustomAnnotationELement {
    String key() default "";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CustomAnnotationField {
    String name();
    boolean isFlagged() default  false;
}

