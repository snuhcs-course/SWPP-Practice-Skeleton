package com.example.decoratorexample;

public class Client {
    public static void main(String[] args){
        Message simpleMessage = new SimpleMessage("Hello");
        System.out.println(simpleMessage.getContent());

        Message encryptedMessage = new EncryptedMessage("Hello");
        System.out.println(encryptedMessage.getContent());

        Message compressedMessage = new CompressedMessage("Hello");
        System.out.println(compressedMessage.getContent());

        Message encryptedAndCompressedMessage = new EncryptedAndCompressedMessage("Hello");
        System.out.println(encryptedAndCompressedMessage.getContent());
    }
}