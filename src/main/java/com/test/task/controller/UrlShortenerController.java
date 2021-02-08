package com.test.task.controller;

import com.test.task.entity.Link;
import com.test.task.service.UrlShortenerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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

    @RequestMapping(method = RequestMethod.GET, path = "/{shortUrl}")
    public ModelAndView redirect(@PathVariable String shortUrl){
        String originalUrl = service.getOriginalUrl(shortUrl);
        RedirectView rv = new RedirectView();
        rv.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
        rv.setUrl(originalUrl);
        return new ModelAndView(rv);
    }
}
