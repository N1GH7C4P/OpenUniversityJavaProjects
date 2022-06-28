import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("10.2")
public class KomponentitTest {
    @Test(timeout = 1000)
    public void testi1() {
        Komponentit k = new Komponentit(1);
        if (k.laske() == 1) return;
        fail("Luokkasi toimii väärin, kun verkossa on vain yksi kone");
    }    

    @Test(timeout = 1000)
    public void testi2() {
        int n = 5000;
        Komponentit k = new Komponentit(n);
        if (k.laske() == n) return;
        fail("Luokkasi toimii väärin, kun verkossa ei ole yhteyksiä"+k.laske());
    }    

    @Test(timeout = 1000)
    public void testi3() {
        int n = 5000;
        Komponentit k = new Komponentit(n);
        for (int i = 1; i+1 <= n; i++) k.lisaaYhteys(i,i+1);
        if (k.laske() == 1) return;
        fail("Luokkasi toimii väärin, kun koneet muodostavat ketjun");
    }    

    @Test(timeout = 1000)
    public void testi4() {
        int n = 5000;
        Komponentit k = new Komponentit(n);
        for (int i = 1; i+1 <= n; i += 2) k.lisaaYhteys(i,i+1);
        if (k.laske() == n/2) return;
        fail("Luokkasi toimii väärin, kun koneet muodostavat pareja");
    }    

    @Test(timeout = 1000)
    public void testi5() {
        int n = 5000;
        Komponentit k = new Komponentit(n);
        for (int i = 1; i+2 <= n; i++) k.lisaaYhteys(i,i+2);
        if (k.laske() == 2) return;
        fail("Luokkasi toimii väärin, kun koneet muodostavat kaksi ketjua");
    }    

    @Test(timeout = 1000)
    public void testi6() {
        int n = 444;
        Komponentit k = new Komponentit(n);
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                k.lisaaYhteys(i,j);
            }
        }
        if (k.laske() == 1) return;
        fail("Luokkasi toimii väärin, kun kaikkien koneiden välillä on yhteys");
    }

    @Test(timeout = 1000)
    public void testi7() {
        Komponentit k = new Komponentit(19);
        k.lisaaYhteys(1,10);
        k.lisaaYhteys(1,14);
        k.lisaaYhteys(2,9);
        k.lisaaYhteys(2,13);
        k.lisaaYhteys(4,5);
        k.lisaaYhteys(4,11);
        k.lisaaYhteys(5,11);
        k.lisaaYhteys(6,10);
        k.lisaaYhteys(6,14);
        k.lisaaYhteys(6,15);
        k.lisaaYhteys(7,12);
        k.lisaaYhteys(7,19);
        k.lisaaYhteys(8,19);
        k.lisaaYhteys(9,18);
        k.lisaaYhteys(14,15);
        k.lisaaYhteys(17,19);
        if (k.laske() == 6) return;
        fail("Luokkasi toimii väärin, kun on sekalaisia komponentteja");
    }

    @Test(timeout = 1000)
    public void testi8() {
        Komponentit k = new Komponentit(2);
        k.lisaaYhteys(2,1);
        if (k.laske() == 1) return;
        fail("Luokkasi toimii väärin, kun kaari annetaan käänteisesti");
    }

    @Test(timeout = 1000)
    public void testi9() {
        int n = 5000;
        Komponentit k = new Komponentit(n);
        for (int i = 2; i <= n; i++) {
            for (int j = 2*i; j <= n; j += i) {
                k.lisaaYhteys(i, j);
            }
        }
        if (k.laske() == 304) return;
        fail("Luokkasi toimii väärin, kun on sekalaisia komponentteja");
    }
}
