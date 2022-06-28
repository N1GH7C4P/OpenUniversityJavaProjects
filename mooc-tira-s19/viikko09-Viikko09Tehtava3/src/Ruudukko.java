import java.util.*;

public class Ruudukko {
    int laske(int[][] t) {
        int cost = maxCost(t,t.length-1,t.length-1);
        return cost;
    }
    static int max(int y, int z) {
        return (y > z) ? y : z; 
    }

    static int maxCost(int cost[][], int m, int n) 
    { 
    if (n < 0 || m < 0) 
        return Integer.MIN_VALUE; 
    else if (m == 0 && n == 0) 
        return cost[m][n]; 
    else
        return cost[m][n] + 
            max(maxCost(cost, m-1, n), maxCost(cost, m, n-1)); 
    }
}
