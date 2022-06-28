import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("2.3")
public class MuutoksetTest {
    static int[] t1, t2, t3;
    
    @BeforeClass
    public static void alku() {
        int n = 1000000;
        t1 = new int[n];
        for (int i = 0; i < n; i++) t1[i] = i+1;
        t2 = new int[n];
        for (int i = 0; i < n; i++) t2[i] = 1;
        t3 = new int[n];
        Random r = new Random(1337);
        for (int i = 0; i < n; i++) {
            if (i == 0 || r.nextInt(10) == 0) {
                t3[i] = r.nextInt(1000000)+1;
            } else {
                t3[i] = t3[i-1];
            }
        }
    }
    
    void testi(int[] t, int a) {
        String s = t.length <= 10 ? Arrays.toString(t) : "suuri";
        Muutokset m = new Muutokset();
        int b = m.laske(t);
        if (a == b) return;
        fail("Kun taulukko on "+s+", metodisi antaa "+b+" mutta oikea vastaus on "+a);
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        testi(new int[] {1}, 0);
    }    

    @Test(timeout = 1000)
    public void testi2() {
        testi(new int[] {1,2,2,3,3,3,4,4,4,4}, 4);
    }    

    @Test(timeout = 1000)
    public void testi3() {
        testi(new int[] {1,1,2,2,1,1,2,2,1,1}, 5);
    }    
    
    @Test(timeout = 1000)
    public void testi4() {
        testi(t1, 0);
    }    

    @Test(timeout = 1000)
    public void testi5() {
        testi(t2, 500000);
    }    

    @Test(timeout = 1000)
    public void testi6() {
        testi(t3, 473389);
    }    
    
}
