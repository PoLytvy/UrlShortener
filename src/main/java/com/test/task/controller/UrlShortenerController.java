package com.test.task.controller;

import com.test.task.entity.Link;
import com.test.task.service.UrlShortenerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlShortenerController {

    private  final UrlShortenerService service;

    public UrlShortenerController(UrlShortenerService service) {
        this.service = service;
    }

    @PostMapping
    public String createShortUrl(@RequestBody Link link){
        return service.createShortUrl(link);
    }
}
