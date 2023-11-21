package com.example.decoratorexample;

public class SimpleMessage implements Message{
    private String content;

    public SimpleMessage(String content) {
        this.content = content;
    }
    @Override
    public String getContent() {
        return content;
    }
}
