package com.example.decoratorexample;

class CompressedMessage implements Message {
    private String content;

    public CompressedMessage(String content) {
        this.content = compress(content);
    }

    private String compress(String content) {
        return "compressed(" + content + ")";
    }

    @Override
    public String getContent() {
        return content;
    }
}
