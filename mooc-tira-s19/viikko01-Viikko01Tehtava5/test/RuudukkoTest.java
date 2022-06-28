import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("1.5")
public class RuudukkoTest {
    void testi(int n) {
        Ruudukko r = new Ruudukko();
        int[][] u = r.muodosta(n);
        boolean ok = true;
        if (u.length != n) ok = false;
        for (int i = 0; i < n; i++) {
            if (u[i].length != n) ok = false;
            for (int j = 0; j < n; j++) {
                if (u[i][j] != (i^j)) ok = false;
            }
        }
        if (!ok) fail("Metodisi toimii väärin, kun n="+n);
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        testi(1);
    }    

    @Test(timeout = 1000)
    public void testi2() {
        testi(10);
    }    

    @Test(timeout = 1000)
    public void testi3() {
        testi(25);
    }    

    @Test(timeout = 1000)
    public void testi4() {
        testi(50);
    }    
    
}
