import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("9.2")
public class AlijonotTest {
    static int[] t1, t2, t3, t4, t5;
    
    @BeforeClass
    public static void alku() {
        int n = 1000;
        t1 = new int[n];
        for (int i = 0; i < n; i++) t1[i] = 1;
        t2 = new int[n];
        for (int i = 0; i < n; i++) t2[i] = i%2+1;
        Random r = new Random(1337);
        t3 = new int[n];
        for (int i = 0; i < n; i++) t3[i] = r.nextInt(10)+1;
        t4 = new int[n];
        for (int i = 0; i < n; i++) t4[i] = r.nextInt(1000000000)+1;
        t5 = new int[n];
        for (int i = 0; i < n; i++) t5[i] = r.nextInt(100)+1;
    }
    
    public void testi(int[] t, long a) {
        String s = t.length <= 10 ? Arrays.toString(t) : "suuri";
        Alijonot x = new Alijonot();
        long b = x.laske(t);
        if (a == b) return;
        fail("Kun taulukko on "+s+", oikea vastaus on "+a+" mutta metodisi antaa "+b);
    }
    
    @Test(timeout = 10000)
    public void testi1() {
        testi(new int[] {1},1);
    }    

    @Test(timeout = 10000)
    public void testi2() {
        testi(new int[] {1,2,1,2},4);
    }    

    @Test(timeout = 10000)
    public void testi3() {
        testi(new int[] {1000000000,1,999999999},2);
    }    

    @Test(timeout = 10000)
    public void testi4() {
        testi(new int[] {1,4,7,5,8,9,4,3,2,7},5);
    }    

    @Test(timeout = 10000)
    public void testi5() {
        testi(t1,1);
    }    

    @Test(timeout = 1000)
    public void testi6() {
        testi(t2,1000);
    }    

    @Test(timeout = 1000)
    public void testi7() {
        testi(t3,227);
    }    

    @Test(timeout = 1000)
    public void testi8() {
        testi(t4,1);
    }        

    @Test(timeout = 1000)
    public void testi9() {
        testi(t5,34);
    }        
}
