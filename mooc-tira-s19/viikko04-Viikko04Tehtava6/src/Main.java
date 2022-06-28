import java.util.*;

public class Main {
    public static void main(String[] args) {
        Laskulauseke l = new Laskulauseke();
        System.out.println(l.laske("1+2")); // 3
        System.out.println(l.laske("2*3+5")); // 11
        System.out.println(l.laske("2*(3+5)")); // 16
    }
}
