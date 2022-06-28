import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("11.1")
public class LyhinReittiTest {
    @Test(timeout = 1000)
    public void testi1() {
        LyhinReitti l = new LyhinReitti(1);
        if (l.laske(1,1) == 0) return;
        fail("Luokkasi toimii väärin, kun on vain yksi kaupunki");
    }    

    @Test(timeout = 1000)
    public void testi2() {
        LyhinReitti l = new LyhinReitti(2);
        if (l.laske(1,2) == -1) return;
        fail("Luokkasi toimii väärin, kun reittiä ei ole");
    }    
    
    @Test(timeout = 1000)
    public void testi3() {
        int n = 100;
        LyhinReitti l = new LyhinReitti(n);
        for (int i = 1; i <= n-1; i++) {
            l.lisaaTie(i, i+1, 1);
        }
        if (l.laske(1,100) == 99) return;
        fail("Luokkasi toimii väärin, kun tiet ovat ketjussa");
    }    

    @Test(timeout = 1000)
    public void testi4() {
        int n = 100;
        LyhinReitti l = new LyhinReitti(n);
        for (int i = 1; i <= n-1; i++) {
            l.lisaaTie(i+1, i, 1);
        }
        if (l.laske(1,100) == 99) return;
        fail("Luokkasi toimii väärin, kun tiet ovat ketjussa");
    }    

    @Test(timeout = 1000)
    public void testi5() {
        LyhinReitti l = new LyhinReitti(9);
        l.lisaaTie(1,2,16);
        l.lisaaTie(1,4,7);
        l.lisaaTie(2,3,9);
        l.lisaaTie(3,5,8);
        l.lisaaTie(3,6,10);
        l.lisaaTie(4,5,5);
        l.lisaaTie(4,7,1);
        l.lisaaTie(5,9,50);
        l.lisaaTie(6,8,12);
        l.lisaaTie(7,9,95);
        l.lisaaTie(8,9,3);
        if (l.laske(1,9) == 45) return;
        fail("Luokkasi toimii väärin, kun reittejä on useita");
    }    

    @Test(timeout = 1000)
    public void testi6() {
        LyhinReitti l = new LyhinReitti(2);
        l.lisaaTie(1,2,5);
        l.lisaaTie(1,2,4);
        if (l.laske(1,2) == 4) return;
        fail("Luokkasi toimii väärin, kun on rinnakkaiset tiet");
    }    

    @Test(timeout = 1000)
    public void testi7() {
        LyhinReitti l = new LyhinReitti(2);
        l.lisaaTie(1,1,1);
        l.lisaaTie(2,2,1);
        l.lisaaTie(1,2,1);
        if (l.laske(1,2) == 1) return;
        fail("Luokkasi toimii väärin, kun tien päissä on sama kaupunki");
    }    

    @Test(timeout = 1000)
    public void testi8() {
        int n = 100;
        LyhinReitti l = new LyhinReitti(n);
        Random r = new Random(1337);
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                l.lisaaTie(i,j,r.nextInt(1000)+1);
            }
        }
        if (l.laske(1,n) == 30) return;
        fail("Luokkasi toimii väärin satunnaisessa verkossa, lyhin = "+l.laske(1,n)+" != 30");
    }    

    @Test(timeout = 1000)
    public void testi9() {
        int n = 100;
        int m = 100000;
        LyhinReitti l = new LyhinReitti(n);
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            int p = r.nextInt(1000)+1;
            l.lisaaTie(a,b,p);
        }
        if (l.laske(1,n) == 5) return;
        fail("Luokkasi toimii väärin satunnaisessa verkossa, n = "+l.laske(1,n)+" != 5");
    }    

    @Test(timeout = 1000)
    public void testi10() {
        int n = 100;
        int m = 100000;
        LyhinReitti l = new LyhinReitti(n);
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = Math.min(n,a+r.nextInt(3)+1);
            int p = r.nextInt(1000)+1;
            l.lisaaTie(a,b,p);
        }
        if (l.laske(1,n) == 54) return;
        fail("Luokkasi toimii väärin satunnaisessa verkossa, n = "+l.laske(1,n)+" != 54");
    }    

    @Test(timeout = 1000)
    public void testi11() {
        int n = 100;
        int m = 100000;
        LyhinReitti l = new LyhinReitti(n);
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n-1)+1;
            int b = Math.min(n-1,a+r.nextInt(3)+1);
            int p = r.nextInt(1000)+1;
            l.lisaaTie(a,b,p);
        }
        if (l.laske(1,n) == -1) return;
        fail("Luokkasi toimii väärin satunnaisessa verkossa");
    }    

    @Test(timeout = 1000)
    public void testi12() {
        LyhinReitti l = new LyhinReitti(3);
        l.lisaaTie(1,3,5);
        l.lisaaTie(1,2,7);
        if (l.laske(3,2) == 12) return;
        fail("Luokkasi toimii väärin pienessä verkossa");
    }    

    @Test(timeout = 1100)
    public void testi13() {
        int n = 100;
        LyhinReitti l = new LyhinReitti(n);
        for (int i = n-1; i >= 1; i--) {
            for (int p = 1000; p >= 1; p--) {
                l.lisaaTie(i,i+1,p);
            }
        }
        if (l.laske(1,n) == 99) return;
        fail("Luokkasi toimii väärin, kun reittejä on paljon");
    }    

    @Test(timeout = 1000)
    public void testi14() {
        int n = 100;
        LyhinReitti l = new LyhinReitti(n);
        for (int i = 1; i <= n-1; i++) {
            l.lisaaTie(i, i+1, 1000);
        }
        if (l.laske(1,100) == 99000) return;
        fail("Luokkasi toimii väärin, kun tiet ovat ketjussa");
    }        
}
