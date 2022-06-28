import java.util.*;

public class Main {
    public static void main(String[] args) {
        HatutJaPallot h = new HatutJaPallot();
        h.lisaaPallo(2);
        h.lisaaPallo(3);
        h.lisaaPallo(5);
        System.out.println(h.monessakoYksi()); // 3
        System.out.println(h.suurinMaara()); // 1
        h.lisaaPallo(3);
        System.out.println(h.monessakoYksi()); // 3
        System.out.println(h.suurinMaara()); // 2
    }
}
