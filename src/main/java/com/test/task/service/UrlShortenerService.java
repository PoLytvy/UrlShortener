package com.test.task.service;

import com.test.task.entity.Link;

import java.util.Map;

public interface UrlShortenerService {

    String link = "http://localhost:8080/link/";

    String createShortUrl(Link link);

    String getOriginalUrl(String shortUrl);

    void deleteByKey(String key);

    Map<String, String> getAllLinks();
}
