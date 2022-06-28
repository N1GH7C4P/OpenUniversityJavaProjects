import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("8.5")
public class LatinalaisetTest {
    
    public void testi(int n, int a) {
        Latinalaiset l = new Latinalaiset();
        int b = l.laske(n);
        if (a == b) return;
        fail("Kun n="+n+", oikea vastaus on "+a+" mutta metodisi antaa "+b);
    }

    @Test(timeout = 1000)
    public void testi1() {
        testi(1,1);
    }    

    @Test(timeout = 1000)
    public void testi2() {
        testi(2,2);
    }    

    @Test(timeout = 1000)
    public void testi3() {
        testi(3,12);
    }    

    @Test(timeout = 1000)
    public void testi4() {
        testi(4,576);
    }    

    @Test(timeout = 1000)
    public void testi5() {
        testi(5,161280);
    }
}
