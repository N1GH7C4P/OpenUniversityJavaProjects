public class Muutokset {
    int laske(int[] t) {
        int muutokset = 0;
        for(int i = 1; i < t.length; i++) {
            if(t[i] == t[i-1]){
                muutokset++;
                i++;
            }
        }
        return muutokset;
    }
}
