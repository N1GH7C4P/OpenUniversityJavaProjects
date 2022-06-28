import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("6.6")
public class JarjestysTest {
    static int[] esi1, sisa1, jalki1;
    static int[] esi2, sisa2, jalki2;
    static int[] esi3, sisa3, jalki3;
    static Random r;
    static int k;
    
    public static void muodosta(int e1, int e2, int s1, int s2, int j1, int j2) {
        if (e1 > e2) return;
        int u = r.nextInt(e2-e1+1);
        esi3[e1] = ++k;
        sisa3[s1+u] = k;
        jalki3[j2] = k;
        muodosta(e1+1,e1+u,s1,s1+u-1,j1,j1+u-1);
        muodosta(e1+u+1,e2,s1+u+1,s2,j1+u,j2-1);
    }
    
    @BeforeClass
    public static void luoTaulukot() {
        int n = 1000000;
        esi1 = new int[n];
        sisa1 = new int[n];
        jalki1 = new int[n];
        for (int i = 0; i < n; i++) {
            esi1[i] = i+1;
            sisa1[i] = n-i;
            jalki1[i] = n-i;
        }
        esi2 = new int[n];
        sisa2 = new int[n];
        jalki2 = new int[n];
        for (int i = 0; i < n; i++) {
            esi2[i] = i+1;
            sisa2[i] = i+1;
            jalki2[i] = n-i;
        }
        esi3 = new int[n];
        sisa3 = new int[n];
        jalki3 = new int[n];
        r = new Random(1337);
        k = 0;
        muodosta(0,n-1,0,n-1,0,n-1);
    }        
    
    
    public void testi(int[] esi, int[] sisa, int[] jalki) {
        Jarjestys j = new Jarjestys();
        int[] uusi = j.muodosta(esi,sisa);
        if (Arrays.equals(uusi,jalki)) return;
        if (esi.length <= 10) {
            String esiKuvaus = Arrays.toString(esi);
            String sisaKuvaus = Arrays.toString(sisa);
            String jalkiKuvaus = Arrays.toString(jalki);
            String uusiKuvaus = Arrays.toString(uusi);
            fail("Kun esijärjestys on "+esiKuvaus+" ja sisäjärjestys on "+sisaKuvaus+
                 ", jälkijärjestys on "+jalkiKuvaus+" mutta metodisi antaa "+uusiKuvaus+".");
        } else {
            fail("Metodisi toimii väärin suuressa tapauksessa.");
        }
    }
    
    @Test(timeout = 1000)
    public void pienetTestit() {
        testi(new int[] {1}, new int[] {1}, new int[] {1});
        testi(new int[] {2,1,3}, new int[] {1,2,3}, new int[] {1,3,2});
        testi(new int[] {3,2,1}, new int[] {1,2,3}, new int[] {1,2,3});
        testi(new int[] {5,1,6,2,4,3}, new int[] {6,1,5,4,2,3}, new int[] {6,1,4,3,2,5});
        testi(new int[] {1,2,3,4,5}, new int[] {4,3,5,2,1}, new int[] {4,5,3,2,1});
        testi(new int[] {7,5,3,1,6,4,2}, new int[] {3,1,5,7,6,2,4}, new int[] {1,3,5,2,4,6,7});
    }
    
    @Test(timeout = 1000)
    public void suuriTesti1() {
        testi(esi1,sisa1,jalki1);
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        testi(esi2,sisa2,jalki2);
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        testi(esi3,sisa3,jalki3);
    }
}
