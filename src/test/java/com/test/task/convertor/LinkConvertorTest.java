package com.test.task.convertor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkConvertorTest {

    private final LinkConvertor convertor = new LinkConvertor();

    @Test
    void convertLinkTest() {
        String link = "http://localhost:8080/test-link-for-link-convertion-test";

        String actual = convertor.convertLink(link);

        assertNotNull(actual);
        assertEquals("fn1", actual);
    }
}
