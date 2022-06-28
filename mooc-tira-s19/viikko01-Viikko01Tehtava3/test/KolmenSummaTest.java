import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("1.3")
public class KolmenSummaTest {
    void testi(int x, int a) {
        KolmenSumma k = new KolmenSumma();
        int b = k.laske(x);
        if (a == b) return;
        fail("Kun x="+x+", metodisi antaa "+b+" mutta oikea vastaus on "+a);
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        testi(1,0);
    }

    @Test(timeout = 1000)
    public void testi2() {
        testi(10,4);
    }

    @Test(timeout = 1000)
    public void testi3() {
        testi(15,12);
    }    
    
    @Test(timeout = 1000)
    public void testi4() {
        testi(79,481);
    }    

    @Test(timeout = 1000)
    public void testi5() {
        testi(100,784);
    }
}
