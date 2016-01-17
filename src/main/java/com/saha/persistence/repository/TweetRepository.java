package com.saha.persistence.repository;

import com.saha.persistence.entity.TweetEntity;
import com.saha.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TweetRepository extends PagingAndSortingRepository<TweetEntity,Long> {


}
