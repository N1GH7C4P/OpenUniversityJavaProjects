import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("12.5")
public class SuunnatTest {
    int n;
    Suunnat s;
    int[][] x, y;
    
    void alusta(int n) {
        this.n = n;
        s = new Suunnat(n);
        x = new int[n+1][n+1];
        y = new int[n+1][n+1];
    }
    
    void lisaaKaari(int a, int b) {
        s.lisaaKaari(a,b);
        x[a][b]++;
        x[b][a]++;
    }
    
    void tarkasta(boolean tulos) {
        ArrayList<Kaari> kaaret = s.muodosta();
        if (tulos == false && kaaret == null) return;
        if (kaaret == null) fail("Ratkaisu on olemassa, mutta tulee null");
        for (Kaari k : kaaret) {
            x[k.alku][k.loppu]--;
            x[k.loppu][k.alku]--;
            y[k.alku][k.loppu] = 1;
        }
        boolean virhe = false;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i][j] != 0) virhe = true;
            }
        }
        if (virhe) fail("Verkon kaaret eivät ole kelvolliset");
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (y[i][k] == 1 && y[k][j] == 1) {
                        y[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (y[i][i] == 1) virhe = true;
        }
        if (virhe) fail("Verkko ei ole syklitön");
    }

    @Test(timeout = 1000)
    public void testi1() {
        alusta(2);
        lisaaKaari(1,2);
        tarkasta(true);
    }

    @Test(timeout = 1000)
    public void testi2() {
        alusta(2);
        lisaaKaari(1,2);
        lisaaKaari(2,1);
        tarkasta(true);
    }

    @Test(timeout = 1000)
    public void testi3() {
        alusta(1);
        lisaaKaari(1,1);
        tarkasta(false);
    }

    @Test(timeout = 1000)
    public void testi4() {
        alusta(4);
        lisaaKaari(1,2);
        lisaaKaari(2,3);
        lisaaKaari(3,4);
        lisaaKaari(4,1);
        tarkasta(true);
    }
    
    @Test(timeout = 1000)
    public void testi5() {
        alusta(100);
        tarkasta(true);
    }

    @Test(timeout = 1000)
    public void testi6() {
        alusta(2);
        int m = 100000;
        for (int i = 1; i <= m/2; i++) {
            lisaaKaari(1,2);
            lisaaKaari(2,1);
        }
        tarkasta(true);
    }

    @Test(timeout = 1000)
    public void testi7() {
        int n = 100;
        alusta(n);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                lisaaKaari(i,j);
            }
        }
        tarkasta(false);
    }

    @Test(timeout = 1000)
    public void testi8() {
        int n = 100;
        alusta(n);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) lisaaKaari(i,j);
            }
        }
        tarkasta(true);
    }

    @Test(timeout = 1000)
    public void testi9() {
        int n = 100;
        alusta(n);
        int m = 100000;
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            lisaaKaari(a,b);
        }
        tarkasta(false);
    }

    @Test(timeout = 1000)
    public void testi10() {
        int n = 100;
        alusta(n);
        int m = 100000;
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            if (a != b) lisaaKaari(a,b);
        }
        tarkasta(true);
    }

    @Test(timeout = 1000)
    public void testi11() {
        int n = 100;
        alusta(n);
        int m = 100000;
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int x = r.nextInt(n)+1;
            lisaaKaari(x,x);
        }
        tarkasta(false);
    }

    @Test(timeout = 1000)
    public void testi12() {
        alusta(15);
        lisaaKaari(2,3);
        lisaaKaari(4,5);
        lisaaKaari(5,6);
        lisaaKaari(6,4);
        lisaaKaari(7,8);
        lisaaKaari(8,9);
        lisaaKaari(9,10);
        lisaaKaari(10,7);
        lisaaKaari(11,12);
        lisaaKaari(12,13);
        lisaaKaari(13,14);
        lisaaKaari(14,15);
        lisaaKaari(15,11);
        tarkasta(true);
    }    
}
