package com.cmcaviar.micro.orderservice.repository;

import com.cmcaviar.micro.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
