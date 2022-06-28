import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("5.2")
public class HatutJaPallotTest {
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
        HatutJaPallot h = new HatutJaPallot();
        assertEquals(h.monessakoYksi(),0);
        assertEquals(h.suurinMaara(),0);
    }

    @Test(timeout = 1000)
    public void testi2() {
        HatutJaPallot h = new HatutJaPallot();
        h.lisaaPallo(1);
        h.lisaaPallo(1);
        h.lisaaPallo(1);
        assertEquals(h.monessakoYksi(),1);
        assertEquals(h.suurinMaara(),3);
    }

    @Test(timeout = 1000)
    public void testi3() {
        HatutJaPallot h = new HatutJaPallot();
        h.lisaaPallo(1);
        h.lisaaPallo(2);
        h.lisaaPallo(3);
        assertEquals(h.monessakoYksi(),3);
        assertEquals(h.suurinMaara(),1);
    }
    
    @Test(timeout = 1000)
    public void testi4() {
        HatutJaPallot h = new HatutJaPallot();
        h.lisaaPallo(1);
        h.lisaaPallo(2);
        assertEquals(h.monessakoYksi(),2);
        assertEquals(h.suurinMaara(),1);
        h.lisaaPallo(1);
        h.lisaaPallo(2);
        assertEquals(h.monessakoYksi(),2);
        assertEquals(h.suurinMaara(),2);
        h.lisaaPallo(3);
        assertEquals(h.monessakoYksi(),3);
        assertEquals(h.suurinMaara(),2);
    }

    @Test(timeout = 1000)
    public void testi5() {
        HatutJaPallot h = new HatutJaPallot();
        h.lisaaPallo(1000000000);
        assertEquals(h.monessakoYksi(),1);
        assertEquals(h.suurinMaara(),1);
    }

    @Test(timeout = 2000)
    public void testi6() {
        HatutJaPallot h = new HatutJaPallot();
        for (int i = 1; i <= 1000000; i++) {
            h.lisaaPallo(1);
        }
    }

    @Test(timeout = 2000)
    public void testi7() {
        HatutJaPallot h = new HatutJaPallot();
        for (int i = 1; i <= 500000; i++) {
            h.lisaaPallo(1);
        }
        for (int i = 1; i <= 250000; i++) {
            assertEquals(h.monessakoYksi(),1);
            assertEquals(h.suurinMaara(),500000);
        }
    }

    @Test(timeout = 2000)
    public void testi8() {
        HatutJaPallot h = new HatutJaPallot();
        for (int i = 1; i <= 500000; i++) {
            h.lisaaPallo(i);
        }
        for (int i = 1; i <= 250000; i++) {
            assertEquals(h.monessakoYksi(),500000);
            assertEquals(h.suurinMaara(),1);
        }
    }

    @Test(timeout = 2000)
    public void testi9() {
        HatutJaPallot h = new HatutJaPallot();
        for (int i = 1; i <= 500000; i++) {
            h.lisaaPallo(i);
        }
        for (int i = 1; i <= 250000; i++) {
            assertEquals(h.monessakoYksi(),500000);
            assertEquals(h.suurinMaara(),1);
        }
    }

    @Test(timeout = 2000)
    public void testi10() {
        HatutJaPallot h = new HatutJaPallot();
        for (int i = 1; i <= 333333; i++) {
            h.lisaaPallo(1);
            assertEquals(h.monessakoYksi(),1);
            assertEquals(h.suurinMaara(),i);
        }
    }

    @Test(timeout = 2000)
    public void testi11() {
        HatutJaPallot h = new HatutJaPallot();
        for (int i = 1; i <= 333333; i++) {
            h.lisaaPallo(i);
            assertEquals(h.monessakoYksi(),i);
            assertEquals(h.suurinMaara(),1);
        }
    }

    @Test(timeout = 2000)
    public void testi12() {
        HatutJaPallot h = new HatutJaPallot();
        long c1 = 0, c2 = 0;
        for (int i = 1; i <= 333333; i++) {
            h.lisaaPallo(t1[i]);
            c1 += h.monessakoYksi();
            c2 += h.suurinMaara();
        }
        assertEquals(c1,55548595364L);
        assertEquals(c2,645414);
    }
}
