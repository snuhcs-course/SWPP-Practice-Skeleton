package com.example.decoratorexample;

public class EncryptedAndCompressedMessage implements Message{
    private String content;

    public EncryptedAndCompressedMessage(String content) {
        this.content = compress(encrypt(content));
    }

    private String encrypt(String content) {
        return "encrypted(" + content + ")";
    }
    private String compress(String content) {
        return "compressed(" + content + ")";
    }

    @Override
    public String getContent() {
        return content;
    }
}
