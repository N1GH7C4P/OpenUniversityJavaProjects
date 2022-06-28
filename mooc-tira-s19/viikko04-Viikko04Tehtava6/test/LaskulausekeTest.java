import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("4.6")
public class LaskulausekeTest {

    private void testi(String lasku, long oikea) {
        Laskulauseke l = new Laskulauseke();
        long tulos = l.laske(lasku);
        if (oikea == tulos) return;
        if (lasku.length() <= 30) {
            fail("Laskun "+lasku+" oikea tulos on "+oikea+" mutta metodisi antaa "+tulos);
        } else {
            fail("Laskun oikea tulos on "+oikea+" mutta metodisi antaa "+tulos);
        }
    }
        
    @Test(timeout = 1000)
    public void pienet() {
        testi("1+2+3+4+5",15);
        testi("1*2*3*4*5",120);
        testi("(1+2)*(3+4)",21);
        testi("(1+2+3)*(4+5+6)*(7+8+9)",2160);
        testi("5*(4+(3*(2+1)))",65);
        testi("1000000000+1000000000",2000000000);
        testi("1000000000*1000000000",1000000000000000000L);
        testi("(1+2*(3+4))*5+6*7",117);
    }
    
    @Test(timeout = 1000)
    public void suuri1() {
        String lasku = "1";
        for (int i = 0; i < 499; i++) lasku += "+1";
        testi(lasku,500);
    }

    @Test(timeout = 1000)
    public void suuri2() {
        String lasku = "1+1";
        for (int i = 0; i < 249; i++) lasku = "("+lasku+")+1";
        testi(lasku,251);
    }

    @Test(timeout = 1000)
    public void suuri3() {
        String lasku = "1337*((42+((42+1337+1337)*42*(42+42+1337)+((1337+42)*1337+42+42+42+1337))*1337+42)+(42+((42+1337+1337)*42*(42+42+1337)+((1337+42)*1337+42+42+42+1337))*1337+42)+(42+((42+1337+1337)*42*(42+42+1337)+((1337+42)*1337+42+42+42+1337))*1337+42)+(42+((42+1337+1337)*42*(42+42+1337)+((1337+42)*1337+42+42+42+1337))*1337+42))*1337";
        testi(lasku,1567267444186583160L);
    }

}
