package com.cmcaviar.micro.orderservice.service;

import com.cmcaviar.micro.orderservice.dto.OrderLineItemsDto;
import com.cmcaviar.micro.orderservice.dto.OrderRequest;
import com.cmcaviar.micro.orderservice.model.Order;
import com.cmcaviar.micro.orderservice.model.OrderLineItems;
import com.cmcaviar.micro.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;



    public void placeOrder(OrderRequest orderRequest) {
       Order order = new Order();
       order.setOrderNumber(UUID.randomUUID().toString());

       List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsList()
               .stream()
               .map(this::mapToDto)
               .toList();

       order.setItems(orderLineItems);
       //Call inventory service and place a product if is in stock
       orderRepository.save(order);

    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
