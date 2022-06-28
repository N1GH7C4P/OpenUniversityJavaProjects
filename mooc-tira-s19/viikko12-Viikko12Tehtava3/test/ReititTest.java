import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("12.3")
public class ReititTest {
    void testi(Reitit r, long a) {
        long b = r.laske();
        if (a == b) return;
        fail("Oikea vastaus on "+a+", mutta koodisi antaa "+b);
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        Reitit r = new Reitit(2);
        r.lisaaKaari(1,2);
        testi(r,1);
    }        

    @Test(timeout = 1000)
    public void testi2() {
        Reitit r = new Reitit(2);
        r.lisaaKaari(1,2);
        r.lisaaKaari(1,2);
        testi(r,2);
    }        

    @Test(timeout = 1000)
    public void testi3() {
        Reitit r = new Reitit(2);
        int m = 100000;
        for (int i = 1; i <= m; i++) {
            r.lisaaKaari(1,2);
        }
        testi(r,m);
    }        

    @Test(timeout = 1000)
    public void testi4() {
        int n = 100;
        Reitit r = new Reitit(n);
        for (int i = 1; i <= n-1; i++) {
            r.lisaaKaari(i,i+1);
        }
        testi(r,1);
    }        
    
    @Test(timeout = 1000)
    public void testi5() {
        Reitit r = new Reitit(2);
        testi(r,0);
    }        

    @Test(timeout = 1000)
    public void testi6() {
        Reitit r = new Reitit(3);
        r.lisaaKaari(1,3);
        r.lisaaKaari(2,1);
        r.lisaaKaari(2,3);
        testi(r,1);
    }        

    @Test(timeout = 1000)
    public void testi7() {
        Reitit r = new Reitit(3);
        r.lisaaKaari(2,1);
        r.lisaaKaari(2,3);
        testi(r,0);
    }        

    @Test(timeout = 1000)
    public void testi8() {
        Reitit r = new Reitit(6);
        r.lisaaKaari(1,2);
        r.lisaaKaari(1,3);
        r.lisaaKaari(2,3);
        r.lisaaKaari(2,4);
        r.lisaaKaari(3,5);
        r.lisaaKaari(5,4);
        r.lisaaKaari(4,6);
        r.lisaaKaari(5,6);
        testi(r,5);
    }        

    @Test(timeout = 1000)
    public void testi9() {
        Reitit r = new Reitit(3);
        for (int i = 1; i <= 7; i++) r.lisaaKaari(1,2);
        for (int i = 1; i <= 191; i++) r.lisaaKaari(2,3);
        testi(r,1337);
    }        

    @Test(timeout = 1000)
    public void testi10() {
        Reitit r = new Reitit(19);
        for (int i = 1; i <= 18; i++) {
            for (int j = 1; j <= 10; j++) {
                r.lisaaKaari(i,i+1);
            }
        }
        testi(r,1000000000000000000L);
    }        

    @Test(timeout = 1000)
    public void testi11() {
        int n = 100;
        Reitit r = new Reitit(n);
        int m = 500;
        Random x = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int a = x.nextInt(n-1)+1;
            int b = a+x.nextInt(n-a)+1;
            r.lisaaKaari(a,b);
        }
        testi(r,607213);
    }        

    @Test(timeout = 1000)
    public void testi12() {
        int n = 100;
        Reitit r = new Reitit(n);
        int m = 1000;
        Random x = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int a = x.nextInt(n-1)+1;
            int b = a+x.nextInt(n-a)+1;
            r.lisaaKaari(a,b);
        }
        testi(r,37358775821L);
    }        

    @Test(timeout = 1000)
    public void testi13() {
        int n = 100;
        Reitit r = new Reitit(n);
        int m = 1337;
        Random x = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int a = x.nextInt(n-1)+1;
            int b = a+x.nextInt(n-a)+1;
            r.lisaaKaari(a,b);
        }
        testi(r,44228584535591L);
    }        

    @Test(timeout = 1000)
    public void testi14() {
        int n = 100;
        Reitit r = new Reitit(n);
        int m = 100000;
        for (int i = 1; i <= m/2; i++) {
            r.lisaaKaari(1,2);
            r.lisaaKaari(2,100);
        }
        testi(r,50000L*50000);
    }        

    @Test(timeout = 1000)
    public void testi15() {
        int n = 99;
        Reitit r = new Reitit(n+1);
        int m = 100000;
        Random x = new Random(1337);
        for (int i = 1; i <= m-1; i++) {
            int a = x.nextInt(n-1)+1;
            int b = a+x.nextInt(n-a)+1;
            r.lisaaKaari(a,b);
        }
        r.lisaaKaari(1,n+1);
        testi(r,1);
    }        

    @Test(timeout = 1000)
    public void testi16() {
        int n = 99;
        Reitit r = new Reitit(n+1);
        int m = 100000;
        Random x = new Random(1337);
        for (int i = 1; i <= m-1; i++) {
            int a = x.nextInt(n-1)+1;
            int b = a+x.nextInt(n-a)+1;
            r.lisaaKaari(a+1,b+1);
        }
        r.lisaaKaari(1,n+1);
        testi(r,1);
    }    
}
