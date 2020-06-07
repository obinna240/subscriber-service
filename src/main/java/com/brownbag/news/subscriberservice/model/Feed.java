package com.brownbag.news.subscriberservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Data
@Builder
public class Feed {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name= "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private Integer serialId;
    private String name;
    @Column(length = 1000, columnDefinition = "varchar(1000)", nullable = true)
    private String author;
    @Column(length = 1000, columnDefinition = "varchar(1000)", nullable = true)
    private String title;
    @Column(length = 1000, columnDefinition = "varchar(1000)", nullable = true)
    private String description;
    @Column(nullable = true)
    private String url;
    @Column(nullable = true)
    private String urlToImage;
    @Column(nullable = true)
    private String publishedAt;
    @Column(length = 1000, columnDefinition = "varchar(1000)",nullable = true)
    private String content;

}

