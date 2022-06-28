import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("9.6")
public class PeliTest {
    @Test(timeout = 1000)
    public void testi1() {
        Peli p = new Peli();
        if (p.voittaja(1) != 1) return;
        fail("Metodisi ei toimi oikein");
    }    
    
    @Test(timeout = 1000)
    public void testi2() {
        Peli p = new Peli();
        int n = 1000000/4;
        Random r = new Random(1337);
        long s = 0;
        for (int i = 1; i <= n; i++) {
            s += p.voittaja(r.nextInt(100)+1)*i;
        }
        for (int i = 1; i <= n; i++) {
            s += p.voittaja(r.nextInt(1000)+1)*i;
        }
        for (int i = 1; i <= n; i++) {
            s += p.voittaja(r.nextInt(1000000)+1)*i;
        }
        for (int i = 1; i <= n; i++) {
            s += p.voittaja(r.nextInt(1000000000)+1)*i;
        }
        if (s == 127169617823L) return;
        fail("Metodisi ei toimi oikein");
    }    

    @Test(timeout = 1000)
    public void testi3() {
        Peli p = new Peli();
        int n = 1000000;
        Random r = new Random(1337);
        long s = 0;
        int x = 0;
        for (int i = 1; i <= n; i++) {
            if ((x&(x-1)) == 0) x = x-1;
            else x &= x-1;
            if (x <= 0) {
                x = r.nextInt(1000000000)+1;
            }
            s += p.voittaja(x)*i;
        }
        if (s == 533274609875L) return;
        fail("Metodisi ei toimi oikein");
    }    
}
