package com.example.springelasticsearch.service;

import com.example.springelasticsearch.domain.BasicProfile;
import com.example.springelasticsearch.domain.User;
import com.example.springelasticsearch.dto.UserRequest;
import com.example.springelasticsearch.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<UserRequest> searchByName(String name, Pageable pageable) {
        return userRepository.searchByName(name, pageable)
                .stream()
                .map(UserRequest::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long userAdd(UserRequest userRequest) {
        BasicProfile basicProfile = BasicProfile.builder()
                .name(userRequest.getName())
                .description(userRequest.getContent())
                .build();

        User user = User.builder()
                .id(userRequest.getId())
                .basicProfile(basicProfile)
                .build();

        User save = userRepository.save(user);
        return save.getId();
    }
}