package com.food.ordering.system.order.service.domain;

import com.food.ordering.system.order.service.domain.entity.Order;
import com.food.ordering.system.order.service.domain.entity.Restaurant;
import com.food.ordering.system.order.service.domain.event.OrderCancelledEvent;
import com.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import com.food.ordering.system.order.service.domain.event.OrderPaidEvent;

import java.util.List;

/*
Note the domain events are constructed within the domain, but not fired.
I think this is evidence of separation of concerns -- the firing of the events will take place
in the application layer.
Also, the state has not yet been persisted.  Both things need to happen in an atomic way and these
are not the responsibility of the domain core.

Where to fire event?  Application service.  The domain core should not be concerned with accidental complexity
 */
public interface OrderDomainService {
    OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant);
    OrderPaidEvent payOrder(Order order);
    void approveOrder(Order order);
    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessage);
    void cancelOrder(Order order, List<String> failureMessages);
}
