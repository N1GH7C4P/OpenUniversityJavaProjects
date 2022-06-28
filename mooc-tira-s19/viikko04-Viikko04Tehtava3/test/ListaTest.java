import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("4.3")
public class ListaTest {
    static int[] t1, t2;
    
    @BeforeClass
    public static void alku()  {
        int n = 1000000;
        t1 = new int[n];
        t2 = new int[n];
        Random r = new Random(1337);
        for (int i = 0; i < n; i++) {
            t1[i] = r.nextInt(1000000000)+1;
            if (i != 0) t2[i] = r.nextInt(i);
        }
    }
    
    @Test(timeout = 10000)
    public void testi1() {
        Lista l = new Lista();
        l.lisaaAlkuun(123);
        int x = l.haeAlkio(0);
        if (x == 123) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }    

    @Test(timeout = 10000)
    public void testi2() {
        Lista l = new Lista();
        l.lisaaLoppuun(123);
        int x = l.haeAlkio(0);
        if (x == 123) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 10000)
    public void testi3() {
        Lista l = new Lista();
        l.lisaaLoppuun(1);
        l.lisaaAlkuun(2);
        l.lisaaLoppuun(3);
        l.lisaaAlkuun(4);
        l.lisaaLoppuun(5);
        boolean virhe = false;
        if (l.haeAlkio(0) != 4) virhe = true;
        if (l.haeAlkio(1) != 2) virhe = true;
        if (l.haeAlkio(2) != 1) virhe = true;
        if (l.haeAlkio(3) != 3) virhe = true;
        if (l.haeAlkio(4) != 5) virhe = true;
        if (!virhe) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }
    
    @Test(timeout = 10000)
    public void testi4() {
        Lista l = new Lista();
        for (int i = 1; i <= 1000000; i++) {
            l.lisaaAlkuun(i);
        }
    }

    @Test(timeout = 10000)
    public void testi5() {
        Lista l = new Lista();
        for (int i = 1; i <= 1000000; i++) {
            l.lisaaLoppuun(i);
        }
    }

    @Test(timeout = 10000)
    public void testi6() {
        Lista l = new Lista();
        long summa = 0;
        for (int i = 1; i <= 500000; i++) {
            l.lisaaAlkuun(i);
            summa += l.haeAlkio(0);
        }
        if (summa == 125000250000L) return;
        long ero =summa-125000250000L;
        fail("Metodisi toimii väärin suuressa testissä, summa: "+summa+" != 125000250000 ! ero: "+ero);
    }

    @Test(timeout = 100000)
    public void testi7() {
        Lista l = new Lista();
        long summa = 0;
        for (int i = 1; i <= 500000; i++) {
            l.lisaaLoppuun(i);
            summa += l.haeAlkio(0);
        }
        if (summa == 500000) return;
        long ero = summa-500000;
        fail("Metodisi toimii väärin suuressa testissä, summa: "+summa+" != 500000 ero: "+ero);
    }
    
    @Test(timeout = 100000)
    public void testi8() {
        Lista l = new Lista();
        long summa = 0;
        for (int i = 1; i <= 500000; i++) {
            if (i%2 == 0) l.lisaaAlkuun(t1[i]);
            else l.lisaaLoppuun(t1[i]); 
            summa += l.haeAlkio(t2[i]);
        }
        if (summa == 249859746047147L) return;
        long ero = summa-249859746047147L;
        fail("Metodisi toimii väärin suuressa testissä, summa: "+summa+" != 249859746047147 ero: "+ero);
    }
    
}
