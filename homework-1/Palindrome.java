


public class Palindrome {
    public  static void main(String[] args) {
        String s = "BABAB";
        System.out.println(isPalindrome(s));
    }

    static boolean isPalindrome(String s) {
        boolean res = true;
        for(int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return res;
    }
}


