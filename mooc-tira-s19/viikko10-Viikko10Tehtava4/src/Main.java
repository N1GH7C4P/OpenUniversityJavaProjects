import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 5000;
        int m = 100000;
        int c = 0;
        Viestinta v = new Viestinta(n);
        for (int i = 1; i+1 <= n; i++) v.lisaaYhteys(i,i+1);
        for (int i = 1; i <= m; i++) {
             if(v.tarkasta(1,n)) {
                 c++;
             };
             System.out.println("c: "+c);
        }
    }
}
