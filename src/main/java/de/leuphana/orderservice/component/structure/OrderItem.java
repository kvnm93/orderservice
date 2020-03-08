package de.leuphana.orderservice.component.structure;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "orderitem")
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID orderItemId;

    private int quantity;

    @Column(columnDefinition = "uuid", updatable = true)
    private UUID articleId;

    public UUID getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(UUID orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UUID getArticleId() {
        return articleId;
    }

    public void setArticleId(UUID articleId) {
        this.articleId = articleId;
    }
}
