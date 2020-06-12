package com.brownbag.news.subscriberservice.news;

import com.brownbag.news.subscriberservice.model.Feed;
import com.brownbag.news.subscriberservice.service.FeedService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//examples used = > "CNN", "BBC News", "ABC News"
@RestController
@RequestMapping("/api/v1/subscriber")
public class SubscriberServiceController {

    //run local "http://localhost:8991/api/v1/db/networks/name"
    //here we use the service name for this DBSERVICEEDPOINT
    public final String DBSERVICEENDPOINT = "http://newsdbservice.brown-bag.svc.cluster.local:8991/api/v1/db/networks/name";
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

        System.out.println("************** HITTING EXTERNAL ENDPOINT *****************");
        ResponseEntity<String> response = restTemplate.exchange(DBSERVICEENDPOINT+"/"+network, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });
        String newsName = objectMapper.readTree(response.getBody()).get("name").asText();
        System.out.println("*************** GETTING EXTERNAL ENDPOINT BODY *****************");

        if(StringUtils.isNotBlank(newsName)) {
            newsName = newsName.toLowerCase();
        }

        Feed defaultfeed = Feed.builder().author("default").content("tester").description("test").name("default").url("default").publishedAt("test").title("test")
                .url("dummyurl").urlToImage("dummyurl").build();
        List<Feed> defaultArray = Arrays.asList(defaultfeed);

        return StringUtils.isNotBlank(newsName) ? feedService.getFeedByName(newsName): defaultArray;

    }

    @GetMapping("/all")
    @ResponseBody
    public List<Feed> getAllNews() throws Exception {
      return feedService.getFeeds(PageRequest.of(0, 30));

    }

    @GetMapping("/name/{networkname}")
    @ResponseBody
    public List<Feed> getFeedsByName(@PathVariable("networkname") String networkname) throws Exception {
        return StringUtils.isNotBlank(networkname) ? feedService.getFeedByName(networkname) : new ArrayList<Feed>();


    }

    @GetMapping("/version")
    @ResponseBody
    public String getVersion() throws Exception {
        return "I am running image version 9 - of subscriber service";
    }

}