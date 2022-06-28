import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("11.6")
public class MontaPolkuaTest {
    void testi(int x) {
        MontaPolkua k = new MontaPolkua();
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
        int[] tavat = new int[n+1];
        tavat[1] = 1;
        boolean[] valmis = new boolean[n+1];
        while (true) {
            int ui = 0, um = INF;
            for (int i = 1; i <= n; i++) {
                if (!valmis[i] && matka[i] < um) {
                    ui = i;
                    um = matka[i];
                }
            }
            if (ui == 0) break;
            for (Kaari e : kaaret) {
                if (e.alku != ui) continue;
                if (matka[e.alku]+e.pituus < matka[e.loppu]) {
                    matka[e.loppu] = matka[e.alku]+e.pituus;
                    tavat[e.loppu] = tavat[e.alku];
                } else if (matka[e.alku]+e.pituus == matka[e.loppu]) {
                    tavat[e.loppu] += tavat[e.alku];
                }
            }
            valmis[ui] = true;
        }
        if (tavat[n] != x) fail("Polkujen määrä on väärä, kun x="+x);
    }
    
    @Test(timeout = 10000)
    public void pienet() {
        for (int x = 1; x <= 100; x++) {
            testi(x);
        }
    }    

    @Test(timeout = 1000)
    public void suuri1() {
        testi(1337);
    }    

    @Test(timeout = 1000)
    public void suuri2() {
        testi(999999999);
    }    

    @Test(timeout = 1000)
    public void suuri3() {
        testi(1000000000);
    }    

    @Test(timeout = 1000)
    public void suuri4() {
        testi(123456789);
    }    
    
    @Test(timeout = 1000)
    public void suuri5() {
        testi(987654321);
    }    

    @Test(timeout = 1000)
    public void suuri6() {
        testi(666);
    }    
    
    @Test(timeout = 10000)
    public void vikat() {
        Random r = new Random();
        for (int i = 1; i <= 10; i++) {
            testi(r.nextInt(1000000000)+1);
        }
    }    
    
}
