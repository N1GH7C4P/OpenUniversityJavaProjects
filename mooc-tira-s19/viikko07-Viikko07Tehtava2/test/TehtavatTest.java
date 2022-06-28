import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("7.2")
public class TehtavatTest {
    
    @Test(timeout = 1000)
    public void pieniTesti() {
        int rivi = 0;
        Tehtavat t = new Tehtavat();
        t.lisaa("apina",10);
        t.lisaa("banaani",20);
        t.lisaa("cembalo",30);
        boolean virhe = false;
        if (!t.hae().equals("cembalo")) {
            virhe = true;
            rivi = 17;
        }
        if (!t.hae().equals("banaani")) {
            virhe = true;
            rivi = 21;
        }
        if (!t.hae().equals("apina")) {
            virhe = true;
            rivi = 25;
        }
        t.lisaa("apina",10);
        t.lisaa("banaani",10);
        t.lisaa("cembalo",10);
        if (!t.hae().equals("apina")) {
            virhe = true;
            rivi = 32;
        }
        if (!t.hae().equals("banaani")) {
            virhe = true;
            rivi = 36;
        }
        if (!t.hae().equals("cembalo")) {
            virhe = true;
            rivi = 40;
        }
        t.lisaa("aybabtu",50);
        t.lisaa("aybabtu",50);
        if (!t.hae().equals("aybabtu")) {
            virhe = true;
            rivi = 46;
        }
        if (!t.hae().equals("aybabtu")) {
            virhe = true;
            rivi = 50;
        }
        if (virhe) fail("Luokkasi toimii väärin pienessä testissä. Rivi: "+rivi);
    }

    @Test(timeout = 2000)
    public void suuriTesti1() {
        Tehtavat t = new Tehtavat();
        int n = 1000000;
        for (int i = 1; i <= n; i++) t.lisaa("aybabtu",100);
        long s = 0;
        for (int i = 1; i <= n; i++) s += t.hae().hashCode();
        if (s != -548836212000000L) fail("Luokkasi toimii väärin suuressa testissä.");
    }    

    @Test(timeout = 2000)
    public void suuriTesti2() {
        Tehtavat t = new Tehtavat();
        int n = 1000000;
        long s = 0;
        for (int i = 1; i <= n; i++) {
            t.lisaa("aybabtu",100);
            s += t.hae().hashCode();
        }
        if (s != -548836212000000L) fail("Luokkasi toimii väärin suuressa testissä.");
    }    

    @Test(timeout = 2000)
    public void suuriTesti3() {
        Tehtavat t = new Tehtavat();
        int n = 1000000;
        Random r = new Random(1337);
        long s = 0;
        for (int i = 1; i <= n; i++) {
            t.lisaa("aybabtu",r.nextInt(100)+1);
        }
        for (int i = 1; i <= n/2; i++) {
            s += t.hae().hashCode();
        }
        if (s != -274418106000000L) fail("Luokkasi toimii väärin suuressa testissä.");
    }    

    @Test(timeout = 2000)
    public void suuriTesti4() {
        Tehtavat t = new Tehtavat();
        int n = 1000000;
        Random r = new Random(1337);
        long s = 0;
        for (int i = 1; i <= n/3; i++) {
            t.lisaa("apina",r.nextInt(100)+1);
            t.lisaa("banaani",r.nextInt(100)+1);
            t.lisaa("cembalo",r.nextInt(100)+1);
        }
        for (int i = 1; i <= n/2; i++) {
            s += t.hae().hashCode();
        }
        if (s != 69507899471345L) fail("Luokkasi toimii väärin suuressa testissä."+s);
    }    
    
}
