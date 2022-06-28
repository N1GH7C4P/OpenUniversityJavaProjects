import java.util.*;

public class Main {
    public static void main(String[] args) {
        OnkoPolkua x = new OnkoPolkua(4);
        x.lisaaKaari(1,2,1);
        x.lisaaKaari(2,3,1);
        x.lisaaKaari(2,4,5);
        x.lisaaKaari(4,2,-4);
        System.out.println(x.tutki()); // true
        OnkoPolkua y = new OnkoPolkua(4);
        y.lisaaKaari(1,2,1);
        y.lisaaKaari(2,3,1);
        y.lisaaKaari(2,4,-5);
        y.lisaaKaari(4,2,4);
        System.out.println(y.tutki()); // false
    }
}
