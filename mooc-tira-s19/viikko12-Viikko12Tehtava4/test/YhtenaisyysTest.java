import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("12.4")
public class YhtenaisyysTest {
    void testi(Yhtenaisyys y, boolean a) {
        boolean b = y.tutki();
        if (a == b) return;
        if (a) fail("Koodisi toimii väärin, kun verkko on vahvasti yhtenäinen");
        if (!a) fail("Koodisi toimii väärin, kun verkko ei ole vahvasti yhtenäinen");
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        Yhtenaisyys y = new Yhtenaisyys(1);
        testi(y,true);
    }        

    @Test(timeout = 1000)
    public void testi2() {
        Yhtenaisyys y = new Yhtenaisyys(2);
        testi(y,false);
    }        

    @Test(timeout = 1000)
    public void testi3() {
        Yhtenaisyys y = new Yhtenaisyys(2);
        y.lisaaKaari(1,2);
        testi(y,false);
    }        

    @Test(timeout = 1000)
    public void testi4() {
        Yhtenaisyys y = new Yhtenaisyys(2);
        y.lisaaKaari(1,2);
        y.lisaaKaari(2,1);
        testi(y,true);
    }        

    @Test(timeout = 1000)
    public void testi5() {
        int n = 100;
        Yhtenaisyys y = new Yhtenaisyys(n);
        for (int i = 1; i <= n-1; i++) {
            y.lisaaKaari(i,i+1);
        }
        testi(y,false);
    }        

    @Test(timeout = 1000)
    public void testi6() {
        int n = 100;
        Yhtenaisyys y = new Yhtenaisyys(n);
        for (int i = 1; i <= n-1; i++) {
            y.lisaaKaari(i,i+1);
        }
        y.lisaaKaari(n,1);
        testi(y,true);
    }        

    @Test(timeout = 1000)
    public void testi7() {
        int n = 100;
        Yhtenaisyys y = new Yhtenaisyys(n);
        testi(y,false);
    }        

    @Test(timeout = 1000)
    public void testi8() {
        int n = 100;
        Yhtenaisyys y = new Yhtenaisyys(n);
        Random r = new Random(1337);
        int m = 451;
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            y.lisaaKaari(a,b);
        }
        testi(y,false);
    }            

    @Test(timeout = 1000)
    public void testi9() {
        int n = 100;
        Yhtenaisyys y = new Yhtenaisyys(n);
        Random r = new Random(1337);
        int m = 452;
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            y.lisaaKaari(a,b);
        }
        testi(y,true);
    }            

    @Test(timeout = 1000)
    public void testi10() {
        int n = 100;
        Yhtenaisyys y = new Yhtenaisyys(n);
        Random r = new Random(1337);
        int m = 100000;
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            y.lisaaKaari(a,b);
        }
        testi(y,true);
    }            
    
    @Test(timeout = 1000)
    public void testi11() {
        int n = 100;
        Yhtenaisyys y = new Yhtenaisyys(n);
        Random r = new Random(1337);
        int m = 100000;
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n-1)+1;
            int b = r.nextInt(n-1)+1;
            y.lisaaKaari(a,b);
        }
        testi(y,false);
    }            

    @Test(timeout = 1000)
    public void testi12() {
        int n = 100;
        Yhtenaisyys y = new Yhtenaisyys(n);
        Random r = new Random(1337);
        int m = 100000;
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            if (b == n) continue;
            y.lisaaKaari(a,b);
        }
        testi(y,false);
    }            

    @Test(timeout = 1000)
    public void testi13() {
        int n = 100;
        Yhtenaisyys y = new Yhtenaisyys(n);
        Random r = new Random(1337);
        int m = 100000;
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            if (a == n) continue;
            y.lisaaKaari(a,b);
        }
        testi(y,false);
    }            

    @Test(timeout = 1000)
    public void testi14() {
        int n = 100;
        Yhtenaisyys y = new Yhtenaisyys(n);
        Random r = new Random(1337);
        int m = 100000;
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            if (a%2 != b%2) continue;
            y.lisaaKaari(a,b);
        }
        testi(y,false);
    }            

    @Test(timeout = 1000)
    public void testi15() {
        int n = 100;
        Yhtenaisyys y = new Yhtenaisyys(n);
        Random r = new Random(1337);
        int m = 100000;
        for (int i = 1; i <= m/2; i++) {
            int a = r.nextInt(n/2)+1;
            int b = r.nextInt(n/2)+1;
            y.lisaaKaari(a,b);
        }
        for (int i = 1; i <= m/2; i++) {
            int a = r.nextInt(n/2)+n/2+1;
            int b = r.nextInt(n/2)+n/2+1;
            y.lisaaKaari(a,b);
        }
        testi(y,false);
    }            

    @Test(timeout = 1000)
    public void testi16() {
        int n = 100;
        Yhtenaisyys y = new Yhtenaisyys(n);
        Random r = new Random(1337);
        int m = 100000;
        for (int i = 1; i <= m/2-1; i++) {
            int a = r.nextInt(n/2)+1;
            int b = r.nextInt(n/2)+1;
            y.lisaaKaari(a,b);
        }
        for (int i = 1; i <= m/2-1; i++) {
            int a = r.nextInt(n/2)+n/2+1;
            int b = r.nextInt(n/2)+n/2+1;
            y.lisaaKaari(a,b);
        }
        y.lisaaKaari(n/2,n/2+1);
        y.lisaaKaari(n/2+1,n/2);
        testi(y,true);
    }            
    
}
