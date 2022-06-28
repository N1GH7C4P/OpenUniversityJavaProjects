import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("11.5")
public class OnkoPolkuaTest {
    @Test(timeout = 1000)
    public void testi1() {
        OnkoPolkua o = new OnkoPolkua(2);
        if (!o.tutki()) return;
        fail("Luokkasi toimii väärin, kun mitään polkua ei ole");
    }    

    @Test(timeout = 1000)
    public void testi2() {
        OnkoPolkua o = new OnkoPolkua(2);
        o.lisaaKaari(1,2,1);
        if (o.tutki()) return;
        fail("Luokkasi toimii väärin, kun polulla on yksi kaari");
    }    

    @Test(timeout = 1000)
    public void testi3() {
        OnkoPolkua o = new OnkoPolkua(2);
        o.lisaaKaari(1,2,-1);
        if (o.tutki()) return;
        fail("Luokkasi toimii väärin, kun polulla on yksi kaari");
    }    
    
    @Test(timeout = 1000)
    public void testi4() {
        OnkoPolkua o = new OnkoPolkua(1);
        o.lisaaKaari(1,1,-1);
        if (!o.tutki()) return;
        fail("Luokkasi toimii väärin, kun polulla on negatiivinen sykli");
    }    

    @Test(timeout = 1000)
    public void testi5() {
        OnkoPolkua o = new OnkoPolkua(3);
        o.lisaaKaari(1,2,1);
        o.lisaaKaari(2,2,-1);
        o.lisaaKaari(1,3,1);
        if (o.tutki()) return;
        fail("Luokkasi toimii väärin, kun polun ulkopuolella on negatiivinen sykli");
    }    

    @Test(timeout = 1000)
    public void testi6() {
        OnkoPolkua o = new OnkoPolkua(3);
        o.lisaaKaari(2,2,-1);
        o.lisaaKaari(2,3,1);
        o.lisaaKaari(1,3,1);
        if (o.tutki()) return;
        fail("Luokkasi toimii väärin, kun polun ulkopuolella on negatiivinen sykli");
    }    
    
    @Test(timeout = 1000)
    public void testi7() {
        OnkoPolkua o = new OnkoPolkua(4);
        o.lisaaKaari(1,2,5);
        o.lisaaKaari(2,4,5);
        o.lisaaKaari(1,4,1);
        o.lisaaKaari(2,3,1);
        o.lisaaKaari(3,2,-2);
        if (!o.tutki()) return;
        fail("Luokkasi toimii väärin, kun polulla on negatiivinen sykli");
    }    

    @Test(timeout = 1000)
    public void testi8() {
        OnkoPolkua o = new OnkoPolkua(4);
        o.lisaaKaari(1,2,5);
        o.lisaaKaari(2,4,5);
        o.lisaaKaari(1,4,1);
        o.lisaaKaari(2,3,-1);
        o.lisaaKaari(3,2,2);
        if (o.tutki()) return;
        fail("Luokkasi toimii väärin, kun polulla on positiivinen sykli");
    }    
    
    @Test(timeout = 1000)
    public void testi9() {
        int n = 100;
        OnkoPolkua o = new OnkoPolkua(n);
        for (int i = n-1; i >= 1; i--) {
            o.lisaaKaari(i,i+1,1000);
        }
        o.lisaaKaari(1,100,1);
        o.lisaaKaari(n/2,n/2,-1);
        if (!o.tutki()) return;
        fail("Luokkasi toimii väärin, kun polulla on negatiivinen sykli");
    }    

    @Test(timeout = 1000)
    public void testi10() {
        int n = 100;
        OnkoPolkua o = new OnkoPolkua(n);
        for (int i = n-1; i >= 1; i--) {
            for (int j = 1; j <= 1000; j++) {
                o.lisaaKaari(i,i+1,1000);
            }
        }
        o.lisaaKaari(1,100,1);
        o.lisaaKaari(n/2,n/2,-1);
        if (!o.tutki()) return;
        fail("Luokkasi toimii väärin, kun polulla on negatiivinen sykli");
    }    

    @Test(timeout = 1000)
    public void testi11() {
        int n = 100;
        int m = 100000;
        OnkoPolkua o = new OnkoPolkua(n);
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n-1)+1;
            int b = a+r.nextInt(n-a)+1;
            o.lisaaKaari(a,b,-1);
        }
        if (o.tutki()) return;
        fail("Luokkasi toimii väärin, kun kaikki kaaret ovat negatiivisia");
    }    

    @Test(timeout = 1000)
    public void testi12() {
        int n = 100;
        int m = 100000;
        OnkoPolkua o = new OnkoPolkua(n);
        Random r = new Random(1337);
        for (int i = 1; i <= m-1; i++) {
            int a = r.nextInt(n-1)+1;
            int b = a+r.nextInt(n-a)+1;
            o.lisaaKaari(a,b,-1);
        }
        o.lisaaKaari(42,13,-1);
        if (!o.tutki()) return;
        fail("Luokkasi toimii väärin, kun kaikki kaaret ovat negatiivisia");
    }    

    @Test(timeout = 1000)
    public void testi13() {
        int n = 100;
        int m = 100000;
        OnkoPolkua o = new OnkoPolkua(n);
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            int p = -1000+r.nextInt(2001);
            o.lisaaKaari(a,b,p);
        }
        if (!o.tutki()) return;
        fail("Luokkasi toimii väärin, kun verkko on satunnainen");
    }    

    @Test(timeout = 1000)
    public void testi14() {
        int n = 100;
        int m = 100000;
        OnkoPolkua o = new OnkoPolkua(n);
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            int p = r.nextInt(1001);
            o.lisaaKaari(a,b,p);
        }
        if (o.tutki()) return;
        fail("Luokkasi toimii väärin, kun verkko on satunnainen");
    }    

    @Test(timeout = 1000)
    public void testi15() {
        int n = 100;
        int m = 100000;
        OnkoPolkua o = new OnkoPolkua(n);
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n-1)+1;
            int b = r.nextInt(n-1)+1;
            int p = r.nextInt(1001);
            o.lisaaKaari(a,b,p);
        }
        if (!o.tutki()) return;
        fail("Luokkasi toimii väärin, kun verkko on satunnainen");
    }        

    @Test(timeout = 1000)
    public void testi16() {
        OnkoPolkua o = new OnkoPolkua(6);
        o.lisaaKaari(1,2,1);
        o.lisaaKaari(2,6,1);
        o.lisaaKaari(1,3,1);
        o.lisaaKaari(3,6,1);
        o.lisaaKaari(2,4,1);
        o.lisaaKaari(5,3,1);
        o.lisaaKaari(4,4,-1);
        o.lisaaKaari(5,5,-1);
        o.lisaaKaari(5,4,666);
        if (o.tutki()) return;
        fail("Luokkasi toimii väärin pienessä verkossa");
    }        

    @Test(timeout = 1000)
    public void testi17() {
        OnkoPolkua o = new OnkoPolkua(6);
        o.lisaaKaari(1,2,1);
        o.lisaaKaari(2,6,1);
        o.lisaaKaari(1,3,1);
        o.lisaaKaari(3,6,1);
        o.lisaaKaari(2,4,1);
        o.lisaaKaari(5,3,1);
        o.lisaaKaari(4,4,-1);
        o.lisaaKaari(5,5,-1);
        o.lisaaKaari(4,5,666);
        if (!o.tutki()) return;
        fail("Luokkasi toimii väärin pienessä verkossa");
    }        

}
