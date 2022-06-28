public class Onnenluvut {
    int laske(int a, int b) {
        int tulos = 0;
        
        boolean combo = false;
        int[] t = new int[b-a];
        for(int i = 0; i < t.length; i++){
            if(i == 3 || i == 7) {
                combo = true;
            }else{
                combo = false;
                tulos++;
            }
        }
    return tulos;
    }
}
