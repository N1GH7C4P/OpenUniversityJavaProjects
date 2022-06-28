/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nightcap
 */
public class Kone implements Comparable<Kone> {
    private int valmistusAika;
    
    public Kone(int valmistusAika) {
        this.valmistusAika = valmistusAika;
    }

    @Override
    public int compareTo(Kone t) {
        return t.valmistusAika - this.valmistusAika;
    }
}
