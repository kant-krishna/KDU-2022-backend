
import java.util.HashMap;
import java.util.Scanner;

public class Program4 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the string 1: ");
        String str1 = scan.next();
        System.out.println("Enter the string 2: ");
        String str2 = scan.next();
        System.out.println("Enter the Integer: ");
        Integer i = scan.nextInt();

        Task1(str1, str2);
        Task2(str1, str2, i);
    }



    static void Task2(String s1, String s2, Integer i) {
        String res = "";
        res += s1.substring(0, i+1);
        res += s2;
        res += s1.substring(i+1);
        System.out.println("Newly fromed string after inserting is:" + res);
    }

    static void Task1(String s1, String s2) {
        Integer res = -1;
        int l1 = s1.length(), l2 = s2.length();
        if(l2 <= l1) {
            for(Integer j = 0, i = 0; j <= l1 - l2; j++, i++) {
                String s3 = s1.substring(j, j+l2);
                if(s3.equals(s2)) {
                    res = j;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}