import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("11.2")
public class LyhinReittiTest {
    int[][] matka;
    int INF = 999999999;
    
    void aloita() {
        int n = 100;
        matka = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matka[i][j] = INF;
            }
        }
    }
    
    void lisaa(LyhinReitti l, int a, int b, int p) {
        l.lisaaTie(a,b,p);
        matka[a][b] = Math.min(matka[a][b],p);
        matka[b][a] = Math.min(matka[b][a],p);
    }
    
    boolean tutki(LyhinReitti l, int x, int y, int u) {
        ArrayList<Integer> reitti = l.muodosta(x, y);
        if (u == -1) return reitti == null;
        if (reitti.get(0) != x) return false;
        if (reitti.get(reitti.size()-1) != y) return false;
        int z = 0;
        for (int i = 1; i <= reitti.size()-1; i++) {
            int a = reitti.get(i-1);
            int b = reitti.get(i);
            if (matka[a][b] == INF) return false;
            z += matka[a][b];
        }
        return z == u;
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        aloita();
        LyhinReitti l = new LyhinReitti(1);
        if (tutki(l,1,1,0)) return;
        fail("Luokkasi toimii väärin, kun on vain yksi kaupunki");
    }    

    @Test(timeout = 1000)
    public void testi2() {
        aloita();
        LyhinReitti l = new LyhinReitti(2);
        if (tutki(l,1,2,-1)) return;
        fail("Luokkasi toimii väärin, kun reittiä ei ole");
    }    
    
    @Test(timeout = 1000)
    public void testi3() {
        aloita();
        int n = 100;
        LyhinReitti l = new LyhinReitti(n);
        for (int i = 1; i <= n-1; i++) {
            lisaa(l,i,i+1,1);
        }
        if (tutki(l,1,100,99)) return;
        fail("Luokkasi toimii väärin, kun tiet ovat ketjussa");
    }    

    @Test(timeout = 1000)
    public void testi4() {
        aloita();
        int n = 100;
        LyhinReitti l = new LyhinReitti(n);
        for (int i = 1; i <= n-1; i++) {
            lisaa(l,i+1,i,1);
        }
        if (tutki(l,1,100,99)) return;
        fail("Luokkasi toimii väärin, kun tiet ovat ketjussa");
    }    

    @Test(timeout = 1000)
    public void testi5() {
        aloita();
        LyhinReitti l = new LyhinReitti(9);
        lisaa(l,1,2,16);
        lisaa(l,1,4,7);
        lisaa(l,2,3,9);
        lisaa(l,3,5,8);
        lisaa(l,3,6,10);
        lisaa(l,4,5,5);
        lisaa(l,4,7,1);
        lisaa(l,5,9,50);
        lisaa(l,6,8,12);
        lisaa(l,7,9,95);
        lisaa(l,8,9,3);
        if (tutki(l,1,9,45)) return;
        fail("Luokkasi toimii väärin, kun reittejä on useita");
    }    

    @Test(timeout = 1000)
    public void testi6() {
        aloita();
        LyhinReitti l = new LyhinReitti(2);
        lisaa(l,1,2,5);
        lisaa(l,1,2,4);
        if (tutki(l,1,2,4)) return;
        fail("Luokkasi toimii väärin, kun on rinnakkaiset tiet");
    }    

    @Test(timeout = 1000)
    public void testi7() {
        aloita();
        LyhinReitti l = new LyhinReitti(2);
        lisaa(l,1,1,1);
        lisaa(l,2,2,1);
        lisaa(l,1,2,1);
        if (tutki(l,1,2,1)) return;
        fail("Luokkasi toimii väärin, kun tien päissä on sama kaupunki");
    }    

    @Test(timeout = 1000)
    public void testi8() {
        aloita();
        int n = 100;
        LyhinReitti l = new LyhinReitti(n);
        Random r = new Random(1337);
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                lisaa(l,i,j,r.nextInt(1000)+1);
            }
        }
        if (tutki(l,1,n,30)) return;
        fail("Luokkasi toimii väärin satunnaisessa verkossa");
    }    

    @Test(timeout = 1000)
    public void testi9() {
        aloita();
        int n = 100;
        int m = 100000;
        LyhinReitti l = new LyhinReitti(n);
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            int p = r.nextInt(1000)+1;
            lisaa(l,a,b,p);
        }
        if (tutki(l,1,n,5)) return;
        fail("Luokkasi toimii väärin satunnaisessa verkossa");
    }    

    @Test(timeout = 1000)
    public void testi10() {
        aloita();
        int n = 100;
        int m = 100000;
        LyhinReitti l = new LyhinReitti(n);
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = Math.min(n,a+r.nextInt(3)+1);
            int p = r.nextInt(1000)+1;
            lisaa(l,a,b,p);
        }
        if (tutki(l,1,n,54)) return;
        fail("Luokkasi toimii väärin satunnaisessa verkossa");
    }    

    @Test(timeout = 1000)
    public void testi11() {
        aloita();
        int n = 100;
        int m = 100000;
        LyhinReitti l = new LyhinReitti(n);
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n-1)+1;
            int b = Math.min(n-1,a+r.nextInt(3)+1);
            int p = r.nextInt(1000)+1;
            lisaa(l,a,b,p);
        }
        if (tutki(l,1,n,-1)) return;
        fail("Luokkasi toimii väärin satunnaisessa verkossa");
    }    

    @Test(timeout = 1000)
    public void testi12() {
        aloita();
        LyhinReitti l = new LyhinReitti(3);
        lisaa(l,1,3,5);
        lisaa(l,1,2,7);
        if (tutki(l,3,2,12)) return;
        fail("Luokkasi toimii väärin pienessä verkossa");
    }    

    @Test(timeout = 1000)
    public void testi13() {
        aloita();
        int n = 100;
        LyhinReitti l = new LyhinReitti(n);
        for (int i = n-1; i >= 1; i--) {
            for (int p = 1000; p >= 1; p--) {
                lisaa(l,i,i+1,p);
            }
        }
        if (tutki(l,1,n,99)) return;
        fail("Luokkasi toimii väärin, kun reittejä on paljon");
    }    

    @Test(timeout = 1000)
    public void testi14() {
        aloita();
        int n = 100;
        LyhinReitti l = new LyhinReitti(n);
        for (int i = 1; i <= n-1; i++) {
            lisaa(l,i,i+1,1000);
        }
        if (tutki(l,1,100,99000)) return;
        fail("Luokkasi toimii väärin, kun tiet ovat ketjussa");
    }    
    
}
