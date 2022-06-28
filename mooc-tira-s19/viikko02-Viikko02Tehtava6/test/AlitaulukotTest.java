import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("2.6")
public class AlitaulukotTest {
    static int[] t1, t2, t3, t4;
    
    @BeforeClass
    public static void alku() {
        int n = 1000000;
        t1 = new int[n];
        for (int i = 0; i < n; i++) t1[i] = 1;
        t2 = new int[n];
        for (int i = 0; i < n; i++) t2[i] = i+1;
        Random r = new Random(1337);
        t3 = new int[n];
        for (int i = 0; i < n; i++) {
            if (r.nextInt(10000) == 0) {
                t3[i] = 3;
            } else {
                t3[i] = r.nextInt(2)+1;
            }
        }
        t4 = new int[n];
        int a = 1, b = 2;
        for (int i = 0; i < n; i++) {
            int z = r.nextInt(10000);
            if (i == 0 || z == 0) {
                a = r.nextInt(1000000)+1;
            }
            if (i == 0 || z == 1) {
                b = r.nextInt(1000000)+1;
            }
            t4[i] = r.nextInt(2) == 0 ? a : b;
        }
    }
    
    void testi(int[] t, long a) {
        String s = t.length <= 10 ? Arrays.toString(t) : "suuri";
        Alitaulukot x = new Alitaulukot();
        long b = x.laske(t);
        if (a == b) return;
        fail("Kun taulukko on "+s+", metodisi antaa "+b+" mutta oikea vastaus on "+a);
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        testi(new int[] {1,2,1,2,1}, 15);
    }    

    @Test(timeout = 1000)
    public void testi2() {
        testi(new int[] {1,2,3,4,5}, 9);
    }

    @Test(timeout = 1000)
    public void testi3() {
        testi(t1, 500000500000L);
    }

    @Test(timeout = 1000)
    public void testi4() {
        testi(t2, 1999999);
    }

    @Test(timeout = 1000)
    public void testi5() {
        testi(t3, 11048749797L);
    }    

    @Test(timeout = 1000)
    public void testi6() {
        testi(t4, 4688866726L);
    }    
}
