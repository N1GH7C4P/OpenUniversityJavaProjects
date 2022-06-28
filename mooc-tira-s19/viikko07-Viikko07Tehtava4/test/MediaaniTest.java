import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("7.4")
public class MediaaniTest {
    
    @Test(timeout = 1000)
    public void pieniTesti() {
        Mediaani m = new Mediaani();
        for (int i = 1; i <= 20; i++) {
            m.lisaa(i);
            if (m.mediaani() != (i+1)/2) {
                fail("Luokkasi antaa väärän mediaanin, kun on lisätty luvut 1-"+i+".");
            }
        }
    }

    @Test(timeout = 2000)
    public void suuriTesti1() {
        Mediaani m = new Mediaani();
        int n = 1000000;
        long s = 0;
        for (int i = 1; i <= n; i++) {
            m.lisaa(i);
            s += m.mediaani();
        }
        if (s != 250000500000L) fail("Luokkasi toimii väärin suuressa tapauksessa.");
    }    

    @Test(timeout = 2000)
    public void suuriTesti2() {
        Mediaani m = new Mediaani();
        int n = 1000000;
        long s = 0;
        for (int i = n; i >= 1; i--) {
            m.lisaa(i);
            s += m.mediaani();
        }
        if (s != 750000000000L) fail("Luokkasi toimii väärin suuressa tapauksessa.");
    }    

    @Test(timeout = 2000)
    public void suuriTesti3() {
        Mediaani m = new Mediaani();
        int n = 1000000;
        long s = 0;
        int b = 0;
        Random r = new Random(1337);
        for (int i = n; i >= 1; i--) {
            b = r.nextInt(1000000000)+1;
            m.lisaa(b);
            s += m.mediaani();
        }
        if (s != 499560941004861L){
            long a = 499560941004861L - s;
            fail("Luokkasi toimii väärin suuressa tapauksessa. S: "+s+" != "+"499560941004861. Ero: "+a+" Viimeinen luku: "+b);
        }
    }    

    @Test(timeout = 2000)
    public void suuriTesti4() {
        Mediaani m = new Mediaani();
        int n = 1000000;
        long s = 0;
        int b = 0;
        Random r = new Random(1337);
        for (int i = n; i >= 1; i--) {
            b = r.nextInt(2)+1;
            m.lisaa(b);
            s += m.mediaani();
        }   long a = 1566211 - s;
        if (s != 1566211) fail("Luokkasi toimii väärin suuressa tapauksessa.S: "+s+" != "+"1566211. Ero: "+a+" Viimeinen luku: "+b);
    }    
}
