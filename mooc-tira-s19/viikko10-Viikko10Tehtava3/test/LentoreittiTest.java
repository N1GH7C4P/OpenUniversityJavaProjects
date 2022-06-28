import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("10.3")
public class LentoreittiTest {
    private void testi(Lentoreitti l, int x, int y, int a) {
        int b = l.laske(x,y);
        if (a == b) return;
        fail("Oikea vastaus on "+a+", mutta koodisi antaa "+b);
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        Lentoreitti l = new Lentoreitti(2);
        l.lisaaYhteys(1, 2);
        testi(l,1,2,0);
    }    

    @Test(timeout = 1000)
    public void testi2() {
        Lentoreitti l = new Lentoreitti(2);
        l.lisaaYhteys(2, 1);
        testi(l,1,2,0);
    }    

    @Test(timeout = 1000)
    public void testi3() {
        Lentoreitti l = new Lentoreitti(2);
        testi(l,1,2,-1);
    }    

    @Test(timeout = 1000)
    public void testi4() {
        int n = 5000;
        Lentoreitti l = new Lentoreitti(n);
        for (int i = 1; i+1 <= n; i++) l.lisaaYhteys(i,i+1);
        testi(l,1,n,n-2);
    }    

    @Test(timeout = 1000)
    public void testi5() {
        int n = 444;
        Lentoreitti l = new Lentoreitti(n);
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                l.lisaaYhteys(i,j);
            }
        }
        testi(l,1,n,0);
    }
    
    private void luoVerkko(Lentoreitti l) {
        l.lisaaYhteys(1,10);
        l.lisaaYhteys(1,14);
        l.lisaaYhteys(2,9);
        l.lisaaYhteys(2,13);
        l.lisaaYhteys(4,5);
        l.lisaaYhteys(4,11);
        l.lisaaYhteys(5,11);
        l.lisaaYhteys(6,10);
        l.lisaaYhteys(6,14);
        l.lisaaYhteys(6,15);
        l.lisaaYhteys(7,12);
        l.lisaaYhteys(7,19);
        l.lisaaYhteys(8,19);
        l.lisaaYhteys(9,18);
        l.lisaaYhteys(14,15);
        l.lisaaYhteys(17,19);        
    }

    @Test(timeout = 1000)
    public void testi6() {
        Lentoreitti l = new Lentoreitti(19);
        luoVerkko(l);
        testi(l,1,15,1);
    }

    @Test(timeout = 1000)
    public void testi7() {
        Lentoreitti l = new Lentoreitti(19);
        luoVerkko(l);
        testi(l,13,18,2);
    }
    
    @Test(timeout = 1000)
    public void testi8() {
        Lentoreitti l = new Lentoreitti(19);
        luoVerkko(l);
        testi(l,1,19,-1);
    }
    
    @Test(timeout = 1000)
    public void testi9() {
        int n = 5000;
        Lentoreitti l = new Lentoreitti(n);
        for (int i = 2; i <= n; i++) {
            for (int j = 2*i; j <= n; j += i) {
                l.lisaaYhteys(i, j);
            }
        }
        testi(l,51,97,1);
    }

    @Test(timeout = 1000)
    public void testi10() {
        int n = 5000;
        Lentoreitti l = new Lentoreitti(n);
        for (int i = 1; i+1 <= n; i++) l.lisaaYhteys(i,i+1);
        for (int i = 3; i <= n-1; i++) l.lisaaYhteys(1,i);
        testi(l,1,n,1);
    }

    @Test(timeout = 1000)
    public void testi11() {
        int n = 444;
        Lentoreitti l = new Lentoreitti(n);
        for (int i = 1; i <= n-1; i++) {
            for (int j = i+1; j <= n-1; j++) {
                l.lisaaYhteys(i,j);
            }
        }
        l.lisaaYhteys(n/2, n);
        testi(l,1,n,1);
    }

    @Test(timeout = 1000)
    public void testi12() {
        int n = 5000;
        Lentoreitti l = new Lentoreitti(n);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 2 && i+j <= n; j++) {
                l.lisaaYhteys(i,i+j);
            }
        }
        testi(l,1,n,n/2-1);
    }

    @Test(timeout = 1000)
    public void testi13() {
        int n = 5000;
        Lentoreitti l = new Lentoreitti(n);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5 && i+j <= n; j++) {
                l.lisaaYhteys(i,i+j);
            }
        }
        testi(l,1,n,n/5-1);
    }    
}
