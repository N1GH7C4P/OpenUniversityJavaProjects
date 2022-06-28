import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("13.6")
public class YhteydetTest {
    void virhe() {
        fail("Luokkasi toimii väärin");
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        Yhteydet y = new Yhteydet(3);
        y.yhdista(1,2);
        if (y.tutki(1,1) != 0) virhe();
        if (y.tutki(1,2) != 1) virhe();
        if (y.tutki(1,3) != -1) virhe();
    }

    @Test(timeout = 1000)
    public void testi2() {
        Yhteydet y = new Yhteydet(2);
        y.yhdista(1,2);
        y.yhdista(1,2);
        if (y.tutki(1,2) != 1) virhe();
    }    
    
    @Test(timeout = 1000)
    public void testi3() {
        Yhteydet y = new Yhteydet(5);
        y.yhdista(2,4);
        y.yhdista(2,3);
        y.yhdista(1,5);
        y.yhdista(2,3);
        y.yhdista(3,4);
        y.yhdista(1,5);
        if (y.tutki(1,2) != -1) virhe();
        if (y.tutki(1,5) != 3) virhe();
        if (y.tutki(2,3) != 2) virhe();
        if (y.tutki(2,4) != 1) virhe();
        if (y.tutki(3,4) != 2) virhe();
    }

    @Test(timeout = 1000)
    public void testi4() {
        int n = 100000;
        Yhteydet y = new Yhteydet(n);
        for (int i = 1; i <= n-1; i++) {
            y.yhdista(i,i+1);
        }
        for (int i = 1; i <= n-1; i++) {
            if (y.tutki(1,i+1) != i) virhe();
        }
    }
    
    @Test(timeout = 1000)
    public void testi5() {
        int n = 100000;
        Yhteydet y = new Yhteydet(n);
        for (int i = 1; i <= n-1; i++) {
            y.yhdista(i,i+1);
        }
        long c = 0;
        Random r = new Random(1337);
        for (int i = 1; i <= n; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            c += y.tutki(a,b);
        }
        if (c != 6683415464L) virhe();
    }

    @Test(timeout = 1000)
    public void testi6() {
        int n = 100000;
        Yhteydet y = new Yhteydet(n);
        Random r = new Random(1337);
        for (int i = 1; i <= n; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            y.yhdista(a,b);
        }
        long c = 0;
        for (int i = 1; i <= n; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            c += y.tutki(a,b);
        }
        if (c != 4741530105L) virhe();
    }

    @Test(timeout = 1000)
    public void testi7() {
        int n = 5000;
        int m = 100000;
        Yhteydet y = new Yhteydet(n);
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            y.yhdista(a,b);
        }
        long c = 0;
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            c += y.tutki(a,b);
        }
        if (c != 504184181) virhe();
    }

    @Test(timeout = 1000)
    public void testi8() {
        int n = 100;
        int m = 100000;
        Yhteydet y = new Yhteydet(n);
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            y.yhdista(a,b);
        }
        long c = 0;
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            c += y.tutki(a,b);
        }
        if (c != 9478496) virhe();
    }

    @Test(timeout = 1000)
    public void testi9() {
        int n = 100000;
        Yhteydet y = new Yhteydet(n);
        for (int i = 1; i <= n; i++) {
            y.yhdista(1,2);
        }
        for (int i = 1; i <= n; i++) {
            if (y.tutki(1,2) != 1) virhe();
        }
    }

    @Test(timeout = 1000)
    public void testi10() {
        int n = 100000;
        Yhteydet y = new Yhteydet(n);
        Random r = new Random(1337);
        for (int i = 2; i <= n; i++) {
            int x = r.nextInt(i-1)+1;
            y.yhdista(x,i);
        }
        long c = 0;
        for (int i = 1; i <= n; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            c += y.tutki(a,b);
        }
        if (c != 6666480188L) virhe();
    }

    @Test(timeout = 1000)
    public void testi11() {
        int n = 100000;
        Yhteydet y = new Yhteydet(n);
        for (int i = 1; i <= n; i++) {
            if (y.tutki(1,1) != 0) virhe();
        }
    }

    @Test(timeout = 1000)
    public void testi12() {
        int n = 100000;
        Yhteydet y = new Yhteydet(n);
        for (int i = 1; i <= n; i++) {
            if (y.tutki(1,2) != -1) virhe();
        }
    }

    @Test(timeout = 1000)
    public void testi13() {
        int n = 100000;
        Yhteydet y = new Yhteydet(n);
        for (int i = 1; i <= n-1; i++) {
            y.yhdista(i,i+1);
        }
        for (int i = 1; i <= n; i++) {
            if (y.tutki(1,n) != n-1) virhe();
        }
    }

    @Test(timeout = 1000)
    public void testi14() {
        int n = 100000;
        Yhteydet y = new Yhteydet(n);
        for (int i = n-1; i >= 1; i--) {
            y.yhdista(i,i+1);
        }
        for (int i = 1; i <= n; i++) {
            if (y.tutki(1,n) != n-1) virhe();
        }
    }

    @Test(timeout = 1000)
    public void testi15() {
        int n = 100000;
        Yhteydet y = new Yhteydet(n);
        for (int i = 2; i <= n; i++) {
            y.yhdista(1,i);
        }
        Random r = new Random();
        for (int i = 1; i <= n; i++) {
            int a = r.nextInt(n-1)+2;
            int b = r.nextInt(n-1)+2;
            if (a == b && y.tutki(a,b) != 0) virhe();
            if (a != b && y.tutki(a,b) != Math.max(a-1,b-1)) virhe();
        }
    }
    
}
