package fordfulkersondfsvsbfs;
import java.util.LinkedList; 
  
class BFS {
    
    private Graph verkko;
    private int n;
    
    public BFS(int n) {
        this.verkko = new Graph(n);
        this.n = n;
    }
    
    public void lisaaKaari(int a, int l, int p) {
        this.verkko.lisaaKaari(a, l, p);
    }
    
    public int laske() {
        return FordFulkerson(this.verkko, 1, n);
    }
    
    public static int FordFulkerson(Graph g, int alku, int kohde) {

        if (alku == kohde) {
            return 0;
        }
        int V = g.getSolut();
 
        Graph rg = new Graph(V);
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                rg.getNaapurit()[i][j] = g.getNaapurit()[i][j];
            }
        }
 
        int vanhempi[] = new int[V];
 
        int maksimi_virtaus = 0;
 
        while (bfs(rg, alku, kohde, vanhempi)) {
            int virta = Integer.MAX_VALUE;
 
            for (int i = kohde; i != alku; i = vanhempi[i]) {
                int j = vanhempi[i];
                virta = Math.min(virta, rg.getNaapurit()[j][i]);
            }
 
            for (int i = kohde; i != alku; i = vanhempi[i]) {
                int j = vanhempi[i];
                rg.getNaapurit()[j][i] -= virta;
                rg.getNaapurit()[i][j] += virta;
            }
 
            maksimi_virtaus += virta;
        }
        return maksimi_virtaus;
    }
 
    public static boolean bfs(Graph rg, int alku, int kohde, int vanhempi[]) {
        
        boolean[] nahty = new boolean[rg.getSolut()];
        for (int i = 0; i < rg.getSolut(); i++)
            nahty[i] = false;
 
        LinkedList<Integer> q = new LinkedList<Integer>();
 
        q.add(alku);
        nahty[alku] = true;
        vanhempi[alku] = -1;
 
        while (!q.isEmpty()) {
            int i = q.poll();
            for (Integer j : rg.naapurit(i)) {
                if ((nahty[j] == false) && (rg.getNaapurit()[i][j] > 0)) {
                    q.add(j);
                    nahty[j] = true;
                    vanhempi[j] = i;
                }
            }
        }
        return nahty[kohde];
    } 
}
        

