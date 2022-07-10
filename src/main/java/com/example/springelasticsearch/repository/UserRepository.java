package com.example.springelasticsearch.repository;


import com.example.springelasticsearch.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepository extends ElasticsearchRepository<User, Long>, CustomUserSearchRepository {
}
