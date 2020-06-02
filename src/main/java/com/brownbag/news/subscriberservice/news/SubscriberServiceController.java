package com.brownbag.news.subscriberservice.news;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Type;
import java.net.URI;


@RestController
@RequestMapping("/api/v1/subscriber")
public class SubscriberServiceController {

    public final String NEWSAPI = "http://newsapi.org/v2/top-headlines";
    public final String APIKEY = "apiKey=fd902d9d92fc420ca5bd973ec15139e4";
//    public final String DBSERVICEENDPOINT = "http://localhost:8991/api/v1/db/networks/name";
    public final String DBSERVICEENDPOINT = "http://news-db-service/api/v1/db/networks/name";
    RestTemplate restTemplate;
    ObjectMapper objectMapper;

    @Autowired
    public SubscriberServiceController(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/{network}")
    public ResponseEntity getNewsTopHeadLines(@PathVariable("network") String network) throws Exception {
        ResponseEntity<String> response = restTemplate.exchange(DBSERVICEENDPOINT+"/"+network, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });

        //we could use a contract here
        System.out.println(response.getBody());
        String newsName = objectMapper.readTree(response.getBody()).get("name").asText();

        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

        params.add("source", newsName);
        params.add("apiKey", APIKEY);

        URI uri = UriComponentsBuilder.fromUriString(NEWSAPI).queryParams(params).build().toUri();
        return restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });

    }

}





