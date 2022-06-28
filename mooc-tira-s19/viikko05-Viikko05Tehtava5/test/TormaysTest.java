import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("5.5")
public class TormaysTest {
    @Test(timeout = 1000)
    public void testi() {
        Tormays t = new Tormays();
        String x = t.merkkijono1();
        String y = t.merkkijono2();
        if (!x.matches("[ab]+")) fail("Merkkijonon 1 muoto ei ole oikea");
        if (!y.matches("[ab]+")) fail("Merkkijonon 2 muoto ei ole oikea");
        if (x.equals(y)) fail("Merkkijonot ovat samat");
        if (x.hashCode() != y.hashCode()) fail("Merkkijonojen hajautusarvot eivät ole samat");
    }    
}
