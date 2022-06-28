import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("1.2")
public class OsajonotTest {
    void testi(String a, String b, int x) {
        Osajonot o = new Osajonot();
        int y = o.laske(a,b);
        if (x == y) return;
        fail("Kun a="+a+" ja b="+b+", metodisi antaa "+y+" mutta oikea vastaus on "+x);
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        testi("apina","apina",1);
    }

    @Test(timeout = 1000)
    public void testi2() {
        testi("aaaaa","a",5);
    }

    @Test(timeout = 1000)
    public void testi3() {
        testi("a","aaaaa",0);
    }

    @Test(timeout = 1000)
    public void testi4() {
        testi("maanantaitiistaikeskiviikkotorstaiperjantailauantaisunnuntai","tai",6);
    }

    @Test(timeout = 1000)
    public void testi5() {
        testi("abcxxxabc","abc",2);
    }

    @Test(timeout = 1000)
    public void testi6() {
        String x = "";
        for(int i = 0; i < 100; i++) x += "a";
        testi(x,"a",100);
    }

    @Test(timeout = 1000)
    public void testi7() {
        testi("bacbacbacba","bacba",3);
    }
}
