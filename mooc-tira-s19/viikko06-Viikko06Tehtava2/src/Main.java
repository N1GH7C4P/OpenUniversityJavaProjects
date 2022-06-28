import java.util.*;

public class Main {
    public static void main(String[] args) {
        PieninEtaisyys p = new PieninEtaisyys();
        p.lisaa(3);
        p.lisaa(8);
        System.out.println(p.laske()); // 5
        p.lisaa(20);
        System.out.println(p.laske()); // 5
        p.lisaa(9);
        System.out.println(p.laske()); // 1
    }
}
