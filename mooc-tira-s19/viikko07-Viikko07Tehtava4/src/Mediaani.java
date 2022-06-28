import java.util.*;

public class Mediaani {
    
    PriorityQueue<Long> maxKeko = new PriorityQueue(10, Collections.reverseOrder());
    PriorityQueue<Long> minKeko = new PriorityQueue(10);
    
    long ensimainen;
    long toinen;
    long maxKekoJuuri = 0;
    long minKekoJuuri = 0;
    boolean ensimmainenLaitettu = false;
    boolean toinenLaitettu = false;
    boolean alustettu = false;
    
    public void lisaa(int x) {
        if(!alustettu) {
            if(!ensimmainenLaitettu) {
                ensimainen = x;
                ensimmainenLaitettu = true;
            }
            else {
                toinen = x;
                maxKekoJuuri = Math.min(ensimainen, toinen);
                minKekoJuuri = Math.max(ensimainen, toinen);
                maxKeko.add(maxKekoJuuri);
                minKeko.add(minKekoJuuri);
                alustettu = true;
                toinenLaitettu = true;
            }
        }
        else {
            if(x < this.mediaani()) {
                maxKeko.add((long)x);
            }else{
                minKeko.add((long)x);
            }
        }
        if(maxKeko.size() > minKeko.size() + 1) {
            long tasattava = maxKeko.poll();
            minKeko.add(tasattava);
        }
        else if(minKeko.size() > maxKeko.size() + 1) {
            long tasattava = minKeko.poll();
            maxKeko.add(tasattava);
        }
    }
    
    public String toString() {
        if (!alustettu) {
            String a = String.valueOf(ensimainen);
            return "["+a+"]";
        }
        String a = minKeko.toString();
        String b = maxKeko.toString();
        return (b+a);
    }
    
    public int mediaani() {
        
        if(!alustettu) {
            if(!toinenLaitettu) {
                return Math.toIntExact(ensimainen);
            }
            else {
                return((int)Math.min(ensimainen, toinen));
            }
        }
        
        if(minKeko.size() > maxKeko.size()) {
            return Math.toIntExact(minKeko.peek());
        }else {
            return Math.toIntExact(maxKeko.peek());
        }
    }
}
