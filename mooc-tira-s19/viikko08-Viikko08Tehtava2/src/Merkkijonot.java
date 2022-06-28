import java.util.*;

import java.util.*;

public class Merkkijonot {  
    
    private ArrayList<String> permutations = new ArrayList();
    
    public ArrayList<String> muodosta(int n, int m) {
        kombinoi("",n,m);
        return permutations;
    }
    
    public void kombinoi(String soFar, int iterations, int m) {
        if(iterations == 0) {
            permutations.add(soFar);
        }
        else {
            for(int i = 0; i < m; i++) {
                Character ch = (char) (65+i);
                kombinoi(soFar + ch, iterations - 1, m);
            }
        }
    }
    public static void main(String[] args) {
        Merkkijonot mj = new Merkkijonot();
        System.out.println(mj.muodosta(5,3));
    }
}