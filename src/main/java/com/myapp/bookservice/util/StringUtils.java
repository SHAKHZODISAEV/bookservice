package com.myapp.bookservice.util;

public class StringUtils {

    public static int countOccurrencesIgnoreCase(String str, String character) {
        return str.replaceAll("(?i)[^" + character + "]", "").length();
    }
}
