package com.brownbag.news.subscriberservice.clients;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NewsClient {

//    public final String NEWS_DBSERVICE_HOST = "/api/v1/db/";
//    private String apihost;
//
//    private final RestTemplate restTemplate;
//
//    public NewsClient(RestTemplateBuilder restTemplateBuilder) {
//        this.restTemplate = restTemplateBuilder.build();
//    }
//
//    public BeerDto getBeerById(UUID uuid){
//        return restTemplate.getForObject(apihost + NEWS_DBSERVICE_HOST + uuid.toString(), BeerDto.class);
//    }
//
//    public URI saveNewBeer(BeerDto beerDto){
//        return restTemplate.postForLocation(apihost + NEWS_DBSERVICE_HOST, beerDto);
//    }
//
//    public void updateBeer(UUID uuid, BeerDto beerDto){
//        restTemplate.put(apihost + NEWS_DBSERVICE_HOST + uuid, beerDto);
//    }
//
//    public void deleteBeer(UUID uuid){
//        restTemplate.delete(apihost + NEWS_DBSERVICE_HOST + uuid );
//    }
//
//    public void setApihost(String apihost) {
//        this.apihost = apihost;
//    }
//
//    public CustomerDto getCustomerById(UUID customerId) {
//        return restTemplate.getForObject(apihost+ CUSTOMER_PATH_V1 + customerId.toString(), CustomerDto.class);
//    }
//
//    public URI saveNewCustomer(CustomerDto customerDto) {
//        return  restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDto);
//    }
//
//    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
//        restTemplate.put(apihost + CUSTOMER_PATH_V1 + customerId, customerDto);
//    }
//
//    public void deleteCustomer(UUID customerId) {
//        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + customerId);
//    }
}