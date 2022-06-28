import java.util.*;

public class Main {
    public static void main(String[] args) {
        VainYksi v = new VainYksi();
        System.out.println(v.etsi(new int[] {5,2,5,3,2})); // 3
        System.out.println(v.etsi(new int[] {1})); // 1
        System.out.println(v.etsi(new int[] {1,10,10,100,100})); // 1 
    }
}
