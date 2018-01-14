package com.strpad.com.strpad.text;

/**
 * Created by Alexandre S on 14/01/2018.
 */
public class Pad {
    private String text;
    private String url;

    public Pad(String url, String text) {
        this.url = url;
        this.text = text;
    }

    public void save(){
        System.out.println("saveee!");
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
