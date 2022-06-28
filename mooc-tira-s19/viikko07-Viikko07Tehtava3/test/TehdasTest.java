import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("7.3")
public class TehdasTest {
    static int[] t1, t2, t3, t4;
    
    @BeforeClass
    public static void alku() {
        int n = 1000000;
        t1 = new int[n];
        for (int i = 0; i < n; i++) t1[i] = 1;
        Random r = new Random(1337);
        t2 = new int[n];
        for (int i = 0; i < n; i++) t2[i] = r.nextInt(10)+1;
        t3 = new int[n];
        for (int i = 0; i < n; i++) t3[i] = r.nextInt(1000000)+1;
        int k = 100;
        t4 = new int[k];
        for (int i = 0; i < k; i++) t4[i] = 1000000-r.nextInt(1000);
    }
    
    void testi(int[] t, int x, long a) {
        String s = t.length <= 10 ? Arrays.toString(t) : "suuri";
        Tehdas u = new Tehdas();
        long b = u.laske(t,x);
        if (a == b) return;
        fail("Kun t on "+s+" ja x on "+x+", oikea vastaus on "+a+" mutta metodisi antaa "+b);
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        testi(new int[] {1,1,2},10,4);
    }    

    @Test(timeout = 1000)
    public void testi2() {
        testi(new int[] {1},1,1);
    }    

    @Test(timeout = 1000)
    public void testi3() {
        testi(new int[] {1000000},1000000,1000000000000L);
    }    

    @Test(timeout = 1000)
    public void testi4() {
        testi(new int[] {42,1337},1000000,40720848);
    }    

    @Test(timeout = 1000)
    public void testi5() {
        testi(new int[] {42,666,1337},1000000,38374560);
    }    

    @Test(timeout = 1000)
    public void testi6() {
        testi(new int[] {1,10,100,1000},1000000,900091);
    }

    @Test(timeout = 2000)
    public void testi7() {
        testi(t1,1,1);
    }

    @Test(timeout = 2000)
    public void testi8() {
        testi(t1,1000000,1);
    }

    @Test(timeout = 2000)
    public void testi9() {
        testi(t2,1000000,5);
    }

    @Test(timeout = 2000)
    public void testi10() {
        testi(t3,1000000,78544);
    }    

    @Test(timeout = 2000)
    public void testi11() {
        testi(t4,1000000,9995630474L);
    }    
}
