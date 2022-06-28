import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("5.3")
public class ToistuminenTest {
    private static int[] t1;
    
    @BeforeClass
    public static void alku() {
        int n = 1000000;
        t1 = new int[n];
        Random r = new Random(1337);
        for (int i = 0; i < n; i++) {
            t1[i] = r.nextInt(1000000000)+1;
        }
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        Toistuminen t = new Toistuminen();
        assertEquals(t.uusiLuku(1),-1);
        assertEquals(t.uusiLuku(1),0);
        assertEquals(t.uusiLuku(2),-1);
        assertEquals(t.uusiLuku(2),0);
        assertEquals(t.uusiLuku(1),2);
        assertEquals(t.uusiLuku(2),1);
        assertEquals(t.uusiLuku(1),1);
    }

    @Test(timeout = 10000)
    public void testi2() {
        Toistuminen t = new Toistuminen();
        assertEquals(t.uusiLuku(1),-1);
        for (int i = 1; i <= 999999; i++) {
            assertEquals(t.uusiLuku(1),0);
        }
    }

    @Test(timeout = 10000)
    public void testi3() {
        Toistuminen t = new Toistuminen();
        for (int i = 1; i <= 1000000; i++) {
            assertEquals(t.uusiLuku(i),-1);
        }
    }

    @Test(timeout = 10000)
    public void testi4() {
        Toistuminen t = new Toistuminen();
        for (int i = 1; i <= 100; i++) {
            assertEquals(t.uusiLuku(i),-1);
        }
        for (int i = 0; i < 1000000-100; i++) {
            assertEquals(t.uusiLuku(i%100+1),99);
        }
    }

    @Test(timeout = 10000)
    public void testi5() {
        Toistuminen t = new Toistuminen();
        long c = 0;
        for (int i = 0; i < 1000000; i++) {
            c += t.uusiLuku(t1[i]);
        }
        assertEquals(c,173563581);
    }

    @Test(timeout = 10000)
    public void testi6() {
        Toistuminen t = new Toistuminen();
        long c = 0;
        for (int i = 0; i < 1000000; i++) {
            c += t.uusiLuku(t1[i%100000]);
        }
        assertEquals(c,89995483239L);
    }

    
}
