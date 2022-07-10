package com.example.springelasticsearch.controller;

import com.example.springelasticsearch.config.Success;
import com.example.springelasticsearch.dto.UserRequest;
import com.example.springelasticsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<Void> addUser(@RequestBody UserRequest userRequest){
        Long userId = userService.userAdd(userRequest);
        URI uri = URI.create(String.valueOf(userId));
        return ResponseEntity.created(uri)
                .build();
    }

    @GetMapping("/users")
    public ResponseEntity<Success> UserList(@RequestBody UserRequest userRequest, Pageable pageable){
        List<UserRequest> userRequests = userService.searchByName(userRequest.getName(), pageable);
        return new ResponseEntity<>(new Success<>("유저 조회",userRequests),HttpStatus.OK);
    }
}
