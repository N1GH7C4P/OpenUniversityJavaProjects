import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("13.5")
public class VirittavatPuutTest {
    void testi(int n, int a) {
        VirittavatPuut v = new VirittavatPuut();
        int b = v.laske(n);
        if (a == b) return;
        fail("Oikea vastaus on "+a+", mutta koodisi antaa "+b);
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        testi(1,1);
    }

    @Test(timeout = 1000)
    public void testi2() {
        testi(2,1);
    }

    @Test(timeout = 1000)
    public void testi3() {
        testi(3,3);
    }

    @Test(timeout = 1000)
    public void testi4() {
        testi(4,16);
    }

    @Test(timeout = 1000)
    public void testi5() {
        testi(5,125);
    }

    @Test(timeout = 1000)
    public void testi6() {
        testi(6,1296);
    }

    @Test(timeout = 1000)
    public void testi7() {
        testi(7,16807);
    }

    @Test(timeout = 1000)
    public void testi8() {
        testi(8,262144);
    }
}
