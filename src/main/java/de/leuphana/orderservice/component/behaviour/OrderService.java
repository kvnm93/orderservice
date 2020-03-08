package de.leuphana.orderservice.component.behaviour;

import de.leuphana.orderservice.component.structure.Order;
import de.leuphana.orderservice.component.structure.OrderItem;
import de.leuphana.orderservice.component.structure.OrderItemRepository;
import de.leuphana.orderservice.component.structure.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"de.leuphana"})
@EntityScan(basePackages = {"de.leuphana"})
@EnableJpaRepositories(basePackages = "de.leuphana.orderservice.component.structure")
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    public Iterable<Order> getOrdersbyUserId(UUID userId) {
        return orderRepository.findAllByCustomerId(userId);
    }

    public Order insertOrder(Order order) {
        Set<OrderItem> orderItemSet = new HashSet<OrderItem>(order.getOrderItems());
        order.setOrderItems(new HashSet<>());
        Order newOrder = orderRepository.save(order);
        newOrder.setOrderItems(orderItemSet);
        return orderRepository.save(newOrder);
    }


    public static void main(String[] args) {
        SpringApplication.run(OrderService.class);
    }

}
