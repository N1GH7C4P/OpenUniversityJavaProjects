import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("9.3")
public class RuudukkoTest {
    public void testi(int[][] t, long a) {
        Ruudukko x = new Ruudukko();
        long b = x.laske(t);
        if (a == b) return;
        fail("Oikea vastaus on "+a+" mutta metodisi antaa "+b);
    }

    @Test(timeout = 1000)
    public void testi1() {
        testi(new int[][] {{1}},1);
    }    

    @Test(timeout = 1000)
    public void testi2() {
        testi(new int[][] {{1,2},{3,4}},8);
    }    

    @Test(timeout = 1000)
    public void testi3() {
        testi(new int[][] {{7,3,15,14},{9,16,8,5},{2,11,12,10},{1,6,13,4}},72);
    }    

    @Test(timeout = 1000)
    public void testi4() {
        int n = 100;
        int[][] t = new int[n][n];
        Random r = new Random(1337);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                t[i][j] = r.nextInt(100)+1;
            }
        }
        testi(t,14730);
    }    
    
    @Test(timeout = 1000)
    public void testi5() {
        int n = 100;
        int[][] t = new int[n][n];
        Random r = new Random(1337);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                t[i][j] = r.nextInt(10)+1;
            }
        }
        testi(t,1545);
    }    
}
