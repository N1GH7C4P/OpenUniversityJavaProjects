import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("11.4")
public class KierroksetTest {
    void testi(int x) {
        Kierrokset k = new Kierrokset();
        ArrayList<Kaari> kaaret = k.muodosta(x);
        int n = 100;
        boolean ok = true;
        if (kaaret.size() > 100000) ok = false;
        for (Kaari e : kaaret) {
            if (e.alku < 1 || e.alku > n) ok = false;
            if (e.loppu < 1 || e.loppu > n) ok = false;
            if (e.pituus < 1 || e.pituus > 1000) ok = false;
        }
        if (!ok) fail("Verkon muoto ei ole oikea, kun x="+x);
        int INF = 999999999;
        int[] matka = new int[n+1];
        for (int i = 2; i <= n; i++) matka[i] = INF;
        int u = 0;
        while (true) {
            u++;
            boolean muutos = false;
            for (Kaari e : kaaret) {
                if (matka[e.alku]+e.pituus < matka[e.loppu]) {
                    matka[e.loppu] = matka[e.alku]+e.pituus;
                    muutos = true;
                }
            }
            if (!muutos) break;
        }
        if (u != x) fail("Kierrosten määrä on väärä, kun x="+x);
    }
    
    @Test(timeout = 10000)
    public void testit() {
        for (int x = 1; x <= 100; x++) {
            testi(x);
        }
    }    
}
