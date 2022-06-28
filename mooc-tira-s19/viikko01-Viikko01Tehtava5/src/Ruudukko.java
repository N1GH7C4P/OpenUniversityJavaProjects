import java.util.*;
import java.util.ArrayList;

public class Ruudukko {
    
    
    int[][] muodosta(int n) {
        int[][] ruudukko = new int[n][n];
            
            ArrayList<Integer> aputaulukko = new ArrayList();
        
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {            
                    for(int a = 0; a < i; a++) {
                        aputaulukko.add(ruudukko[a][j]);
                    }
                    
                    for(int b = 0; b < j; b++) {
                       aputaulukko.add(ruudukko[i][b]);
                    }
                    
                    System.out.println(aputaulukko.toString());
                    
                    for(int k = 0; k < 2*n; k++){
                        if(!aputaulukko.contains(k)){
                            ruudukko[i][j] = k;   
                            break;
                        } 
                    }
                    aputaulukko.clear();
                    
                }
        }   
            return ruudukko;
    }
}