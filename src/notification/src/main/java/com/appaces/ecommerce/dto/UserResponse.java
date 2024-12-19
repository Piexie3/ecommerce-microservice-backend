package com.appaces.ecommerce.dto;

public record UserResponse(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
