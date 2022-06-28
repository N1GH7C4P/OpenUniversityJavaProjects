import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("8.4")
public class PermutaatiotTest {
    
    public void testi(int n, int a) {
        Permutaatiot p = new Permutaatiot();
        int b = p.laske(n);
        if (a == b) return;
        fail("Kun n="+n+", oikea vastaus on "+a+" mutta metodisi antaa "+b);
    }

    @Test(timeout = 1000)
    public void testi1() {
        testi(1,1);
    }    

    @Test(timeout = 1000)
    public void testi2() {
        testi(2,0);
    }    

    @Test(timeout = 1000)
    public void testi3() {
        testi(3,0);
    }    

    @Test(timeout = 1000)
    public void testi4() {
        testi(4,2);
    }    

    @Test(timeout = 1000)
    public void testi5() {
        testi(5,14);
    }    

    @Test(timeout = 1000)
    public void testi6() {
        testi(6,90);
    }    

    @Test(timeout = 1000)
    public void testi7() {
        testi(7,646);
    }    

    @Test(timeout = 1000)
    public void testi8() {
        testi(8,5242);
    }        
}
