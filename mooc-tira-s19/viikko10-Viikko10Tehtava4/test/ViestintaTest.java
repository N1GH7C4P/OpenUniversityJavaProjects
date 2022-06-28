import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("10.4")
public class ViestintaTest {
    @Test(timeout = 1000)
    public void testi1() {
        Viestinta v = new Viestinta(2);
        v.lisaaYhteys(1,2);
        if (v.tarkasta(1,2)) return;
        fail("Luokkasi toimii väärin, kun verkossa on vain yksi yhteys");
    }    

    @Test(timeout = 1000)
    public void testi2() {
        int n = 5000;
        int m = 100000;
        Viestinta v = new Viestinta(n);
        for (int i = 1; i+1 <= n; i++) v.lisaaYhteys(i,i+1);
        for (int i = 1; i <= m; i++) {
            if (!v.tarkasta(1,n)) fail("Luokkasi toimii väärin, kun koneet muodostavat ketjun");
        }
    }    

    @Test(timeout = 1000)
    public void testi3() {
        int n = 444;
        Viestinta v = new Viestinta(n);
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                v.lisaaYhteys(i,j);
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (!v.tarkasta(i,j)) fail("Luokkasi toimii väärin, kun kaikkien koneiden välillä on yhteys");
            }
        }
    }

    @Test(timeout = 1000)
    public void testi4() {
        int n = 19;
        Viestinta v = new Viestinta(n);
        v.lisaaYhteys(1,10);
        v.lisaaYhteys(1,14);
        v.lisaaYhteys(2,9);
        v.lisaaYhteys(2,13);
        v.lisaaYhteys(4,5);
        v.lisaaYhteys(4,11);
        v.lisaaYhteys(5,11);
        v.lisaaYhteys(6,10);
        v.lisaaYhteys(6,14);
        v.lisaaYhteys(6,15);
        v.lisaaYhteys(7,12);
        v.lisaaYhteys(7,19);
        v.lisaaYhteys(8,19);
        v.lisaaYhteys(9,18);
        v.lisaaYhteys(14,15);
        v.lisaaYhteys(17,19);
        int c = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (v.tarkasta(i,j)) c++;
            }
        }
        if (c == 58) return;
        fail("Luokkasi toimii väärin, kun on sekalaisia komponentteja c: "+c);
    }

    @Test(timeout = 1000)
    public void testi5() {
        int n = 5000;
        int m = 100000;
        Viestinta v = new Viestinta(n);
        for (int i = 2; i <= n; i++) {
            for (int j = 2*i; j <= n; j += i) {
                v.lisaaYhteys(i, j);
            }
        }
        int c = 0;
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int x = r.nextInt(n-1)+1;
            int y = x+r.nextInt(n-x)+1;
            if (v.tarkasta(x,y)) c++;
        }
        if (c == 84517) return;
        fail("Luokkasi toimii väärin, kun on sekalaisia komponentteja");
    }

    @Test(timeout = 1000)
    public void testi6() {
        int n = 5000;
        int m = 100000;
        Viestinta v = new Viestinta(n);
        for (int i = 1; i+1 <= n; i++) v.lisaaYhteys(i,i+1);
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int x = r.nextInt(n-1)+1;
            int y = x+r.nextInt(n-x)+1;
            if (!v.tarkasta(x,y)) fail("Luokkasi toimii väärin, kun koneet muodostavat ketjun");
        }
    }    

    @Test(timeout = 1000)
    public void testi7() {
        int n = 5000;
        int m = 100000;
        Viestinta v = new Viestinta(n);
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int x = r.nextInt(n-1)+1;
            int y = x+r.nextInt(n-x)+1;
            if (v.tarkasta(x,y)) fail("Luokkasi toimii väärin, kun verkossa ei ole yhteyksiä");
        }
    }

    @Test(timeout = 1000)
    public void testi8() {
        int n = 5000;
        int m = 100000;
        Viestinta v = new Viestinta(n);
        for (int i = 1; i+2 <= n; i++) v.lisaaYhteys(i,i+2);
        Random r = new Random(1337);
        int c = 0;
        for (int i = 1; i <= m; i++) {
            int x = r.nextInt(n-1)+1;
            int y = x+r.nextInt(n-x)+1;
            if (v.tarkasta(x,y)) c++;
        }
        if (c == 49952) return;
        fail("Luokkasi toimii väärin, kun koneet muodostavat kaksi ketjua");
    }
}
