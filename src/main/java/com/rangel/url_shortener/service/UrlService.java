package com.rangel.url_shortener.service;

import com.rangel.url_shortener.exception.UrlException;
import com.rangel.url_shortener.generator.UrlGenerator;
import com.rangel.url_shortener.model.Url;
import com.rangel.url_shortener.validator.UrlValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlService {

    @Value("${app.base-url}")
    private String baseUrl;

    private UrlGenerator generator;
    private UrlValidator validator;

    public UrlService(UrlGenerator generator, UrlValidator validator, @Value("${app.base-url}") String baseUrl) {
        this.generator = generator;
        this.validator = validator;
        this.baseUrl = baseUrl;
    }

    private Map<String, String> urlStorage = new HashMap<>();
    private Map<String, String> originalUrlStorage = new HashMap<>();

    public Url shortenUrl(Url url) {
        validator.validateOriginalUrl(url);

        String originalUrl = url.getOriginalUrl();

        if(originalUrlStorage.containsKey(originalUrl)) {
            String shortenedCode = originalUrlStorage.get(originalUrl);
            url.setShortenedUrl(baseUrl + shortenedCode);
        } else{
            String shortenedCode = generator.generateShortUrl(originalUrl);
            url.setShortenedUrl(baseUrl + shortenedCode);

            urlStorage.put(shortenedCode, originalUrl);
            originalUrlStorage.put(originalUrl, shortenedCode);
        }

        return url;
    }

    public String getOriginalUrl(String shortenedCode) {
        String originalUrl = urlStorage.get(shortenedCode);

        if(originalUrl == null) {
            throw new UrlException("URL encurtada não encotrada");
        }
        return originalUrl;
    }

}
