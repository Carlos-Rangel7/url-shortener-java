package com.rangel.url_shortener.validator;

import com.rangel.url_shortener.exception.UrlException;
import com.rangel.url_shortener.model.Url;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class UrlValidator {

    public void validateOriginalUrl(Url url) {
        if(url == null || !StringUtils.hasText(url.getOriginalUrl())) {
            throw new UrlException("A URL não pode estar nula ou vazia");
        }
        if(!isValid(url.getOriginalUrl())) {
            throw new UrlException("A URL não esta no formato valido");
        }
    }
    private boolean isValid(String url) {
        try {
            URI uri = new URI(url);
            return uri.getScheme() != null && (uri.getScheme().equals("http") || uri.getScheme().equals("https"));
        } catch (URISyntaxException e) {
            return false;
        }
    }

}
