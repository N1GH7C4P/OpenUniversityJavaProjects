import java.util.*;

public class Main {
    public static void main(String[] args) {
        Yhteydet y = new Yhteydet(5);
        y.yhdista(2,4);
        y.yhdista(2,3);
        y.yhdista(1,5);
        y.yhdista(2,3);
        y.yhdista(3,4);
        y.yhdista(1,5);
        System.out.println(y.tutki(1,2)); // -1
        System.out.println(y.tutki(1,5)); // 3
        System.out.println(y.tutki(2,3)); //2
        System.out.println(y.tutki(2,4)); //1
        System.out.println(y.tutki(3,4)); //2
    }
}
