import java.util.*;

public class Main {
    public static void main(String[] args) {
        PieninEro p = new PieninEro();
        System.out.println(p.laske(new int[] {4,1,8,5})); // 1
        System.out.println(p.laske(new int[] {1,10,100})); // 9
        System.out.println(p.laske(new int[] {1,1,1,1,1})); // 0   
    }
}
