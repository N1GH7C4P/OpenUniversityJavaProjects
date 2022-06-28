import java.util.*;

public class Taulukko {
    int laske(int[] t) {
        
        while(t.length != 1){
            
            if(t.length == 2){
                int[] new_t = new int [1];
                new_t[0] = t[0]+t[1];
                t = new_t;
                continue;
            }
            
            //Tehdään kopio taulukosta, joka on yhden arvon lyhyempi.
            int[] new_t = new int [t.length-1];
           
            //Uuden taulukon muihin lukuihin lisätään niitä edeltävät ja seuraavat luvut.
            for(int i = 0; i <= new_t.length-1; i++) {
                new_t[i] = t[i] + t[i+1];
            }
            
            t = new_t;
            
            System.out.println("Rivi: ");
            for(int i = 0; i<t.length; i++){
                System.out.println("["+t[i]+"]");
            }
        }
        return t[0];
    }
}
