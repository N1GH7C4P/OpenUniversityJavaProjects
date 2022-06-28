import java.util.*;

public class Main {
    public static void main(String[] args) {
        PisinToisto p = new PisinToisto();
        System.out.println(p.laske(new int[] {1,2,1,1,2})); // 2
        System.out.println(p.laske(new int[] {1,2,3,4,5})); // 1
        System.out.println(p.laske(new int[] {1,1,1,1,1})); // 5
    }
}
