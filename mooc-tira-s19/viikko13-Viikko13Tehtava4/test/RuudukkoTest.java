import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("13.4")
public class RuudukkoTest {
    void virhe() {
        fail("Luokkasi toimii väärin");
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        Ruudukko r = new Ruudukko(1);
        if (r.laskeHuoneet() != 0) virhe();
        r.teeLattia(1,1);
        if (r.laskeHuoneet() != 1) virhe();
    }

    @Test(timeout = 1000)
    public void testi2() {
        Ruudukko r = new Ruudukko(2);
        if (r.laskeHuoneet() != 0) virhe();
        r.teeLattia(1,1);
        if (r.laskeHuoneet() != 1) virhe();
        r.teeLattia(2,2);
        if (r.laskeHuoneet() != 2) virhe();
        r.teeLattia(1,2);
        if (r.laskeHuoneet() != 1) virhe();
        r.teeLattia(2,1);
        if (r.laskeHuoneet() != 1) virhe();
    }

    @Test(timeout = 1000)
    public void testi3() {
        Ruudukko r = new Ruudukko(1);
        r.teeLattia(1,1);
        if (r.laskeHuoneet() != 1) virhe();
        r.teeLattia(1,1);
        if (r.laskeHuoneet() != 1) virhe();
    }
    
    @Test(timeout = 1000)
    public void testi4() {
        Ruudukko r = new Ruudukko(3);
        r.teeLattia(1,1);
        r.teeLattia(1,2);
        r.teeLattia(1,3);
        r.teeLattia(2,3);
        r.teeLattia(3,3);
        r.teeLattia(3,2);
        r.teeLattia(3,1);
        if (r.laskeHuoneet() != 1) virhe();
        r.teeLattia(2,1);
        if (r.laskeHuoneet() != 1) virhe();
    }

    @Test(timeout = 1000)
    public void testi5() {
        Ruudukko r = new Ruudukko(3);
        r.teeLattia(1,1);
        r.teeLattia(1,2);
        r.teeLattia(1,3);
        r.teeLattia(3,1);
        r.teeLattia(3,2);
        r.teeLattia(3,3);
        if (r.laskeHuoneet() != 2) virhe();
        r.teeLattia(2,2);
        if (r.laskeHuoneet() != 1) virhe();
    }

    @Test(timeout = 1000)
    public void testi6() {
        int n = 500;
        int m = 100000;
        Ruudukko r = new Ruudukko(n);
        Random x = new Random(1337);
        long c = 0;
        for (int i = 1; i <= m; i++) {
            int a = x.nextInt(n)+1;
            int b = x.nextInt(n)+1;
            r.teeLattia(a,b);
            c += r.laskeHuoneet();
        }
        if (c != 2472002837L) virhe();
    }    

    @Test(timeout = 1000)
    public void testi7() {
        int n = 500;
        int m = 100000;
        Ruudukko r = new Ruudukko(n);
        long c = 0;
        for (int i = 1; i <= m; i++) {
            r.teeLattia(1,1);
            c += r.laskeHuoneet();
        }
        if (c != m) virhe();
    }    

    @Test(timeout = 1000)
    public void testi8() {
        int n = 500;
        int m = 100000;
        Ruudukko r = new Ruudukko(n);
        long c = 0;
        int a = 1, b = 1;
        for (int i = 1; i <= m; i++) {
            r.teeLattia(a,b);
            c += r.laskeHuoneet();
            a++;
            if (a == n+1) {b++; a = 1;}
        }
        if (c != m) virhe();
    }    

    @Test(timeout = 1000)
    public void testi9() {
        Ruudukko r = new Ruudukko(3);
        r.teeLattia(1,2);
        r.teeLattia(3,2);
        r.teeLattia(2,1);
        r.teeLattia(2,3);
        if (r.laskeHuoneet() != 4) virhe();
        r.teeLattia(2,2);
        if (r.laskeHuoneet() != 1) virhe();
    }
    
    int[] tila, nahty;
    
    void haku(int k, int n) {
        if (k < 0 || k >= n*n) return;
        if (tila[k] == 0 || nahty[k] == 1) return;
        nahty[k] = 1;
        haku(k-n,n);
        haku(k+n,n);
        if (k%n != 0) haku(k-1,n);
        if (k%n != n-1) haku(k+1,n);
    }

    @Test(timeout = 1000)
    public void testi10() {
        int n = 500;
        int m = 100000;
        Ruudukko r = new Ruudukko(n);
        Random x = new Random();
        tila = new int[n*n];
        for (int i = 1; i <= m; i++) {
            int a = x.nextInt(n)+1;
            int b = x.nextInt(n)+1;
            tila[(a-1)*n+b-1] = 1;
            r.teeLattia(a,b);
            int h = r.laskeHuoneet();
            if (x.nextInt(10000) == 666) {
                nahty = new int[n*n];
                int u = 0;
                for (int j = 0; j < n*n; j++) {
                    if (tila[j] == 1 && nahty[j] == 0) {
                        u++;
                        haku(j,n);
                    }
                }
                if (u != h) virhe();
            }
        }
    }    
}
