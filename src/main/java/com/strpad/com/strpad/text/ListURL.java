package com.strpad.com.strpad.text;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alexandre S on 13/01/2018.
 */
public class ListURL {

    private static Map<String, String> urlMap;


    static {
        urlMap = new HashMap<>();
    }

    static void addURL(String url){
        urlMap.put(url, url);
    }

    static boolean contains(String url){
        return urlMap.containsKey(url);
    }

    static String getText(String url){
        return urlMap.get(url);
    }

    static String putText(String url, String text){
        return urlMap.put(url, text);
    }

}
