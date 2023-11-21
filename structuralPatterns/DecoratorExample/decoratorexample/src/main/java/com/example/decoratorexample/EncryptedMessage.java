package com.example.decoratorexample;

class EncryptedMessage implements Message {
    private String content;

    public EncryptedMessage(String content) {
        this.content = encrypt(content);
    }

    private String encrypt(String content) {
        return "encrypted(" + content + ")";
    }

    @Override
    public String getContent() {
        return content;
    }
}
