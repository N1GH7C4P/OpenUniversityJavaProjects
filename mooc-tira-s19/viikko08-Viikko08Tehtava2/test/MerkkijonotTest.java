import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("8.2")
public class MerkkijonotTest {
    
    public void testi(int n, int k) {
        int c = 1;
        for (int i = 0; i < n; i++) {
            c *= k;
            if (c > 100000) return;
        }
        String s = "Luokkasi toimii väärin, kun n="+n+" ja k="+k;
        Merkkijonot m = new Merkkijonot();
        ArrayList<String> u = m.muodosta(n,k);
        if (u.size() != c) fail(s);
        String z = "";
        for (int i = 0; i < k; i++) z += (char)('A'+i);
        for (int i = 0; i < c; i++) {
            if (u.get(i).length() != n) fail(s);
            if (!u.get(i).matches("["+z+"]+")) fail(s);
            if (i > 0 && u.get(i-1).compareTo(u.get(i)) >= 0) fail(s);
        }
    }

    @Test(timeout = 5000)
    public void testit() {
        for (int n = 1; n <= 16; n++) {
            for (int k = 1; k <= 26; k++) {
                testi(n,k);
            }
        }
    }    

}
