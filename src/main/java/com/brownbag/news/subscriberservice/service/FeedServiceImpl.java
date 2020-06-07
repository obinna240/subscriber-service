package com.brownbag.news.subscriberservice.service;

import com.brownbag.news.subscriberservice.model.Feed;
import com.brownbag.news.subscriberservice.repository.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class FeedServiceImpl implements FeedService {

    @Autowired
    FeedRepository feedRepository;


    @Override
    public List<Feed> getFeedByName(String name, Pageable pageable) {
        return feedRepository.findByName(name, pageable);
    }

    @Override
    public List<Feed> getFeeds(Pageable pageable) {
        return feedRepository.findAll(pageable).getContent();
    }
}
