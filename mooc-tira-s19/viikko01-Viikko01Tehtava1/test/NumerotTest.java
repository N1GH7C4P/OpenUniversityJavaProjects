import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("1.1")
public class NumerotTest {
    void testi(int x, int a) {
        Numerot n = new Numerot();
        int b = n.summa(x);
        if (a == b) return;
        fail("Kun x="+x+", metodisi antaa "+b+" mutta oikea vastaus on "+a);
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        testi(1,1);
    }

    @Test(timeout = 1000)
    public void testi2() {
        testi(1000000000,1);
    }

    @Test(timeout = 1000)
    public void testi3() {
        testi(721900373,32);
    }
}
