package com.appaces.ecommerce.service;

import com.appaces.ecommerce.customer.User;
import com.appaces.ecommerce.dto.UserRequest;
import com.appaces.ecommerce.dto.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public User toUser(UserRequest request) {
        if(request == null){
            return null;
        }
        return User.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .address(request.address())
                .build();
    }

    public UserResponse fromUser(User user) {
        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAddress()
        );
    }
}
