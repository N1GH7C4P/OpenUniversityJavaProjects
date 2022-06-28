import java.util.*;

public class Peli {  
    
   int coins;
    
    public int voittaja(int n) {
        
        int edellinen = 7;
        ArrayList<Integer> losers = new ArrayList();
        int i = 0;
        while(edellinen < 1000000000L){
            i = edellinen*2+1;
            losers.add(i);
            edellinen = i;
        }
        
        int coins = n;
        if(coins == 1) {
            return 2;
        }else if(coins == 2) {
            return 1;
        }else if(coins == 3) {
            return 2;
        }else if(coins > 3 && coins < 7) {
            return 1;
        }else if(coins == 7) {
            return 2;
        }else if(losers.contains(coins)) {
            return 2;
        }else{
            return 1;
        }
    }
}