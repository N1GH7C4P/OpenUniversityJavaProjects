import java.util.*;

public class Main {
    public static void main(String[] args) {
        Saavutettavuus s = new Saavutettavuus(6);
        s.lisaaYhteys(1,2);
        s.lisaaYhteys(2,3);
        s.lisaaYhteys(1,3);
        s.lisaaYhteys(3,4);
        s.lisaaYhteys(5,6);
        System.out.println(s.laske(1)); // 3
    }
}
