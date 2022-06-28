import java.util.*;

public class Main {
    public static void main(String[] args) {
        SamatLuvut s = new SamatLuvut();
        s.lisaa(2);
        s.lisaa(7);
        s.lisaa(2);
        System.out.println(s.pienin()); // 2
        s.poista(2);
        System.out.println(s.pienin()); // 2
        s.poista(2);
        System.out.println(s.pienin()); // 7
    }
}
