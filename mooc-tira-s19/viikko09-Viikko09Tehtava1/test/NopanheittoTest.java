import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("9.1")
public class NopanheittoTest {
    
    public void testi(int n, long a) {
        Nopanheitto x = new Nopanheitto();
        long b = x.laske(n);
        if (a == b) return;
        fail("Kun n="+n+", oikea vastaus on "+a+" mutta metodisi antaa "+b);
    }

    @Test(timeout = 1000)
    public void testi1() {
        testi(1,1);
    }    

    @Test(timeout = 1000)
    public void testi2() {
        testi(6,32);
    }    

    @Test(timeout = 1000)
    public void testi3() {
        testi(7,63);
    }    

    @Test(timeout = 1000)
    public void testi4() {
        testi(33,3414621024L);
    }    

    @Test(timeout = 1000)
    public void testi5() {
        testi(49,196131794875135L);
    }        

    @Test(timeout = 1000)
    public void testi6() {
        testi(50,389043663364337L);
    }        
}
