package com.brownbag.news.subscriberservice.news;

import com.brownbag.news.subscriberservice.model.Feed;
import com.brownbag.news.subscriberservice.service.FeedService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


//examples used = > "CNN", "BBC News", "ABC News"
@RestController
@RequestMapping("/api/v1/subscriber")
public class SubscriberServiceController {

    //run local "http://localhost:8991/api/v1/db/networks/name"
    //here we use the service name for this DBSERVICEEDPOINT
    public final String DBSERVICEENDPOINT = "http://newsdbservice/api/v1/db/networks/name";
    RestTemplate restTemplate;
    ObjectMapper objectMapper;
    FeedService feedService;

    @Autowired
    public SubscriberServiceController(RestTemplate restTemplate, ObjectMapper objectMapper, FeedService feedService) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.feedService = feedService;
    }

    @GetMapping("/{network}")
    @ResponseBody
    public List<Feed> getNewsTopHeadLines(@PathVariable("network") String network) throws Exception {
        ResponseEntity<String> response = restTemplate.exchange(DBSERVICEENDPOINT+"/"+network, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });

        String newsName = objectMapper.readTree(response.getBody()).get("name").asText();

        if (StringUtils.containsIgnoreCase(newsName, "BBC")){
            newsName = "bbc";
        }
        else if(StringUtils.containsIgnoreCase(newsName, "ABC")){
            newsName = "abc";
        }

        return StringUtils.isNotBlank(newsName) ? feedService.getFeedByName(newsName): new ArrayList<Feed>();



    }

}