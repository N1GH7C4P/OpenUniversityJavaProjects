import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("2.4")
public class HalkaisuTest {
    static int[] t1, t2;
    
    @BeforeClass
    public static void alku() {
        int n = 1000000;
        t1 = new int[n];
        for (int i = 0; i < n; i++) t1[i] = 0;
        t2 = new int[n];
        Random r = new Random(1337);
        for (int i = 0; i < n/2; i++) t2[i] = r.nextInt(11)-5;
        for (int i = n/2; i < n; i++) t2[i] = t2[i-n/2];
    }
    
    void testi(int[] t, int a) {
        String s = t.length <= 10 ? Arrays.toString(t) : "suuri";
        Halkaisu h = new Halkaisu();
        int b = h.laske(t);
        if (a == b) return;
        fail("Kun taulukko on "+s+", metodisi antaa "+b+" mutta oikea vastaus on "+a);
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        testi(new int[] {1,1}, 1);
    }    

    @Test(timeout = 1000)
    public void testi2() {
        testi(new int[] {1,2}, 0);
    }    

    @Test(timeout = 1000)
    public void testi3() {
        testi(new int[] {1,-1,1,-1,1,-1,1,-1}, 3);
    }    
    
    @Test(timeout = 1000)
    public void testi4() {
        testi(t1, 999999);
    }    

    @Test(timeout = 1000)
    public void testi5() {
        testi(t2, 396);
    }        
}
