package com.appaces.ecommerce.dto;

import com.appaces.ecommerce.customer.Address;
import lombok.Builder;

@Builder
public record UserResponse(
        String id,
        String firstName,
        String lastName,
        String email,
        Address address
) {
}
