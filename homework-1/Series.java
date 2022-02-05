


public class Series {
    public  static void main(String[] args) {
        isThreeMultiple(10);
        System.out.println(" ");
        series1(20);
        System.out.println(" ");
        series2(20);
        System.out.println(" ");
        series3(20);

    }

    static void isThreeMultiple(Integer n) {
        for(Integer i = 1; i < n; i++) {


            if(check(n) % 3 == 0){
                System.out.print(i);
                System.out.print(" ");
            }
        }
        return;
    }
    static Integer check(Integer n) {
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    static void series1(Integer n) {
        Integer a = 1, b = 4, c = 7;
        while(n>=1) {
            System.out.print(a);
            System.out.print(" ");
            Integer temp = c;
            c = temp + a + b;
            a = b;
            b = temp;
            n -= 1;
        }
    }
    static void series2(Integer n) {
        for(Integer i = 1; i <= n; i++) {
            if(i % 4 != 0) {
                System.out.print(i*i);
                System.out.print(" ");
            }
        }
    }

    static void series3(Integer n) {
        Integer prev = 1, fact = 4;
        for(Integer i = 1; i <= n; i++) {
            System.out.print(prev);
            prev += fact;
            fact += 4;
            if(fact % 3 == 0) {
                fact += 4;
            }
            System.out.print(" ");
        }
    }
}


