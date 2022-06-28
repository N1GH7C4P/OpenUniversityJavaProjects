import java.util.*;

public class Main {
    public static void main(String[] args) {
        Inversiot i = new Inversiot();
        int[] t = i.muodosta(5,2);
        System.out.println(Arrays.toString(t)); // [2, 1, 3, 5, 4]
    }
}
