import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("8.3")
public class OsajoukotTest {
    
    public void testi(int[] t, int x, int a) {
        String s = Arrays.toString(t);
        Osajoukot o = new Osajoukot();
        int b = o.laske(t, x);
        if (a == b) return;
        fail("Kun taulukko on "+s+" ja x="+x+", oikea vastaus on "+a+" mutta metodisi antaa "+b);
    }

    @Test(timeout = 1000)
    public void testi1() {
        testi(new int[] {1,2,3,4,5},10,3);
    }    

    @Test(timeout = 1000)
    public void testi2() {
        testi(new int[] {1,1,1,1,1},2,10);
    }    
    
    @Test(timeout = 1000)
    public void testi3() {
        testi(new int[] {1},1,1);
    }    

    @Test(timeout = 1000)
    public void testi4() {
        testi(new int[] {1},2,0);
    }    

    @Test(timeout = 1000)
    public void testi5() {
        int x = 1000000000;
        testi(new int[] {x,x,x,x,x},705032704,0);
    }

    @Test(timeout = 1000)
    public void testi6() {
        int n = 16;
        int[] t = new int[n];
        for (int i = 0; i < n; i++) t[i] = 1;
        testi(t,8,12870);
    }

    @Test(timeout = 1000)
    public void testi7() {
        int n = 16;
        Random r = new Random(1337);
        int[] t = new int[n];
        for (int i = 0; i < n; i++) t[i] = r.nextInt(5)+1;
        testi(t,10,211);
    }

    @Test(timeout = 1000)
    public void testi8() {
        int n = 16;
        Random r = new Random(1337);
        int[] t = new int[n];
        for (int i = 0; i < n; i++) t[i] = r.nextInt(100)+1;
        testi(t,123,71);
    }

    @Test(timeout = 1000)
    public void testi9() {
        int n = 16;
        Random r = new Random(1337);
        int[] t = new int[n];
        for (int i = 0; i < n; i++) t[i] = r.nextInt(1000000000)+1;
        testi(t,t[n/2],1);
    }    

    @Test(timeout = 1000)
    public void testi10() {
        int n = 16;
        Random r = new Random(1337);
        int[] t = new int[n];
        for (int i = 0; i < n; i++) t[i] = r.nextInt(1000000000)+1;
        testi(t,t[n/2]+1,0);
    }    
}
