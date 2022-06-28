public class PisinToisto {
    
    int laske(int[] t) {
        
        int[] toistot = new int[t.length*2];
        
        for(int i = 0; i < t.length; i++) {
            toistot[t[i]] += 1;  
        }
    
    int maxToisto = 1;
        
    for(int j = 0; j < toistot.length; j++){
        if(toistot[j] > maxToisto){
            maxToisto = toistot[j];
        }
    }
    return maxToisto;
    }
}
