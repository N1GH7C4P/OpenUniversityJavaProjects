import java.util.*;

public class Main {
    public static void main(String[] args) {
        Polkupeite p = new Polkupeite(5);
        p.lisaaKaari(1,2);
        p.lisaaKaari(2,3);
        p.lisaaKaari(3,4);
        p.lisaaKaari(5,2);
        p.lisaaKaari(5,3);
        System.out.println(p.muodosta()); // [1->2, 5->3->4]
    }
}
