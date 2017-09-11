package com.sulevsky.dataconsumer;

public class AggregatedMessage {
    private String id;
    private String providersContent;
    private String ownContent;

    public AggregatedMessage(String id, String providersContent, String ownContent) {
        this.id = id;
        this.providersContent = providersContent;
        this.ownContent = ownContent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvidersContent() {
        return providersContent;
    }

    public void setProvidersContent(String providersContent) {
        this.providersContent = providersContent;
    }

    public String getOwnContent() {
        return ownContent;
    }

    public void setOwnContent(String ownContent) {
        this.ownContent = ownContent;
    }
}
