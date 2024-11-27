package com.appaces.ecommerce.controller;

import com.appaces.ecommerce.dto.UserRequest;
import com.appaces.ecommerce.dto.UserResponse;
import com.appaces.ecommerce.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService customerService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestParam @Valid UserRequest request){
        return ResponseEntity.ok(customerService.createUser(request));
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateUser(@RequestBody @Valid  UserRequest request){
         customerService.updateUser(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> findAll(){
        return ResponseEntity.ok(customerService.findAllUsers());
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existById(@PathVariable String id){
        return ResponseEntity.ok(customerService.existById(id));
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable String id){
        return ResponseEntity.ok(customerService.findById(id));
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        customerService.deleteUser(id);
        return ResponseEntity.accepted().build();
    }
}
