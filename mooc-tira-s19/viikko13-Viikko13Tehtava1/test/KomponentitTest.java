import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("13.1")
public class KomponentitTest {
    void virhe() {
        fail("Luokkasi toimii väärin");
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        Komponentit k = new Komponentit(1);
        if (k.laske() != 1) virhe();
    }        

    @Test(timeout = 1000)
    public void testi2() {
        Komponentit k = new Komponentit(1);
        k.yhdista(1,1);
        if (k.laske() != 1) virhe();
    }        

    @Test(timeout = 1000)
    public void testi3() {
        Komponentit k = new Komponentit(2);
        if (k.laske() != 2) virhe();
        k.yhdista(1,2);
        if (k.laske() != 1) virhe();
    }        

    @Test(timeout = 1000)
    public void testi4() {
        Komponentit k = new Komponentit(5);
        if (k.laske() != 5) virhe();
        k.yhdista(1,2);
        if (k.laske() != 4) virhe();
        k.yhdista(3,4);
        if (k.laske() != 3) virhe();
        k.yhdista(3,5);
        if (k.laske() != 2) virhe();
        k.yhdista(1,5);
        if (k.laske() != 1) virhe();
    }        

    @Test(timeout = 1000)
    public void testi5() {
        int n = 100000;
        Komponentit k = new Komponentit(n);
        if (k.laske() != n) virhe();
        for (int i = 1; i <= n-1; i++) {
            k.yhdista(i,i+1);
            if (k.laske() != n-i) virhe();
        }
    }        

    @Test(timeout = 1000)
    public void testi6() {
        int n = 100000;
        Komponentit k = new Komponentit(n);
        if (k.laske() != n) virhe();
        for (int i = n; i >= 2; i--) {
            k.yhdista(i,i-1);
            if (k.laske() != i-1) virhe();
        }
    }        

    @Test(timeout = 1000)
    public void testi7() {
        int n = 100000;
        Komponentit k = new Komponentit(n);
        if (k.laske() != n) virhe();
        for (int i = 2; i <= n; i++) {
            k.yhdista(1,i);
            if (k.laske() != n-i+1) virhe();
        }
    }        

    @Test(timeout = 1000)
    public void testi8() {
        int n = 100000;
        Komponentit k = new Komponentit(n);
        if (k.laske() != n) virhe();
        for (int i = 1; i <= n-1; i++) {
            k.yhdista(n,i);
            if (k.laske() != n-i) virhe();
        }
    }        
    
    @Test(timeout = 1000)
    public void testi9() {
        int n = 100000;
        Komponentit k = new Komponentit(2);
        for (int i = 1; i <= n; i++) {
            k.yhdista(1,2);
            if (k.laske() != 1) virhe();
        }
    }        

    @Test(timeout = 1000)
    public void testi10() {
        int n = 100000;
        Komponentit k = new Komponentit(n);
        long c = 0;
        Random r = new Random(1337);
        for (int i = 1; i <= n; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            k.yhdista(a,b);
            c += k.laske();
        }
        if (c != 5259449868L) virhe();
    }
    
    ArrayList<Integer>[] verkko;
    int[] tila;
    
    void haku(int s) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(s);
        tila[s] = 1;
        for (int i = 0; i < a.size(); i++) {
            for (int u : verkko[a.get(i)]) {
                if (tila[u] == 0) {
                    tila[u] = 1;
                    a.add(u);
                }
            }
        }
    }

    @Test(timeout = 1000)
    public void testi11() {
        int n = 100000;
        Komponentit k = new Komponentit(n);
        Random r = new Random();
        verkko = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) verkko[i] = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            k.yhdista(a,b);
            int x = k.laske();
            verkko[a].add(b);
            verkko[b].add(a);
            if (r.nextInt(10000) == 666) {
                tila = new int[n+1];
                int u = 0;
                for (int j = 1; j <= n; j++) {
                    if (tila[j] == 0) {u++; haku(j);}
                }
                if (u != x) virhe();
            }
        }
    }        
    
}
