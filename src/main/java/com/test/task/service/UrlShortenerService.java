package com.test.task.service;

import com.test.task.entity.Link;

public interface UrlShortenerService {

    String createShortUrl(Link link);

    String getOriginalUrl(String shortUrl);
}
