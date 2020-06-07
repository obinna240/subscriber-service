package com.brownbag.news.subscriberservice.service;

import com.brownbag.news.subscriberservice.model.Feed;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FeedService {

    List<Feed> getFeedByName(String name);
    List<Feed> getFeeds(Pageable pageable);
}
