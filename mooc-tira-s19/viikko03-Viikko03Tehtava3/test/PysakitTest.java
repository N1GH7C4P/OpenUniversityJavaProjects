import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("3.3")
public class PysakitTest {
    static int[] t1;
    
    @BeforeClass
    public static void alku()  {
        int n = 1000000;
        t1 = new int[n];
        Random r = new Random(1337);
        for (int i = 0; i < n; i++) {
            t1[i] = r.nextInt(1000000000)+1;
        }
    }
    
    void testi(int[] t, int k, int a) {
        String s = t.length <= 10 ? Arrays.toString(t) : "suuri";
        Pysakit x = new Pysakit();
        int b = x.laske(t,k);
        if (a == b) return;
        fail("Kun taulukko on "+s+" ja k="+k+", metodisi antaa "+b+" mutta oikea vastaus on "+a);
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        testi(new int[] {1,1,5}, 1, 2);
    }    

    @Test(timeout = 1000)
    public void testi2() {
        testi(new int[] {5,4,3,2,1}, 2, 1);
    }

    @Test(timeout = 1000)
    public void testi3() {
        testi(new int[] {21,22,23,11,12,13,1,2,3}, 1, 3);
    }

    @Test(timeout = 1000)
    public void testi4() {
        testi(t1, 100, 832906);
    }    

    @Test(timeout = 1000)
    public void testi5() {
        testi(t1, 5000, 90881);
    }        
    
    @Test(timeout = 1000)
    public void testi6() {
        testi(t1, 100000, 4976);
    }    

    @Test(timeout = 1000)
    public void testi7() {
        testi(t1, 1000000000, 1);
    }    
}
