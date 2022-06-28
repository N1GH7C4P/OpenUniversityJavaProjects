import java.util.*;

public class Main {
    public static void main(String[] args) {
        Yhtenaisyys a = new Yhtenaisyys(3);
        a.lisaaKaari(1,2);
        a.lisaaKaari(2,3);
        a.lisaaKaari(3,1);
        System.out.println(a.tutki()); // true
        Yhtenaisyys b = new Yhtenaisyys(3);
        b.lisaaKaari(1,2);
        b.lisaaKaari(2,3);
        b.lisaaKaari(1,3);
        System.out.println(b.tutki()); // false
    }
}
