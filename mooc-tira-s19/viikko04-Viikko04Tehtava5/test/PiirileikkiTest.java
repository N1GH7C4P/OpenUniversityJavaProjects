import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("4.5")
public class PiirileikkiTest {
    void testi(int n, int a) {
        Piirileikki p = new Piirileikki();
        int b = p.viimeinen(n);
        if (a == b) return;
        fail("Kun n="+n+", metodisi antaa "+b+" mutta oikea vastaus on "+a);
    }
    
    @Test(timeout = 1000)
    public void pienet() {
        testi(1,1);
        testi(2,1);
        testi(3,3);
        testi(4,1);
        testi(5,3);
        testi(6,5);
        testi(7,7);
        testi(8,1);
        testi(9,3);
        testi(10,5);
    }
    
    @Test(timeout = 1000)
    public void suuri1() {
        testi(123456,115841);
    }

    @Test(timeout = 1000)
    public void suuri2() {
        testi(654321,260067);
    }

    @Test(timeout = 1000)
    public void suuri3() {
        testi(999999,951423);
    }

    @Test(timeout = 1000)
    public void suuri4() {
        testi(1000000,951425);
    }
    
}
