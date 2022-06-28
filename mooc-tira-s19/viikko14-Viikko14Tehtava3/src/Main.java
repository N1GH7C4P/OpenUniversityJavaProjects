import java.util.*;

public class Main {
    public static void main(String[] args) {
        Tanssiaiset t = new Tanssiaiset(2,3);
        t.lisaaPari(1,2);
        t.lisaaPari(1,3);
        t.lisaaPari(2,1);
        t.lisaaPari(2,2);
        t.lisaaPari(2,3);
        System.out.println(t.muodosta()); // [(1,3), (2,2)]
    }
}
