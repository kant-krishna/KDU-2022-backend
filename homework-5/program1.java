
/*

Program 1
Try out using the annotations discussed in the session (marker annotation, single value
annotation etc)

 */


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

class Program1 {
    public static void main(String[] args) {

        /* 1 marker annotations
        Basically used for marking, has no attributes : @override
         */
        Child objChild = new Child();
        objChild.display();
        // Here if you use override and wont really override class by any chance, compiler will throw error.

        /* SINGLE VALUE ANNOTATION


         */

        AnnotatedBySingleValue singleValue = new AnnotatedBySingleValue();
        try {
            System.out.println(singleValue.getClass().getMethod("Display").getAnnotations()[0]);
        }
        catch (Exception e) {
            System.out.println(e);
        }


    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface SingleValue {
    int value();
}

@SingleValue(10)
class AnnotatedBySingleValue {
    @SingleValue(11)
    public void Display() {
        System.out.println("Nothing");
    }
}


class Parent {
    void display() {
        System.out.println("Parent class called.");
    }
}
class Child extends Parent {
    @Override
    void display() {
        System.out.println("Child class called.");
    }
}