package com.appaces.ecommerce.service.order;

import com.appaces.ecommerce.dto.OrderItemsRequests;
import com.appaces.ecommerce.dto.OrderRequest;
import com.appaces.ecommerce.dto.PurchaseRequest;
import com.appaces.ecommerce.models.OrderMapper;
import com.appaces.ecommerce.repository.OrderRepository;
import com.appaces.ecommerce.service.order.orderitems.OrderItemsService;
import com.appaces.ecommerce.service.product.ProductClient;
import com.appaces.ecommerce.service.user.UserClient;
import com.appaces.ecommerce.utils.exceptions.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final UserClient userClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderMapper mapper;
    private final OrderItemsService itemsService;

    @Override
    public Integer createOrder(OrderRequest request) {
        /*
         * check user ->user-ms(using openfein)
         * purchase product -> product-ms(using resttemplate,alternative to fenclient)
         * persist order
         * persist order items
         * start payment -> payment-ms
         * send order confirmation - notification-ms
         */

        var user = this.userClient
                .findUserById(request.userId())
                .orElseThrow(() -> new CustomException("User to order product is not found"));
        this.productClient.purchaseProucts(request.products());

        var order = this.orderRepository.save(mapper.toOrder(request));

        for (PurchaseRequest purchaseRequest : request.products()) {
            itemsService.saveOrderItems(
                    new OrderItemsRequests(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    ));
        }
        return 0;
    }
}
