package de.leuphana.orderservice.connector;

import de.leuphana.orderservice.component.behaviour.OrderService;
import de.leuphana.orderservice.component.structure.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RestController
public class OrderServiceRestConnectorProvider {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order/")
    public Order createOrder(@RequestBody Order order) {
        return orderService.insertOrder(order);
    }

    @GetMapping("/order/")
    public Set<Order> getOrdersByCustomerId(@RequestParam UUID customerId) {
        Set<Order> orders = new HashSet<Order>();

        Iterable<Order> iter = orderService.getOrdersbyUserId(customerId);

        iter.forEach(order -> {
            orders.add(order);
        });

        return orders;
    }
}
