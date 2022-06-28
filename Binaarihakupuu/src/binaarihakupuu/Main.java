/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaarihakupuu;
import java.util.*;

/**
 *
 * @author nightcap
 */
public class Main {
    
    public static void main(String[] args) {
        Random rand = new Random();
        Binaarihakupuu bhp = new Binaarihakupuu();
        for(int i = 0; i < 1000000; i++) {
            bhp.lisaa(rand.nextInt(1000000));
        }
        System.out.println("korkeus: "+bhp.laskePuunKorkeus());
    }
}
