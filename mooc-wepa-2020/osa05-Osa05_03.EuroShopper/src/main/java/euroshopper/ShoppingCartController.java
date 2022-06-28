/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euroshopper;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author kimmo
 */
@Controller
public class ShoppingCartController {
    
    @Autowired
    ItemRepository itemRepository;
    
    private double price;
    
    @Autowired
    private HttpSession session;
    
    @Autowired
    private ShoppingCart sc;
    
    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("items", sc.getItems());
        model.addAttribute("sum", price);
        return "cart";
    }
    
    @PostMapping("/cart/items/{id}")
    public String addItem(@PathVariable Long id) {
        Item i = itemRepository.getOne(id);
        sc.addToCart(i);
        price += itemRepository.getOne(id).getPrice();
        return("redirect:/cart");
    }
}
