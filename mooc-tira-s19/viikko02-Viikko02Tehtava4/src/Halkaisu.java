public class Halkaisu {
    int laske(int[] t) {
        int halkaisut = 0;
        int vasen = t[0];
        int oikea = 0;
        for(int i = 1; i < t.length; i++) {
            oikea += t[i];
        }
        
        //System.out.println("Vasen alku: "+vasen);
        //System.out.println("Oikea alku: "+oikea);
        if(oikea == vasen){
            halkaisut++;
        }
        //System.out.println("Halkaisut: "+halkaisut);
        
        for(int i = 1; i < t.length-1; i++) {
            
            //System.out.println("Vasen ("+vasen+") + "+ "t["+i+"]"+"("+t[i]+")");
            vasen = vasen + t[i];
            
            //System.out.println("Oikea ("+oikea+") - "+ "t["+i+"]"+"("+t[i]+")");
            oikea = oikea - t[i];
            
            if(oikea == vasen){
                halkaisut++;
            }
            //System.out.println("Halkaisut: "+halkaisut);
        }
    return halkaisut;
    }
}
