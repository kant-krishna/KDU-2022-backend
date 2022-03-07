import java.util.HashMap;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        System.out.println("Enter the string: ");
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        HashMap<Character, Integer> mp = new HashMap<>();
        for(Integer i = 0; i < str.length(); i++) {
            if(mp.get(str.charAt(i))!=null){
                mp.put(str.charAt(i), mp.get(str.charAt(i))+1);
            }
            else {
                mp.put(str.charAt(i), 1);
            }
        }

        for(Character i: mp.keySet()) {
            System.out.println(i+" "+mp.get(i));
        }
    }
}