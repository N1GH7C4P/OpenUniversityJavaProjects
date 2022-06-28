import java.util.*;

public class Main {
    public static void main(String[] args) {
        Summahaku s = new Summahaku();
        System.out.println(s.laske(new int[] {1,3,2,4}, 4)); // 2
        System.out.println(s.laske(new int[] {0,0,0,0}, 0)); // 10
        System.out.println(s.laske(new int[] {1,-1,1,-1}, 0)); // 4
    }
}
