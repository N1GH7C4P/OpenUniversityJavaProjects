/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euroshopper;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 *
 * @author kimmo
 */
@Data 
@NoArgsConstructor
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart implements Serializable {
    
    @Autowired
    private HttpSession session;
    
    private Map<Item,Long> items = new HashMap();
    
    public void addToCart(Item i) {
        if(!this.items.containsKey(i)) {
            this.items.put(i, 1L);
        }
        else {
            this.items.put(i, this.items.get(i)+1L);
        }
    }
    public void emptyCart() {
        this.items = new HashMap<Item,Long>();
    }
}