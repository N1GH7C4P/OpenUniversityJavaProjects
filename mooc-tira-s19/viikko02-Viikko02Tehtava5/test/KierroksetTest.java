import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("2.5")
public class KierroksetTest {
    static int[] t1, t2, t3;
    
    @BeforeClass
    public static void alku() {
        int n = 1000000;
        t1 = new int[n];
        for (int i = 0; i < n; i++) t1[i] = i+1;
        t2 = new int[n];
        for (int i = 0; i < n; i++) t2[i] = n-i;
        t3 = new int[n];
        Random r = new Random(1337);
        for (int i = 0; i < n; i++) t3[i] = i+1;
        for (int i = n-1; i >= 0; i--) {
            int k = r.nextInt(i+1);
            int t = t3[i]; t3[i] = t3[k]; t3[k] = t;
        }
    }
    
    void testi(int[] t, int a) {
        String s = t.length <= 10 ? Arrays.toString(t) : "suuri";
        Kierrokset k = new Kierrokset();
        int b = k.laske(t);
        if (a == b) return;
        fail("Kun taulukko on "+s+", metodisi antaa "+b+" mutta oikea vastaus on "+a);
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        testi(new int[] {1}, 1);
    }    

    @Test(timeout = 1000)
    public void testi2() {
        testi(new int[] {1,9,2,8,3,7,4,6,5}, 5);
    }    

    @Test(timeout = 1000)
    public void testi3() {
        testi(new int[] {9,8,7,5,6,4,3,1,2}, 7);
    }    
    
    @Test(timeout = 1000)
    public void testi4() {
        testi(t1, 1);
    }    

    @Test(timeout = 10000)    
    public void testi5() {
    float t1 = java.lang.System.nanoTime();
        testi(t2, 1000000);
    float t2 = java.lang.System.nanoTime();
    float dt = t2-t1;
        System.out.println("dt: "+dt);
    }        

    @Test(timeout = 1000)
    public void testi6() {
        testi(t3, 499911);
    }        
}
