package com.example.springelasticsearch.repository;

import com.example.springelasticsearch.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
@Slf4j
public class CustomUserSearchRepositoryImpl implements CustomUserSearchRepository{

    private final ElasticsearchOperations elasticsearchOperations;

    @Override
    public List<User> searchByName(String name, Pageable pageable) {
        Criteria criteria = Criteria.where("basicProfile.name").contains(name);

        Query query = new CriteriaQuery(criteria);

        SearchHits<User> search = elasticsearchOperations.search(query, User.class);

        List<User> collect = search.stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());
        return collect;
    }
}
