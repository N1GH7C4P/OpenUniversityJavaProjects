import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 99;
        Reitit r = new Reitit(n+1);
        int m = 100000;
        Random x = new Random(1337);
        for (int i = 1; i <= m-1; i++) {
            int a = x.nextInt(n-1)+1;
            int b = a+x.nextInt(n-a)+1;
            r.lisaaKaari(a+1,b+1);
        }
        r.lisaaKaari(1,n+1);
        System.out.println(r.laske()); //1
    }
}
