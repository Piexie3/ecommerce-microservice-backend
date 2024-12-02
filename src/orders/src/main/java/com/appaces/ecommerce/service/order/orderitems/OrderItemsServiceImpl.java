package com.appaces.ecommerce.service.order.orderitems;

import com.appaces.ecommerce.dto.OrderItemsRequests;
import com.appaces.ecommerce.repository.OrderItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemsServiceImpl implements OrderItemsService{
    private final OrderItemsRepository repository;
    private final OrderItemsMapper mapper;
    @Override
    public Integer saveOrderItems(OrderItemsRequests requests) {
        var order = mapper.toOrderItems(requests);
        return repository.save(order).getId();
    }
}
