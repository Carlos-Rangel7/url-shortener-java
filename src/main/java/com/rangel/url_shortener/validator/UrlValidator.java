package com.rangel.url_shortener.validator;

import com.rangel.url_shortener.model.Url;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class UrlValidator {

    public void validateOriginalUrl(Url url) {
        if(url == null || !StringUtils.hasText(url.getOriginalUrl())) {
            throw new IllegalArgumentException("A URL n~so pode estar nula ou vazia");
        }
        if(!isValid(url.getOriginalUrl())) {
            throw new IllegalArgumentException("A URL não esta no formato valido");
        }
    }
    private boolean isValid(String url) {
        try {
            new URI(url);
            return true;
        } catch (URISyntaxException e) {
            return false;
        }
    }

}
