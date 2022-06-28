import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("13.2")
public class KunnostusTest {
    void virhe() {
        fail("Luokkasi toimii väärin");
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        Kunnostus k = new Kunnostus(1);
        if (k.laske() != 0) virhe();
    }        

    @Test(timeout = 1000)
    public void testi2() {
        Kunnostus k = new Kunnostus(2);
        if (k.laske() != -1) virhe();
    }        
    
    @Test(timeout = 1000)
    public void testi3() {
        Kunnostus k = new Kunnostus(2);
        k.lisaaTie(1,2,5);
        k.lisaaTie(1,2,4);
        if (k.laske() != 4) virhe();
    }        

    @Test(timeout = 1000)
    public void testi4() {
        Kunnostus k = new Kunnostus(5);
        k.lisaaTie(1,2,2);
        k.lisaaTie(1,3,2);
        k.lisaaTie(1,4,2);
        k.lisaaTie(1,5,2);
        k.lisaaTie(2,3,1);
        k.lisaaTie(3,4,1);
        k.lisaaTie(4,5,1);
        k.lisaaTie(5,2,1);
        if (k.laske() != 5) virhe();
    }        

    @Test(timeout = 1000)
    public void testi5() {
        int n = 100000;
        Kunnostus k = new Kunnostus(n);
        for (int i = 1; i <= n-1; i++) {
            k.lisaaTie(i,i+1,1);
        }
        if (k.laske() != n-1) virhe();
    }        

    @Test(timeout = 1000)
    public void testi6() {
        int n = 100000;
        Kunnostus k = new Kunnostus(n);
        for (int i = 1; i <= n-1; i++) {
            k.lisaaTie(i,i+1,1000);
        }
        if (k.laske() != 1000*(n-1)) virhe();
    }        

    @Test(timeout = 1000)
    public void testi7() {
        int n = 100000;
        Kunnostus k = new Kunnostus(n);
        Random r = new Random(1337);
        for (int i = 1; i <= n; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            int x = r.nextInt(1000)+1;
            k.lisaaTie(a,b,x);
        }
        if (k.laske() != -1) virhe();
    }        

    @Test(timeout = 1000)
    public void testi8() {
        int n = 5000;
        int m = 100000;
        Kunnostus k = new Kunnostus(n);
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            int x = r.nextInt(1000)+1;
            k.lisaaTie(a,b,x);
        }
        if (k.laske() != 153198) virhe();
    }    

    @Test(timeout = 1000)
    public void testi9() {
        int n = 100;
        int m = 100000;
        Kunnostus k = new Kunnostus(n);
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            int x = r.nextInt(1000)+1;
            k.lisaaTie(a,b,x);
        }
        if (k.laske() != 115) virhe();
    }    

    @Test(timeout = 1000)
    public void testi10() {
        int n = 100000;
        Kunnostus k = new Kunnostus(n);
        Random r = new Random();
        int s = 0;
        for (int i = 1; i <= n-1; i++) {
            int x = r.nextInt(1000)+1;
            k.lisaaTie(i,i+1,x);
            s += x;
        }
        if (k.laske() != s) virhe();
    }    

}
