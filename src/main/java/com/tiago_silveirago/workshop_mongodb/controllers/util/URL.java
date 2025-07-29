package com.tiago_silveirago.workshop_mongodb.controllers.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class URL {
    public static String decodeParameter(String text) {
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }
}
