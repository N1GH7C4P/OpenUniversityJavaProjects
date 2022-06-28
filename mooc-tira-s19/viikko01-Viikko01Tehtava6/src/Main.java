import java.util.*;

public class Main {
    public static void main(String[] args) {
        Onnenluvut o = new Onnenluvut();
        System.out.println(o.laske(1,10)); // 2
        System.out.println(o.laske(123,321)); // 0
        System.out.println(o.laske(1,1000000)); // 126
    }
}
