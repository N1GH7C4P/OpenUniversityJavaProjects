import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("12.6")
public class JarjestyksetTest {
    void testi(Jarjestykset j, int a) {
        int b = j.laske();
        if (a == b) return;
        fail("Oikea vastaus on "+a+", mutta koodisi antaa "+b);
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        Jarjestykset j = new Jarjestykset(1);
        testi(j,1);
    }        

    @Test(timeout = 1000)
    public void testi2() {
        Jarjestykset j = new Jarjestykset(2);
        j.lisaaKaari(1,2);
        testi(j,1);
    }        

    @Test(timeout = 1000)
    public void testi3() {
        Jarjestykset j = new Jarjestykset(2);
        testi(j,2);
    }

    @Test(timeout = 1000)
    public void testi4() {
        Jarjestykset j = new Jarjestykset(1);
        j.lisaaKaari(1,1);
        testi(j,0);
    }

    @Test(timeout = 1000)
    public void testi5() {
        Jarjestykset j = new Jarjestykset(2);
        j.lisaaKaari(1,2);
        j.lisaaKaari(2,1);
        testi(j,0);
    }
    
    @Test(timeout = 1000)
    public void testi6() {
        Jarjestykset j = new Jarjestykset(5);
        testi(j,120);
    }

    @Test(timeout = 1000)
    public void testi7() {
        Jarjestykset j = new Jarjestykset(5);
        j.lisaaKaari(2,4);
        j.lisaaKaari(2,5);
        j.lisaaKaari(1,3);
        testi(j,20);
    }

    @Test(timeout = 1000)
    public void testi8() {
        Jarjestykset j = new Jarjestykset(5);
        j.lisaaKaari(1,2);
        j.lisaaKaari(2,3);
        j.lisaaKaari(3,4);
        j.lisaaKaari(4,5);
        testi(j,1);
    }

    @Test(timeout = 1000)
    public void testi9() {
        Jarjestykset j = new Jarjestykset(9);
        testi(j,362880);
    }

    @Test(timeout = 1000)
    public void testi10() {
        Jarjestykset j = new Jarjestykset(2);
        j.lisaaKaari(1,2);
        j.lisaaKaari(1,2);
        testi(j,1);
    }

    @Test(timeout = 1000)
    public void testi11() {
        int n = 100;
        Jarjestykset j = new Jarjestykset(n);
        for (int i = 1; i+1 <= n; i++) {
            j.lisaaKaari(i,i+1);
        }
        testi(j,1);
    }    

    @Test(timeout = 1000)
    public void testi12() {
        int n = 100;
        Jarjestykset j = new Jarjestykset(n);
        for (int i = 2; i+1 <= n; i++) {
            j.lisaaKaari(i,i+1);
        }
        testi(j,100);
    }    

    @Test(timeout = 1000)
    public void testi13() {
        int n = 100;
        Jarjestykset j = new Jarjestykset(n);
        for (int i = 3; i+1 <= n; i++) {
            j.lisaaKaari(i,i+1);
        }
        testi(j,9900);
    }    

    @Test(timeout = 1000)
    public void testi14() {
        int n = 10;
        Jarjestykset j = new Jarjestykset(n);
        j.lisaaKaari(1,3);
        j.lisaaKaari(3,7);
        j.lisaaKaari(4,2);
        testi(j,302400);
    }    

    @Test(timeout = 1000)
    public void testi15() {
        int n = 100;
        Jarjestykset j = new Jarjestykset(n);
        for (int i = 1; i+1 <= n; i++) {
            j.lisaaKaari(i,i+1);
        }
        j.lisaaKaari(n,1);
        testi(j,0);
    }    
    
    @Test(timeout = 1000)
    public void testi16() {
        Jarjestykset j = new Jarjestykset(10);
        j.lisaaKaari(1,2);
        j.lisaaKaari(2,3);
        j.lisaaKaari(3,4);
        j.lisaaKaari(4,5);
        j.lisaaKaari(6,7);
        j.lisaaKaari(7,8);
        j.lisaaKaari(8,9);
        j.lisaaKaari(9,10);
        testi(j,252);
    }    

    @Test(timeout = 1000)
    public void testi17() {
        Jarjestykset j = new Jarjestykset(100);
        j.lisaaKaari(3,8);
        j.lisaaKaari(5,8);
        j.lisaaKaari(8,7);
        j.lisaaKaari(7,9);
        j.lisaaKaari(9,3);
        testi(j,0);
    }    
    
    @Test(timeout = 5000)
    public void testi18() {
        int n = 100;
        Jarjestykset j = new Jarjestykset(n);
        for (int i = 4; i+1 <= n; i++) {
            j.lisaaKaari(i,i+1);
        }
        testi(j,970200);
    }    

    
}
