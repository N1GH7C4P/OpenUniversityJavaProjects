import java.util.*;

public class Main {
    public static void main(String[] args) {
        Halkaisu h = new Halkaisu();
        System.out.println(h.laske(new int[] {1,2,-1,4,0})); // 1
        System.out.println(h.laske(new int[] {1,2,3,4,5})); // 0
        System.out.println(h.laske(new int[] {0,0,0,0,0})); // 4
        System.out.println(h.laske(new int[] {1,-1,1,-1,1,-1,1,-1})); //3
    }
}
