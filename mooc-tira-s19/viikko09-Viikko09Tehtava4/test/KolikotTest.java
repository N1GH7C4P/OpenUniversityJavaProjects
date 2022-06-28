import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("9.4")
public class KolikotTest {
    public void testi(int[] t, int a) {
        String s = t.length <= 10 ? Arrays.toString(t) : "suuri";
        Kolikot k = new Kolikot();
        int b = k.laske(t);
        if (a == b) return;
        fail("Kun taulukko on "+s+", oikea vastaus on "+a+" mutta metodisi antaa "+b);
    }

    @Test(timeout = 1000)
    public void testi1() {
        testi(new int[] {1},1);
    }    

    @Test(timeout = 1000)
    public void testi2() {
        testi(new int[] {1,2,4,8},15);
    }    
    
    @Test(timeout = 1000)
    public void testi3() {
        testi(new int[] {1,1,1,2,2,2,3,3,3},18);
    }    

    @Test(timeout = 1000)
    public void testi4() {
        testi(new int[] {100,100,100},3);
    }    

    @Test(timeout = 1000)
    public void testi5() {
        int n = 100;
        int[] t = new int[n];
        for (int i = 0; i < n; i++) t[i] = 1;
        testi(t,n);
    }    

    @Test(timeout = 1000)
    public void testi6() {
        int n = 100;
        int[] t = new int[n];
        for (int i = 0; i < n; i++) t[i] = i+1;
        testi(t,n*(n+1)/2);
    }    

    @Test(timeout = 1000)
    public void testi7() {
        int n = 100;
        int[] t = new int[n];
        for (int i = 0; i < n; i++) t[i] = 100;
        testi(t,n);
    }    

    @Test(timeout = 1000)
    public void testi8() {
        int n = 100;
        int[] t = new int[n];
        Random r = new Random(1337);
        for (int i = 0; i < n; i++) t[i] = r.nextInt(10)+1;
        testi(t,502);
    }    

    @Test(timeout = 1000)
    public void testi9() {
        int n = 100;
        int[] t = new int[n];
        Random r = new Random(1337);
        for (int i = 0; i < n; i++) t[i] = r.nextInt(100)+1;
        testi(t,4442);
    }    

    @Test(timeout = 1000)
    public void testi10() {
        int n = 100;
        int[] t = new int[n];
        Random r = new Random(1337);
        for (int i = 0; i < n; i++) t[i] = r.nextInt(10)+91;
        testi(t,8506);
    }    

    @Test(timeout = 1000)
    public void testi11() {
        int n = 100;
        int[] t = new int[n];
        for (int i = 0; i <= 6; i++) t[i] = 1<<i;
        for (int i = 7; i < n; i++) t[i] = 100;
        testi(t,9427);
    }    
    
}
