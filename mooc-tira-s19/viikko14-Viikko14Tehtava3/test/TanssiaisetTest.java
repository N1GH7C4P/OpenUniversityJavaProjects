import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("14.3")
public class TanssiaisetTest {
    int n = 100;
    boolean[][] pari;
    boolean[][] mukana;
    
    void alusta() {
        pari = new boolean[n+1][n+1];
        mukana = new boolean[2][n+1];
    }
    
    void lisaaPari(Tanssiaiset t, int a, int b) {
        t.lisaaPari(a,b);
        pari[a][b] = true;
    }
    
    void tarkasta(Tanssiaiset t, int a) {
        ArrayList<Pari> tulos = t.muodosta();
        int b = tulos.size();
        if (a != b) {
            fail("Muodostat "+b+" paria, vaikka oikea vastaus olisi "+a);
        }
        for (Pari p : tulos) {
            int x = p.opiskelija1;
            int y = p.opiskelija2;
            if (pari[x][y] && !mukana[0][x] && !mukana[1][y]) {
                pari[x][y] = false;
                mukana[0][x] = true;
                mukana[1][y] = true;
            } else {
                fail("Muodostat virheellisen parin");
            }
        }
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        Tanssiaiset t = new Tanssiaiset(1,1);
        alusta();
        tarkasta(t,0);
    }    

    @Test(timeout = 1000)
    public void testi2() {
        Tanssiaiset t = new Tanssiaiset(1,1);
        alusta();
        lisaaPari(t,1,1);
        tarkasta(t,1);
    }    

    @Test(timeout = 1000)
    public void testi3() {
        Tanssiaiset t = new Tanssiaiset(2,2);
        alusta();
        lisaaPari(t,1,1);
        lisaaPari(t,1,2);
        lisaaPari(t,2,1);
        lisaaPari(t,2,2);
        tarkasta(t,2);
    }    

    @Test(timeout = 1000)
    public void testi4() {
        Tanssiaiset t = new Tanssiaiset(2,2);
        alusta();
        lisaaPari(t,1,1);
        lisaaPari(t,2,1);
        tarkasta(t,1);
    }    
    
    @Test(timeout = 1000)
    public void testi5() {
        Tanssiaiset t = new Tanssiaiset(1,1);
        alusta();
        lisaaPari(t,1,1);
        lisaaPari(t,1,1);
        tarkasta(t,1);
    }    

    @Test(timeout = 1000)
    public void testi6() {
        int n = 100;
        Tanssiaiset t = new Tanssiaiset(n,n);
        alusta();
        for (int i = 1; i <= n; i++) {
            lisaaPari(t,i,i);
        }
        tarkasta(t,n);
    }    

    @Test(timeout = 1000)
    public void testi7() {
        int n = 100;
        Tanssiaiset t = new Tanssiaiset(n,1);
        alusta();
        for (int i = 1; i <= n; i++) {
            lisaaPari(t,i,1);
        }
        tarkasta(t,1);
    }    

    @Test(timeout = 1000)
    public void testi8() {
        int n = 100;
        Tanssiaiset t = new Tanssiaiset(1,n);
        alusta();
        for (int i = 1; i <= n; i++) {
            lisaaPari(t,1,i);
        }
        tarkasta(t,1);
    }
    
    void satunnaiset(int n, int m, int x) {
        Tanssiaiset t = new Tanssiaiset(n,n);
        alusta();
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            lisaaPari(t,a,b);
        }
        tarkasta(t,x);
    }

    @Test(timeout = 1000)
    public void testi9() {
        satunnaiset(100,10,9);
    }        

    @Test(timeout = 1000)
    public void testi10() {
        satunnaiset(100,50,39);
    }        

    @Test(timeout = 1000)
    public void testi11() {
        satunnaiset(100,100,60);
    }        
    
    @Test(timeout = 1000)
    public void testi12() {
        satunnaiset(100,200,86);
    }        

    @Test(timeout = 1000)
    public void testi13() {
        satunnaiset(100,300,94);
    }        

    @Test(timeout = 1000)
    public void testi14() {
        satunnaiset(100,400,97);
    }        

    @Test(timeout = 1000)
    public void testi15() {
        satunnaiset(100,450,99);
    }        
    
    @Test(timeout = 1000)
    public void testi16() {
        satunnaiset(100,1000,100);
    }        
}
