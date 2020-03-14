package de.leuphana.orderservice.component.behaviour;

import de.leuphana.orderservice.component.structure.Order;
import de.leuphana.orderservice.component.structure.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {OrderService.class})
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void getOrdersbyUserId() {
        UUID customerUuid = UUID.randomUUID();

        Order order = new Order();
        order.setCustomerId(customerUuid);

        Set<OrderItem> orderItemSet = new HashSet<>();
        OrderItem orderItem = new OrderItem();

        orderItemSet.add(orderItem);

        order.setOrderItems(orderItemSet);

        Order newOrder = orderService.insertOrder(order);

        assertNotNull(newOrder);
        assertNotNull(newOrder.getOrderId());


        Iterable<Order> orderSearchSet = orderService.getOrdersbyUserId(customerUuid);

        orderSearchSet.forEach(o -> {
            assertNotNull(o);
        });

    }

    @Test
    public void insertOrder() {
        Order order = new Order();

        Set<OrderItem> orderItemSet = new HashSet<>();
        OrderItem orderItem = new OrderItem();

        orderItemSet.add(orderItem);

        order.setOrderItems(orderItemSet);

        Order newOrder = orderService.insertOrder(order);

        assertNotNull(newOrder);
        assertNotNull(newOrder.getOrderId());

        assertNotNull(orderItem);
    }
}