//
//
//
//
//
//{
//        "status": "ok",
//        "totalResults": 10,
//        "articles": [
//        {
//        "source": {
//        "id": "bbc-news",
//        "name": "BBC News"
//        },
//        "author": "BBC News",
//        "title": "In pictures: Unrest spreads across US",
//        "description": "Images from protests and violence as anger over the death of black man George Floyd increases.",
//        "url": "http://www.bbc.co.uk/news/world-us-canada-52859057",
//        "urlToImage": "https://ichef.bbci.co.uk/news/1024/branded_news/155F0/production/_112563578_061695101-1.jpg",
//        "publishedAt": "2020-05-30T08:41:04Z",
//        "content": "Image copyrightGetty ImagesImage caption\r\n Fire at a petrol station in Minneapolis, which continues to see the worst unrest\r\nProtests against the death of an unarmed black man in police custody in Mi… [+1853 chars]"
//        },
//        {
//        "source": {
//        "id": "bbc-news",
//        "name": "BBC News"
//        },
//        "author": "BBC News",
//        "title": "Coronavirus updates: India records its biggest single day jump in cases",
//        "description": "But despite the rising number of coronavirus cases, the government has been easing restrictions.",
//        "url": "http://www.bbc.co.uk/news/live/world-52859146",
//        "urlToImage": "https://m.files.bbci.co.uk/modules/bbc-morph-news-waf-page-meta/4.1.2/bbc_news_logo.png",
//        "publishedAt": "2020-05-30T07:07:26.4397537Z",
//        "content": "Its the final weekend before a further easing of lockdown measures in England, which will see more than two people able to meet outside from Monday and schools will reopen to some pupils.\r\nHere are t… [+1350 chars]"
//        },
//        {
//        "source": {
//        "id": "bbc-news",
//        "name": "BBC News"
//        },
//        "author": "BBC News",
//        "title": "Risk in lockdown easing too soon, warn scientists",
//        "description": "Lifting restrictions is \"risky\", warn experts who want a fully working test and trace system first.",
//        "url": "http://www.bbc.co.uk/news/uk-52858392",
//        "urlToImage": "https://ichef.bbci.co.uk/news/1024/branded_news/408E/production/_112562561_061685316.jpg",
//        "publishedAt": "2020-05-30T05:07:24Z",
//        "content": "Image copyrightGetty Images\r\nScientific advisers to the government have warned of the risk of lifting lockdown in England, as the UK heads into the weekend before rules change.\r\nProfessor John Edmund… [+3483 chars]"
//        },
//        {
//        "source": {
//        "id": "bbc-news",
//        "name": "BBC News"
//        },
//        "author": "BBC News",
//        "title": "Clashes as protesters across US demand justice",
//        "description": "Crowds rally at the White House among other places over the death in police custody of George Floyd.",
//        "url": "http://www.bbc.co.uk/news/world-us-canada-52857334",
//        "urlToImage": "https://ichef.bbci.co.uk/images/ic/1024x576/p08fj9b4.jpg",
//        "publishedAt": "2020-05-30T03:46:43Z",
//        "content": "Media captionA police station was set on fire in third night of unrest in Minneapolis\r\nProtesters have clashed with police in cities across the US over the killing of an unarmed African-American man … [+6780 chars]"
//        },
//        {
//        "source": {
//        "id": "bbc-news",
//        "name": "BBC News"
//        },
//        "author": "BBC News",
//        "title": "World's largest all-electric plane takes flight",
//        "description": "An historic day for the aviation industry as the world's largest all-electric plane takes flight.",
//        "url": "http://www.bbc.co.uk/news/world-us-canada-52856887",
//        "urlToImage": "https://ichef.bbci.co.uk/news/1024/branded_news/12C6A/production/_112560967_p08fll6m.jpg",
//        "publishedAt": "2020-05-29T22:48:35Z",
//        "content": null
//        },
//        {
//        "source": {
//        "id": "bbc-news",
//        "name": "BBC News"
//        },
//        "author": "BBC News",
//        "title": "SpaceX launch: Nasa astronauts set for second try",
//        "description": "SpaceX will need to beat the weather to get Nasa astronauts Doug Hurley and Bob Behnken into orbit.",
//        "url": "http://www.bbc.co.uk/news/science-environment-52855029",
//        "urlToImage": "https://ichef.bbci.co.uk/images/ic/1024x576/p08fcspg.jpg",
//        "publishedAt": "2020-05-29T22:14:48Z",
//        "content": "Media captionBad weather conditions delayed Wednesday's launch attempt\r\nRocket company SpaceX will make a second attempt in the coming hours to get Nasa astronauts Doug Hurley and Bob Behnken into or… [+3777 chars]"
//        },
//        {
//        "source": {
//        "id": "bbc-news",
//        "name": "BBC News"
//        },
//        "author": "BBC News",
//        "title": "Why has a US city gone up in flames?",
//        "description": "Tensions in Minneapolis did not start with the death of George Floyd. They've been years in the making.",
//        "url": "http://www.bbc.co.uk/news/world-us-canada-52854037",
//        "urlToImage": "https://ichef.bbci.co.uk/news/1024/branded_news/11FD5/production/_112558637_hi061684118-getty.jpg",
//        "publishedAt": "2020-05-29T21:19:41Z",
//        "content": "Image copyrightGetty Images\r\nTensions between Minneapolis' black community and the police did not start with the death of George Floyd. They have been years in the making.\r\nOn a hot Thursday morning … [+5220 chars]"
//        },
//        {
//        "source": {
//        "id": "bbc-news",
//        "name": "BBC News"
//        },
//        "author": "BBC News",
//        "title": "Trump targets China over Hong Hong",
//        "description": "US President Donald Trump says Chinese government's moves in Hong Kong are a \"tragedy\" and he will start to remove city's trade privileges",
//        "url": "http://www.bbc.co.uk/news/world-us-canada-52856876",
//        "urlToImage": "https://ichef.bbci.co.uk/news/1024/branded_news/148B2/production/_111764148_breaking-promo.png",
//        "publishedAt": "2020-05-29T19:17:05Z",
//        "content": "US President Donald Trump says Chinese government's moves in Hong Kong are a \"tragedy\" and he will start to remove city's trade privileges \r\nThis breaking news story is being updated and more details… [+224 chars]"
//        },
//        {
//        "source": {
//        "id": "bbc-news",
//        "name": "BBC News"
//        },
//        "author": "BBC News",
//        "title": "Anger as CNN journalist arrested live on air",
//        "description": "Omar Jimenez and a camera crew were detained in Minneapolis during protests",
//        "url": "http://www.bbc.co.uk/news/world-us-canada-52854980",
//        "urlToImage": "https://ichef.bbci.co.uk/images/ic/1024x576/p08fjtmc.jpg",
//        "publishedAt": "2020-05-29T18:56:39Z",
//        "content": "Media captionCNN correspondent Omar Jimenez was detained live on air\r\nA CNN reporter has been released after being arrested while covering protests in Minneapolis over the death of an unarmed black m… [+2210 chars]"
//        },
//        {
//        "source": {
//        "id": "bbc-news",
//        "name": "BBC News"
//        },
//        "author": "BBC News",
//        "title": "Forbes drops Kylie Jenner from billionaire list",
//        "description": "The magazine says the Kardashian family misled the press about the value of Kylie Jenner's makeup business.",
//        "url": "http://www.bbc.co.uk/news/business-52854345",
//        "urlToImage": "https://ichef.bbci.co.uk/news/1024/branded_news/2042/production/_102685280_gettyimages-956294722.jpg",
//        "publishedAt": "2020-05-29T18:03:42Z",
//        "content": "Image copyrightGetty ImagesImage caption\r\n Kylie Jenner is the youngest self-made billionaire of all time\r\nForbes magazine has struck celebrity Kylie Jenner from its list of billionaires and accused … [+2485 chars]"
//        }
//        ]
//        }
//
//
//    private final NewsService newsService;
//
//    public DbServiceController(NewsService newsService) {
//        this.newsService = newsService;
//    }
//
//    @GetMapping("/networks")
//    public ResponseEntity<List<NewsNetwork>> getAllNews() {
//        return new ResponseEntity<>(newsService.getNetworks(), HttpStatus.OK);
//    }
//
//    @GetMapping("/networks/{id}")
//    public ResponseEntity<NewsNetwork> getNewsNetworkById(@PathVariable("id") Integer id) {
//        return new ResponseEntity<>(newsService.getNewsServiceById(id), HttpStatus.OK);
//    }
//
//    @PostMapping("/networks")
//    public ResponseEntity saveNews(@RequestBody NewsNetwork newsNetwork){
//        NewsNetwork network= newsService.saveNetwork(newsNetwork);
//        HttpHeaders headers = new HttpHeaders();
//
//        headers.add("networkNewsResource", "api/v1/db/"+network.getId());
//        return new ResponseEntity(headers, HttpStatus.CREATED);
//    }