package com.example.wardrobewizard;

public class Posts {

    private String title;
    private String  url;

    public Posts(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
