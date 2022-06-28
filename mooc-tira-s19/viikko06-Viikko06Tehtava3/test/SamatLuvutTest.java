import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("6.3")
public class SamatLuvutTest {
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
        SamatLuvut s = new SamatLuvut();
        s.lisaa(1);
        if (s.pienin() != 1) fail("Luokkasi toimii väärin");
    }

    @Test(timeout = 1000)
    public void testi2() {
        SamatLuvut s = new SamatLuvut();
        s.lisaa(1);
        s.lisaa(1);
        s.lisaa(1);
        if (s.pienin() != 1) fail("Luokkasi toimii väärin");
        s.poista(1);
        if (s.pienin() != 1) fail("Luokkasi toimii väärin");
        s.poista(1);
        if (s.pienin() != 1) fail("Luokkasi toimii väärin");
    }
    
    @Test(timeout = 1000)
    public void testi3() {
        SamatLuvut s = new SamatLuvut();
        s.lisaa(3);
        s.lisaa(7);
        s.lisaa(5);
        s.lisaa(2);
        if (s.pienin() != 2) fail("Luokkasi toimii väärin");
        s.poista(2);
        if (s.pienin() != 3) fail("Luokkasi toimii väärin");
        s.poista(3);
        if (s.pienin() != 5) fail("Luokkasi toimii väärin");
        s.poista(5);
        if (s.pienin() != 7) fail("Luokkasi toimii väärin");
        s.poista(7);
    }

    @Test(timeout = 2000)
    public void testi4() {
        SamatLuvut s = new SamatLuvut();
        for (int i = 0; i < 500000; i++) s.lisaa(1);
        for (int i = 0; i < 250000; i++) {
            if (s.pienin() != 1) fail("Luokkasi toimii väärin");
            s.poista(1);            
        }
    }

    @Test(timeout = 2000)
    public void testi5() {
        SamatLuvut s = new SamatLuvut();
        for (int i = 1; i <= 500000; i++) s.lisaa(i);
        for (int i = 1; i <= 250000; i++) {
            if (s.pienin() != i) fail("Luokkasi toimii väärin");
            s.poista(i);
        }
    }

    @Test(timeout = 2000)
    public void testi6() {
        SamatLuvut s = new SamatLuvut();
        for (int i = 1; i <= 100000; i++) {
            s.lisaa(1);
            s.lisaa(2);
        }
        for (int i = 1; i <= 100000; i++) {
            if (s.pienin() != 1) fail("Luokkasi toimii väärin");
            s.poista(1);
        }
        for (int i = 1; i <= 100000; i++) {
            if (s.pienin() != 2) fail("Luokkasi toimii väärin");
            s.poista(1);
        }
    }

    @Test(timeout = 2000)
    public void testi7() {
        SamatLuvut s = new SamatLuvut();
        long u = 0;
        for (int i = 0; i < 250000; i++) {
            s.lisaa(t1[i]);
            u += s.pienin();
        }
        for (int i = 0; i < 249999; i++) {
            s.poista(t1[i]);
            u += s.pienin();
        }
        if (u != 37830414863L) fail("Luokkasi toimii väärin ");
    }
    
}
