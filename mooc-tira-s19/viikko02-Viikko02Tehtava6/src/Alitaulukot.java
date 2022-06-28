public class Alitaulukot {
    
    long laske(int[] t) {
        int n = t.length;
        int r = 2;
        int data[] = new int[r];
        int[] palautus = combinationUtil(t, n, r, 0, data, 0);
        
    }
} 