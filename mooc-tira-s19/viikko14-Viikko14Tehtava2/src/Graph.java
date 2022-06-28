/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kimmo
 */
public class Graph {
    private int solut;
    private int[][] naapurit;
 
    public int getSolut() {
        return solut;
    }
 
    public int[][] getNaapurit() {
        return naapurit;
    }
 
    public Graph(int solut) {
        this.solut = solut+1;
        this.naapurit = new int[solut+1][solut+1];
        for (int i = 1; i < solut+1; i++) {
            for (int j = 1; j < solut+1; j++) {
                this.naapurit[i][j] = 0;
            }
        }
    }
 
    public void lisaaKaari(int i, int j, int weight) {
        this.naapurit[i][j] += weight;
    }
 
    public void poistaKaari(int i, int j) {
        this.naapurit[i][j] = 0;
    }
 
    public boolean onKaari(int i, int j) {
        if (this.naapurit[i][j] != 0) {
            return true;
        }
        return false;
    }
 
    public List<Integer> naapurit(int vertex) {
        List<Integer> kaaret = new ArrayList<Integer>();
        for (int i = 0; i < solut; i++)
            if (onKaari(vertex, i))
                kaaret.add(i);
        return kaaret;
    }
 
    public void tulostaVerkko() {
        for (int i = 0; i < solut; i++) {
            List<Integer> kaaret = naapurit(i);
            System.out.print(i + ": ");
            for (int j = 0; j < kaaret.size(); j++) {
                System.out.print(kaaret.get(j) + " ");
            }
            System.out.println();
        }
    }
}