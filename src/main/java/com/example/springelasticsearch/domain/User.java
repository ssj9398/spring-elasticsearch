package com.example.springelasticsearch.domain;

import lombok.*;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;

@Document(indexName = "users")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private BasicProfile basicProfile;

    @PersistenceConstructor
    public User(Long id, BasicProfile basicProfile) {
        this.id = id;
        this.basicProfile = basicProfile;
    }
}