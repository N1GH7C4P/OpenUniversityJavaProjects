import java.util.*;

public class Main {
    public static void main(String[] args) {
        Alitaulukot a = new Alitaulukot();
        System.out.println(a.laske(new int[] {1,2,1,3,2})); // 10
        System.out.println(a.laske(new int[] {1,1,1,1,1})); // 15
        System.out.println(a.laske(new int[] {1,2,3,4,5})); // 9    
    }
}
