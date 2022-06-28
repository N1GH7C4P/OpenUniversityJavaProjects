import java.util.*;

public class Main {
    public static void main(String[] args) {
        Peli p = new Peli();
        System.out.println(p.voittaja(2)); // 1
        System.out.println(p.voittaja(3)); // 2
        System.out.println(p.voittaja(5)); // 1
        System.out.println(p.voittaja(7)); // 2
        System.out.println(p.voittaja(8)); // 1
        System.out.println(p.voittaja(15)); // 2
    }
}
