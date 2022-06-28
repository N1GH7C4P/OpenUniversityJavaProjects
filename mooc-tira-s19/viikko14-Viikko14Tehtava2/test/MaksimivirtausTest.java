import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("14.2")
public class MaksimivirtausTest {
    void testi(Maksimivirtaus m, int a) {
        int b = m.laske();
        if (a == b) return;
        fail("Oikea vastaus on "+a+", mutta luokkasi antaa "+b);
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        Maksimivirtaus m = new Maksimivirtaus(2);
        m.lisaaKaari(1,2,1);
        testi(m,1);
    }

    @Test(timeout = 1000)
    public void testi2() {
        Maksimivirtaus m = new Maksimivirtaus(2);
        testi(m,0);
    }

    @Test(timeout = 1000)
    public void testi3() {
        Maksimivirtaus m = new Maksimivirtaus(2);
        m.lisaaKaari(2,1,1);
        testi(m,0);
    }
    
    @Test(timeout = 1000)
    public void testi4() {
        Maksimivirtaus m = new Maksimivirtaus(2);
        m.lisaaKaari(1,2,1);
        m.lisaaKaari(1,2,1);
        testi(m,2);
    }

    @Test(timeout = 1000)
    public void testi5() {
        int n = 100;
        Maksimivirtaus m = new Maksimivirtaus(n);
        for (int i = 1; i <= n-1; i++) {
            m.lisaaKaari(i,i+1,1);
        }
        testi(m,1);
    }

    @Test(timeout = 1000)
    public void testi6() {
        int n = 100;
        Maksimivirtaus m = new Maksimivirtaus(n);
        for (int i = 1; i <= n-1; i++) {
            m.lisaaKaari(i,i+1,n-i);
        }
        testi(m,1);
    }
    
    @Test(timeout = 1000)
    public void testi7() {
        Maksimivirtaus m = new Maksimivirtaus(2);
        for (int i = 1; i <= 1000; i++) {
            m.lisaaKaari(1,2,1000000);
        }
        testi(m,1000000000);
    }

    @Test(timeout = 1000)
    public void testi8() {
        Maksimivirtaus m = new Maksimivirtaus(4);
        m.lisaaKaari(1,2,1);
        m.lisaaKaari(1,3,1);
        m.lisaaKaari(2,3,1);
        m.lisaaKaari(2,4,1);
        m.lisaaKaari(3,4,1);
        testi(m,2);
    }

    @Test(timeout = 1000)
    public void testi9() {
        Maksimivirtaus m = new Maksimivirtaus(4);
        m.lisaaKaari(1,2,1);
        m.lisaaKaari(1,3,1);
        m.lisaaKaari(2,4,1);
        m.lisaaKaari(3,2,1);
        m.lisaaKaari(3,4,1);
        testi(m,2);
    }

    @Test(timeout = 1000)
    public void testi10() {
        int n = 10;
        Maksimivirtaus m = new Maksimivirtaus(n);
        int k = 1000;
        Random r = new Random(1337);
        for (int i = 1; i <= k; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            int p = r.nextInt(1000000)+1;
            m.lisaaKaari(a,b,p);
        }
        testi(m,32734596);
    }

    @Test(timeout = 1000)
    public void testi11() {
        int n = 20;
        Maksimivirtaus m = new Maksimivirtaus(n);
        int k = 1000;
        Random r = new Random(1337);
        for (int i = 1; i <= k; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            int p = r.nextInt(1000000)+1;
            m.lisaaKaari(a,b,p);
        }
        testi(m,17486809);
    }

    @Test(timeout = 1000)
    public void testi12() {
        int n = 50;
        Maksimivirtaus m = new Maksimivirtaus(n);
        int k = 1000;
        Random r = new Random(1337);
        for (int i = 1; i <= k; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            int p = r.nextInt(1000000)+1;
            m.lisaaKaari(a,b,p);
        }
        testi(m,5841612);
    }

    @Test(timeout = 1000)
    public void testi13() {
        int n = 100;
        Maksimivirtaus m = new Maksimivirtaus(n);
        int k = 1000;
        Random r = new Random(1337);
        for (int i = 1; i <= k; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            int p = r.nextInt(1000000)+1;
            m.lisaaKaari(a,b,p);
        }
        testi(m,2079196);
    }

    @Test(timeout = 1000)
    public void testi14() {
        Maksimivirtaus m = new Maksimivirtaus(2);
        m.lisaaKaari(1,1,1000000);
        m.lisaaKaari(2,2,1000000);
        m.lisaaKaari(1,2,1);
        testi(m,1);
    }

    @Test(timeout = 1000)
    public void testi15() {
        Maksimivirtaus m = new Maksimivirtaus(4);
        for (int i = 1; i <= 499; i++) {
            m.lisaaKaari(1,2,1000000);
            m.lisaaKaari(3,4,1000000);
        }
        m.lisaaKaari(2,3,1);
        m.lisaaKaari(3,2,1);
        testi(m,1);
    }
    
}
