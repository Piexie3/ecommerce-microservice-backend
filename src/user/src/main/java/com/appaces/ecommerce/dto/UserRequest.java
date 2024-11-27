package com.appaces.ecommerce.dto;

import com.appaces.ecommerce.customer.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserRequest(
        String id,

        @NotNull(message = "User last name is required")
        String firstName,

        @NotNull(message = "User first name is required")
        String lastName,
        @Email(message = "User email is not a valid email")
        String email,
        Address address
) {
}
