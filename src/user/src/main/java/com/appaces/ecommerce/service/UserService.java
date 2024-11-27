package com.appaces.ecommerce.service;

import com.appaces.ecommerce.dto.UserRequest;
import com.appaces.ecommerce.dto.UserResponse;
import com.appaces.ecommerce.repository.UserRepository;
import com.appaces.ecommerce.utils.AppUtils;
import com.appaces.ecommerce.utils.exceptions.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;
    public String createUser(UserRequest request) {
        var customer = userRepository.save(mapper.toUser(request));
        return customer.getId();
    }

    public void updateUser(UserRequest request) {
        var user = userRepository.findById(request.id()).orElseThrow(
                ()-> new CustomException(
                        format("Cannot update user, No user found with the provided ID:: %s",request.id())
                )
        );
        AppUtils.updateField(user::setId,request.id(),user.getId());
        AppUtils.updateField(user::setFirstName,request.firstName(),user.getFirstName());
        AppUtils.updateField(user::setLastName,request.lastName(),user.getLastName());
        AppUtils.updateField(user::setAddress,request.address(),user.getAddress());
        AppUtils.updateField(user::setEmail,request.email(),user.getEmail());

        userRepository.save(user);

    }

    public List<UserResponse> findAllUsers() {
        return userRepository.findAll().stream().map(mapper::fromUser).collect(Collectors.toList());
    }

    public Boolean existById(String id) {
        return userRepository.findById(id).isPresent();
    }

    public UserResponse findById(String id) {
        return userRepository.findById(id)
                .map(mapper::fromUser)
                .orElseThrow(()->new CustomException(format("No User found by User Id: %s",id)));
    }

    public void deleteUser(String id) {
        userRepository.findById(id).ifPresentOrElse(
                userRepository::delete,
                ()->  {
                 throw new CustomException(format("No User found by User Id: %s",id));
                }
        );

    }
}
