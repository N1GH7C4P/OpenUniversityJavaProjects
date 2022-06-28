import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("10.1")
public class SaavutettavuusTest {
    @Test(timeout = 1000)
    public void testi1() {
        Saavutettavuus s = new Saavutettavuus(1);
        if (s.laske(1) == 0) return;
        fail("Luokkasi toimii väärin, kun verkossa on vain yksi kone");
    }    

    @Test(timeout = 1000)
    public void testi2() {
        int n = 5000;
        Saavutettavuus s = new Saavutettavuus(n);
        if (s.laske(1337) == 0) return;
        fail("Luokkasi toimii väärin, kun verkossa ei ole yhteyksiä");
    }    

    @Test(timeout = 1000)
    public void testi3() {
        int n = 5000;
        Saavutettavuus s = new Saavutettavuus(n);
        for (int i = 1; i+1 <= n; i++) s.lisaaYhteys(i,i+1);
        if (s.laske(1337) == n-1) return;
        fail("Luokkasi toimii väärin, kun koneet muodostavat ketjun, "+s.laske(1337)+" =//= "+(n-1));
    }    

    @Test(timeout = 1000)
    public void testi4() {
        int n = 5000;
        Saavutettavuus s = new Saavutettavuus(n);
        for (int i = 1; i+1 <= n; i += 2) s.lisaaYhteys(i,i+1);
        if (s.laske(42) == 1) return;
        fail("Luokkasi toimii väärin, kun koneet muodostavat pareja");
    }    

    @Test(timeout = 1000)
    public void testi5() {
        int n = 5000;
        Saavutettavuus s = new Saavutettavuus(n);
        for (int i = 1; i+2 <= n; i++) s.lisaaYhteys(i,i+2);
        if (s.laske(42) == n/2-1) return;
        fail("Luokkasi toimii väärin, kun koneet muodostavat kaksi ketjua");
    }    

    @Test(timeout = 1000)
    public void testi6() {
        int n = 444;
        Saavutettavuus s = new Saavutettavuus(n);
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                s.lisaaYhteys(i,j);
            }
        }
        if (s.laske(123) == n-1) return;
        fail("Luokkasi toimii väärin, kun kaikkien koneiden välillä on yhteys");
    }

    @Test(timeout = 1000)
    public void testi7() {
        Saavutettavuus s = new Saavutettavuus(19);
        s.lisaaYhteys(1,10);
        s.lisaaYhteys(1,14);
        s.lisaaYhteys(2,9);
        s.lisaaYhteys(2,13);
        s.lisaaYhteys(4,5);
        s.lisaaYhteys(4,11);
        s.lisaaYhteys(5,11);
        s.lisaaYhteys(6,10);
        s.lisaaYhteys(6,14);
        s.lisaaYhteys(6,15);
        s.lisaaYhteys(7,12);
        s.lisaaYhteys(7,19);
        s.lisaaYhteys(8,19);
        s.lisaaYhteys(9,18);
        s.lisaaYhteys(14,15);
        s.lisaaYhteys(17,19);
        if (s.laske(10) == 4) return;
        fail("Luokkasi toimii väärin, kun on sekalaisia yhteyksiä");
    }

    @Test(timeout = 1000)
    public void testi8() {
        Saavutettavuus s = new Saavutettavuus(2);
        s.lisaaYhteys(2,1);
        if (s.laske(1) == 1) return;
        fail("Luokkasi toimii väärin, kun kaari annetaan käänteisesti");
    }

    @Test(timeout = 1000)
    public void testi9() {
        int n = 5000;
        Saavutettavuus s = new Saavutettavuus(n);
        for (int i = 2; i <= n; i++) {
            for (int j = 2*i; j <= n; j += i) {
                s.lisaaYhteys(i, j);
            }
        }
        if (s.laske(1337) == 4696) return;
        fail("Luokkasi toimii väärin, kun on sekalaisia yhteyksiä");
    }
}
