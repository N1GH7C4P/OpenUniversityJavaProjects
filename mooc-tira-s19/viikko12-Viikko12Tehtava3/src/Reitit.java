import java.util.*;

public class Reitit {

    private int n;
    private ArrayList<Integer> jarjestys;
    private ArrayList<Integer>[] solmut;
    private boolean[] kayty;
    private boolean eiPolkua;
    private long[] polut;

    private ArrayList<Integer>[] muisti;

    public Reitit(int n) {
        this.n = n;
        this.jarjestys = new ArrayList<>();
        this.solmut = new ArrayList[this.n + 1];
        this.kayty = new boolean[n + 1];
        this.polut = new long[n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            this.solmut[i] = new ArrayList<>();
            this.polut[i] = -1;
            this.kayty[i] = false;
        }

        this.polut[1] = 1;
        this.eiPolkua = true;
        this.muisti = new ArrayList[n + 1];
        
        for (int i = 0; i < n; i++) {
            this.muisti[i + 1] = new ArrayList<>();
        }
    }

    public void lisaaKaari(int a, int b) {
        this.solmut[a].add(b);
        this.muisti[b].add(a);
    }

    public long laske() {
        topoSort(1);
        if (this.eiPolkua) {
            return 0;
        }
        return laskePolut(this.n);
    }

    public void topoSort(int solmu) {
        
        if (solmu == this.n) {
            this.eiPolkua = false;
        }

        if (this.solmut[solmu].isEmpty()) {
            this.jarjestys.add(solmu);
            this.kayty[solmu] = true;
            return;
        }

        for (int node : this.solmut[solmu]) {
            if (this.kayty[node]) {
                continue;
            }
            topoSort(node);
        }
        this.kayty[solmu] = true;
        this.jarjestys.add(solmu);
    }

    public long laskePolut(int mista) {
        
        if (polut[mista] != -1) {
            return polut[mista];
        }
        polut[mista] = 0;
        long polkuja = 0;
        for (int node : this.muisti[mista]) {
            polkuja += laskePolut(node);
        }

        this.polut[mista] = polkuja;
        return polkuja;
    }
}

 