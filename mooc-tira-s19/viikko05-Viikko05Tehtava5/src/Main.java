import java.util.*;

public class Main {
    public static void main(String[] args) {
        Tormays t = new Tormays();
        HashMap<Integer,String> mjt = t.luoMontaMerkkijonoa();
        t.jarjestaMerkkijonot(mjt);
    }
}
