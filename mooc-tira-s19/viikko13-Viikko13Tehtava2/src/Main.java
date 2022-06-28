import java.util.*;

public class Main {
    public static void main(String[] args) {
        Kunnostus k = new Kunnostus(4);
        k.lisaaTie(1,2,1);
        k.lisaaTie(1,3,4);
        k.lisaaTie(2,3,6);
        k.lisaaTie(2,4,5);
        k.lisaaTie(3,4,3);
        System.out.println(k.laske()); // 8
    }
}
