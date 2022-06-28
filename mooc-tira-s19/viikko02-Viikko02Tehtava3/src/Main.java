import java.util.*;

public class Main {
    public static void main(String[] args) {
        Muutokset m = new Muutokset();
        System.out.println(m.laske(new int[] {1,1,2,2,2})); // 2
        System.out.println(m.laske(new int[] {1,2,3,4,5})); // 0
        System.out.println(m.laske(new int[] {1,1,1,1,1})); // 2
    }
}
