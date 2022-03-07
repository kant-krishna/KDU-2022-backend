import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class Program5 {
    public static void main(String[] args) {

        //          1

        try {
            FileInputStream fin = new FileInputStream("root.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }

        //           3

        try {
            Integer a = 10, b = 0;
            Integer c = a/b;
        } catch (Exception e) {
            System.out.println("Error: " + e);;
        }

        // Combined 2 & 5

        try {
            String s1 = "638842";
            Integer n = Integer.parseInt(s1);
        }
        catch (NumberFormatException e) {
            System.out.println("Error: " + e);
        }
        finally {
            System.out.println("This is the block, that will run no matter any exception occured or not.");
        }

        //            4
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(10);
        try {
            int index_called = 2;
            if(index_called > arr.size()) {
                throw new IndexOutofBounds("Index out of Bounds.");
            }
        }
        catch (IndexOutofBounds e) {
            System.out.println(e);
        }
    }
}


class IndexOutofBounds extends Exception {
    public IndexOutofBounds(String s) {
        super(s);
    }
}