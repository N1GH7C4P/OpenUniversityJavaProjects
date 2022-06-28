import java.util.*;

public class Main {
    public static void main(String[] args) {
        Poistot p = new Poistot();
        System.out.println(p.laske(new int[] {1,2,2,3})); // 2
        System.out.println(p.laske(new int[] {1,2,3,4})); // 4
        System.out.println(p.laske(new int[] {1,2,2,3,3,1})); // 0
    }
}
