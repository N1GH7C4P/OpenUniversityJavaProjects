import java.util.*;

public class Main {
    
    static int n = 100;
    static int[][] matka = new int[n+1][n+1];
    static int INF = 999999999;
    
    public static void main(String[] args) 
	{   
            aloita();
            int n = 100;
            LyhinReitti l = new LyhinReitti(n);
            for (int i = 1; i <= n-1; i++) {
                lisaa(l,i+1,i,1);
            }
            System.out.println(tutki(l,1,100,99));
	}
    
    static void aloita() {   
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matka[i][j] = INF;
            }
        }
    }
    
    static void lisaa(LyhinReitti l, int a, int b, int p) {
        l.lisaaTie(a,b,p);
        matka[a][b] = Math.min(matka[a][b],p);
        matka[b][a] = Math.min(matka[b][a],p);
    }
    
    static boolean tutki(LyhinReitti l, int x, int y, int u) {
        ArrayList<Integer> reitti = l.muodosta(x, y);
        if (u == -1) return reitti == null;
        if (reitti.get(0) != x) return false;
        if (reitti.get(reitti.size()-1) != y) return false;
        int z = 0;
        for (int i = 1; i <= reitti.size()-1; i++) {
            int a = reitti.get(i-1);
            int b = reitti.get(i);
            if (matka[a][b] == INF) return false;
            z += matka[a][b];
        }
        return z == u;
    }
}
