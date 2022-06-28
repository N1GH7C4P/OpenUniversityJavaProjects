import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        int n = 5000;
        Lentoreitti l = new Lentoreitti(n);
        for (int i = 2; i <= n; i++) {
            for (int j = 2*i; j <= n; j += i) {
                l.lisaaYhteys(i, j);
            }
        }
        
        System.out.println(l.laske(51, 97));
        ArrayList<Integer> a = l.getYhteydet(51);
        ArrayList<Integer> b = l.getYhteydet(97);
        for(int i = 0; i < a.size(); i++) {
            if(b.contains(a.get(i))){
                System.out.println(a.get(i));
            }
        }
    }
}
