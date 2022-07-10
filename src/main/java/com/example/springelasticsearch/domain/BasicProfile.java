package com.example.springelasticsearch.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class BasicProfile {

    @Column(nullable = false, unique = true)
    private String name;

    private String description;
}