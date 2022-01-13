import java.lang.reflect.Array;

class Generics {

    public static void main(String[] args) {

        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Character[] charArray = { 'A', 'B', 'C', 'D', 'E','F' };
        printArray(intArray);
        printArray(charArray);


        GenClass<Integer> m=new GenClass<Integer>();
        m.add(2);
        GenClass<Character> n=new GenClass<Character>();
        n.add('A');

    }

    public static < E > void printArray(E[] elements) {
        for ( E element : elements){
            System.out.println(element );
        }
        System.out.println();
    }


}

class GenClass<T>{
    T obj;
    void add(T obj){this.obj=obj;}
    T get(){return obj;}
}