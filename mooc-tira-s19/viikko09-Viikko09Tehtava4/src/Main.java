import java.util.*;

public class Main {
    public static void main(String[] args) {
        Kolikot k = new Kolikot();
        System.out.println(k.laske(new int[] {1,1,4})); // 5
        System.out.println(k.laske(new int[] {1,1,1,1})); // 4
        System.out.println(k.laske(new int[] {1,2,3,4})); // 10
    }
}
