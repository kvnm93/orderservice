package de.leuphana.orderservice.component.structure;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends CrudRepository<Order, UUID> {

    public Iterable<Order> findAllByCustomerId(UUID userId);
}
