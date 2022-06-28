import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("1.4")
public class TaulukkoTest {
    void testi(int[] u, int a) {
        String s = Arrays.toString(u);
        Taulukko t = new Taulukko();
        int b = t.laske(u);
        if (a == b) return;
        fail("Kun taulukko on "+s+", metodisi antaa "+b+" mutta oikea vastaus on "+a);
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        testi(new int[] {1},1);
    }

    @Test(timeout = 1000)
    public void testi2() {
        testi(new int[] {1,2,3,4,5},48);
    }

    @Test(timeout = 1000)
    public void testi3() {
        testi(new int[] {7,1,1,3,8,2,9,5,4,2},2538);
    }
    
    @Test(timeout = 1000)
    public void testi4() {
        int[] t = new int[20];
        for (int i = 0; i < 20; i++) t[i] = i+1;
        testi(t,5505024);
    }

    @Test(timeout = 1000)
    public void testi5() {
        int[] t = new int[20];
        for (int i = 0; i < 20; i++) t[i] = 100;
        testi(t,52428800);
    }
    
}
