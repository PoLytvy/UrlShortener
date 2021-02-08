package com.test.task.service.impl;

import com.test.task.convertor.LinkConvertor;
import com.test.task.entity.Link;
import com.test.task.exception.ShortUrlNotFoundException;
import com.test.task.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {

    private final LinkConvertor convertor;
    private final Map<String, String> urls = new HashMap<>();

    @Autowired
    public UrlShortenerServiceImpl(LinkConvertor convertor) {
        this.convertor = convertor;
    }

    @Override
    public String createShortUrl(Link link) {
        String originalUrl = link.getValue();
        String key = convertor.convertLink(originalUrl);
        urls.put(key, originalUrl);
        return UrlShortenerService.link + key;
    }

    @Override
    public String getOriginalUrl(String shortUrl) {
        if (!urls.containsKey(shortUrl)){
            throw new ShortUrlNotFoundException("Url by key " + shortUrl + " not found");
        }
        return urls.get(shortUrl);
    }

    @Override
    public void deleteByKey(String key) {
        urls.remove(key);
    }

    @Override
    public Map<String, String> getAllLinks() {
        return urls;
    }
}
