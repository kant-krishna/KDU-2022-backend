

public class Program1 {
    public static void main(String[] args) {
        Credentials obj = Credentials.secretCall("New Object", 75);

    }
}

class Credentials {
    private String str = "Hello";
    private Integer i = 10;

    private Credentials(String str, Integer i) {
        this.str = str;
        this.i = i;
    }

    public static Credentials secretCall(String str, Integer i) {
            return new Credentials(str, i);
    }
}
