package com.sulevsky.dataconsumer;

public class DataProviderMessage {
    private String id;
    private String content;

    public DataProviderMessage(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public DataProviderMessage() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
