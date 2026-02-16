package com.dflong.greenbull.netty;


public class Message {
    private String type;
    private String content;
    private long timestamp;

    public Message() {}

    public Message(String type, String content) {
        this.type = type;
        this.content = content;
        this.timestamp = System.currentTimeMillis();
    }

    // getter和setter方法
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }

    @Override
    public String toString() {
        return "Message{type='" + type + "', content='" + content + "', timestamp=" + timestamp + '}';
    }
}
