import java.util.*;

public class Main {
    public static void main(String[] args) {
        Tehdas t = new Tehdas();
        System.out.println(t.laske(new int[] {2,3,7}, 2)); // 3
        System.out.println(t.laske(new int[] {2,3,7}, 5)); // 6
        System.out.println(t.laske(new int[] {2,3,7}, 6)); // 7
    }
}
