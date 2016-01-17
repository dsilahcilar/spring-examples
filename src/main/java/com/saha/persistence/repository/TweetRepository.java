package com.saha.persistence.repository;

import com.saha.persistence.entity.TweetEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TweetRepository extends PagingAndSortingRepository<TweetEntity,Long> {

    List<TweetEntity> findTop5ByUserEntityIdOrderById(Long id);
}
