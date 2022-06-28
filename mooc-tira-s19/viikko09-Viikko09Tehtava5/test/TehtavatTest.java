import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("9.5")
public class TehtavatTest {
    @Test(timeout = 1000)
    public void testit() {
        Tehtavat t = new Tehtavat();
        long[] v = {1,14,105,560,2366,8372,25662,69680,170261,378742,773773,1461824,2567656,4211312,6472168,9346624,12711986,16311932,19775938,22675744,24608948,25288120,24608948,22675744,19775938,16311932,12711986,9346624,6472168,4211312,2567656,1461824,773773,378742,170261,69680,25662,8372,2366,560,105,14,1};
        for (int x = 42; x <= 84; x++) {
            long u = t.laske(x);
            if (u == v[x-42]) continue;
            fail("Kun x="+x+", oikea vastaus on "+v[x-42]+" mutta metodisi antaa "+u);
        }
    }    

}
