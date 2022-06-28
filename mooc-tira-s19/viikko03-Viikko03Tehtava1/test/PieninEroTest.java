import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("3.1")
public class PieninEroTest {
    static int[] t1, t2;
    
    @BeforeClass
    public static void alku()  {
        int n = 1000000;
        t1 = new int[n];
        Random r = new Random(1337);
        for (int i = 0; i < n; i++) {
            t1[i] = r.nextInt(1000000000)+1;
        }
        t2 = new int[n];
        t2[0] = 1;
        for (int i = 1; i < n; i++) {
            t2[i] = t2[i-1]+r.nextInt(500)+500;
        }
        for (int i = n-1; i >= 0; i--) {
            int k = r.nextInt(i+1);
            int t = t2[i]; t2[i] = t2[k]; t2[k] = t;
        }
    }
    
    void testi(int[] t, int a) {
        String s = t.length <= 10 ? Arrays.toString(t) : "suuri";
        PieninEro x = new PieninEro();
        int b = x.laske(t);
        if (a == b) return;
        fail("Kun taulukko on "+s+", metodisi antaa "+b+" mutta oikea vastaus on "+a);
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        testi(new int[] {1,2,3,4,5}, 1);
    }    

    @Test(timeout = 1000)
    public void testi2() {
        testi(new int[] {1,1,1,1,1}, 0);
    }

    @Test(timeout = 1000)
    public void testi3() {
        testi(new int[] {1,1000000000}, 999999999);
    }

    @Test(timeout = 1000)
    public void testi4() {
        testi(new int[] {38,10,25,2,29,50}, 4);
    }

    @Test(timeout = 1000)
    public void testi5() {
        testi(t1, 0);
    }    

    @Test(timeout = 1000)
    public void testi6() {
        testi(t2, 500);
    }    
}
