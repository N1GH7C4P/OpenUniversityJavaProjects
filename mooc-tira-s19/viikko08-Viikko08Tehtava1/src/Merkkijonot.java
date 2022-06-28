import java.util.*;

public class Merkkijonot {  
    
    private ArrayList<String> permutations = new ArrayList();
    
    public ArrayList<String> muodosta(int n) {
        kombinoi("",n);
        return permutations;
    }
    
    public void kombinoi(String soFar, int iterations) {
        if(iterations == 0) {
            permutations.add(soFar);
        }
        else {
            kombinoi(soFar + "A", iterations - 1);
            kombinoi(soFar + "B", iterations - 1);
        }
    }
    public static void main(String[] args) {
        Merkkijonot mj = new Merkkijonot();
        System.out.println(mj.muodosta(5));
    }
}
