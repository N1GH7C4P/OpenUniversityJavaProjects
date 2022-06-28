/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hajautusarvo;

/**
 *
 * @author nightcap
 */
public class Hajautusarvo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String sana = "saippuakauppias";
        double N = 931663099;
        double h = 0;
        double d = 0;
        int A = 17;
        int[] arvot = new int[sana.length()];
        int k = sana.length();
        
        for(int i = 0; i < sana.length(); i++) {
            arvot[i] = Integer.valueOf(sana.charAt(i));
        }
        
        for (int i = 0; i < sana.length(); i++) {
            
            double a = Math.pow(A, k - i -1);
            double e = k - i -1;
            double b = arvot[i];
            double c = a*b;
            
            System.out.println("");
            System.out.println("polynomikerroin: "+a);
            System.out.println("merkin ASCII-arvo: "+b);
            System.out.println("eksponentti: "+e);
            System.out.println("merkin hajautusarvo: "+c);
            
            d += c;
            h = (h*A + b)%N;
        }
        System.out.println("sanan hajautusarvo: "+(long)d);
        System.out.println("sanan hajautusarvon jakojäännös: "+(long)h);
    }
}
