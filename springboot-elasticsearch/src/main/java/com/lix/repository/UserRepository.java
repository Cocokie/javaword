package com.lix.repository;

import com.lix.domain.Item;
import com.lix.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User,Long> {
    List<Item> findByPriceBetween(double price1, double price2);
}
