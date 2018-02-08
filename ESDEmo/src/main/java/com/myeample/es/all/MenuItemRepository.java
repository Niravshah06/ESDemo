package com.myeample.es.all;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MenuItemRepository extends ElasticsearchRepository<MenuItem, String> {
 
    Page<MenuItem> findBytitle(String name, Pageable pageable);
 
    
}