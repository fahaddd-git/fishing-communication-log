package com.example.websocket;

public class sendMessage {
    private String messageText;
    private String destinationPhoneNumber;


    public sendMessage(String messageText, String destinationPhoneNumber) {
        this.messageText = messageText;
        this.destinationPhoneNumber = destinationPhoneNumber;
    }
    public sendMessage(){}

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getDestinationPhoneNumber() {
        return destinationPhoneNumber;
    }

    public void setDestinationPhoneNumber(String destinationPhoneNumber) {
        this.destinationPhoneNumber = destinationPhoneNumber;
    }
}
