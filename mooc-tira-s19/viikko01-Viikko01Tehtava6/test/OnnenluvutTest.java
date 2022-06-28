import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("1.6")
public class OnnenluvutTest {
    void testi(int a, int b, int x) {
        Onnenluvut o = new Onnenluvut();
        int y = o.laske(a,b);
        if (x == y) return;
        fail("Kun väli on "+a+"..."+b+", metodisi antaa "+y+" mutta oikea vastaus on "+x);
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        testi(1,100,6);
    }    

    @Test(timeout = 1000)
    public void testi2() {
        testi(3,3,1);
    }        
    
    @Test(timeout = 1000)
    public void testi3() {
        testi(123,456,4);
    }    
    
    @Test(timeout = 1000)
    public void testi4() {
        testi(1,1000000000,1022);
    }    

    @Test(timeout = 1000)
    public void testi5() {
        testi(377373337,777377333,264);
    }        
}
