package com.rangel.url_shortener.controller;

import com.rangel.url_shortener.model.Url;
import com.rangel.url_shortener.service.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@CrossOrigin(origins = "https://url-shortener-java-1.onrender.com")
@RequestMapping("/urls")
public class UrlController {

    private UrlService service;

    public UrlController(UrlService service) {
        this.service = service;
    }

    @PostMapping("/shorten")
    public Url shortenedUrl(@RequestBody Url url) {
        return service.shortenUrl(url);
    }

    @GetMapping("/{shortenedCode}")
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String shortenedCode) {
        String originalUrl = service.getOriginalUrl(shortenedCode);

        if(originalUrl != null) {
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(originalUrl)).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }




}
