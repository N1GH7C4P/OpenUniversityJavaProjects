import java.util.*;

public class Main {
    public static void main(String[] args) {
        Jarjestys j = new Jarjestys();
        int[] a = {4,2,1,3,5};
        int[] b = {2,4,3,1,5};
        int[] c = j.muodosta(a,b);
        System.out.println(Arrays.toString(c)); // [2, 3, 5, 1, 4]
    }
}
