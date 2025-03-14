package com.rangel.url_shortener.generator;

import java.util.Random;

public class UrlGenerator {

    private final static String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final static int CODE_LENGTH = 6;
    private final Random rand = new Random();

    public String generateShortUrl(String originalUrl) {
        StringBuilder shortened = new StringBuilder();

        for (int i = 0; i < CODE_LENGTH; i++) {
            shortened.append(CHARACTERS.charAt(rand.nextInt(CHARACTERS.length())));
        }
        return shortened.toString();
    }
}
