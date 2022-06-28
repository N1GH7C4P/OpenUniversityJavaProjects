import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("14.6")
public class RuudukkoTest {
    void testi(int[][] ruudukko, int a) {
        Ruudukko r = new Ruudukko();
        int n = ruudukko.length;
        int[][] kopio = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                kopio[i][j] = ruudukko[i][j];
            }
        }
        ArrayList<Siirto> tulos = r.muodosta(kopio);
        int b = tulos.size();
        if (a != b) fail("Oikea siirtojen määrä on "+a+", mutta koodisi antaa "+b);
        for (Siirto s : tulos) {
            if (s.kohta < 1 || s.kohta > n) fail("Virheellinen kohta");
            if (s.suunta.equals("V")) {
                for (int i = 0; i < n; i++) {
                    ruudukko[s.kohta-1][i] = 0;
                }
            } else if (s.suunta.equals("P")) {
                for (int i = 0; i < n; i++) {
                    ruudukko[i][s.kohta-1] = 0;
                }                
            } else {
                fail("Virheellinen suunta");
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ruudukko[i][j] != 0) fail("Ruudukkoon jää musta ruutu");
            }
        }
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        int[][] r = {{0}};
        testi(r,0);
    }    

    @Test(timeout = 1000)
    public void testi2() {
        int[][] r = {{1}};
        testi(r,1);
    }    
    
    @Test(timeout = 1000)
    public void testi3() {
        int[][] r = {{1,1},{0,0}};
        testi(r,1);
    }    

    @Test(timeout = 1000)
    public void testi4() {
        int[][] r = {{1,0},{1,0}};
        testi(r,1);
    }    

    @Test(timeout = 1000)
    public void testi5() {
        int[][] r = {{1,1},{1,0}};
        testi(r,2);
    }    

    @Test(timeout = 1000)
    public void testi6() {
        int[][] r = {{1,1},{1,1}};
        testi(r,2);
    }    

    public void satunnainen(int n, int p, int a) {
        int[][] r = new int[n][n];
        Random x = new Random(1337);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                r[i][j] = x.nextInt(1000) < p ? 1 : 0;
            }
        }
        testi(r,a);
    }

    @Test(timeout = 1000)
    public void testi7() {
        satunnainen(100,0,0);
    }    

    @Test(timeout = 1000)
    public void testi8() {
        satunnainen(100,1,13);
    }    

    @Test(timeout = 1000)
    public void testi9() {
        satunnainen(100,5,37);
    }    

    @Test(timeout = 1000)
    public void testi10() {
        satunnainen(100,10,59);
    }    

    @Test(timeout = 1000)
    public void testi11() {
        satunnainen(100,15,68);
    }    

    @Test(timeout = 1000)
    public void testi12() {
        satunnainen(100,20,84);
    }    

    @Test(timeout = 1000)
    public void testi13() {
        satunnainen(100,25,93);
    }    

    @Test(timeout = 1000)
    public void testi14() {
        satunnainen(100,30,95);
    }    

    @Test(timeout = 1000)
    public void testi15() {
        satunnainen(100,35,97);
    }    

    @Test(timeout = 1000)
    public void testi16() {
        satunnainen(100,40,99);
    }    

    @Test(timeout = 1000)
    public void testi17() {
        satunnainen(100,50,100);
    }    

    @Test(timeout = 1000)
    public void testi18() {
        satunnainen(100,1000,100);
    }    
    
}
