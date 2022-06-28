import java.util.*;

public class Main {
    public static void main(String[] args) {
        Alijonot a = new Alijonot();
        System.out.println(a.laske(new int[] {1,1,1,1,1,1,1,1})); // 1
        System.out.println(a.laske(new int[] {1,2,3,4,1,2,3,4})); // 6
        System.out.println(a.laske(new int[] {1, 4, 7, 5, 8, 9, 4, 3, 2, 7})); // 5
    }
}
