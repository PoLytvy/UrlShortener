package com.test.task.service.impl;

import com.test.task.convertor.LinkConvertor;
import com.test.task.entity.Link;
import com.test.task.exception.ShortUrlNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UrlShortenerServiceImplTest {

    @Spy
    private LinkConvertor convertor;

    @InjectMocks
    private UrlShortenerServiceImpl service;

    @Test
    void createShortUrlTest() {
        Link link = new Link();
        link.setValue("http://localhost:8080/test-link-for-link-convertion-test");

        String actual = service.createShortUrl(link);

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals("http://localhost:8080/link/fn1", actual);
    }

    @Test
    void getOriginalUrlTrowShortUrlNotFoundExceptionTest() {
        assertThrows(ShortUrlNotFoundException.class,
                () -> service.getOriginalUrl("test"));
    }
}
