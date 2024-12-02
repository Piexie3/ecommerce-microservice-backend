package com.appaces.ecommerce.service.user;

import com.appaces.ecommerce.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "user-service",
        url = "${application.config.user-url}"
)
public interface UserClient {
    @GetMapping("/by-id/{id}")
    Optional<UserResponse> findUserById(@PathVariable String id);
}
