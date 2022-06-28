import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("5.6")
public class SummahakuTest {
    static int[] t1, t2, t3;
    
    @BeforeClass
    public static void alku() {
        int n = 1000000;
        t1 = new int[n];
        t2 = new int[n];
        t3 = new int[n];
        for (int i = 0; i < n; i++) t1[i] = i%100+1;
        for (int i = 0; i < n; i++) t2[i] = 0;
        Random r = new Random(1337);
        for (int i = 0; i < n; i++) t3[i] = r.nextInt(201)-100;
    }
    
    public void testi(int[] t, int x, long v1) {
        String s = t.length <= 10 ? Arrays.toString(t) : "suuri";
        Summahaku a = new Summahaku();
        long v2 = a.laske(t,x);
        if (v1 == v2) return;
        fail("Kun taulukko on "+s+", oikea vastaus on "+v1+" mutta metodisi antaa "+v2);
    }

    @Test(timeout = 1000)
    public void testi1() {
        testi(new int[] {1,2,3},3,2);
    }    

    @Test(timeout = 1000)
    public void testi2() {
        testi(new int[] {5},5,1);
    }    

    @Test(timeout = 1000)
    public void testi3() {
        testi(new int[] {1,0,0,1,0,0,1},2,6);
    }    

    @Test(timeout = 1000)
    public void testi4() {
        testi(new int[] {100,-99,100},1,2);
    }    

    @Test(timeout = 1000)
    public void testi5() {
        testi(t1,123,30000);
    }    
    
    @Test(timeout = 1000)
    public void testi6() {
        testi(t2,0,500000500000L);
    }    

    @Test(timeout = 1000)
    public void testi7() {
        testi(t3,0,7530618);
    }    

    @Test(timeout = 1000)
    public void testi8() {
        testi(t3,1,7528004);
    }    
}
