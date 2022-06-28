package euroshopper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OrderController {
    
    @Autowired
    private HttpSession session;
    
    @Autowired
    private ShoppingCart sc;
    
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;
    
    private Map<Item,Long> items;
    private List<OrderItem> orderItems = new ArrayList();
    
    @RequestMapping("/orders")
    public String list(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "orders";
    }
    
    @Transactional
    @PostMapping("/orders")
    public String order(@RequestParam String name, @RequestParam String address) {
        
        this.items = sc.getItems();
        Order order = new Order();
        OrderItem oi = new OrderItem();
        items.forEach((k,v) -> {
            oi.setItem(k);
            oi.setItemCount(v);
            orderItems.add(oi);
        });
        
        order.setOrderItems(orderItems);
        order.setName(name);
        order.setAddress(address);
        
        orderRepository.save(order);
        sc.emptyCart();

        return "redirect:/orders";
    }
}
