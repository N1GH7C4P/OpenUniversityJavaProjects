/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstravsbellman;

/**
 *
 * @author kimmo
 */
import java.util.*;
import javafx.util.Pair; 

public class Dijkstra {  
    
    private ArrayDeque<Pair<Integer, Solmu>> keko;
    private HashSet<Integer> kasitelty;
    private Solmu[] verkko;
    private Integer[] etaisyys;
    private int teidenMaara = 0;
    private Map<Solmu, Solmu> edeltajat;
    
    public Dijkstra(int n) {
        this.edeltajat = new HashMap<Solmu, Solmu>();
        this.teidenMaara = 0;
        this.verkko = new Solmu[n+1];
        this.kasitelty = new HashSet();
        this.keko = new ArrayDeque();
        this.etaisyys = new Integer[n+1];
        for(int i = 1; i < n+1; i++) {
            this.verkko[i] = new Solmu(i);
            this.etaisyys[i] = Integer.MAX_VALUE;
        }
    }
    
    public void lisaaTie(int a, int b, int p) {
        this.verkko[a].lisaaKaari(verkko[b],p);
        this.verkko[b].lisaaKaari(verkko[a],p);
        this.teidenMaara++;
    }
    
    public int laske(int y) {
        this.etaisyys[1] = 0;
        Pair pari = new Pair(0, this.verkko[1]);
        this.keko.push(pari);
        while(!this.keko.isEmpty()) {
            Pair<Integer, Solmu> a = this.keko.pop();
            Solmu solmu = a.getValue();
            if(this.kasitelty.size() == this.verkko.length) {
                continue;
            }
            for(Kaari k : solmu.getKaaret()) {
                int nyky = this.etaisyys[k.getLoppu().getId()];
                int uusi = this.etaisyys[solmu.getId()] + k.getPituus();
                if(uusi < nyky) {
                    this.etaisyys[k.getLoppu().getId()] = uusi;
                    if(solmu.getId() == y) {
                        break;
                    }
                    edeltajat.put(k.getLoppu(), solmu);
                    a = new Pair(uusi, k.getLoppu());
                    this.keko.push(a);
                }
            }
            this.kasitelty.add(solmu.getId());
        }
        if(this.etaisyys[y] == Integer.MAX_VALUE) {
            return -1;
        }
        return this.etaisyys[y];
    }
    public ArrayList<Integer> tuotaPolku(Solmu kohde) {
        ArrayList<Integer> polku = new ArrayList<Integer>();
        Solmu a = kohde;
        // check if a path exists
        if (edeltajat.get(a) == null) {
            return null;
        }
        polku.add(a.getId());
        while (edeltajat.get(a) != null) {
            a = edeltajat.get(a);
            polku.add(a.getId());
        }
        // Put it into the correct order
        Collections.reverse(polku);
        return polku;
    }
}

