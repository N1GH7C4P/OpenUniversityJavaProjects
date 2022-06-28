import java.util.*;

public class Main {
    public static void main(String[] args) {
        Toistuminen t = new Toistuminen();
        System.out.println(t.uusiLuku(1)); // -1
        System.out.println(t.uusiLuku(2)); // -1
        System.out.println(t.uusiLuku(3)); // -1
        System.out.println(t.uusiLuku(1)); // 2
        System.out.println(t.uusiLuku(2)); // 2
        System.out.println(t.uusiLuku(1)); // 1
    }
}
