import java.util.*;

public class Main {
    public static void main(String[] args) {
        Ruudukko r = new Ruudukko(4);
        System.out.println(r.laskeHuoneet()); // 0
        r.teeLattia(1,1);
        r.teeLattia(1,3);
        System.out.println("");
        r.tulostaVanhemmat();
        System.out.println(r.laskeHuoneet()); // 2
        r.teeLattia(1,2);
        System.out.println("");
        r.tulostaVanhemmat();
        System.out.println(r.laskeHuoneet()); // 1
        r.teeLattia(3,3);
        System.out.println("");
        r.tulostaVanhemmat();
        System.out.println(r.laskeHuoneet()); // 2
    }
}
