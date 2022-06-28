import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("8.1")
public class MerkkijonotTest {
    
    public void testi(int n) {
        String s = "Luokkasi toimii väärin, kun n="+n;
        Merkkijonot m = new Merkkijonot();
        ArrayList<String> u = m.muodosta(n);
        int c = (1<<n);
        if (u.size() != c) fail(s);
        for (int i = 0; i < c; i++) {
            if (u.get(i).length() != n) fail(s);
            if (!u.get(i).matches("[AB]+")) fail(s);
            if (i > 0 && u.get(i-1).compareTo(u.get(i)) >= 0) fail(s);
        }
    }

    @Test(timeout = 5000)
    public void testit() {
        for (int i = 1; i <= 16; i++) {
            testi(i);
        }
    }    

}
