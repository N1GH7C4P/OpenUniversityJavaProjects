import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("4.4")
public class PoistotTest {
    static int[] t1, t2, t3;
    
    @BeforeClass
    public static void alku()  {
        int n = 1000000;
        t1 = new int[n];
        t2 = new int[n];
        t3 = new int[n];
        Random r = new Random(1337);
        for (int i = 0; i < n; i++) {
            t1[i] = r.nextInt(1000000000)+1;
            t2[i] = r.nextInt(2)+1;
            t3[i] = 123;
        }
    }

    void testi(int[] t, int a) {
        String s = t.length <= 10 ? Arrays.toString(t) : "suuri";
        Poistot p = new Poistot();
        int b = p.laske(t);
        if (a == b) return;
        fail("Kun taulukko on "+s+", metodisi antaa "+b+" mutta oikea vastaus on "+a);
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        testi(new int[] {1},1);
    }

    @Test(timeout = 1000)
    public void testi2() {
        testi(new int[] {1,2},2);
    }

    @Test(timeout = 1000)
    public void testi3() {
        testi(new int[] {1,1},0);
    }

    @Test(timeout = 1000)
    public void testi4() {
        testi(new int[] {1,3,3,4,4,1,2,5,5,2},0);
    }

    @Test(timeout = 1000)
    public void testi5() {
        testi(new int[] {1,1,1,1},0);
    }

    @Test(timeout = 1000)
    public void testi6() {
        testi(new int[] {1,1,1,1,1},1);
    }

    @Test(timeout = 1000)
    public void testi7() {
        testi(t1,1000000);
    }

    @Test(timeout = 1000)
    public void testi8() {
        testi(t2,1006);
    }    

    @Test(timeout = 1000)
    public void testi9() {
        testi(t3,0);
    }    
}
