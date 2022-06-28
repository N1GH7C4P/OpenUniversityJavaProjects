import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("14.4")
public class PolkupeiteTest {
    int n;
    boolean[][] kaari;
    boolean[] mukana;
    
    Polkupeite alusta(int n) {
        this.n = n;
        kaari = new boolean[n+1][n+1];
        mukana = new boolean[n+1];
        return new Polkupeite(n);
    }
    
    void lisaaKaari(Polkupeite p, int a, int b) {
        p.lisaaKaari(a,b);
        kaari[a][b] = true;
    }
    
    void tarkasta(Polkupeite p, int a) {
        ArrayList<Polku> tulos = p.muodosta();
        int b = tulos.size();
        if (a != b) {
            fail("Muodostat "+b+" polkua, vaikka oikea vastaus olisi "+a);
        }
        for (Polku x : tulos) {
            for (int s : x.solmut) {
                if (mukana[s]) fail("Solmu kuuluu moneen polkuun");
                mukana[s] = true;                
            }
            for (int i = 0; i+1 < x.solmut.size(); i++) {
                if (!kaari[x.solmut.get(i)][x.solmut.get(i+1)]) fail("Polussa on verkkoon kuulumaton kaari");
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!mukana[i]) fail("Kaikki solmut eivät kuulu polkuihin");
        }
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        Polkupeite p = alusta(1);
        tarkasta(p,1);
    }    

    @Test(timeout = 1000)
    public void testi2() {
        Polkupeite p = alusta(2);
        tarkasta(p,2);
    }    

    @Test(timeout = 1000)
    public void testi3() {
        Polkupeite p = alusta(2);
        lisaaKaari(p,1,2);
        tarkasta(p,1);
    }    
    
    @Test(timeout = 1000)
    public void testi4() {
        Polkupeite p = alusta(2);
        lisaaKaari(p,2,1);
        tarkasta(p,1);
    }    

    @Test(timeout = 1000)
    public void testi5() {
        Polkupeite p = alusta(2);
        lisaaKaari(p,1,2);
        lisaaKaari(p,1,2);
        tarkasta(p,1);
    }    

    @Test(timeout = 1000)
    public void testi6() {
        Polkupeite p = alusta(6);
        lisaaKaari(p,1,2);
        lisaaKaari(p,2,3);
        lisaaKaari(p,3,4);
        lisaaKaari(p,5,6);
        tarkasta(p,2);
    }    

    @Test(timeout = 1000)
    public void testi7() {
        int n = 10;
        Polkupeite p = alusta(10);
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                lisaaKaari(p,i,j);
            }
        }
        tarkasta(p,1);
    }    

    @Test(timeout = 1000)
    public void testi8() {
        Polkupeite p = alusta(8);
        lisaaKaari(p,1,2);
        lisaaKaari(p,1,3);
        lisaaKaari(p,2,5);
        lisaaKaari(p,3,4);
        lisaaKaari(p,3,7);
        lisaaKaari(p,4,6);
        lisaaKaari(p,4,7);
        lisaaKaari(p,4,8);
        lisaaKaari(p,5,3);
        lisaaKaari(p,5,4);
        lisaaKaari(p,5,6);
        lisaaKaari(p,6,8);
        lisaaKaari(p,7,8);
        tarkasta(p,2);
    }    

    @Test(timeout = 1000)
    public void testi9() {
        int n = 100;
        Polkupeite p = alusta(n);
        for (int i = 1; i <= n-1; i++) {
            lisaaKaari(p,i,i+1);
        }
        tarkasta(p,1);
    }    

    @Test(timeout = 1000)
    public void testi10() {
        int n = 100;
        Polkupeite p = alusta(n);
        tarkasta(p,n);
    }    
    
    void satunnaiset(int n, int m, int x) {
        Polkupeite p = alusta(n);
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n-1)+1;
            int b = a+r.nextInt(n-a)+1;
            lisaaKaari(p,a,b);
        }
        tarkasta(p,x);
    }

    @Test(timeout = 1000)
    public void testi11() {
        satunnaiset(100,10,90);
    }    

    @Test(timeout = 1000)
    public void testi12() {
        satunnaiset(100,50,66);
    }    

    @Test(timeout = 1000)
    public void testi13() {
        satunnaiset(100,100,50);
    }    

    @Test(timeout = 1000)
    public void testi14() {
        satunnaiset(100,200,36);
    }    

    @Test(timeout = 1000)
    public void testi15() {
        satunnaiset(100,300,29);
    }    

    @Test(timeout = 1000)
    public void testi16() {
        satunnaiset(100,500,23);
    }    

    @Test(timeout = 1000)
    public void testi17() {
        satunnaiset(100,1000,13);
    }        
}
