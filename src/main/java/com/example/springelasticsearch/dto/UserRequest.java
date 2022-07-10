package com.example.springelasticsearch.dto;

import com.example.springelasticsearch.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequest {

    private String name;

    private String content;

    private Long id;

    public UserRequest(User user) {
        this.name = user.getBasicProfile().getName();
        this.content = user.getBasicProfile().getDescription();
        this.id = user.getId();
    }
}
