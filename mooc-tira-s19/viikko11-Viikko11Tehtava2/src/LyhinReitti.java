import java.util.*;

public class LyhinReitti {  
    
    private PriorityQueue<Pair<Integer, Integer>> keko;
    private Boolean[] kasitelty;
    private Integer[] verkko;
    private Integer[] etaisyys;
    private PriorityQueue<Kaari>[] kaaret;
    private int teidenMaara = 0;
    private Map<Integer, Integer> edeltajat;
    private Integer kasiteltyYhteensa;
    
    public LyhinReitti(int n) {
        this.kaaret = new PriorityQueue[n+1];
        this.edeltajat = new HashMap<Integer, Integer>();
        this.teidenMaara = 0;
        this.verkko = new Integer[n+1];
        this.kasitelty = new Boolean[n+1];
        this.kasiteltyYhteensa = 0;
        this.keko = new PriorityQueue();
        this.etaisyys = new Integer[n+1];
        for(int i = 1; i < n+1; i++) {
            this.kasitelty[i] = false;
            this.verkko[i] = i;
            this.etaisyys[i] = Integer.MAX_VALUE;
            this.kaaret[i] = new PriorityQueue();
        }
    }
    
    public void lisaaTie(int a, int b, int p) {
        this.kaaret[a].add(new Kaari(a,b,p));
        this.kaaret[b].add(new Kaari(b,a,p));
        this.teidenMaara++;
    }
    
    public ArrayList<Integer> muodosta(int x, int y) {
        
        if(this.verkko[x] == this.verkko[y]) {
            ArrayList<Integer> vainYksi = new ArrayList();
            vainYksi.add(y);
            return vainYksi;
        }
        
        this.etaisyys[x] = 0;
        Pair pari = new Pair(0, this.verkko[x]);
        this.keko.add(pari);
        while(!this.keko.isEmpty()) {
            Pair<Integer, Integer> a = this.keko.poll();
            Integer solmu = a.second;
            if(this.kasiteltyYhteensa == this.verkko.length) {
                continue;
            }
            for(Kaari k : kaaret[solmu]) {
                int nyky = this.etaisyys[k.getLoppu()];
                int uusi = this.etaisyys[solmu] + k.getPituus();
                if(uusi < nyky) {
                    this.etaisyys[k.getLoppu()] = uusi;
                    if(solmu == y) {
                        break;
                    }
                    edeltajat.put(k.getLoppu(), solmu);
                    a = new Pair(uusi, k.getLoppu());
                    this.keko.add(a);
                }
            }
            if(!this.kasitelty[solmu]) {
                this.kasitelty[solmu] = true;
                this.kasiteltyYhteensa++;
            }
        }
        if(this.etaisyys[y] == Integer.MAX_VALUE) {
            return null;
        }
        ArrayList<Integer> polku = this.tuotaPolku(verkko[y]);
        return polku;
    }
    
    public ArrayList<Integer> tuotaPolku(Integer kohde) {
        ArrayList<Integer> polku = new ArrayList<>();
        Integer a = kohde;
        if (edeltajat.get(a) == null) {
            return null;
        }
        polku.add(a);
        while (edeltajat.get(a) != null) {
            a = edeltajat.get(a);
            polku.add(a);
        }
        Collections.reverse(polku);
        return polku;
    }
}