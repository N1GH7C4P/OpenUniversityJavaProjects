import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("6.2")
public class PieninEtaisyysTest {
    static int[] t1;
    
    @BeforeClass
    public static void alku() {
        int n = 1000000;
        Random r = new Random(1337);
        t1 = new int[n];
        for (int i = 0; i < n; i++) {
            t1[i] = r.nextInt(1000000000)+1;
        }
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        PieninEtaisyys p = new PieninEtaisyys();
        p.lisaa(1);
        p.lisaa(2);
        if (p.laske() != 1) fail("Luokkasi toimii väärin");
    }

    @Test(timeout = 1000)
    public void testi2() {
        PieninEtaisyys p = new PieninEtaisyys();
        p.lisaa(2);
        p.lisaa(1);
        if (p.laske() != 1) fail("Luokkasi toimii väärin");
    }

    @Test(timeout = 1000)
    public void testi3() {
        PieninEtaisyys p = new PieninEtaisyys();
        p.lisaa(2);
        p.lisaa(8);
        if (p.laske() != 6) fail("Luokkasi toimii väärin");
        p.lisaa(5);
        if (p.laske() != 3) fail("Luokkasi toimii väärin");
        p.lisaa(6);
        if (p.laske() != 1) fail("Luokkasi toimii väärin");
        p.lisaa(4);
        if (p.laske() != 1) fail("Luokkasi toimii väärin");
    }
    
    @Test(timeout = 1000)
    public void testi4() {
        PieninEtaisyys p = new PieninEtaisyys();
        p.lisaa(2);
        p.lisaa(2);
        p.lisaa(3);
        if (p.laske() != 1) fail("Luokkasi toimii väärin");
    }

    @Test(timeout = 2000)
    public void testi5() {
        PieninEtaisyys p = new PieninEtaisyys();
        p.lisaa(1);
        for (int i = 2; i <= 500000; i++) {
            p.lisaa(i);
            if (p.laske() != 1) fail("Luokkasi toimii väärin");
        }
    }

    @Test(timeout = 2000)
    public void testi7() {
        PieninEtaisyys p = new PieninEtaisyys();
        p.lisaa(t1[0]);
        long s = 0;
        for (int i = 1; i <= 499999; i++) {
            p.lisaa(t1[i]);
            s += p.laske();
        }
        if (s != 229604927) fail("Luokkasi toimii väärin");
    }    
}
