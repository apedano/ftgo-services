package com.apedano.ftgo.orderservice.persistence;

import com.apedano.ftgo.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderJpa, Long> {
       public OrderJpa findByReference(String reference);

}
