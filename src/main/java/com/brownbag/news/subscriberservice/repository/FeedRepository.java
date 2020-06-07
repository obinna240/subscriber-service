package com.brownbag.news.subscriberservice.repository;

import com.brownbag.news.subscriberservice.model.Feed;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FeedRepository extends PagingAndSortingRepository<Feed, Integer> {

    List<Feed> findByName(String name);
}
