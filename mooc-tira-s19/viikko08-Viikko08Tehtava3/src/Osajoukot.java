import java.util.*;

public class Osajoukot 
{ 
    static boolean[][] osajoukot; 
    public int osajoukkoja = 0;

    public void tulostaOsajoukot(int t[], int i, int summa, ArrayList<Integer> p) 
    {   
         
        if (i == 0 && summa != 0 && osajoukot[0][summa]) 
        { 
                p.add(t[i]); 
                osajoukkoja++; 
                p.clear(); 
                return; 
        } 

        if (i == 0 && summa == 0) 
        { 
                osajoukkoja++;
                p.clear(); 
                return; 
        } 

        if (osajoukot[i-1][summa]) 
        { 
                ArrayList<Integer> b = new ArrayList<>(); 
                b.addAll(p); 
                tulostaOsajoukot(t, i-1, summa, b); 
        } 

        if (summa >= t[i] && osajoukot[i-1][summa-t[i]]) 
        { 
                p.add(t[i]); 
                tulostaOsajoukot(t, i-1, summa-t[i], p); 
        } 
    } 

    public int laske(int t[], int summa) 
    {
        int n = t.length;
        if (n == 0 || summa < 0) 
        return osajoukkoja; 

        osajoukot = new boolean[n][summa + 1]; 
        for (int i=0; i<n; ++i) { 
            osajoukot[i][0] = true; 
        }
        if (t[0] <= summa) 
        osajoukot[0][t[0]] = true; 

        for (int i = 1; i < n; ++i) 
                for (int j = 0; j < summa + 1; ++j) 
                        osajoukot[i][j] = (t[i] <= j) ? (osajoukot[i-1][j] || osajoukot[i-1][j-t[i]]) : osajoukot[i - 1][j]; 
        if (osajoukot[n-1][summa] == false) 
        { 
                System.out.println("Ei osajoukkoja joiden summama:" + " summa "+ summa); 
                return osajoukkoja; 
        } 
 
        ArrayList<Integer> p = new ArrayList();
        tulostaOsajoukot(t, n-1, summa, p);
        return osajoukkoja;
    } 
}