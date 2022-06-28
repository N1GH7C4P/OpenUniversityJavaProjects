import java.util.*;

public class Main {
    public static void main(String[] args) {
        Piirileikki p = new Piirileikki();
        System.out.println(p.viimeinen(7)); // 7
        System.out.println(p.viimeinen(4)); // 1
        System.out.println(p.viimeinen(123)); // 119
    }
}
