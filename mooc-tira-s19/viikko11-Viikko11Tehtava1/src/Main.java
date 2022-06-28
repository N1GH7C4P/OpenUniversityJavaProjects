import java.util.*;

public class Main {
    public static void main(String[] args) {
        LyhinReitti l = new LyhinReitti(5);
        l.lisaaTie(1,2,7);
        l.lisaaTie(4,5,3);
        l.lisaaTie(2,4,2);
        l.lisaaTie(1,3,6);
        l.lisaaTie(3,4,5);        
        System.out.println(l.laske(1,5)); // 12
    }
}
