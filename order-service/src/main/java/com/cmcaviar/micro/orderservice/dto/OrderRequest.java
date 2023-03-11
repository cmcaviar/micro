package com.cmcaviar.micro.orderservice.dto;

import com.cmcaviar.micro.orderservice.model.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    List<OrderLineItemsDto> orderLineItemsList;
}
