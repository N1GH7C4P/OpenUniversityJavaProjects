import java.util.*;

public class Tehtavat {  
    public long laske(int x) {
        int n = 7;
        int k = 3;
        long[][] bin = new long[n+1][k+1];
        bin[0][0] = 1;
        bin[n][k] = binomikerroin(n,k,bin);
        System.out.println(bin[n-1][k-1]);
        return bin[n-1][k-1];
    }
    public long binomikerroin(int n, int k, long[][] bin) {
        
        for(int i = 1; i < n; i++) {
            bin[i][0] = 1;
            for(int j = 1; j < k; j++) {
                bin[i][j] = bin[i-1][j-1]+bin[i-1][j];
            }
        }
        return bin[n-1][k-1];
    }
}
