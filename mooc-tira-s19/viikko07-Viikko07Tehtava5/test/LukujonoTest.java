import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("7.5")
public class LukujonoTest {
    
    @Test(timeout = 1000)
    public void pienetTestit() {
        int[] oikeat = {1,2,3,4,5,6,8,9,10,12,15,16,18,20,24,25,27,30,32,36};
        Lukujono l = new Lukujono();
        for (int i = 1; i < oikeat.length; i++) {
            int uusi = (int)l.laske(i);
            if (uusi != oikeat[i]) {
                fail("Kohdassa "+i+" on luku "+oikeat[i]+", mutta metodisi antaa luvun "+uusi+".");
            }
        }
    }

    @Test(timeout = 1000)
    public void suuriTesti1() {
        int kohta = 123;
        long oikea = 3072;
        Lukujono l = new Lukujono();
        long uusi = l.laske(kohta);
        if (oikea == uusi) return;
        fail("Kohdassa "+kohta+" on luku "+oikea+", mutta metodisi antaa luvun "+uusi+".");
    }    

    @Test(timeout = 1000)
    public void suuriTesti2() {
        int kohta = 666;
        long oikea = 4428675;
        Lukujono l = new Lukujono();
        long uusi = l.laske(kohta);
        if (oikea == uusi) return;
        fail("Kohdassa "+kohta+" on luku "+oikea+", mutta metodisi antaa luvun "+uusi+".");
    }    

    @Test(timeout = 1000)
    public void suuriTesti3() {
        int kohta = 5252;
        long oikea = 88473600000000L;
        Lukujono l = new Lukujono();
        long uusi = l.laske(kohta);
        if (oikea == uusi) return;
        fail("Kohdassa "+kohta+" on luku "+oikea+", mutta metodisi antaa luvun "+uusi+".");
    }    

    @Test(timeout = 1000)
    public void suuriTesti4() {
        int kohta = 9999;
        long oikea = 288325195312500000L;
        Lukujono l = new Lukujono();
        long uusi = l.laske(kohta);
        if (oikea == uusi) return;
        fail("Kohdassa "+kohta+" on luku "+oikea+", mutta metodisi antaa luvun "+uusi+".");
    }    

    @Test(timeout = 1000)
    public void suuriTesti5() {
        int kohta = 10000;
        long oikea = 288555831593533440L;
        Lukujono l = new Lukujono();
        long uusi = l.laske(kohta);
        if (oikea == uusi) return;
        fail("Kohdassa "+kohta+" on luku "+oikea+", mutta metodisi antaa luvun "+uusi+".");
    }        
}
