package com.test.task.service;

import com.test.task.entity.Link;

public interface UrlShortenerService {

    String link = "http://localhost:8080/";

    String createShortUrl(Link link);

    String getOriginalUrl(String shortUrl);
}
