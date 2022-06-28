import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("3.2")
public class VainYksiTest {
    static int[] t1, t2;
    
    @BeforeClass
    public static void alku()  {
        int n = 999999;
        t1 = new int[n];
        Random r = new Random(1337);
        for (int i = 0; i < n; i++) {
            t1[i] = i/2+1;
        }
        for (int i = n-1; i >= 0; i--) {
            int k = r.nextInt(i+1);
            int t = t1[i]; t1[i] = t1[k]; t1[k] = t;
        }
        t2 = new int[n];
        for (int i = 0; i < n-1; i++) {
            t2[i] = (i/2+1)*1999;
        }
        t2[n-1] = 123456789;
        for (int i = n-1; i >= 0; i--) {
            int k = r.nextInt(i+1);
            int t = t2[i]; t2[i] = t2[k]; t2[k] = t;
        }
    }
    
    void testi(int[] t, int a) {
        String s = t.length <= 10 ? Arrays.toString(t) : "suuri";
        VainYksi x = new VainYksi();
        int b = x.etsi(t);
        if (a == b) return;
        fail("Kun taulukko on "+s+", metodisi antaa "+b+" mutta oikea vastaus on "+a);
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        testi(new int[] {1,1,2,2,3}, 3);
    }    

    @Test(timeout = 1000)
    public void testi2() {
        testi(new int[] {1,2,2,3,3}, 1);
    }

    @Test(timeout = 1000)
    public void testi3() {
        testi(new int[] {5}, 5);
    }

    @Test(timeout = 1000)
    public void testi4() {
        testi(new int[] {10,20,30,40,30,20,10}, 40);
    }

    @Test(timeout = 1000)
    public void testi5() {
        testi(t1, 500000);
    }    

    @Test(timeout = 1000)
    public void testi6() {
        testi(t2, 123456789);
    }    
}
