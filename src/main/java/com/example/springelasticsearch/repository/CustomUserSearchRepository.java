package com.example.springelasticsearch.repository;

import com.example.springelasticsearch.domain.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomUserSearchRepository {
    List<User> searchByName(String name, Pageable pageable);
}
